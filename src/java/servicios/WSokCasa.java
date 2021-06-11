/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import Modelo.Persona;
import Modelo.PersonaDao;
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
    
    /* SOY UN COMENTARIO */
    @WebMethod(operationName= "mostrarPersonas")
    @WebResult(name="Persona")
    public List<Persona> get_todoProducto(){
        
        PersonaDao persDao = new PersonaDao(); 
        List<Persona> lista = persDao.fun_mostrarPersonas(); 
        return lista; 
    }
    


}
