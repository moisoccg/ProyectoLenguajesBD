
package modelo;

public class TipoTelefono {
    private int idtipotelefono;
    private String tipotelefono;

    public TipoTelefono() {
    }

    public TipoTelefono(int idtipotelefono, String tipotelefono) {
        this.idtipotelefono = idtipotelefono;
        this.tipotelefono = tipotelefono;
    }

    public int getIdtipotelefono() {
        return idtipotelefono;
    }

    public void setIdtipotelefono(int idtipotelefono) {
        this.idtipotelefono = idtipotelefono;
    }

    public String getTipotelefono() {
        return tipotelefono;
    }

    public void setTipotelefono(String tipotelefono) {
        this.tipotelefono = tipotelefono;
    }
    
    
}
