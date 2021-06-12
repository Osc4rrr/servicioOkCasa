/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author SEPULS PC'S
 */
public class PersonaDao {
    Conexion conn; 
    
    public PersonaDao(){
        conn = new Conexion(); 
    }
    
    public List<Persona> fun_mostrarPersonas(){
    
        Connection acceso = conn.getCnn(); 
        Persona pers = null; 
        List<Persona> lista = new ArrayList(); 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call PERSONA_PKG.proc_mostrarPersonas(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute(); 
            
            ResultSet rs = (ResultSet) cs.getObject(1); 
            
            while(rs.next()){
                pers = new Persona(); 
                pers.setId_persona(rs.getInt("ID_PERSONA"));
                pers.setRut(rs.getString("RUT"));
                pers.setNombre(rs.getString("NOMBRE"));
                pers.setApellido(rs.getString("APELLIDO"));
                pers.setFecha_nac(rs.getDate("FECHA_NAC"));
                pers.setDireccion(rs.getString("DIRECCION"));
                pers.setCorreo(rs.getString("CORREO"));
                pers.setNro_celular(rs.getInt("NRO_CELULAR"));
                pers.setTipo_persona(rs.getString("TIPO_PERSONA"));
                pers.setContrasenia(rs.getString("CONTRASENIA"));
                
                lista.add(pers); 
            }
        } catch (Exception e) {
            
            System.out.println("Error" + e.getMessage());
        }
        
        return lista; 
    }
    
    
    public boolean agregarPersona(Persona persona){
        Connection acceso = conn.getCnn(); 
        boolean fueAgregado = true; 
        
        try {
            CallableStatement cs = acceso.prepareCall("{ call PERSONA_PKG.ins(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cs.setInt(1, persona.getId_persona());
            cs.setString(2, persona.getRut());
            cs.setString(3, persona.getNombre()); 
            cs.setString(4, persona.getApellido());
            cs.setDate(5, (Date) persona.getFecha_nac());
            cs.setString(6, persona.getDireccion());
            cs.setString(7, persona.getCorreo()); 
            cs.setInt(8,persona.getNro_celular());
            cs.setString(9, persona.getTipo_persona());
            cs.setString(10, persona.getContrasenia());
            
            
            
            fueAgregado = !cs.execute();
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
        
        return fueAgregado; 
        
    }
}
