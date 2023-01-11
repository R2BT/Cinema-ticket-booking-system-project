package theatermain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phattaraporn
 */
public class Seat {
    private double price;
	private String seat;
	
	private static List<Seat> seatList = new ArrayList<>();
	
        public Seat() {
        }
	
	public Seat(String seat,double price) {
		if(seat!=null && price!=0)
                {
                    this.seat = seat;
                    this.price = price;
                    seatList.add(this);
                    System.out.println("Book Seat success");
                    showSeat();
                }
               
        }
        
        public void unSeat(String seat,double price){
            
            System.out.println("Un Book Seat success");
            
            this.seat =seat;
            seatList.clear();
            showSeat();
            
        }
	
	public List<Seat> showSeat(){
        
            for(int i=0;i<seatList.size();i++){
            
                System.out.println(seatList.get(i).getSeat()+" "+seatList.get(i).getPrice());
            }
            return seatList;
        
        }
	
	
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}







	public static List<Seat> getSeatList() {
		return seatList;
	}







	public static void setSeatList(List<Seat> seatList) {
		Seat.seatList = seatList;
	}
	
}
