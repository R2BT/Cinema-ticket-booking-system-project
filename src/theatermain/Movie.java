
package theatermain;

import static theatermain.Register.pst;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Movie {
    
    private static ResultSet rs=null;
    static PreparedStatement pst=null;
    private static String movie_name;
    private static String description;
    private static String time;
    private static String movie_pic;
    private static String movie_id;
    
    public String getMovie_name() {
	return movie_name;
    }
    public void setMovie_name(String movie_name) {
	Movie.movie_name = movie_name;
    }
    
    public String getTime() {
	return time;
    }
    public void setTime(String time) {
	Movie.time = time;
    }
    
    
    public String getDescription() {
	return description;
    }
    public void setDescription(String description) {
	Movie.description = description;
    }
    
    public String getMovie_id() {
	return movie_id;
    }
    public void setMovie_id(String movie_id) {
	Movie.movie_id = movie_id;
    }
    
    public String getMovie_pic() {
	return movie_pic;
    }
    public void setMovie_pic(String movie_pic) {
	Movie.movie_pic = movie_pic;
    }
    
    public Movie(){
    
    }
    
    public Movie(String movie_id,String movie_name,String description,String time,String movie_pic){

        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.description = description;
        this.time = time;
        this.movie_pic = movie_pic;
        inserteMemberDB();

    }
    
   
    
    public static void inserteMemberDB(){
        
        try {
            String sql = "insert into movie(movie_id,movie_name,description,time,movie_pic)values(?,?,?,?,?)";
            Connection con = (Connection) Cinema.connectDB();
            pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, movie_id);
            pst.setString(2, movie_name);
            pst.setString(3, description);
            pst.setString(4, time);
            pst.setString(5, movie_pic);
            pst.execute();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    } 
    
}
