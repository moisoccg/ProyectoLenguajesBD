/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    //Conexion con la Base de Datos, solo existe una en el modelo singleton

    private static Conexion conexion;
//Ruta de la Base de Datos
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:ORCL";

//Conexion a la Base de Datos
     private static Connection conn=null;



    public Conexion() {
//Inicializacion de la Conexion
    try {
//Se suscribe el controlador de la BD
    Class.forName("oracle.jdbc.driver.OracleDriver").getDeclaredConstructor().newInstance();
//Se crea una conexion con la base de datos
    conn = DriverManager.getConnection(DBURL, "USQL", "USQL");
    }catch (ClassNotFoundException |
        NoSuchMethodException |
        SecurityException |
        InstantiationException |
        IllegalAccessException |
        IllegalArgumentException |
        InvocationTargetException |
        SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo estatico para obtener la conexion
    public static synchronized Connection getConnection(){
        if (conexion==null) {
        conexion = new Conexion();
        }
        return conn;
    }

 }
