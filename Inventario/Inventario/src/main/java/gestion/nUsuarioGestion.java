
package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Conexion;
import modelo.nUsuario;



public class nUsuarioGestion {
    
    private static final String INSERT_CLIENTE_SQL = "{call PR_AGREGARCLIENTE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 
    
    public static boolean insertar(nUsuario nuevoUsuario) throws Exception{
        String  SQL_INSERT_USUARIO="call PR_AgregarUsuario('%s', '%s', '%s', '%s', '%s')";
         SQL_INSERT_USUARIO=String.format(SQL_INSERT_USUARIO, nuevoUsuario.getNombre(),
                                            nuevoUsuario.getApellidos(),
                                            nuevoUsuario.getContraseña(),
                                            nuevoUsuario.getCedula(),
                                            nuevoUsuario.getRol().getIdRol());
         PreparedStatement sentencia = Conexion.getConnection().prepareStatement(SQL_INSERT_USUARIO);
         int count=sentencia.executeUpdate(SQL_INSERT_USUARIO);
        if (count==0){
            return false;
        }  
        return true;
    }
    
    // --- PARA CLIENTE HAY QUE CAMBIARLO
    public static boolean insertarCliente(nUsuario nuevoUsuario) throws Exception{

        try{   
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(INSERT_CLIENTE_SQL);
            preparedStatement.setString(1, nuevoUsuario.getNombre());
            preparedStatement.setString(2, nuevoUsuario.getApellidos());
            preparedStatement.setString(3, nuevoUsuario.getCedula());
            preparedStatement.setString(4, nuevoUsuario.getCorreo().getCorreoelectronico());
            preparedStatement.setInt(5, nuevoUsuario.getTtelefono().getIdtipotelefono());
            preparedStatement.setString(6, nuevoUsuario.getTelefono().getTelefono());
            preparedStatement.setInt(7, nuevoUsuario.getTdireccion().getIdtipodireccion());
            preparedStatement.setInt(8, nuevoUsuario.getProvincia().getIdprovincia() );
            preparedStatement.setInt(9, nuevoUsuario.getCanton().getIdcanton());
            preparedStatement.setInt(10, nuevoUsuario.getDistrito().getIddistrito());
            preparedStatement.setString(11, nuevoUsuario.getDireccion().getDireccion());
            preparedStatement.setInt(12, nuevoUsuario.getId());

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
    
        public static boolean insertarCliente(nUsuario nuevoUsuario, String correo,
                String telefono, int tipotelefono, int tdireccion, int provincia,
                int canton, int distrito, String  direccion) throws Exception{

        try{   
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareCall(INSERT_CLIENTE_SQL);
            preparedStatement.setString(1, nuevoUsuario.getNombre());
            preparedStatement.setString(2, nuevoUsuario.getApellidos());
            preparedStatement.setString(3, nuevoUsuario.getCedula());
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, tipotelefono);
            preparedStatement.setString(6, telefono);
            preparedStatement.setInt(7, tdireccion);
            preparedStatement.setInt(8, provincia );
            preparedStatement.setInt(9, canton);
            preparedStatement.setInt(10, distrito);
            preparedStatement.setString(11, direccion);
            preparedStatement.setInt(12, nuevoUsuario.getId());

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
    
    
}
