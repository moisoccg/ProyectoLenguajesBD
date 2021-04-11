
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Telefono;

/**
 *
 * @author RAQUE
 */
@Named(value = "telefonoController")
@SessionScoped
public class TelefonoController extends Telefono implements Serializable {

    /**
     * Creates a new instance of TelefonoController
     */
    public TelefonoController() {
    }
    
}
