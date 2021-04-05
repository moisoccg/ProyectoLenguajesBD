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
import modelo.Producto;
import modelo.TipoProducto;
 
/**
 *
 * @author moiso
 */
public class ProductoGestion {
    
    private static final String INSERT_PRODUCTO_SQL = "{call PR_AgregarProducto(?, ?, ?, ?, ?, ?, ?, ?)}";
    private static final String SELECT_PRODUCTO_BY_ID = "select * from producto where idproducto = ?";
    private static final String SELECT_ALL_PRODUCTO = "select * from producto";
    private static final String DELETE_PRODUCTO_SQL = "delete from producto where idproducto = ?";
    private static final String UPDATE_PRODUCTO_SQL = "{call PR_ActProducto (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    
    
        public static boolean insertar(Producto nuevoProducto) throws SQLException {
        System.out.println(INSERT_PRODUCTO_SQL);
        
        try { 
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(INSERT_PRODUCTO_SQL);
            preparedStatement.setString(1, nuevoProducto.getDescripcionProducto());
            preparedStatement.setFloat(2, nuevoProducto.getPrecioProducto());
            java.sql.Date sqldate1 = new java.sql.Date(nuevoProducto.getFechaElaborado().getTime());
            preparedStatement.setDate(3, sqldate1);
            java.sql.Date sqldate2 = new java.sql.Date(nuevoProducto.getFechaVencimiento().getTime());
            preparedStatement.setDate(4, sqldate2);
            preparedStatement.setInt(5, nuevoProducto.getTipoProducto().getIdTipoProducto());
            preparedStatement.setDouble(6, nuevoProducto.getNumeroSerie());
            preparedStatement.setDouble(7, nuevoProducto.getCantidadStock());
            preparedStatement.setDouble(8, nuevoProducto.getCantidadMinima());
            
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
        
        
        
        public static Producto selectProducto(int id) {
            Producto producto = null;
            TipoProductoGestion tipoGestion = null;
            TipoProducto tipo = null;
        try  {
            Connection connection = Conexion.getConnection();  
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTO_BY_ID); 
            preparedStatement.setInt(1, id);
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
                
                producto = new Producto(idProducto,descripcion, precio,fechaElaborado,fechaVencimiento,numeroSerie,cantstock,cantmin,tipo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return producto;
    }
               
        
    public static List<Producto> selectAllProducto(){
        List<Producto> productos = new ArrayList<>();
        TipoProductoGestion tipoGestion = null;
        TipoProducto tipo = null;
        
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement preparedStatement
                    = con.prepareStatement(SELECT_ALL_PRODUCTO);
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
        
    
    public static boolean deleteProducto(int id) throws SQLException {
        boolean rowDeleted;
        try {
            Connection connection = Conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTO_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;

            return rowDeleted;

        } catch (SQLException e) {

            printSQLException(e);
            return false;
        }

    }
    
    
    
    public static boolean updateProducto(Producto producto) throws SQLException {
        boolean rowUpdated;
        try{ 
            Connection connection = Conexion.getConnection();
        PreparedStatement statement =
        connection.prepareCall(UPDATE_PRODUCTO_SQL); 
        
            statement.setInt(1, producto.getIdProducto());
            statement.setString(2, producto.getDescripcionProducto());
            statement.setFloat(3, producto.getPrecioProducto());
            //Convert util.Date to sql.Date as BootFaces uses util.Date for input
            java.sql.Date sqldate1 = new java.sql.Date(producto.getFechaElaborado().getTime());
            statement.setDate(4, sqldate1);
            //Convert util.Date to sql.Date as BootFaces uses util.Date for input
            java.sql.Date sqldate2 = new java.sql.Date(producto.getFechaVencimiento().getTime());
            statement.setDate(5, sqldate2);
            statement.setInt(6, producto.getTipoProducto().getIdTipoProducto());
            statement.setDouble(7, producto.getNumeroSerie());
            statement.setDouble(8, producto.getCantidadStock());
            statement.setDouble(9, producto.getCantidadMinima());
            
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
           
                printSQLException(e);
            return false;
        }
        return rowUpdated;
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
