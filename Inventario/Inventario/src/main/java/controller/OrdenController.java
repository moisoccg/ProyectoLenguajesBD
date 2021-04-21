/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.ProductoGestion;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Orden;
import gestion.OrdenGestion;
import java.util.List;
import modelo.Producto;
import modelo.Sucursal;

/**
 *
 * @author moiso
 */

@Named(value = "ordenController")
@SessionScoped
public class OrdenController extends Orden implements Serializable{
    
      public OrdenController() {
      }

    public String nuevaOrden() {
        Orden orden = new Orden();
        Sucursal sucursal = new Sucursal(0,"");
        this.setIdOrden(0);
        this.setFechaOrden(null);
        this.setSucursal(null);
        this.setUsuario(null);
        this.setIdSucursal(0);
        this.setIdUsuario(0);
        return "nuevaOrden.xhtml";
    }
    
    
    public String inserta() throws Exception {
        if (OrdenGestion.insertar(this)) {
            this.setIdOrden(0);
            this.setFechaOrden(null);
            this.setSucursal(null);
            this.setUsuario(null);
            this.setIdSucursal(0);
            this.setIdUsuario(0);
            return "listaOrdenes.xhtml";
        } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error", "Posible identificación duplicada");
                FacesContext.getCurrentInstance().addMessage("nuevoProductoForm: Identificacion", msg);
                return "listaOrdenes.xhtml";
            }
    }
   
        public String agregaProducto(int idOrden) {
        Producto producto = ProductoGestion.selectProducto(idOrden);
        Orden orden = OrdenGestion.selectOrden(idOrden);
        System.out.println("Orden: " + orden.toString());
        if(orden!=null) {
            
            this.setFechaOrden(orden.getFechaOrden());
            this.setIdOrden(orden.getIdOrden());
            this.setIdSucursal(orden.getIdSucursal());
            this.setIdUsuario(orden.getIdUsuario());
            this.setSucursal(orden.getSucursal());
            this.setUsuario(orden.getUsuario());
            
            return "agregarProductoOrden.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaOrdenForm: idOrden", msg);
            return "listaOrdenes.xhtml";
        }
    }
    
    public List<Orden> getOrdenes() {
        return OrdenGestion.selectAllOrden();
    }
    
    
}
