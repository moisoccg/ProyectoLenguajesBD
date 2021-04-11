
package modelo;

public class Direccion {
  private int iddireccion;
  private String direccion; //calle
  private Distrito Distrito;
  private Canton Canton;
  private Provincia Provincia;
  private Usuario Usuario;
  private TipoDireccion TipoDireccion;

    public Direccion() {
    }

    public Direccion(int iddireccion, String direccion, Distrito Distrito, Canton Canton, Provincia Provincia, Usuario Usuario, TipoDireccion TipoDireccion) {
        this.iddireccion = iddireccion;
        this.direccion = direccion;
        this.Distrito = Distrito;
        this.Canton = Canton;
        this.Provincia = Provincia;
        this.Usuario = Usuario;
        this.TipoDireccion = TipoDireccion;
    }

    public int getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(int iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Distrito getDistrito() {
        return Distrito;
    }

    public void setDistrito(Distrito Distrito) {
        this.Distrito = Distrito;
    }

    public Canton getCanton() {
        return Canton;
    }

    public void setCanton(Canton Canton) {
        this.Canton = Canton;
    }

    public Provincia getProvincia() {
        return Provincia;
    }

    public void setProvincia(Provincia Provincia) {
        this.Provincia = Provincia;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public TipoDireccion getTipoDireccion() {
        return TipoDireccion;
    }

    public void setTipoDireccion(TipoDireccion TipoDireccion) {
        this.TipoDireccion = TipoDireccion;
    }
  
  
  
}
