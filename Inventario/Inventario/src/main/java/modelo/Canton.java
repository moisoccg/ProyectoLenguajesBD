
package modelo;

public class Canton {
    private int idcanton;
    private String descripcioncanton;
    private Provincia provincia;

    public Canton() {
    }

    public Canton(int idcanton, String descripcioncanton, Provincia provincia) {
        this.idcanton = idcanton;
        this.descripcioncanton = descripcioncanton;
        this.provincia = provincia;
    }

    public int getIdcanton() {
        return idcanton;
    }

    public void setIdcanton(int idcanton) {
        this.idcanton = idcanton;
    }

    public String getDescripcioncanton() {
        return descripcioncanton;
    }

    public void setDescripcioncanton(String descripcioncanton) {
        this.descripcioncanton = descripcioncanton;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
}
