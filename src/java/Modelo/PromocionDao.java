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
 * @author nashi
 */
public class PromocionDao {
    Conexion conn; 
    
    public PromocionDao(){
        conn = new Conexion(); 
    }
    
    public List<Promocion> fun_mostrarPromocion(){
        
        Connection acceso = conn.getCnn(); 
        Promocion pro = null; 
        List<Promocion> lista = new ArrayList(); 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call PROMOCION_PKG.proc_mostrarPromocion(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute(); 
            
            ResultSet rs = (ResultSet) cs.getObject(1); 
            
            while(rs.next()){
                pro = new Promocion(); 
                pro.setId_promocion(rs.getInt("ID_PROMOCION"));
                pro.setDescripcion(rs.getString("DESCRIPCION"));
                
                lista.add(pro); 
            }
        } catch (Exception e) {
            
            System.out.println("Error" + e.getMessage());
        }
        
        return lista; 
    }
    
    
    
    public boolean agregarPromocion(int id, String descripcion){
        Connection acceso = conn.getCnn(); 
        boolean fueAgregado = false; 
        
        try {
            CallableStatement cs = acceso.prepareCall("{ call PROMOCION_PKG.ins(?, ?) }");
            cs.setInt(1, id);
            cs.setString(2, descripcion);   
            
            if(!cs.execute())
            {
                fueAgregado = true; 
            }else{
                fueAgregado = false;
            }
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        
        
        return fueAgregado; 
    }
}
