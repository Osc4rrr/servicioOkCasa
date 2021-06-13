/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author SEPULS PC'S
 */
public class ServicioDao {
    Conexion conn; 
    
    public ServicioDao(){
        conn = new Conexion(); 
    }
    
    public List<Servicio> fun_mostrarServicios(){
    
        Connection acceso = conn.getCnn(); 
        Servicio s = null; 
        List<Servicio> lista = new ArrayList(); 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call SERVICIO_PKG.proc_mostrarServicios(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute(); 
            
            ResultSet rs = (ResultSet) cs.getObject(1); 
            
            while(rs.next()){
                
                s = new Servicio(); 
                TipoPaquete tp = new TipoPaquete(); 
                DetalleServicio ds = new DetalleServicio(); 
                
                tp.setId_tipo_paquete(rs.getInt("TIPO_PAQUETE_ID_TIPO_PAQUETE"));
                ds.setId_detalle_servicio(rs.getInt("SERVICIO_ID"));
                
                
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                s.setNombre(rs.getString("NOMBRE"));
                s.setDescripcion(rs.getString("DESCRIPCION"));
                s.setTipoPaquete(tp);
                s.setDetalleServicio(ds);
                
                lista.add(s); 

               
            }
        } catch (SQLException e) {
            
            System.out.println("Error" + e.getMessage());
        }
        
        return lista; 
    }
    
    public boolean agregarServicio(Servicio s){
    
        Connection acceso = conn.getCnn(); 
        boolean fueAgregado = false; 
       
        try {
            CallableStatement cs = acceso.prepareCall("{ call SERVICIO_PKG.ins(?, ?, ?, ?, ?) }");
            cs.setInt(1, s.getId_servicio());
            cs.setInt(2, s.getDetalleServicio().getId_detalle_servicio());
            cs.setString(3, s.getDescripcion());
            cs.setInt(4, s.getTipoPaquete().getId_tipo_paquete());
            cs.setString(5, s.getNombre());
           
            
            fueAgregado = !cs.execute();


        } catch (SQLException e) {
            
            System.out.println("Error aca: " + e.getMessage());
        }
        
        return fueAgregado; 
    
    }
    
    public boolean modificarServicio(Servicio s) {
        Connection acceso = conn.getCnn(); 
        boolean fueModificado = false; 
        
        
        try {
            CallableStatement cs = acceso.prepareCall("{ call SERVICIO_PKG.upd(?, ?, ?, ?, ?) }");
            cs.setInt(1, s.getId_servicio());
            cs.setInt(2, s.getServicio_id());
            cs.setString(3, s.getDescripcion());
            cs.setInt(4, s.getTipo_paquete_id_tipo_paquete());
            cs.setString(5, s.getNombre());
           
            
            fueModificado = !cs.execute();
        } catch (SQLException e) {
            
            System.out.println("Error aca: " + e.getMessage());
        }
        
        return fueModificado; 
    
    }
    
    public boolean eliminarServicio(int codigo_servicio, int servicio_id){
        Connection acceso = conn.getCnn();
        boolean fueEliminado = false; 
        
        
        try {
            CallableStatement cs = acceso.prepareCall("{call SERVICIO_PKG.del(?, ?)}");
            cs.setInt(1 ,servicio_id);
            cs.setInt(2, codigo_servicio);
            
            fueEliminado = !cs.execute(); 
        } catch (SQLException e) {
            
            System.out.println("Error aca: " + e.getMessage());
        }
        
        return fueEliminado; 
                
    
    }
}
