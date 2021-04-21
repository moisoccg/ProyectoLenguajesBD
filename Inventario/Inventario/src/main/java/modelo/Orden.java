/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author moiso
 */
public class Orden {
    
    private int idOrden;
    private Date fechaOrden;
    private int idUsuario;
    private int idSucursal;
    private Sucursal sucursal;
    private Usuario usuario;

    public Orden() {
    }

    public Orden(int idOrden, Date fechaOrden, Sucursal sucursal, Usuario usuario) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.idUsuario = idUsuario;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }
    
    public Orden(int idOrden, Date fechaOrden, int idUsuario, int idSucursal) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.sucursal.setIdSucursal(idSucursal);
        this.usuario.setId(idUsuario);
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

            
}
