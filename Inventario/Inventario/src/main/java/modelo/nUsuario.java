
package modelo;


public class nUsuario {
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Contraseña;
    private String Cedula;
    private Roles Rol;
    //variables para Cliente:
    private Provincia provincia;
    private Canton canton;
    private Distrito distrito;
    private TipoDireccion tdireccion;
    private Direccion direccion;
    private TipoTelefono ttelefono;
    private Telefono telefono;
    private Correo correo;
    
    public nUsuario() {
    }

    public nUsuario(int Id, String Nombre, String Apellidos, String Contraseña, String Cedula, Roles Rol) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Contraseña = Contraseña;
        this.Cedula = Cedula;
        this.Rol = Rol;
    }
    
    //Constructor para Cliente
    public nUsuario(int Id, String Nombre, String Apellidos, String Contraseña, String Cedula, Roles Rol, Provincia provincia, Canton canton, Distrito distrito, TipoDireccion tdireccion, Direccion direccion, TipoTelefono ttelefono, Telefono telefono, Correo correo) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Contraseña = Contraseña;
        this.Cedula = Cedula;
        this.Rol = Rol;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.tdireccion = tdireccion;
        this.direccion = direccion;
        this.ttelefono = ttelefono;
        this.telefono = telefono;
        this.correo = correo;
    }


    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public TipoDireccion getTdireccion() {
        return tdireccion;
    }

    public void setTdireccion(TipoDireccion tdireccion) {
        this.tdireccion = tdireccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TipoTelefono getTtelefono() {
        return ttelefono;
    }

    public void setTtelefono(TipoTelefono ttelefono) {
        this.ttelefono = ttelefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    //variables para cliente
    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
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
    
    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }
}
