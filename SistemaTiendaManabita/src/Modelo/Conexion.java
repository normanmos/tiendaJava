
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/proyecto";
    String user="root";
    String pass ="root";
    
    public Connection Conectar()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
        }
        
        catch(Exception e)
        {
                System.out.println("Error en la conexión, verifique, su usuario y password o el nombre de la base a la que intenta conectarse");
        }
        return con;
    }
}