
package gestion;

import java.sql.PreparedStatement;
import modelo.Conexion;
import modelo.nUsuario;

public class nUsuarioGestion {
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
}
