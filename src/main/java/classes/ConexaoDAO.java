/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author gabri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {
    
    public String usuario ="<USERNAME>";
    public String URL = "jdbc:mysql://<HOST>:<PORT>/<DATABASE>?useTimezone=true&serverTimezone=UTC";
    public String senha =".";
    
    
    public Connection conectaBD(){
        try {
            Connection conn = DriverManager.getConnection(URL,usuario,senha);
          
            System.out.println(conn);
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return  null;
        }
    }
}