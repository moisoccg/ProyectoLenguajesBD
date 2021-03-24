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
import java.util.List;
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
    
    
    public String valida(){
        Usuario usuario = UsuarioGestion.valida(this.getId(),this.getContraseña());
        if(usuario!=null){
            
            this.setId(usuario.getId());
            this.setNombre(usuario.getNombre());
            this.setApellidos(usuario.getApellidos());
            this.setContraseña(usuario.getContraseña());
            this.setCedula(usuario.getCedula());
            this.setRol(usuario.getRol());

            if (this.getRol().getIdRol()==1) {
                System.out.println("Soy administrador");
                return "PrincipalAdmin.xhtml";
            }
            else{
                return "hola1.xhtml";
            }
        }else{
            
            FacesMessages.error("loginForm:growlMsg", "Error!" , "Usuario o contraseña no válidos!");
 
            return "index.xhtml";
        }
    }
    
      public List<Usuario> getUsuarios(){
        return UsuarioGestion.getUsuarios();
    }
}
