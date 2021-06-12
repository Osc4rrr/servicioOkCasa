/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import Modelo.Persona;
import Modelo.PersonaDao;
import Modelo.TipoPaquete;
import Modelo.TipoPaqueteDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    
    //Listar Personas
    @WebMethod(operationName= "mostrarPersonas")
    @WebResult(name="Persona")
    public List<Persona> get_todoProducto(){
        
        PersonaDao persDao = new PersonaDao(); 
        List<Persona> lista = persDao.fun_mostrarPersonas(); 
        return lista; 
    }
    
    //Listar Tipos Paquete
    @WebMethod(operationName= "mostrarTiposPaquete")
    @WebResult(name="TipoPaquete")
    public List<TipoPaquete> get_todoTipoPaquete(){
        
        TipoPaqueteDao tpDao = new TipoPaqueteDao(); 
        List<TipoPaquete> lista = tpDao.fun_mostrarTipoPaquete(); 
        return lista; 
    }
    
    
    //Agregar Tipo Paquete
    @WebMethod(operationName= "agregarTipoPaquete")
    @WebResult(name="TipoPaquete")
    public boolean ingresarTipoPaquete(
            @WebParam(name="id_tipo_paquete") int id_tipo_paquete,
            @WebParam(name="paquete") String paquete){
        
        TipoPaquete tp = new TipoPaquete(); 
        
        tp.setId_tipo_paquete(id_tipo_paquete);
        tp.setPaquete(paquete);
        
        TipoPaqueteDao tpDao = new TipoPaqueteDao(); 
       
        
        return tpDao.agregarTipoPaquete(tp); 
       
    }
    
    //Modificar Tipo Paquete
    @WebMethod(operationName= "modificarTipoPaquete")
    @WebResult(name="TipoPaquete")
    public boolean modificarTipoPaquete(
            @WebParam(name="id_tipo_paquete") int id_tipo_paquete,
            @WebParam(name="paquete") String paquete){
        
        TipoPaquete tp = new TipoPaquete(); 
        
        tp.setId_tipo_paquete(id_tipo_paquete);
        tp.setPaquete(paquete);
        
        TipoPaqueteDao tpDao = new TipoPaqueteDao(); 
       
        
        return tpDao.modificarTipoPaquete(tp); 
       
    }
    
    //Eliminar Tipo Paquete
    @WebMethod(operationName= "eliminarTipoPaquete")
    @WebResult(name="TipoPaquete")
    public boolean eliminarTipoPaquete(
            @WebParam(name="id_tipo_paquete") int id_tipo_paquete){
        
        TipoPaquete tp = new TipoPaquete(); 
        
        tp.setId_tipo_paquete(id_tipo_paquete);
        
        TipoPaqueteDao tpDao = new TipoPaqueteDao(); 
       
        return tpDao.eliminarTipoPaquete(tp); 
       
    }
    
    
    @WebMethod(operationName="insertarPersona")
    @WebResult (name="Persona")
    public boolean ingresarPersona(
            @WebParam(name="idPersona") int id_persona, 
            @WebParam(name="rutPersona") String rut_persona, 
            @WebParam(name="nombrePersona") String nombre_persona,
            @WebParam(name="apellidoPersona") String apellido_persona,
            @WebParam(name="fechaNacPersona") String fecha_nac_persona,
            @WebParam(name="direccionPersona") String direccion_persona, 
            @WebParam(name="correoPersona") String correo_persona,
            @WebParam(name="nroCelularPersona") int nro_celular_persona, 
            @WebParam(name="tipoPersona") String tipo_persona,
            @WebParam(name="contraseniaPersona") String contrasenia_persona 
    ) throws ParseException{
        
        Persona p = new Persona(); 
        String sDate1="31/12/1998";  
        Date date1=new SimpleDateFormat("d/M/yyyy").parse(sDate1);  
        
        
        p.setId_persona(id_persona);
        p.setRut(rut_persona);
        p.setNombre(nombre_persona);
        p.setApellido(apellido_persona);
        p.setFecha_nac( date1);
        p.setDireccion(direccion_persona);
        p.setCorreo(correo_persona);
        p.setNro_celular(nro_celular_persona);
        p.setTipo_persona(tipo_persona);
        p.setContrasenia(contrasenia_persona);
        
        
        
        
        System.out.println(p);
        
        PersonaDao persDao = new PersonaDao(); 
        
        return persDao.agregarPersona(p);
        
        
    }
    
    
    
    /* SOY UN COMENTARIO 
    * SOY OTRO COMENTARIO oscar 
    * otro comentario mas
    */


}
