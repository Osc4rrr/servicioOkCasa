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
public class TipoPaquete {
    private int id_tipo_paquete;
    private String paquete;

    public TipoPaquete() {
    }

    public TipoPaquete(int id_tipo_paquete, String paquete) {
        this.id_tipo_paquete = id_tipo_paquete;
        this.paquete = paquete;
    }

    public int getId_tipo_paquete() {
        return id_tipo_paquete;
    }

    public void setId_tipo_paquete(int id_tipo_paquete) {
        this.id_tipo_paquete = id_tipo_paquete;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "TipoPaquete{" + "id_tipo_paquete=" + id_tipo_paquete + ", paquete=" + paquete + '}';
    }
    
    
    
    
}
