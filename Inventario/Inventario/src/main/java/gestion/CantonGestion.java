
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Canton;
import modelo.Provincia;

public class CantonGestion {
    
    public static ArrayList<Canton> getCantones() {
        ArrayList<Canton> lista = new ArrayList<>();
        try {
            String SQL_SELECT_CANTONES = "Select * from canton inner join provincia on canton.idprovincia=provincia.idprovincia";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_CANTONES);
            
            ResultSet rs = sentencia.executeQuery(SQL_SELECT_CANTONES);

            while (rs != null && rs.next()) {
                lista.add(new Canton(
                        rs.getInt(1),
                        rs.getString(2),
                        new Provincia(rs.getInt(4), rs.getString(5))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
