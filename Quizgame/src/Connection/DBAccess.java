/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Windows
 */
public class DBAccess {
    private Connection con;
    private Statement stmt;
    public DBAccess()
    {
        try{
            MyConnection myconn = new MyConnection();
            con = myconn.getConnection();
            stmt = con.createStatement();
        }catch(Exception e)
        {}
    }
    public int Update(String srt)
    {
        try{
            int i = stmt.executeUpdate(srt);
            return i;
        }catch(Exception e)
        {
            return -1;
        }
    }
    public ResultSet Query(String srt)
    {
        try{
            ResultSet rs = stmt.executeQuery(srt);
            return rs;
        }catch(Exception e)
        {
            return null;
        }
    }
}
