/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author moiso
 */
public class TipoProducto {
    
    private int idTipoProducto;
    private String nombreTipoProducto;
    private String descripcionTipoProducto;

    public TipoProducto() {
    }

    public TipoProducto(int idTipoProducto, String nombreTipoProducto, String descripcionTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        this.nombreTipoProducto = nombreTipoProducto;
        this.descripcionTipoProducto = descripcionTipoProducto;
    }
    
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public String getDescripcionTipoProducto() {
        return descripcionTipoProducto;
    }

    public void setDescripcionTipoProducto(String descripcionTipoProducto) {
        this.descripcionTipoProducto = descripcionTipoProducto;
    }

}
