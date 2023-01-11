
package theatermain;

import static theatermain.Movie.inserteMemberDB;
import static theatermain.Movie.pst;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.util.Date;


public class Cycle_composit {
    private static ResultSet rs=null;
    static PreparedStatement pst=null;
    private static String cycle_date;
    private static String room_id;
    private static String movie_id;
    private static String cycle_id;
 
    public String getRoom_id() {
	return room_id;
    }
    public void setRoom_id(String room_id) {
	Cycle_composit.room_id = room_id;
    }
    
    public String getCycle_date() {
	return cycle_date;
    }
    public void setCycle_date(String cycle_date) {
	Cycle_composit.cycle_date = cycle_date;
    }
    
    public String getMovie_id() {
	return movie_id;
    }
    public void setMovie_id(String movie_id) {
	Cycle_composit.movie_id = movie_id;
    }
    
     public Cycle_composit(String idCycle,String currentDate,String room_id,String idMovie){
        this.cycle_date = currentDate;
        this.cycle_id =idCycle;
        this.movie_id = idMovie;
        this.room_id = room_id;
        inserteCycle_compositDB();
    }
    
    public void inserteCycle_compositDB(){
    
        try {
            String sql = "insert into cycle_composit(cycle_id,cycle_date,room_id,movie_id)values(?,?,?,?)";
            Connection con = (Connection) Cinema.connectDB();
            pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, cycle_id);
            pst.setString(2, cycle_date);
            pst.setString(3, room_id);
            pst.setString(4, movie_id);
     
            pst.execute();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    }
    
    
    
}
