
package com.espedanny.examenchicaizad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static Connection getConnection(){
        Connection conexion = null;
        try{
            String urldb = "jdbc:mysql://localhost:3306/cartelera";
            String usuariodb = "root";
            String passworddb = "";
            
            conexion=DriverManager.getConnection(urldb, usuariodb,passworddb);
            
            System.out.println("Conectado a la base de datos!!");
        }catch(SQLException e){
            //thrown e;
            System.err.println("Error de conexion a la Base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
