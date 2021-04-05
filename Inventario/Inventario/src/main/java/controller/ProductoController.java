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
import modelo.Producto;
import modelo.TipoProducto;
import gestion.ProductoGestion;
import java.sql.SQLException;
/**
 *
 * @author moiso
 */

@Named(value = "productoController")
@SessionScoped
public class ProductoController extends Producto implements Serializable{

    public ProductoController() {
    }

    public String nuevoProducto() {
        Producto prod = new Producto();
        TipoProducto tipo = new TipoProducto(0,"","");
        this.setDescripcionProducto("");
        this.setPrecioProducto(0);
        this.setFechaElaborado(null);
        this.setFechaVencimiento(null);
        this.setTipoProducto(null);
        this.setNumeroSerie(0);
        this.setCantidadStock(0);
        this.setCantidadMinima(0);
        this.setTipoProducto(tipo);
        return "nuevoProducto.xhtml";
    }
        
        
    public String inserta() throws Exception {
        if (ProductoGestion.insertar(this)) {
            this.setDescripcionProducto("");
            this.setPrecioProducto(0);
            this.setFechaElaborado(null);
            this.setFechaVencimiento(null);
            this.setTipoProducto(null);
            this.setNumeroSerie(0);
            this.setCantidadStock(0);
            this.setCantidadMinima(0);
            return "listaProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoProductoForm: Identificacion", msg);
            return "listaProducto.xhtml";
        }
    }
    
    public List<Producto> getProductos() {
        return ProductoGestion.selectAllProducto();
    }
    
        public String edita(int idProducto) {
        Producto producto = ProductoGestion.selectProducto(idProducto);
        if (producto != null) {
            this.setIdProducto(idProducto);
            this.setDescripcionProducto(producto.getDescripcionProducto());
            this.setPrecioProducto(producto.getPrecioProducto());
            this.setFechaElaborado(producto.getFechaElaborado());
            this.setFechaVencimiento(producto.getFechaVencimiento());
            this.setTipoProducto(producto.getTipoProducto());
            this.setNumeroSerie(producto.getNumeroSerie());
            this.setCantidadStock(producto.getCantidadStock());
            this.setCantidadMinima(producto.getCantidadMinima());
            return "editaProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaProductoForm: idProducto", msg);
            return "listaProducto.xhtml";
        }
    }
        
        
    public String modifica() throws SQLException {
        if (ProductoGestion.updateProducto(this)) { //Si logra modificar
            this.setIdProducto(0);
            this.setDescripcionProducto("");
            this.setPrecioProducto(0);
            this.setFechaElaborado(null);
            this.setFechaVencimiento(null);
            this.setTipoProducto(null);
            this.setNumeroSerie(0);
            this.setCantidadStock(0);
            this.setCantidadMinima(0);
            System.out.println("Modificó producto");
            return "listaProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar Producto");
            FacesContext.getCurrentInstance().addMessage("editaProducto:id", msg);
            System.out.println("No Modificó producto");
            return "listaProducto.xhtml";
        }
    }
    
    public String elimina() throws SQLException{
        if (ProductoGestion.deleteProducto(this.getIdProducto())) { 
            return "listaProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar Producto");
            FacesContext.getCurrentInstance().addMessage("editaProducto:id", msg);
            return "editaProducto.xhtml";
        }
    }
}
