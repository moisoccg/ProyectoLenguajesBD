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
import modelo.Canton;
import modelo.Conexion;
import modelo.Distrito;
import modelo.Provincia;

public class DistritoGestion {
    
   public static ArrayList<Distrito> getDistritos() {
        ArrayList<Distrito> lista = new ArrayList<>();
        try {
            String SQL_SELECT_DISTRITOS = "Select * from distrito inner join canton on distrito.idcanton = canton.idcanton inner join provincia on canton.idprovincia= provincia.idprovincia";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_DISTRITOS);
            
            ResultSet rs = sentencia.executeQuery(SQL_SELECT_DISTRITOS);

            while (rs != null && rs.next()) {
                lista.add(new Distrito(
                        rs.getInt(1),
                        rs.getString(2),
                        new Canton(rs.getInt(4), rs.getString(5), new Provincia (rs.getInt(7), rs.getString(8)))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
