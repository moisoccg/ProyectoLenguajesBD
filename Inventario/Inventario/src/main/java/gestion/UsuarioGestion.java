/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Roles;
import modelo.Usuario;

public class UsuarioGestion {
    //String SQL para recuperar un usuario

    private static final String SQL_VALIDA = "SELECT * FROM usuario inner join roles on usuario.idrol = roles.idRol WHERE IDUSUARIO = ? and CONTRASEÑA = ?";

//Metodo para validar un usuario en la BD
    public static Usuario valida(int Id, String Contraseña) {
        Usuario usuario = null;
//Creo la Sentencia SQL con el String SQL armado anteriormente
        try {
//Se crea la sentencia
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_VALIDA);
            sentencia.setInt(1, Id); //Se reemplaza el primer ? por el parametro real
            sentencia.setString(2, Contraseña); //Se reemplaza el segundo ? por el parametro real

//Recupero el resultado de la consulta sql
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) { //Si puede hacer next en el resultado es xq hay un usuario
//Creo un usuario nuevo con los valores del ResultSet
                usuario = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),
                rs.getString(4), rs.getString(5),
                new Roles (rs.getInt(7), rs.getString(8))); //DIVERGENCIA VID S3 1:25:00
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
    public static ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            String  SQL_SELECT_USUARIOS="Select * from usuario inner join roles on usuario.idrol = roles.idRol";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_USUARIOS);
            ResultSet rs = sentencia.executeQuery();
            
            while(rs!= null && rs.next()){
                lista.add(new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),
                new Roles (rs.getInt(7), rs.getString(8))));
            }
        }catch(SQLException ex){
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    }
    
    
}
