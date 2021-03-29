/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.nUsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Roles;
import modelo.nUsuario;

/**
 *
 * @author Raque
 */
@Named(value = "nUsuarioController")
@SessionScoped
public class nUsuarioController extends nUsuario implements Serializable {

    /**
     * Creates a new instance of nUsuarioController
     */
    public nUsuarioController() {
    }

    public String nuevoUsuario() {
        nUsuario u = new nUsuario();
        Roles r = new Roles(0, "");
        this.setNombre("");
        this.setApellidos("");
        this.setContraseña("");
        this.setCedula("");
        this.setRol(r);
        return "nuevoUsuario.xhtml";
    }

    public String inserta() throws Exception {
        if (nUsuarioGestion.insertar(this)) {
            this.setNombre("");
            this.setApellidos("");
            this.setContraseña("");
            this.setCedula("");
            return "listaUsuario.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoUsuarioForm: Identificacion", msg);
            return "listaUsuario.xhtml";
        }
    }
}
