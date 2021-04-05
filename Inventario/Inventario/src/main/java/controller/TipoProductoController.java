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
import modelo.TipoProducto;
import gestion.TipoProductoGestion;
import java.sql.SQLException;
/**
 *
 * @author moiso
 */

@Named(value = "tipoProductoController")
@SessionScoped
public class TipoProductoController extends TipoProducto implements Serializable{

    public TipoProductoController() {
    }
    
    public String nuevoTipoProducto() {
        TipoProducto tipo = new TipoProducto();
        this.setNombreTipoProducto("");
        this.setDescripcionTipoProducto("");
        return "nuevoTipoProducto.xhtml";
    }

    public String inserta() throws Exception {
        if (TipoProductoGestion.insertar(this)) {
           this.setNombreTipoProducto("");
        this.setDescripcionTipoProducto("");
            return "listaTipoProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoProveedorForm: Identificacion", msg);
            return "listaTipoProducto.xhtml";
        }
    }
    
    public List<TipoProducto> getTiposProducto() {
        return TipoProductoGestion.selectAllTipos();
    }
    
    public String edita(int idTipoProducto) {
        TipoProducto tipoProducto = TipoProductoGestion.selectTipoProducto(idTipoProducto);
        if (tipoProducto != null) {
            this.setIdTipoProducto(idTipoProducto);
            this.setNombreTipoProducto(tipoProducto.getNombreTipoProducto());
            this.setDescripcionTipoProducto(tipoProducto.getDescripcionTipoProducto());
            return "editaTipoProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaUsuarioForm: idUsuario", msg);
            return "listaProveedor.xhtml";
        }
    }
    
    public String modifica() throws SQLException {
       
        if (TipoProductoGestion.updateTipoProducto(this)) { //Si logra modificar
            this.setIdTipoProducto(0);
            this.setNombreTipoProducto("");
            this.setDescripcionTipoProducto("");
            System.out.println("Modificó tipo producto");
            return "listaTipoProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar Proveedor");
            FacesContext.getCurrentInstance().addMessage("editaProveedor:id", msg);
            System.out.println("No Modificó tipo producto");
            return "listaTipoProducto.xhtml";
        }
    }
    
    public String elimina() throws SQLException{
        if (TipoProductoGestion.deleteTipoProducto(this.getIdTipoProducto())) { 
            return "listaTipoProducto.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar Proveedor");
            FacesContext.getCurrentInstance().addMessage("editaProveedor:id", msg);
            return "editaTipoProducto.xhtml";
        }
    }

    
}
