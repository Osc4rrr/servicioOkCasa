/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author nashi
 */
public class Promocion {
    private int id_promocion;
    private String descripcion;

    public Promocion() {
    }

    public Promocion(int id_promocion, String descripcion) {
        this.id_promocion = id_promocion;
        this.descripcion = descripcion;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Promocion{" + "id_promocion=" + id_promocion + ", descripcion=" + descripcion + '}';
    }
    
    
}
