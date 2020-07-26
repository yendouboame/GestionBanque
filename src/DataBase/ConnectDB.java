/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataBase;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CR35U5
 */
public class ConnectDB {
    
        public static Connection avoirConnexion () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Wrong driver");
        }
        String url = "jdbc:mysql://localhost:3306/gestionbanque";
        String user = "root";
        String pass = "";
        
        try {
            Connection connect = DriverManager.getConnection(url, user, pass);
            //JOptionPane.showMessageDialog(null, "Connexion établie avec succès");
            return connect;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Connexion non établie");
            return null;
        }
    }
    
    public static void main(String[]args) {
        avoirConnexion();
    }
}
