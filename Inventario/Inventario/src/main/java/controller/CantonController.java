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
import modelo.Canton;
import gestion.CantonGestion;

/**
 *
 * @author RAQUE
 */
@Named(value = "cantonController")
@SessionScoped
public class CantonController extends Canton implements Serializable {

    /**
     * Creates a new instance of CantonController
     */
    public CantonController() {
    }
    
    public List<Canton> getCantones() {
        return CantonGestion.getCantones();
    }
    
}
