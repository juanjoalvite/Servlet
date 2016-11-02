/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juanj
 */
public class MysqlConnectionHandler {

    protected Connection conn;
    protected Statement stmt;
    private final String url = "jdbc:mysql://localhost:3306/curso";
    private final String user = "root";
    private final String password = "";

    public MysqlConnectionHandler() {
    }

    public Connection doConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            if (conn != null) {
                System.out.println("Conectado a " + conn.toString());
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Conexión no válida url, usuario o clave incorrecta ");
            return conn;
        }
    }

    public void closeConnection() {
        try {
            stmt.close();
            conn.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conexión");
        }
    }

    public Statement getStatement() {
        return this.stmt;
    }
}
