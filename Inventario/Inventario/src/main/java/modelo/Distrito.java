
package modelo;


public class Distrito {
    private int iddistrito;
    private String descripciondistrito;
    private Canton Canton;

    public Distrito() {
    }

    public Distrito(int iddistrito, String descripciondistrito, Canton Canton) {
        this.iddistrito = iddistrito;
        this.descripciondistrito = descripciondistrito;
        this.Canton = Canton;
    }

    public int getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(int iddistrito) {
        this.iddistrito = iddistrito;
    }

    public String getDescripciondistrito() {
        return descripciondistrito;
    }

    public void setDescripciondistrito(String descripciondistrito) {
        this.descripciondistrito = descripciondistrito;
    }

    public Canton getCanton() {
        return Canton;
    }

    public void setCanton(Canton Canton) {
        this.Canton = Canton;
    }
    
    
}
