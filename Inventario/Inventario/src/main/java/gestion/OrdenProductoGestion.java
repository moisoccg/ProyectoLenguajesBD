/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Conexion;
import modelo.Orden;
import modelo.OrdenProducto;
import modelo.Producto;
import modelo.TipoProducto;

/**
 *
 * @author moiso
 */
public class OrdenProductoGestion {
    
    private static final String INSERT_PRODUCTO_ORDEN_SQL = "{call PR_AgregarProductoOrden(?, ?, ?, ?)}";
    private static final String SELECT_ALL_ORDEN_PROD = "select * from OrdenProducto op, Orden o, Producto p where o.idorden=op.idorden and p.idproducto = op.idproducto";
    
    
        public static boolean agregarProducto(int idOrden, int idProducto, int idSucursal, int idUsuario) throws SQLException {
        System.out.println(INSERT_PRODUCTO_ORDEN_SQL);
        
        try { 
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(INSERT_PRODUCTO_ORDEN_SQL);
            
            System.out.println("idProducto: " + idProducto);
            System.out.println("idOrden: " + idOrden);
            System.out.println("idSucursal: " + idSucursal);
            System.out.println("idUsuario: " + idUsuario);
            preparedStatement.setInt(1, idOrden);
            preparedStatement.setInt(2, idUsuario);
            preparedStatement.setInt(3, idSucursal);
            preparedStatement.setInt(4, idProducto);

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
        
        
    public static List<Producto> selectAllOrdenProducto(){
        List<Producto> productos = new ArrayList<>();
        TipoProductoGestion tipoGestion = null;
        TipoProducto tipo = null;
        
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement preparedStatement
                    = con.prepareStatement(SELECT_ALL_ORDEN_PROD);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("idproducto");
                String descripcion = rs.getString("descripcionproducto");
                float precio = rs.getFloat("precioproducto");
                Date fechaElaborado = rs.getDate("fechaelaborado");
                Date fechaVencimiento = rs.getDate("fechavencimiento");
                int idTipoProducto = rs.getInt("idtipoproducto");
                double numeroSerie = rs.getDouble("numeroserie");
                double cantstock = rs.getDouble("cantidadstock");
                double cantmin = rs.getDouble("cantidadminima");
                
                tipo = tipoGestion.selectTipoProducto(idTipoProducto);
                
                productos.add(new Producto(idProducto,descripcion, precio,fechaElaborado,fechaVencimiento,numeroSerie,cantstock,cantmin,tipo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productos;
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
