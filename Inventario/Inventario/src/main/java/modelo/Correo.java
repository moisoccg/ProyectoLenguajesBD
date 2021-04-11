/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Correo {
    private int idcorreo;
    private String correoelectronico;
    private Usuario Usuario;

    public Correo() {
    }

    public Correo(int idcorreo, String correoelectronico, Usuario Usuario) {
        this.idcorreo = idcorreo;
        this.correoelectronico = correoelectronico;
        this.Usuario = Usuario;
    }

    public int getIdcorreo() {
        return idcorreo;
    }

    public void setIdcorreo(int idcorreo) {
        this.idcorreo = idcorreo;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }
    
    
    
}
