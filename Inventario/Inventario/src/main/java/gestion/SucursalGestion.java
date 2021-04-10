
package gestion;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Sucursal;


public class SucursalGestion {
    public static boolean insertar(Sucursal nuevaSucursal) throws Exception{
        
        String  SQL_INSERT_SUCURSAL="call PR_AGREGARSUC('%s')";
         SQL_INSERT_SUCURSAL=String.format(SQL_INSERT_SUCURSAL, nuevaSucursal.getNombreSucursal());
         PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_INSERT_SUCURSAL);
         int count=sentencia.executeUpdate(SQL_INSERT_SUCURSAL);
        if (count==0){
            return false;
        }  
        return true;
    }
    

    public static ArrayList<Sucursal> getSucursales(){
        ArrayList<Sucursal> lista = new ArrayList<>();
        try{
            String  SQL_SELECT_SUCURSALES="Select * from sucursal";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_SUCURSALES);
            ResultSet rs = sentencia.executeQuery();
            
            while(rs!= null && rs.next()){
                lista.add(new Sucursal(rs.getInt(1),rs.getString(2)));
            }
        }catch(SQLException ex){
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    }
    
    public static Sucursal getSucursal(int IdSucursal) {
        Sucursal sucursal = null;
        try {
            String SQL_SELECT_SUCURSAL = "SELECT * FROM SUCURSAL WHERE idsucursal = ?";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_SUCURSAL);
            sentencia.setInt(1, IdSucursal);

            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                sucursal = new Sucursal(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sucursal;
    }
    
    private static final String SQL_UPDATE_SUCURSAL = "call PR_ACTSUC(?,?)";

    public static boolean modificar(Sucursal sucursal) { 
        try {
            CallableStatement ps = Conexion.getConnection().prepareCall(SQL_UPDATE_SUCURSAL);
           
            ps.setInt(1, sucursal.getIdSucursal());
            ps.setString(2, sucursal.getNombreSucursal());
            return ps.executeUpdate() > 0; 
        } catch (SQLException ex) {
            Logger.getLogger(SucursalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private static final String SQL_DELETE_SUCURSAL= "call PR_ELIMINARSUC(?)";

    public static boolean eliminar(int IdSucursal) { 
        try {
          
            CallableStatement ps = Conexion.getConnection().prepareCall(SQL_DELETE_SUCURSAL);
            ps.setInt(1, IdSucursal);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SucursalGestion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
 
}
