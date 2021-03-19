
package modelo;

public class Usuario {
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Contraseña;
    private String Cedula;
    private Roles Rol;

    public Usuario() {
    }

    public Usuario(int Id, String Nombre, String Apellidos, String Contraseña, String Cedula, Roles Rol) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Contraseña = Contraseña;
        this.Cedula = Cedula;
        this.Rol = Rol;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public Roles getRol() {
        return Rol;
    }

    public void setRol(Roles Rol) {
        this.Rol = Rol;
    }

    
}