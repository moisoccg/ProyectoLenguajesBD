/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.DistritoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import modelo.Distrito;

/**
 *
 * @author RAQUE
 */
@Named(value = "distritoController")
@SessionScoped
public class DistritoController extends Distrito implements Serializable {

    /**
     * Creates a new instance of DistritoController
     */
    public DistritoController() {
    }
    
    public List<Distrito> getDistritos() {
        return DistritoGestion.getDistritos();
    }
}
