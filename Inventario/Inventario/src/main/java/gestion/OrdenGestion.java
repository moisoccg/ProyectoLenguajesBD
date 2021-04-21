/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.OrdenProducto;
import modelo.Producto;
import modelo.Orden;
import modelo.TipoProducto;
import modelo.Usuario;
import modelo.Sucursal;

/**
 *
 * @author moiso
 */
public class OrdenGestion {
    
    
    private static final String INSERT_ORDEN_SQL = "{call PR_AgregarOrden(?, ?)}";
    //private static final String INSERT_PRODUCTO_ORDEN_SQL = "{call PR_AgregarProductoOrden(?, ?, ?, ?, ?)}";
    private static final String SELECT_ORDEN_BY_ID = "select * from orden where idorden = ?";
    private static final String SELECT_ALL_ORDENES = "select * from orden";
    private static final String SELECT_ALL_ORDEN_PROD = "select * from OrdenProducto op, Orden o, Producto p where o.idorden=op.idorden and p.idproducto = op.idproducto";

    
    public static boolean insertar(Orden nuevaOrden) throws SQLException {
        System.out.println(INSERT_ORDEN_SQL);
        
        try { 
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(INSERT_ORDEN_SQL);
            java.sql.Date sqldate1 = new java.sql.Date(nuevaOrden.getFechaOrden().getTime());
            preparedStatement.setDate(1, sqldate1);
            System.out.println("SucursalID"+nuevaOrden.getIdSucursal());
            preparedStatement.setInt(2, nuevaOrden.getIdSucursal());
            
            System.out.println(preparedStatement);
            int count  = preparedStatement.executeUpdate();
            if(count==0){
                return false;
            }  
            return true;
        
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public static Orden selectOrden(int id) {
            Orden orden = null;
            Producto producto = null;
            Usuario usuario = null;
            UsuarioGestion usuarioGestion = null;
            Sucursal sucursal = null;
            SucursalGestion sucursalGestion = null;
        try  {
            Connection connection = Conexion.getConnection();  
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDEN_BY_ID); 
            preparedStatement.setInt(1, id);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrden = rs.getInt("idorden");
                Date fechaOrden = rs.getDate("fechaorden");
                int idUsuario = rs.getInt("idusuario");
                int idSucursal = rs.getInt("idsucursal");
                sucursal = sucursalGestion.getSucursal(idSucursal);
                usuario = usuarioGestion.getUsuario(idUsuario);
                
                orden = new Orden(idOrden,fechaOrden, sucursal, usuario);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orden;
    }
    
    
    
    public static List<Orden> selectAllOrden(){
        
        List<Orden> ordenes = new ArrayList<>();
           Usuario usuario = null;
            UsuarioGestion usuarioGestion = null;
            Sucursal sucursal = null;
            SucursalGestion sucursalGestion = null;
        
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement preparedStatement
                    = con.prepareStatement(SELECT_ALL_ORDENES);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               int idOrden = rs.getInt("idorden");
                Date fechaOrden = rs.getDate("fechaorden");
                int idUsuario = rs.getInt("idusuario");
                int idSucursal = rs.getInt("idsucursal");
                
                sucursal = sucursalGestion.getSucursal(idSucursal);
                usuario = usuarioGestion.getUsuario(idUsuario);
                
                ordenes.add(new Orden(idOrden,fechaOrden, sucursal,usuario));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ordenes;
    }
    
    
    
    
    
    
    
    
    
    
    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
