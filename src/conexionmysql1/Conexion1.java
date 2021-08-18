/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql1;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion1 {
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "clases";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";
    Connection conn = null;

    public Connection conectarMySQL() throws SQLException {
        

        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error"+e.getMessage());
        }

        return conn;
    }
    public void CerrarConexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexion "+e.getMessage());
        }
        
    }
    
}
