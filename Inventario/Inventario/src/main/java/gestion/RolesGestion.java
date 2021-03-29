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

/**
 *
 * @author RAQUE
 */
public class RolesGestion {
    public static ArrayList<Roles> getRoles(){
        ArrayList<Roles> lista = new ArrayList<>();
        try{
            String  SQL_SELECT_ROLES="Select * from roles";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_ROLES);
            ResultSet rs = sentencia.executeQuery(SQL_SELECT_ROLES);
            
            while(rs!= null && rs.next()){
                lista.add(new Roles(
                rs.getInt(1),
                rs.getString(2)));
            }
        }catch(SQLException ex){
            Logger.getLogger(RolesGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    }
}
