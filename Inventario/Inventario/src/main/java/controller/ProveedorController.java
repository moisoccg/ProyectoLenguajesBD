/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.ProveedorGestion;
import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Proveedor;
import modelo.Usuario;


/**
 *
 * @author RAQUE
 */
@Named(value = "proveedorController")
@SessionScoped
public class ProveedorController extends Proveedor implements Serializable {

    /**
     * Creates a new instance of ProveedorController
     */
    public ProveedorController() {
    }
    
    public String nuevoProveedor() {
        Proveedor p = new Proveedor();
        this.setNombreProveedor("");
        this.setCedulajuridica("");
        this.setTelefonoProveedor("");
        return "nuevoProveedor.xhtml";
    }

    public String inserta() throws Exception {
        if (ProveedorGestion.insertar(this)) {
           this.setNombreProveedor("");
           this.setCedulajuridica("");
           this.setTelefonoProveedor("");
            return "listaProveedor.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoProveedorForm: Identificacion", msg);
            return "listaProveedor.xhtml";
        }
    }
    
    public List<Proveedor> getProveedores() {
        return ProveedorGestion.getProveedores();
    }
    
    public String edita(int IdProveedor) {
        Proveedor elProveedor = ProveedorGestion.getProveedor(IdProveedor);
        if (elProveedor != null) {
            this.setIdproveedor(elProveedor.getIdproveedor());
            this.setNombreProveedor(elProveedor.getNombreProveedor());
            this.setCedulajuridica(elProveedor.getCedulajuridica());
            this.setTelefonoProveedor(elProveedor.getTelefonoProveedor());
            return "editaProveedor.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaUsuarioForm: idUsuario", msg);
            return "listaProveedor.xhtml";
        }
    }
    
    public String modifica() {
        if (ProveedorGestion.modificar(this)) { //Si logra modificar
            this.setIdproveedor(0);
            this.setNombreProveedor("");
            this.setTelefonoProveedor("");
            return "listaProveedor.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar Proveedor");
            FacesContext.getCurrentInstance().addMessage("editaProveedor:id", msg);
            return "listaProveedor.xhtml";
        }
    }
    
    public String elimina() {
        if (ProveedorGestion.eliminar(this.getIdproveedor())) { 
            return "listaProveedor.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar Proveedor");
            FacesContext.getCurrentInstance().addMessage("editaProveedor:id", msg);
            return "editaProveedor.xhtml";
        }
    }

}
