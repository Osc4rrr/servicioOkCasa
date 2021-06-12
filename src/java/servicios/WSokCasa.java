/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import Modelo.Persona;
import Modelo.PersonaDao;
import Modelo.Promocion;
import Modelo.PromocionDao;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author SEPULS PC'S
 */
@WebService(serviceName = "WSokCasa")
public class WSokCasa {
    
    /* SOY UN COMENTARIO 
    * SOY OTRO COMENTARIO
    * otro comentario mas
    */
    @WebMethod(operationName= "mostrarPersonas")
    @WebResult(name="Persona")
    public List<Persona> get_todoProducto(){
        
        PersonaDao persDao = new PersonaDao(); 
        List<Persona> lista = persDao.fun_mostrarPersonas(); 
        return lista; 
    }
    
    @WebMethod(operationName="insertarPersona")
    @WebResult (name="Persona")
    public boolean ingresarPersona(
            @WebParam(name="idPersona") int id_persona, 
            @WebParam(name="rutPersona") String rut_persona, 
            @WebParam(name="nombrePersona") String nombre_persona,
            @WebParam(name="apellidoPersona") String apellido_persona,
            @WebParam(name="fechaNacPersona") Date fecha_nac_persona,
            @WebParam(name="direccionPersona") String direccion_persona, 
            @WebParam(name="correoPersona") String correo_persona,
            @WebParam(name="nroCelularPersona") int nro_celular_persona, 
            @WebParam(name="tipoPersona") String tipo_persona,
            @WebParam(name="contraseniaPersona") String contrasenia_persona 
    ){
        
        Persona p = new Persona(); 
        
        p.setId_persona(id_persona);
        p.setRut(rut_persona);
        p.setNombre(nombre_persona);
        p.setApellido(apellido_persona);
        p.setFecha_nac(fecha_nac_persona);
        p.setDireccion(direccion_persona);
        p.setCorreo(correo_persona);
        p.setNro_celular(nro_celular_persona);
        p.setTipo_persona(tipo_persona);
        p.setContrasenia(contrasenia_persona);
        
        
        
        return true; 
    }
    
    @WebMethod(operationName= "mostrarPromocion")
    @WebResult(name="Promocion")
    public List<Promocion> obtenerPromocion(){
        
        PromocionDao proDao = new PromocionDao(); 
        
        List<Promocion> lista = proDao.fun_mostrarPromocion(); 
        
        return lista; 
    }
    
    @WebMethod(operationName="insertarPromocion")
    @WebResult (name="Promocion")
    public boolean ingresarPromocion(
            @WebParam(name="idpromocion") int id_promocion, 
            @WebParam(name="descripcion") String descripcion

    ){
        
        PromocionDao p = new PromocionDao();
        
        p.fun_agregarPromocion(id_promocion, descripcion);
        
        return true; 
    }
    
    @WebMethod(operationName="actualizarPromocion")
    @WebResult (name="Promocion")
    public boolean actualizarPromocion(
            @WebParam(name="idpromocion") int id_promocion, 
            @WebParam(name="descripcion") String descripcion)
    {
        
        PromocionDao promDao = new PromocionDao();
        
        boolean resultado = promDao.fun_actualizarPromocion(id_promocion, descripcion);
        
        return resultado; 
    }
    
    
    
    /* SOY UN COMENTARIO 
    * SOY OTRO COMENTARIO oscar 
    * otro comentario mas
    */


}
