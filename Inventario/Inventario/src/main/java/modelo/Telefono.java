
package modelo;

public class Telefono {
    private int idtelefono;
    private String telefono;
    private Usuario Usuario;
    private TipoTelefono TipoTelefono;

    public Telefono() {
    }

    public Telefono(int idtelefono, String telefono, Usuario Usuario, TipoTelefono TipoTelefono) {
        this.idtelefono = idtelefono;
        this.telefono = telefono;
        this.Usuario = Usuario;
        this.TipoTelefono = TipoTelefono;
    }

    public int getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(int idtelefono) {
        this.idtelefono = idtelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public TipoTelefono getTipoTelefono() {
        return TipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono TipoTelefono) {
        this.TipoTelefono = TipoTelefono;
    }
    
    
}
