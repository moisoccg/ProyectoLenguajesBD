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
import modelo.Roles;
import gestion.RolesGestion;

/**
 *
 * @author Raque
 */
@Named(value = "rolController")
@SessionScoped
public class RolesController extends Roles implements Serializable {

    /**
     * Creates a new instance of RolController
     */
    public RolesController() {
    }
    
    public List<Roles> getRol(){
        return RolesGestion.getRoles();
    }
}
