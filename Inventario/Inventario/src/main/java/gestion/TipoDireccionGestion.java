
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.TipoDireccion;

public class TipoDireccionGestion {
  
     public static ArrayList<TipoDireccion> getTipoDireccion() {
        ArrayList<TipoDireccion> lista = new ArrayList<>();
        try {
            String SQL_SELECT_TIPODIRECCION = "Select * from TipoDireccion";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_TIPODIRECCION);
            ResultSet rs = sentencia.executeQuery(SQL_SELECT_TIPODIRECCION);

            while (rs != null && rs.next()) {
                lista.add(new TipoDireccion(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
   
}
