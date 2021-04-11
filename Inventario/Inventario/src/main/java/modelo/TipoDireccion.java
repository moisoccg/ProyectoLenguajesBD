
package modelo;

public class TipoDireccion {
    private int idtipodireccion;
    private String tipodirecccion;

    public TipoDireccion() {
    }

    public TipoDireccion(int idtipodireccion, String tipodirecccion) {
        this.idtipodireccion = idtipodireccion;
        this.tipodirecccion = tipodirecccion;
    }

    public int getIdtipodireccion() {
        return idtipodireccion;
    }

    public void setIdtipodireccion(int idtipodireccion) {
        this.idtipodireccion = idtipodireccion;
    }

    public String getTipodirecccion() {
        return tipodirecccion;
    }

    public void setTipodirecccion(String tipodirecccion) {
        this.tipodirecccion = tipodirecccion;
    }
    
    
}
