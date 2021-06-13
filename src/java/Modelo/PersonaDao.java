/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    
    
    public boolean agregarPersona(Persona persona) throws ParseException{
        Connection acceso = conn.getCnn(); 
        boolean fueAgregado = true; 
        
        
         //SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
         //Date fecha = DateFor.parse("10/10/2010"); 
         //java.sql.Date sqlDate = new java.sql.Date();
         
         //java.util.Date dateUtil=new java.util.Date("22/08/2020"); 
         //java.sql.Date dateSql= new java.sql.Date(dateUtil.getDay(),dateUtil.getMonth(),dateUtil.getYear());
         
         
         java.sql.Date planilla = (java.sql.Date)persona.getFecha_nac();
         
        
        try {
            //System.out.println("Fecha aca " + dateSql);
            
            

            
            //Date fecha_na = Date.valueOf(persona.getFecha_nac()); 
            
            //System.out.println("Fecha parseada " + fecha_na);
            
            CallableStatement cs = acceso.prepareCall("{ call PERSONA_PKG.ins(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cs.setString(1, persona.getRut());
            cs.setString(2, persona.getDireccion()); 
            cs.setInt(3, persona.getId_persona());
            cs.setString(4, persona.getApellido());
            cs.setString(5, persona.getCorreo());
            cs.setInt(6, persona.getNro_celular()); 
            cs.setDate(7, new java.sql.Date(persona.getFecha_nac().getTime()));
            cs.setString(8, persona.getTipo_persona());
            cs.setString(9, persona.getNombre());
            cs.setString(10, persona.getContrasenia());

            fueAgregado = !cs.execute();
            
            
        } catch (SQLException e) {
            
            System.out.println("Error aca: " + e.getMessage());
        }
        
        
        return fueAgregado; 
        
    }
    
    public boolean eliminarPersona(int codigo_persona){
        Connection acceso = conn.getCnn(); 
        boolean fueEliminado =false; 
        
        try {
            CallableStatement cs = acceso.prepareCall("{call PERSONA_PKG.del(?)}");
            cs.setInt(1, codigo_persona);
            
            fueEliminado = !cs.execute(); 
        } catch (SQLException e) {
            System.out.println("Error aca: " + e.getMessage());

        }
        
        return fueEliminado; 
    
    }
}
