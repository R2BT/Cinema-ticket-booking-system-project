
package theatermain;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.util.List;

public class Ticket {
        
        private Seat seat;
    	private String ticket_id;
	private String ticket_seat;
	private double ticket_price;
	private String cycle_id;
	private String movie_id;
	private String member_id;
        
        //connectdb
        private static ResultSet rs=null;
        static PreparedStatement pst=null;
       
        
        
        public Ticket(String cycle_id,String movie_id,String member_id,String ticket_seat,double ticket_price){
           
            this.cycle_id = cycle_id;
            this.member_id = member_id;
            this.movie_id = movie_id;
            this.ticket_seat = ticket_seat;
            this.ticket_price = ticket_price;
            System.out.println(cycle_id+" "+member_id+" "+movie_id+" "+ticket_seat+" "+ticket_price);
            
                inserteTicket_compositDB();        
            
        }
        
        
        
        
        
        public void inserteTicket_compositDB(){
    
        try {
            String sql = "insert into ticket(cycle_id,movie_id,member_id,ticket_seat,ticket_price)values(?,?,?,?,?)";
            Connection con = (Connection) Cinema.connectDB();
            pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,cycle_id );
            pst.setString(2,movie_id );
            pst.setString(3,member_id);
            pst.setString(4,ticket_seat);
            pst.setDouble(5,ticket_price);
            pst.execute();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    }
        
        
        
        
        	
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getTicket_seat() {
		return ticket_seat;
	}
	public void setTicket_seat(String ticket_seat) {
		this.ticket_seat = ticket_seat;
	}
	public double getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}
	public String getCycle_id() {
		return cycle_id;
	}
	public void setCycle_id(String cycle_id) {
		this.cycle_id = cycle_id;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}	
    
    
    
    
}
