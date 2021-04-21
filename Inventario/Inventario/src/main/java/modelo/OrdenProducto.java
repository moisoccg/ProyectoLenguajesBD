/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moiso
 */
public class OrdenProducto {
    Orden orden;
    List<Producto> listaProducto = new ArrayList<>();
    Producto producto;

    int idOrden;
    int idProducto;
    int idSucursal;


    public OrdenProducto() {
    }

    public OrdenProducto(Orden orden, Producto producto, int idOrden, int idProducto, int idSucursal) {
        this.orden = orden;
        this.producto = producto;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.idSucursal = idSucursal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Orden getOrden() {
        return orden;
    }
    
    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void addProductoToLista(Producto prod){
        this.listaProducto.add(prod);
    }
    
    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> producto) {
        this.listaProducto = producto;
    }

    
}
