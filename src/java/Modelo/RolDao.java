/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author nashi
 */
public class RolDao {
     Conexion conn; 
    
    public RolDao(){
        conn = new Conexion(); 
    }
    
    public List<Rol> fun_mostrarRol(){
        Connection acceso = conn.getCnn(); 
        Rol rol = null; 
        List<Rol> lista = new ArrayList(); 
        
        
        try {
            CallableStatement cs = acceso.prepareCall("{call ROL_PKG.proc_mostrarRol(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute(); 
            
            ResultSet rs = (ResultSet) cs.getObject(1); 
            
            while(rs.next()){
                rol = new Rol(); 
                rol.setId_rol(rs.getInt("ID_ROL"));
                rol.setRol(rs.getString("ROL"));
                
                lista.add(rol); 
            }
        } catch (Exception e) {
            
            System.out.println("Error" + e.getMessage());
        }
        
        return lista; 
    }
    
    
    
    
    
}
