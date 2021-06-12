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
import java.util.concurrent.Callable;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author SEPULS PC'S
 */
public class TipoPaqueteDao {
    
    Conexion conn;
    
    public TipoPaqueteDao(){
        conn = new Conexion(); 
    }
    
    public List<TipoPaquete> fun_mostrarTipoPaquete(){
        Connection acceso = conn.getCnn(); 
        TipoPaquete tp = null; 
        
        List<TipoPaquete> lista = new ArrayList(); 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call TIPO_PAQUETE_PKG.proc_mostrarTiposPaquete(?)}"); 
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute(); 
            
            ResultSet rs = (ResultSet) cs.getObject(1); 
            
            while(rs.next()){
                tp = new TipoPaquete(); 
                tp.setId_tipo_paquete(rs.getInt("ID_TIPO_PAQUETE"));
                tp.setPaquete(rs.getString("PAQUETE"));
                
                lista.add(tp); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lista; 
        
    }
    
    public boolean agregarTipoPaquete(TipoPaquete tp){
        Connection acceso = conn.getCnn(); 
        boolean fueAgregado = false; 
        
        System.out.println("id" + tp.getId_tipo_paquete());        
        System.out.println("paquete" + tp.getPaquete());

        
        
        try {
            CallableStatement cs = acceso.prepareCall("{ call TIPO_PAQUETE_PKG.ins(?, ?) }");
            cs.setString(1, tp.getPaquete());
            cs.setInt(2, tp.getId_tipo_paquete());
            
            fueAgregado = !cs.execute();


        } catch (SQLException e) {
            
            System.out.println("Error aca: " + e.getMessage());
        }
        
        return fueAgregado; 
    
    }
    
    public boolean modificarTipoPaquete(TipoPaquete tp){
        Connection acceso = conn.getCnn(); 
        boolean fueModificado = false; 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call TIPO_PAQUETE_PKG.upd(?, ?)}");
            cs.setString(1, tp.getPaquete());
            cs.setInt(2, tp.getId_tipo_paquete());
            
            fueModificado = !cs.execute(); 
        } catch (Exception e) {
            System.out.println("Error aca: " + e.getMessage());

        }
        
        return fueModificado; 
    
    }
    
    public boolean eliminarTipoPaquete(TipoPaquete tp){
        Connection acceso = conn.getCnn(); 
        boolean fueEliminado =false; 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call TIPO_PAQUETE_PKG.del(?)}");
            cs.setInt(1, tp.getId_tipo_paquete());
            
            fueEliminado = !cs.execute(); 
        } catch (SQLException e) {
            System.out.println("Error aca: " + e.getMessage());

        }
        
        return fueEliminado; 
    }
    
    
    
}
