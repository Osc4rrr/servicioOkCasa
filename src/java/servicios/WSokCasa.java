/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import Modelo.DetalleServicio;
import Modelo.Persona;
import Modelo.PersonaDao;
import Modelo.Servicio;
import Modelo.ServicioDao;
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
    
    //Listar Servicios
    @WebMethod(operationName = "mostrarServicios")
    @WebResult(name="Servicio")
    public List<Servicio> get_todoServicio(){
        ServicioDao sDao = new ServicioDao(); 
        List<Servicio> lista = sDao.fun_mostrarServicios(); 
        
        return lista; 
    
    }
    
    //Agregar Servicio
    @WebMethod(operationName = "agregarServicio")
    @WebResult(name="servicio")
    public boolean ingresarServicio(
            @WebParam(name="id_servicio") int id_servicio, 
            @WebParam(name="nombre_servicio") String nombre_servicio, 
            @WebParam(name="descripcion") String descripcion, 
            @WebParam(name="tipo_paquete_id") int tipo_paquete_id, 
            @WebParam(name="servicio_id") int servicio_id
    ){
    
        Servicio s = new Servicio();
        TipoPaquete tp = new TipoPaquete(); 
        DetalleServicio ds = new DetalleServicio(); 
        
        tp.setId_tipo_paquete(tipo_paquete_id);
        ds.setId_detalle_servicio(id_servicio);
        
        s.setId_servicio(id_servicio);
        s.setNombre(nombre_servicio);
        s.setDescripcion(descripcion);
        s.setTipoPaquete(tp);
        s.setDetalleServicio(ds);
        
        ServicioDao sDao = new ServicioDao();
        
        return sDao.agregarServicio(s); 
               
    }
    
    //modificar Servicio
    @WebMethod(operationName = "modificarServicio")
    @WebResult(name="servicio")
    public boolean modificarServicio(
            @WebParam(name="id_servicio") int id_servicio, 
            @WebParam(name="servicio_id") int servicio_id,
            @WebParam(name="nombre_servicio") String nombre_servicio, 
            @WebParam(name="descripcion") String descripcion, 
            @WebParam(name="tipo_paquete_id") int tipo_paquete_id
            
    ){
    
        Servicio s = new Servicio();
        
        s.setId_servicio(id_servicio);
        s.setNombre(nombre_servicio);
        s.setDescripcion(descripcion);
        s.setTipo_paquete_id_tipo_paquete(tipo_paquete_id);
        s.setServicio_id(servicio_id);
        
        ServicioDao sDao = new ServicioDao();
        
        return sDao.modificarServicio(s); 
               
    }
    
    //Eliminar Servicio 
    @WebMethod(operationName = "eliminarServicio")
    @WebResult(name="servicio")
    public boolean eliminarServicio(
            @WebParam(name="id_servicio") int id_servicio,
            @WebParam(name="servicio_id") int servicio_id){
    
        ServicioDao sDao = new ServicioDao(); 
        
        return sDao.eliminarServicio(id_servicio, servicio_id); 
    
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
    
    //Eliminar persona
    @WebMethod(operationName = "eliminarPersona")
    @WebResult(name="Persona")
    public boolean eliminarPersona(@WebParam(name="id_codigo_persona") int id_persona){
        PersonaDao pDao = new PersonaDao(); 
        return pDao.eliminarPersona(id_persona); 
       
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
        
        
        String string = fecha_nac_persona;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(string);
       
        
        
        p.setId_persona(id_persona);
        p.setRut(rut_persona);
        p.setNombre(nombre_persona);
        p.setApellido(apellido_persona);
        p.setFecha_nac(date);
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
