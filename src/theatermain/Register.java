
package theatermain;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Register {
    
    

    private static ResultSet rs=null;
    static PreparedStatement pst=null;
    
    private static String email;
    private  static String password;
    private static String fname;
    private static String lname;
    private static String phone;
    public String getEmail() {
	return email;
    }
    public void setEmail(String email) {
	Register.email = email;
    }
    public String getPassword() {
	return password;
    }
    public void setPassword(String password) {
	Register.password = password;
    }
    public String getLname() {
	return lname;
    }
    public void setLname(String lname) {
	Register.lname = lname;
    }
    public String getFname() {
	return fname;
    }
    public void setFname(String fname) {
	Register.fname = fname;
    }
    public String getPhone() {
	return phone;
    }
    public void setPhone(String phone) {
	Register.phone = phone;
    }
    
    
    public Register(){
    
    }
    
    public Register(String fname,String lname,String phone,String email,String password){
    
        
        Register.fname = fname;
        Register.lname = lname;
        Register.phone = phone;
        Register.email = email;
        Register.password = password;
        inserteMemberDB();
    }
    
    
    public static void inserteMemberDB(){
        
        try {
            String sql = "insert into member(user,password,fname,lname,phone)values(?,?,?,?,?)";
            Connection con = (Connection) Cinema.connectDB();
            pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            pst.setString(3, fname);
            pst.setString(4, lname);
            pst.setString(5, phone);
            pst.execute();
            
            //JOptionPane.showMessageDialog("Save", "Savesucces", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    } 
    
    
    
    
    
    
}