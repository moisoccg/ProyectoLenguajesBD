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
import modelo.Canton;
import modelo.Correo;
import modelo.Direccion;
import modelo.Distrito;
import modelo.Provincia;
import modelo.Roles;
import modelo.Telefono;
import modelo.TipoDireccion;
import modelo.TipoTelefono;
import modelo.nUsuario;


/**
 *
 * @author Raque
 */
@Named(value = "nUsuarioController")
@SessionScoped
public class nUsuarioController extends nUsuario implements Serializable {
     
    Canton canton = new Canton();
    Correo correo = new Correo();
    Direccion direccion = new Direccion();
    Distrito distrito = new Distrito();
    Provincia provincia = new Provincia();
    Telefono telefono = new Telefono();
    TipoDireccion tdireccion = new TipoDireccion();
    TipoTelefono ttelefono = new TipoTelefono();
            
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
    
    
    public String insertaCliente(String correo,
                String telefono, int tipotelefono, int tdireccion, int provincia,
                int canton, int distrito, String  direccion) throws Exception {
        if (nUsuarioGestion.insertarCliente(this, correo,
                 telefono,  tipotelefono,  tdireccion,  provincia,
                 canton,  distrito,   direccion)) {
            this.setNombre("");
            this.setApellidos("");
            this.setContraseña("");
            this.setCedula("");
            this.setRol(null);
            this.setProvincia(null);
            this.setCanton(null);
            this.setDistrito(null);
            this.setDireccion(null);
            this.setTdireccion(null);
            this.setTelefono(null);
            this.setTtelefono(null);
            this.setCorreo(null);
            return "listaCliente.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoUsuarioForm: Identificacion", msg);
            return "listaCliente.xhtml";
        }
    }
    
        public String insertaCliente() throws Exception {
        if (nUsuarioGestion.insertarCliente(this)) {
            this.setNombre("");
            this.setApellidos("");
            this.setContraseña("");
            this.setCedula("");
            this.setRol(null);
            this.setProvincia(null);
            this.setCanton(null);
            this.setDistrito(null);
            this.setDireccion(null);
            this.setTdireccion(null);
            this.setTelefono(null);
            this.setTtelefono(null);
            this.setCorreo(null);
            return "listaCliente.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("nuevoUsuarioForm: Identificacion", msg);
            return "listaCliente.xhtml";
        }
    }
    
    public String nuevoCliente() {
        nUsuario u = new nUsuario();
            this.setNombre("");
            this.setApellidos("");
            this.setContraseña("");
            this.setCedula("");
            this.setRol(null);
            this.setProvincia(null);
            this.setCanton(null);
            this.setDistrito(null);
            this.setDireccion(null);
            this.setTdireccion(null);
            this.setTelefono(null);
            this.setTtelefono(null);
            this.setCorreo(null);
        return "nuevoCliente.xhtml";
    }
}
