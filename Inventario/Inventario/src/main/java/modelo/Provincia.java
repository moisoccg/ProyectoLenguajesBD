
package modelo;

public class Provincia {
    private int idprovincia;
    private String descripcionprovincia;

    public Provincia() {
    }

    public Provincia(int idprovincia, String descripcionprovincia) {
        this.idprovincia = idprovincia;
        this.descripcionprovincia = descripcionprovincia;
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getDescripcionprovincia() {
        return descripcionprovincia;
    }

    public void setDescripcionprovincia(String descripcionprovincia) {
        this.descripcionprovincia = descripcionprovincia;
    }
    
    
}
