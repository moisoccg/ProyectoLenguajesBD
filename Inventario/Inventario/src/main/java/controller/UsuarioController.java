/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author RAQUE
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }

    public String valida() {
        Usuario usuario = UsuarioGestion.valida(this.getId(), this.getContraseña());
        if (usuario != null) {

            this.setId(usuario.getId());
            this.setNombre(usuario.getNombre());
            this.setApellidos(usuario.getApellidos());
            this.setContraseña(usuario.getContraseña());
            this.setCedula(usuario.getCedula());
            this.setRol(usuario.getRol());

            if (this.getRol().getIdRol() == 1) {
                System.out.println("Soy administrador");
                return "PrincipalAdmin.xhtml";
            } else {
                return "hola1.xhtml";
            }
        } else {

            FacesMessages.error("loginForm:growlMsg", "Error!", "Usuario o contraseña no válidos!");

            return "index.xhtml";
        }
    }

    public List<Usuario> getUsuarios() {
        return UsuarioGestion.getUsuarios();
    }

    public String edita(int Id) {
        Usuario elUsuario = UsuarioGestion.getUsuario(Id);
        if (elUsuario != null) {
            this.setId(elUsuario.getId());
            this.setNombre(elUsuario.getNombre());
            this.setApellidos(elUsuario.getApellidos());
            this.setContraseña(elUsuario.getContraseña());
            this.setCedula(elUsuario.getCedula());
            this.setRol(elUsuario.getRol());
            return "editaUsuario.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("listaUsuarioForm: idUsuario", msg);
            return "listaUsuario.xhtml";
        }
    }

    public String elimina() {
        if (UsuarioGestion.eliminar(this.getId())) { 
            return "listaUsuario.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar Usuario");
            FacesContext.getCurrentInstance().addMessage("editaUsuario:id", msg);
            return "listaUsuario.xhtml";
        }
    }
    
    public String modifica() {
        if (UsuarioGestion.modificar(this)) { //Si logra modificar
            this.setId(0);
            this.setNombre("");
            this.setApellidos("");
            this.setContraseña("");
            this.setCedula("");
            return "listaUsuario.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al modificar Usuario");
            FacesContext.getCurrentInstance().addMessage("editaUsuario:id", msg);
             return "listaUsuario.xhtml";
        }
    }
}