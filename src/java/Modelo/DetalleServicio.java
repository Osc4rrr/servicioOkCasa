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
public class DetalleServicio {
    private int id_detalle_servicio;
    private int cantidad_servicio; 
    private Servicio servicio; 
    private int solicitud;

    public DetalleServicio() {
    }

    public DetalleServicio(int id_detalle_servicio, int cantidad_servicio, Servicio servicio, int solicitud) {
        this.id_detalle_servicio = id_detalle_servicio;
        this.cantidad_servicio = cantidad_servicio;
        this.servicio = servicio;
        this.solicitud = solicitud;
    }

    public int getId_detalle_servicio() {
        return id_detalle_servicio;
    }

    public void setId_detalle_servicio(int id_detalle_servicio) {
        this.id_detalle_servicio = id_detalle_servicio;
    }

    public int getCantidad_servicio() {
        return cantidad_servicio;
    }

    public void setCantidad_servicio(int cantidad_servicio) {
        this.cantidad_servicio = cantidad_servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(int solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public String toString() {
        return "DetalleServicio{" + "id_detalle_servicio=" + id_detalle_servicio + ", cantidad_servicio=" + cantidad_servicio + ", servicio=" + servicio + ", solicitud=" + solicitud + '}';
    }
    
    
    
}
