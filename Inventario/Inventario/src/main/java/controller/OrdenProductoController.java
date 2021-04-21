/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.OrdenProducto;
import gestion.OrdenGestion;
import gestion.OrdenProductoGestion;
import gestion.ProductoGestion;
import java.sql.SQLException;
import modelo.Orden;
import modelo.Producto;
/**
 *
 * @author moiso
 */


@Named(value = "ordenProductoController")
@SessionScoped
public class OrdenProductoController extends OrdenProducto implements Serializable{
    
    public String agregaProducto(int idOrden) {
        Producto producto = ProductoGestion.selectProducto(idOrden);
        Orden orden = OrdenGestion.selectOrden(idOrden);
        System.out.println("Orden: " + orden.toString());
        if(orden!=null) {
            this.setIdOrden(idOrden);
            this.setIdProducto(producto.getIdProducto());
            this.setOrden(orden);
            this.setProducto(producto);
            
            return "agregarProductoOrden.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaOrdenForm: idOrden", msg);
            return "listaOrdenes.xhtml";
        }
    }
    
    
        public String inserta(int idOrden, int idProducto, int idSucursal, int idUsuario) throws Exception {
        if (OrdenProductoGestion.agregarProducto(idOrden,idProducto,idSucursal,idUsuario)) {
            this.setIdOrden(0);
            this.setIdProducto(0);
            this.setIdSucursal(0);
           this.setOrden(null);
           this.setProducto(null);
            return "listaOrdenes.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoProductoForm: Identificacion", msg);
            return "listaOrdenes.xhtml";
        }
    }
        
        
    public List<Producto> getProductos() {
        return ProductoGestion.selectAllProducto();
    }
    
    
}