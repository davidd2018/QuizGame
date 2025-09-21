/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;


import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Windows
 */
public class MyConnection {
    public Connection getConnection()
    {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;Database=QuizGame;user=sa;password=sa";
            Connection con = DriverManager.getConnection(url);
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString(),"Loi",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
