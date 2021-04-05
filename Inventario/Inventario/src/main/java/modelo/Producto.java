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
public class Producto {
    private int idProducto;
    private String descripcionProducto;
    private float precioProducto;
    private Date fechaElaborado;
    private Date fechaVencimiento;
    private double numeroSerie;
    private double cantidadStock;
    private double cantidadMinima;
    
    private TipoProducto tipoProducto;

    public Producto() {
    }

    public Producto(int idProducto, String descripcionProducto, float precioProducto, Date fechaElaborado, Date fechaVencimiento, double numeroSerie, double cantidadStock, double cantidadMinima, TipoProducto tipoProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.fechaElaborado = fechaElaborado;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroSerie = numeroSerie;
        this.cantidadStock = cantidadStock;
        this.cantidadMinima = cantidadMinima;
        this.tipoProducto = tipoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Date getFechaElaborado() {
        return fechaElaborado;
    }

    public void setFechaElaborado(Date fechaElaborado) {
        this.fechaElaborado = fechaElaborado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(double numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(double cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
}
