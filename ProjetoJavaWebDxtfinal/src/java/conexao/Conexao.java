/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexao {

   

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver sucess");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Driver");
        }
         Connection conn = null;
            try {
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_java_web?","root","");
           
                System.out.println("Amém");
        } catch (SQLException ex) {
            System.out.println("Erro 1" + ex.getMessage());

        }

        return conn;
                
    }

}
