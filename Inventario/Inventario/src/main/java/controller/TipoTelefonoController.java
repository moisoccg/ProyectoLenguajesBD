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
import modelo.TipoTelefono;
import gestion.TipoTelefonoGestion;

/**
 *
 * @author Raque
 */
@Named(value = "tipotelefonoController")
@SessionScoped
public class TipoTelefonoController extends TipoTelefono implements Serializable {

    /**
     * Creates a new instance of RolController
     */
    public TipoTelefonoController() {
    }
    
    public List<TipoTelefono> getTipoTelefono(){
        return TipoTelefonoGestion.getTipoTelefono();
    }
}
