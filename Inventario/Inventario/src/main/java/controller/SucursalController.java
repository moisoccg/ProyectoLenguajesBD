/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.SucursalGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Sucursal;

/**
 *
 * @author RAQUE
 */
@Named(value = "sucursalController")
@SessionScoped
public class SucursalController extends Sucursal implements Serializable {

    /**
     * Creates a new instance of ProveedorController
     */
    public SucursalController() {
    }
    
    public String nuevaSucursal() {
        Sucursal s = new Sucursal();
        this.setNombreSucursal("");
        return "nuevaSucursal.xhtml";
    }

    public String inserta() throws Exception {
        if (SucursalGestion.insertar(this)) {
           this.setNombreSucursal("");
            return "listaSucursal.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevaSucursalForm: Identificacion", msg);
            return "listaSucursal.xhtml";
        }
    }
    
    public List<Sucursal> getSucursales() {
        return SucursalGestion.getSucursales();
    }
    
    public String edita(int IdSucursal) {
        Sucursal laSucursal = SucursalGestion.getSucursal(IdSucursal);
             
        if (laSucursal != null) {
            this.setIdSucursal(laSucursal.getIdSucursal());
            this.setNombreSucursal(laSucursal.getNombreSucursal());
            return "editaSucursal.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaSucursalForm: idSucursalo", msg);
            return "listaSucursal.xhtml";
        }
    }
    
    public String modifica() {
        if (SucursalGestion.modificar(this)) { //Si logra modificar
            this.setIdSucursal(0);
            this.setNombreSucursal("");
            return "listaSucursal.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar Sucursal");
            FacesContext.getCurrentInstance().addMessage("editaProveedor:id", msg);
            return "listaSucursal.xhtml";
        }
    }
    
    public String elimina() {
        if (SucursalGestion.eliminar(this.getIdSucursal())) { 
            return "listaSucursal.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar Sucursal");
            FacesContext.getCurrentInstance().addMessage("editaSucursal:id", msg);
            return "editaSucursal.xhtml";
        }
    }
    
}
