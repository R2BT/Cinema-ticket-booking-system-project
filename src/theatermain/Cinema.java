
package theatermain;

import java.sql.*;

public class Cinema {

    public static void main(String[] args) {
        connectDB();
    }
    
    public static Connection connectDB(){
    
        String db_name = "cinema_oop";
        String username="root";
        String password="";
        String hostname="localhost";
        String driverName="com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driverName);
            String url="jdbc:mysql://"+hostname+"/"+db_name;
            Connection con = DriverManager.getConnection(url,username, password);
            System.out.println("ConnectComplete");
            return con;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    
    }
    
}
