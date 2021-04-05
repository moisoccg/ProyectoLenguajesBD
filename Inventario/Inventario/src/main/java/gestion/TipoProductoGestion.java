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
import java.util.List;
import modelo.Conexion;
import modelo.TipoProducto;
/**
 *
 * @author moiso
 */
public class TipoProductoGestion {
    
    private static final String INSERT_TIPOPRODUCTO_SQL = "{call PR_AgregarTipoProducto(?, ?)}";
    private static final String SELECT_TIPOPRODUCTO_BY_ID = "select * from tipoproducto where idtipoproducto = ?";
    private static final String SELECT_ALL_TIPOPRODUCTO = "select * from tipoproducto";
    private static final String DELETE_TIPOPRODUCTO_SQL = "delete from tipoproducto where idtipoproducto = ?";
    private static final String UPDATE_TIPOPRODUCTO_SQL = "{call PR_ActTipoProducto (?,?,?)}";
    
        public static boolean insertar(TipoProducto nuevoTipo) throws SQLException {
        System.out.println(INSERT_TIPOPRODUCTO_SQL);
        
        try { 
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(INSERT_TIPOPRODUCTO_SQL);
            preparedStatement.setString(1, nuevoTipo.getNombreTipoProducto());
            preparedStatement.setString(2, nuevoTipo.getDescripcionTipoProducto());
            
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
        
        
       public static TipoProducto selectTipoProducto(int id) {
        TipoProducto tipo = null;
        try  {
            Connection connection = Conexion.getConnection();  
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TIPOPRODUCTO_BY_ID); 
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idTipoProducto = rs.getInt("idtipoproducto");
                String nombretipoproducto = rs.getString("nombretipoproducto");
                String descripciontipoproducto = rs.getString("descripciontipoproducto");
                tipo = new TipoProducto(idTipoProducto,nombretipoproducto, descripciontipoproducto);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tipo;
    }
     
    
        public static List<TipoProducto> selectAllTipos() {
        List<TipoProducto> tipos = new ArrayList<>();
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement preparedStatement =
            con.prepareStatement(SELECT_ALL_TIPOPRODUCTO); 
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idtipoproducto");
                System.out.println("idtipoproducto: " + id);
                String nombre = rs.getString("nombretipoproducto");
                String descripcion = rs.getString("descripciontipoproducto");
                tipos.add(new TipoProducto(id, nombre, descripcion));
                }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tipos;
}
        
       public static boolean deleteTipoProducto(int id) throws SQLException {
            boolean rowDeleted;
            try{
                Connection connection = Conexion.getConnection();  
                    PreparedStatement statement = connection.prepareStatement(DELETE_TIPOPRODUCTO_SQL); 
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
                
                return rowDeleted;
                
            } catch (SQLException e) {
           
                printSQLException(e);
            return false;
        }
        
    }
        
       
       
    public static boolean updateTipoProducto(TipoProducto tipo) throws SQLException {
        boolean rowUpdated;
        try{ 
            Connection connection = Conexion.getConnection();
        PreparedStatement statement =
        connection.prepareCall(UPDATE_TIPOPRODUCTO_SQL); 
        
            statement.setString(1, tipo.getNombreTipoProducto());
            statement.setString(2, tipo.getDescripcionTipoProducto());
            statement.setInt(3, tipo.getIdTipoProducto());
              
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
