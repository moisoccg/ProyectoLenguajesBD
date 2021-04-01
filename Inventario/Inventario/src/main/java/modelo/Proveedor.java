
package modelo;

public class Proveedor {
    private int idproveedor;
    private String nombreProveedor;
    private String cedulajuridica;
    private String telefonoProveedor;

    public Proveedor() {
    }

    public Proveedor(int idproveedor, String nombreProveedor, String cedulajuridica, String telefonoProveedor) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
        this.cedulajuridica = cedulajuridica;
        this.telefonoProveedor = telefonoProveedor;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCedulajuridica() {
        return cedulajuridica;
    }

    public void setCedulajuridica(String cedulajuridica) {
        this.cedulajuridica = cedulajuridica;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
    
    
}
