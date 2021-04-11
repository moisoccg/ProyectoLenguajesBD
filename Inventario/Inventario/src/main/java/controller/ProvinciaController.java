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
import modelo.Provincia;
import gestion.ProvinciaGestion;

/**
 *
 * @author Raque
 */
@Named(value = "provinciaController")
@SessionScoped
public class ProvinciaController extends Provincia implements Serializable {

    /**
     * Creates a new instance of RolController
     */
    public ProvinciaController() {
    }
    
    public List<Provincia> getProvincias(){
        return ProvinciaGestion.getProvincias();
    }
}
