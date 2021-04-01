
package gestion;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Proveedor;
import modelo.Roles;
import modelo.Usuario;


public class ProveedorGestion {
    public static boolean insertar(Proveedor nuevoProveedor) throws Exception{
        
        String  SQL_INSERT_PROVEEDOR="call PR_AgregarProveedor('%s', '%s', '%s')";
         SQL_INSERT_PROVEEDOR=String.format(SQL_INSERT_PROVEEDOR, nuevoProveedor.getNombreProveedor(),
                                          nuevoProveedor.getCedulajuridica(),
                                          nuevoProveedor.getTelefonoProveedor());
         PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_INSERT_PROVEEDOR);
         int count=sentencia.executeUpdate(SQL_INSERT_PROVEEDOR);
        if (count==0){
            return false;
        }  
        return true;
    }
    
    
    public static ArrayList<Proveedor> getProveedores(){
        ArrayList<Proveedor> lista = new ArrayList<>();
        try{
            String  SQL_SELECT_PROVEEDORES="Select * from proveedor";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_PROVEEDORES);
            ResultSet rs = sentencia.executeQuery();
            
            while(rs!= null && rs.next()){
                lista.add(new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),
                rs.getString(4)));
            }
        }catch(SQLException ex){
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    }
    
    public static Proveedor getProveedor(int IdProveedor) {
        Proveedor proveedor = null;
        try {
            String SQL_SELECT_PROVEEDOR = "SELECT * FROM proveedor WHERE idproveedor = ?";
            PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_SELECT_PROVEEDOR);
            sentencia.setInt(1, IdProveedor);

            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                proveedor = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return proveedor;
    }
    
    private static final String SQL_UPDATE_PROVEEDOR = "call PR_ActProveedor(?,?,?,?)";

    public static boolean modificar(Proveedor proveedor) { 
        try {
            CallableStatement ps = Conexion.getConnection().prepareCall(SQL_UPDATE_PROVEEDOR);
           
            ps.setInt(1, proveedor.getIdproveedor());
            ps.setString(2, proveedor.getNombreProveedor());
            ps.setString(3, proveedor.getCedulajuridica());
            ps.setString(4, proveedor.getTelefonoProveedor());
            return ps.executeUpdate() > 0; 
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private static final String SQL_DELETE_PROVEEDOR= "call PR_EliminarProveedor(?)";

    public static boolean eliminar(int IdProveedor) { //True si lo Elimina/ False si no
        try {
            //Preparo la Sentencia
            CallableStatement ps = Conexion.getConnection().prepareCall(SQL_DELETE_PROVEEDOR);
            //Sustituyo los ? del String SQL por los parametros que corresponden
            ps.setInt(1, IdProveedor);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
