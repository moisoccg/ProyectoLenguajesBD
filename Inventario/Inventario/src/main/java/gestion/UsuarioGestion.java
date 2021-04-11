/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.CallableStatement;
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
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        new Roles(rs.getInt(7), rs.getString(8))); //DIVERGENCIA VID S3 1:25:00
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public static ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            String SQL_SELECT_USUARIOS = "Select * from usuario inner join roles on usuario.idrol = roles.idRol where usuario.idrol <>3";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_USUARIOS);
            ResultSet rs = sentencia.executeQuery();

            while (rs != null && rs.next()) {
                lista.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        new Roles(rs.getInt(7), rs.getString(8))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static Usuario getUsuario(int Id) {
        Usuario usuario = null;
        try {
            String SQL_SELECT_USUARIO = "SELECT * FROM usuario inner join roles on usuario.idrol = roles.idRol WHERE IDUSUARIO = ?";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_USUARIO);
            sentencia.setInt(1, Id);

            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        new Roles(rs.getInt(7), rs.getString(8)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    private static final String SQL_DELETE_USUARIO = "call PR_EliminarUsuario(?)";

    public static boolean eliminar(int Id) { //True si lo Elimina/ False si no
        try {
            //Preparo la Sentencia
            CallableStatement ps = Conexion.getConnection().prepareCall(SQL_DELETE_USUARIO);
            //Sustituyo los ? del String SQL por los parametros que corresponden
            ps.setInt(1, Id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    private static final String SQL_UPDATE_USUARIO = "call PR_ActUsuario(?,?,?)";

    public static boolean modificar(Usuario usuario) { //True si lo Modifica/ False si no
        try {
            //Preparo la Sentencia
            CallableStatement ps = Conexion.getConnection().prepareCall(SQL_UPDATE_USUARIO);
            //Sustituyo los ? del String SQL por los parametros que corresponden
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getContraseña());
            ps.setInt(3, usuario.getRol().getIdRol());
            return ps.executeUpdate() > 0; //Aqui no es un ResultSet xq al ser un Insert lo q deculve es #de fila de insercion ó 0 si no pudo insertar
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    ////PARA CLIENTES
    public static ArrayList<Usuario> getClientes() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            String SQL_SELECT_USUARIOS = "Select * from usuario inner join roles on usuario.idrol = roles.idRol where usuario.idrol =3";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_USUARIOS);
            ResultSet rs = sentencia.executeQuery();

            while (rs != null && rs.next()) {
                lista.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        new Roles(rs.getInt(7), rs.getString(8))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
