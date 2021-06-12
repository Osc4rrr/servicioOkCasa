/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author nashi
 */
public class PromocionDao {
        Conexion conn; 
    
    public PromocionDao(){
        conn = new Conexion(); 
    }
    
    public boolean agregarPromocion(Promocion promocion){
        Connection acceso = conn.getCnn(); 
        boolean fueAgregado = false; 
        
        try {
            CallableStatement cs = acceso.prepareCall("{ call PROMOCION_PKG.ins(?, ?) }");
            cs.setInt(1, promocion.getId_promocion());
            cs.setString(2, promocion.getDescripcion());   
            cs.execute();
            
            fueAgregado = !cs.execute();
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
        
        return fueAgregado; 
    }
}
