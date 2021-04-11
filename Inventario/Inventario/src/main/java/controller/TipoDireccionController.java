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
import modelo.TipoDireccion;
import gestion.TipoDireccionGestion;

/**
 *
 * @author Raque
 */
@Named(value = "tipodireccionController")
@SessionScoped
public class TipoDireccionController extends TipoDireccion implements Serializable {

    /**
     * Creates a new instance of RolController
     */
    public TipoDireccionController() {
    }
    
    public List<TipoDireccion> getTipoDireccion(){
        return TipoDireccionGestion.getTipoDireccion();
    }
}
