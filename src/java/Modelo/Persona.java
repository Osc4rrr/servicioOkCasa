/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author SEPULS PC'S
 */
public class Persona {
    
    private int id_persona; 
    private String rut; 
    private String nombre; 
    private String apellido; 
    private Date fecha_nac;
    private String direccion; 
    private String correo; 
    private int nro_celular; 
    private String tipo_persona; 
    private String contrasenia; 

    public Persona() {
    }

    public Persona(int id_persona, String rut, String nombre, String apellido, Date fecha_nac, String direccion, String correo, int nro_celular, String tipo_persona, String contrasenia) {
        this.id_persona = id_persona;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.correo = correo;
        this.nro_celular = nro_celular;
        this.tipo_persona = tipo_persona;
        this.contrasenia = contrasenia;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNro_celular() {
        return nro_celular;
    }

    public void setNro_celular(int nro_celular) {
        this.nro_celular = nro_celular;
    }

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nac=" + fecha_nac + ", direccion=" + direccion + ", correo=" + correo + ", nro_celular=" + nro_celular + ", tipo_persona=" + tipo_persona + ", contrasenia=" + contrasenia + '}';
    }
    
    
    
    
    
}
