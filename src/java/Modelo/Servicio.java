/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SEPULS PC'S
 */
public class Servicio {
    private int id_servicio; 
    private String nombre; 
    private String descripcion; 
    private TipoPaquete tipoPaquete; 
    private DetalleServicio detalleServicio; 

    public Servicio() {
    }

    public Servicio(int id_servicio, String nombre, String descripcion, TipoPaquete tipoPaquete, DetalleServicio detalleServicio) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoPaquete = tipoPaquete;
        this.detalleServicio = detalleServicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPaquete getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(TipoPaquete tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public DetalleServicio getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(DetalleServicio detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id_servicio=" + id_servicio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoPaquete=" + tipoPaquete + ", detalleServicio=" + detalleServicio + '}';
    }
    
    

    
    
    
}
