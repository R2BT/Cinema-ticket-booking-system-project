package theatermain;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static theatermain.Movie.pst;

public class UserPage extends javax.swing.JFrame {
    Seat seat;
    boolean check = true;
    Login login = new Login();
    static String idmem;
    private static List<Seat> seatList = new ArrayList<>();
    ImageIcon imageicon;
    static String users; 
    //show movie
    private Connection conMovie = null;
    private ResultSet rsMovie = null;
    private PreparedStatement pstMovie = null;
    private File fMovie = null;
    private String pathMovie = null;
    private ImageIcon formatMovie = null;
    private String nameMovie;
    private String idMovie;
    private String currentDate;
    static String idCycle;
    private String date;
    private String time;
    private String room;
    private String description;
    private String timeCycle;
    //connectdb
    static ResultSet rs=null;
    static PreparedStatement pst=null;
    
    
    public UserPage() {
        initComponents();
        conMovie = (Connection) Cinema.connectDB();
        userTab.setText(users);
        //showDataNameMovie();
        //showDataTime();
    }
    public UserPage(String idMember) {
        UserPage.idmem = idMember;
        
    }

    public void showDetailBooking(){
        NameMovie.setText(nameMovie);
        
        showDataImgMovie();
        cycle.setText(time);
        showIdTime();
        roomdetail.setText(room);
        datedetail.setText(date);
        Description.setText(description);
        checkSeat();
    }
    
    
    public void showIdTime(){
        timeCycle = (String) cycle.getText();
        if("09:00-11:00".equals(timeCycle)){
            UserPage.idCycle = "C01";
        }
        else if("12:00-15:00".equals(timeCycle)){
            UserPage.idCycle = "C02";
        }
        else if("15:00-18:00".equals(timeCycle)){
            UserPage.idCycle = "C03";
        }
        //System.out.println(UserPage.idCycle);
        
    }
    
    public void showDataImgMovie(){
        
         try {
            
            String namedata = NameMovie.getText();
            System.out.println(namedata);
 
            String sql = "select movie_id,movie_pic,description from movie where movie_name =?";
            pstMovie = (PreparedStatement) conMovie.prepareStatement(sql);
            pstMovie.setString(1,namedata);

            pstMovie.execute();
            rsMovie = (ResultSet) pstMovie.executeQuery();
                
            rsMovie.first();
            idMovie = rsMovie.getString("movie_id");
            System.out.println(idMovie);
            String imagedata = rsMovie.getString("movie_pic");
            description = rsMovie.getString("description");
            formatMovie = new ImageIcon(imagedata);
            Image m = formatMovie.getImage();
            Image img = m.getScaledInstance(imgmovie.getWidth(), imgmovie.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(img);
            imgmovie.setIcon(image);

            } catch (Exception e) {
                e.printStackTrace();
            }
        
        
    }
    

    public void showDetailBookingTicket(){
        MOVIENAME.setText(nameMovie);
        String seatTicket="";
        double priceBooking=0;
        showDataImgMovieTicket();
        CYCLE.setText(timeCycle);
        showIdTime();
        TIME.setText(time);
        Description.setText(description);
        ROOMID.setText(room);
        DATE.setText(date);
        seatList=seat.showSeat();
        for(int i=0;i<seatList.size();i++){
            seatTicket=seatTicket+seatList.get(i).getSeat()+" ";
            priceBooking+=seatList.get(i).getPrice();
        }
        SEAT.setText(seatTicket);
        PRICE.setText(priceBooking+" THB");
        checkSeat();
    }
    
    
    
    public void showDataImgMovieTicket(){
        
         try {
            
            String namedata = NameMovie.getText();
            System.out.println(namedata);
 
            String sql = "select movie_id,movie_pic,time,description from movie where movie_name =?";
            pstMovie = (PreparedStatement) conMovie.prepareStatement(sql);
            pstMovie.setString(1,namedata);

            pstMovie.execute();
            rsMovie = (ResultSet) pstMovie.executeQuery();
                
            rsMovie.first();
            idMovie = rsMovie.getString("movie_id");
            time = rsMovie.getString("time");
         
            //Description.setText(description);
            System.out.println(idMovie);
            String imagedata = rsMovie.getString("movie_pic");
     
            formatMovie = new ImageIcon(imagedata);
            Image m = formatMovie.getImage();
            Image img = m.getScaledInstance(imgmovie.getWidth(), imgmovie.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(img);
            IMGMOVIE.setIcon(image);

            } catch (Exception e) {
                e.printStackTrace();
            }
        
        
    }
    
    
    
   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        userTab = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        F1 = new javax.swing.JLabel();
        E1 = new javax.swing.JLabel();
        D1 = new javax.swing.JLabel();
        F2 = new javax.swing.JLabel();
        D2 = new javax.swing.JLabel();
        E2 = new javax.swing.JLabel();
        D4 = new javax.swing.JLabel();
        D3 = new javax.swing.JLabel();
        E4 = new javax.swing.JLabel();
        E3 = new javax.swing.JLabel();
        F4 = new javax.swing.JLabel();
        F3 = new javax.swing.JLabel();
        D6 = new javax.swing.JLabel();
        D5 = new javax.swing.JLabel();
        E6 = new javax.swing.JLabel();
        E5 = new javax.swing.JLabel();
        F6 = new javax.swing.JLabel();
        F5 = new javax.swing.JLabel();
        D8 = new javax.swing.JLabel();
        D7 = new javax.swing.JLabel();
        E8 = new javax.swing.JLabel();
        E7 = new javax.swing.JLabel();
        F8 = new javax.swing.JLabel();
        F7 = new javax.swing.JLabel();
        D10 = new javax.swing.JLabel();
        D9 = new javax.swing.JLabel();
        E10 = new javax.swing.JLabel();
        E9 = new javax.swing.JLabel();
        F10 = new javax.swing.JLabel();
        F9 = new javax.swing.JLabel();
        D12 = new javax.swing.JLabel();
        D11 = new javax.swing.JLabel();
        E12 = new javax.swing.JLabel();
        E11 = new javax.swing.JLabel();
        F12 = new javax.swing.JLabel();
        F11 = new javax.swing.JLabel();
        D14 = new javax.swing.JLabel();
        D13 = new javax.swing.JLabel();
        E14 = new javax.swing.JLabel();
        E13 = new javax.swing.JLabel();
        F14 = new javax.swing.JLabel();
        F13 = new javax.swing.JLabel();
        D16 = new javax.swing.JLabel();
        D15 = new javax.swing.JLabel();
        E16 = new javax.swing.JLabel();
        E15 = new javax.swing.JLabel();
        F16 = new javax.swing.JLabel();
        F15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        B1 = new javax.swing.JLabel();
        A1 = new javax.swing.JLabel();
        A2 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        B3 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        A3 = new javax.swing.JLabel();
        C6 = new javax.swing.JLabel();
        B6 = new javax.swing.JLabel();
        A6 = new javax.swing.JLabel();
        A5 = new javax.swing.JLabel();
        B5 = new javax.swing.JLabel();
        C5 = new javax.swing.JLabel();
        C4 = new javax.swing.JLabel();
        B4 = new javax.swing.JLabel();
        A4 = new javax.swing.JLabel();
        C9 = new javax.swing.JLabel();
        B9 = new javax.swing.JLabel();
        A9 = new javax.swing.JLabel();
        A8 = new javax.swing.JLabel();
        B8 = new javax.swing.JLabel();
        C8 = new javax.swing.JLabel();
        C7 = new javax.swing.JLabel();
        B7 = new javax.swing.JLabel();
        A7 = new javax.swing.JLabel();
        C12 = new javax.swing.JLabel();
        B12 = new javax.swing.JLabel();
        A12 = new javax.swing.JLabel();
        A11 = new javax.swing.JLabel();
        B11 = new javax.swing.JLabel();
        C11 = new javax.swing.JLabel();
        C10 = new javax.swing.JLabel();
        B10 = new javax.swing.JLabel();
        A10 = new javax.swing.JLabel();
        C15 = new javax.swing.JLabel();
        B15 = new javax.swing.JLabel();
        A15 = new javax.swing.JLabel();
        A14 = new javax.swing.JLabel();
        B14 = new javax.swing.JLabel();
        C14 = new javax.swing.JLabel();
        C13 = new javax.swing.JLabel();
        B13 = new javax.swing.JLabel();
        A13 = new javax.swing.JLabel();
        C16 = new javax.swing.JLabel();
        B16 = new javax.swing.JLabel();
        A16 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        NameMovie = new javax.swing.JLabel();
        cycle = new javax.swing.JLabel();
        roomdetail = new javax.swing.JLabel();
        datedetail = new javax.swing.JLabel();
        imgmovie = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        backTologin3 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTicket = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        backTologin2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        IMGMOVIE = new javax.swing.JLabel();
        MOVIENAME = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        ROOMID = new javax.swing.JLabel();
        CYCLE = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        SEAT = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        PRICE = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ticketShow = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        backTologin1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_user_25px.png"))); // NOI18N

        userTab.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        userTab.setText("user");

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_Logout_20px_1_1.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Theater Ticket");

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 8)); // NOI18N
        jLabel18.setText("Book movie tickets online today.");
        jLabel18.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 501, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTab, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel10)
                        .addComponent(userTab)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 900, 40));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(153, 0, 0));

        jPanel2.setBackground(new java.awt.Color(211, 78, 78));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel11.setText("All Orders");

        jLabel28.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_invoice_125px_1.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel28)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(211, 78, 78));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Booking");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 190, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_ticket_125px_1.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 102));

        jPanel5.setBackground(new java.awt.Color(211, 78, 78));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel12.setText("Payment");

        jLabel35.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_cash_in_hand_125px_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(81, 81, 81))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel35)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel12)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 900, 320));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_Avengers_45px.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_disney_plus_45px.png"))); // NOI18N
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_pixar_45px_1_1.png"))); // NOI18N
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/avatar2_1.jpg"))); // NOI18N
        jLabel14.setText("jLabel1");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 130, 190));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/adam_1.jpg"))); // NOI18N
        jLabel16.setText("jLabel1");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 170));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/b_1.jpg"))); // NOI18N
        jLabel17.setText("jLabel1");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 120, 170));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/thor_1.jpeg"))); // NOI18N
        jLabel27.setText("jLabel1");
        jLabel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 110, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/wa_1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 110, 150));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/03.png"))); // NOI18N
        jLabel32.setText("jLabel32");
        jPanel10.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, -60, 460, 240));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 230));

        jTabbedPane1.addTab("tab1", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Detail :");

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));

        F1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F1MouseClicked(evt);
            }
        });

        E1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E1MouseClicked(evt);
            }
        });

        D1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D1MouseClicked(evt);
            }
        });

        F2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F2MouseClicked(evt);
            }
        });

        D2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D2MouseClicked(evt);
            }
        });

        E2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E2MouseClicked(evt);
            }
        });

        D4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D4MouseClicked(evt);
            }
        });

        D3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D3MouseClicked(evt);
            }
        });

        E4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E4MouseClicked(evt);
            }
        });

        E3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E3MouseClicked(evt);
            }
        });

        F4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F4MouseClicked(evt);
            }
        });

        F3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F3MouseClicked(evt);
            }
        });

        D6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D6MouseClicked(evt);
            }
        });

        D5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D5MouseClicked(evt);
            }
        });

        E6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E6MouseClicked(evt);
            }
        });

        E5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E5MouseClicked(evt);
            }
        });

        F6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F6MouseClicked(evt);
            }
        });

        F5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F5MouseClicked(evt);
            }
        });

        D8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D8MouseClicked(evt);
            }
        });

        D7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D7MouseClicked(evt);
            }
        });

        E8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E8MouseClicked(evt);
            }
        });

        E7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E7MouseClicked(evt);
            }
        });

        F8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F8MouseClicked(evt);
            }
        });

        F7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F7MouseClicked(evt);
            }
        });

        D10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D10MouseClicked(evt);
            }
        });

        D9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D9MouseClicked(evt);
            }
        });

        E10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E10MouseClicked(evt);
            }
        });

        E9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E9MouseClicked(evt);
            }
        });

        F10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F10MouseClicked(evt);
            }
        });

        F9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F9MouseClicked(evt);
            }
        });

        D12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D12MouseClicked(evt);
            }
        });

        D11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D11MouseClicked(evt);
            }
        });

        E12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E12MouseClicked(evt);
            }
        });

        E11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E11MouseClicked(evt);
            }
        });

        F12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F12MouseClicked(evt);
            }
        });

        F11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                F11MouseEntered(evt);
            }
        });

        D14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D14MouseClicked(evt);
            }
        });

        D13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D13MouseClicked(evt);
            }
        });

        E14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E14MouseClicked(evt);
            }
        });

        E13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E13MouseClicked(evt);
            }
        });

        F14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F14MouseClicked(evt);
            }
        });

        F13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F13MouseClicked(evt);
            }
        });

        D16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D16MouseClicked(evt);
            }
        });

        D15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        D15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        D15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D15MouseClicked(evt);
            }
        });

        E16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E16MouseClicked(evt);
            }
        });

        E15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        E15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        E15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E15MouseClicked(evt);
            }
        });

        F16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F16MouseClicked(evt);
            }
        });

        F15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        F15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px.png"))); // NOI18N
        F15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F15MouseClicked(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("SCREEN");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        C1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C1MouseClicked(evt);
            }
        });

        B1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });

        A1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A1MouseClicked(evt);
            }
        });

        A2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A2MouseClicked(evt);
            }
        });

        B2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });

        C2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C2MouseClicked(evt);
            }
        });

        B3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
        });

        C3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C3MouseClicked(evt);
            }
        });

        A3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A3MouseClicked(evt);
            }
        });

        C6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N

        B6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B6MouseClicked(evt);
            }
        });

        A6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A6MouseClicked(evt);
            }
        });

        A5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A5MouseClicked(evt);
            }
        });

        B5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
        });

        C5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C5MouseClicked(evt);
            }
        });

        C4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C4MouseClicked(evt);
            }
        });

        B4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
        });

        A4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A4MouseClicked(evt);
            }
        });

        C9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C9MouseClicked(evt);
            }
        });

        B9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B9MouseClicked(evt);
            }
        });

        A9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A9MouseClicked(evt);
            }
        });

        A8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A8MouseClicked(evt);
            }
        });

        B8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B8MouseClicked(evt);
            }
        });

        C8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C8MouseClicked(evt);
            }
        });

        C7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C7MouseClicked(evt);
            }
        });

        B7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B7MouseClicked(evt);
            }
        });

        A7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A7MouseClicked(evt);
            }
        });

        C12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C12MouseClicked(evt);
            }
        });

        B12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B12MouseClicked(evt);
            }
        });

        A12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A12MouseClicked(evt);
            }
        });

        A11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A11MouseClicked(evt);
            }
        });

        B11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B11MouseClicked(evt);
            }
        });

        C11.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C11MouseClicked(evt);
            }
        });

        C10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C10MouseClicked(evt);
            }
        });

        B10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B10MouseClicked(evt);
            }
        });

        A10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A10MouseClicked(evt);
            }
        });

        C15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C15MouseClicked(evt);
            }
        });

        B15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B15MouseClicked(evt);
            }
        });

        A15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A15MouseClicked(evt);
            }
        });

        A14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A14MouseClicked(evt);
            }
        });

        B14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B14MouseClicked(evt);
            }
        });

        C14.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C14MouseClicked(evt);
            }
        });

        C13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C13MouseClicked(evt);
            }
        });

        B13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B13MouseClicked(evt);
            }
        });

        A13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A13MouseClicked(evt);
            }
        });

        C16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        C16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        C16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C16MouseClicked(evt);
            }
        });

        B16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        B16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        B16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B16MouseClicked(evt);
            }
        });

        A16.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        A16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_armchair_20px_1.png"))); // NOI18N
        A16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A16MouseClicked(evt);
            }
        });

        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setText("F");

        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setText("E");

        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setText("D");

        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setText("C");

        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setText("B");

        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setText("A");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel203, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(D1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D2))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(E1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E2))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(F1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F2))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(C1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C2))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(B1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B2))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(A1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D4))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E4))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D6))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E6))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D8))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E8))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D10))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E10))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D12))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E12))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D14))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E14))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(D15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(D16))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(E15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(E16))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(F15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(F16))))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B3)
                                    .addComponent(A3)
                                    .addComponent(C3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(C4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C5))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(B4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B5))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(A4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B6)
                                    .addComponent(A6)
                                    .addComponent(C6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(C7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C8))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(B7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B8))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(A7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B9)
                                    .addComponent(A9)
                                    .addComponent(C9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(C10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C11))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(B10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B11))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(A10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B12)
                                    .addComponent(A12)
                                    .addComponent(C12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(C13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C14))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(B13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B14))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(A13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B15)
                                    .addComponent(A15)
                                    .addComponent(C15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(B16)
                                    .addComponent(A16)
                                    .addComponent(C16)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F15)
                            .addComponent(F16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E15)
                            .addComponent(E16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D15)
                            .addComponent(D16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F13)
                            .addComponent(F14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E13)
                            .addComponent(E14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D13)
                            .addComponent(D14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F11)
                            .addComponent(F12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E11)
                            .addComponent(E12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D11)
                            .addComponent(D12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F9)
                            .addComponent(F10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E9)
                            .addComponent(E10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D9)
                            .addComponent(D10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F7)
                            .addComponent(F8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E7)
                            .addComponent(E8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D7)
                            .addComponent(D8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F5)
                            .addComponent(F6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E5)
                            .addComponent(E6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D5)
                            .addComponent(D6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F3)
                            .addComponent(F4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E3)
                            .addComponent(E4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(D3)
                            .addComponent(D4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(F2)
                                .addComponent(jLabel194, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(E1)
                            .addComponent(E2)
                            .addComponent(jLabel195))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(D1)
                                .addComponent(D2))
                            .addComponent(jLabel196))))
                .addGap(35, 35, 35)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C1)
                            .addComponent(C2)
                            .addComponent(C3)
                            .addComponent(jLabel200))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(B1)
                                .addComponent(B2)
                                .addComponent(B3))
                            .addComponent(jLabel202))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A1)
                            .addComponent(A2)
                            .addComponent(A3)
                            .addComponent(jLabel203)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C4)
                            .addComponent(C5)
                            .addComponent(C6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B4)
                            .addComponent(B5)
                            .addComponent(B6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A4)
                            .addComponent(A5)
                            .addComponent(A6)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C7)
                            .addComponent(C8)
                            .addComponent(C9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B7)
                            .addComponent(B8)
                            .addComponent(B9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A7)
                            .addComponent(A8)
                            .addComponent(A9)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C10)
                            .addComponent(C11)
                            .addComponent(C12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B10)
                            .addComponent(B11)
                            .addComponent(B12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A10)
                            .addComponent(A11)
                            .addComponent(A12)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C13)
                            .addComponent(C14)
                            .addComponent(C15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B13)
                            .addComponent(B14)
                            .addComponent(B15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A13)
                            .addComponent(A14)
                            .addComponent(A15)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(C16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(A16)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        NameMovie.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        NameMovie.setForeground(new java.awt.Color(255, 255, 255));
        NameMovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameMovieMouseClicked(evt);
            }
        });

        cycle.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        cycle.setForeground(new java.awt.Color(255, 255, 255));

        roomdetail.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        roomdetail.setForeground(new java.awt.Color(255, 255, 255));

        datedetail.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        datedetail.setForeground(new java.awt.Color(255, 255, 255));

        imgmovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        imgmovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgmovieMouseClicked(evt);
            }
        });

        jLabel15.setText("jLabel15");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Description :");

        Description.setForeground(new java.awt.Color(255, 255, 255));
        Description.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(imgmovie, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cycle, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(roomdetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(datedetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NameMovie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(NameMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(imgmovie, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(cycle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(roomdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datedetail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 430));

        jPanel14.setBackground(new java.awt.Color(153, 0, 0));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setBackground(new java.awt.Color(0, 0, 0));
        jLabel69.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Show Time - Seats Booking");
        jPanel14.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        backTologin3.setBackground(new java.awt.Color(158, 51, 6));
        backTologin3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        backTologin3.setForeground(new java.awt.Color(255, 51, 0));
        backTologin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_back_to_35px.png"))); // NOI18N
        backTologin3.setBorder(new javax.swing.border.MatteBorder(null));
        backTologin3.setBorderPainted(false);
        backTologin3.setContentAreaFilled(false);
        backTologin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backTologin3MouseClicked(evt);
            }
        });
        backTologin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTologin3ActionPerformed(evt);
            }
        });
        jPanel14.add(backTologin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 50));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_next_page_40px.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, 50));

        jPanel8.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 930, 50));

        jTabbedPane1.addTab("tab2", jPanel8);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel11);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel12);

        jPanel16.setBackground(new java.awt.Color(153, 0, 0));
        jPanel16.setPreferredSize(new java.awt.Dimension(900, 560));

        tableTicket.setAutoCreateRowSorter(true);
        tableTicket.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tableTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Theater Room", "Movie"
            }
        ));
        tableTicket.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tableTicket);

        jPanel3.setBackground(new java.awt.Color(102, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Show Time");
        jPanel3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        backTologin2.setBackground(new java.awt.Color(255, 102, 0));
        backTologin2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        backTologin2.setForeground(new java.awt.Color(255, 102, 0));
        backTologin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_back_to_35px.png"))); // NOI18N
        backTologin2.setBorder(new javax.swing.border.MatteBorder(null));
        backTologin2.setBorderPainted(false);
        backTologin2.setContentAreaFilled(false);
        backTologin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backTologin2MouseClicked(evt);
            }
        });
        backTologin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTologin2ActionPerformed(evt);
            }
        });
        jPanel3.add(backTologin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 60, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_next_page_40px.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, 50));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel16);

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(0, 0, 0));
        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, new java.awt.Color(204, 204, 204), java.awt.Color.lightGray, java.awt.Color.lightGray));

        IMGMOVIE.setBackground(new java.awt.Color(204, 0, 0));
        IMGMOVIE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.gray));

        MOVIENAME.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MOVIENAME.setForeground(new java.awt.Color(255, 255, 255));
        MOVIENAME.setText("MOVIE NAME");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_sound_15px_1.png"))); // NOI18N
        jLabel33.setText("TH/--");

        TIME.setForeground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("CYCLE");

        DATE.setForeground(new java.awt.Color(255, 255, 255));
        DATE.setText("DATE 1/10/2022");

        ROOMID.setForeground(new java.awt.Color(255, 255, 255));

        CYCLE.setForeground(new java.awt.Color(255, 255, 255));
        CYCLE.setText("TIME_CYCLE");
        CYCLE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("SEAT :");

        SEAT.setForeground(new java.awt.Color(255, 255, 255));

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("PRICE");

        PRICE.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Theatre");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("THEATRE TICKET");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        minutes.setForeground(new java.awt.Color(255, 255, 255));
        minutes.setText(" Minutes");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ROOMID)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(IMGMOVIE, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(CYCLE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MOVIENAME, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel36)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DATE)
                                            .addComponent(SEAT)))
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addComponent(TIME, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minutes)))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(PRICE)
                                    .addComponent(jLabel45)))))
                    .addComponent(jLabel33))
                .addGap(53, 53, 53))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(7, 19, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(MOVIENAME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(minutes)
                                .addComponent(jLabel24))
                            .addComponent(TIME, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DATE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(IMGMOVIE, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ROOMID)
                    .addComponent(jLabel19)
                    .addComponent(CYCLE))
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PRICE)
                    .addComponent(SEAT))
                .addGap(34, 34, 34))
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 120, 510, -1));

        jPanel21.setBackground(new java.awt.Color(153, 0, 0));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Show Time - Seats Booking - SUMMARY");
        jPanel21.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_back_to_35px.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BUY");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 134, 35));

        jPanel18.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 930, 60));

        jTabbedPane1.addTab("tab4", jPanel18);

        jPanel20.setBackground(new java.awt.Color(153, 0, 0));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ticketShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MOVIE TILTLE", "DATE", "SHOWTIME", "THEATRE", "SEAT No.", "PRICE"
            }
        ));
        jScrollPane2.setViewportView(ticketShow);

        jPanel20.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 127, 709, 323));

        jPanel22.setBackground(new java.awt.Color(102, 0, 0));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jPanel22.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jLabel63.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jPanel22.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jPanel22.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jPanel22.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, -50, 140, 160));

        jLabel66.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jPanel22.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -50, 140, 160));

        jPanel20.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 565, 900, 50));

        jPanel23.setBackground(new java.awt.Color(102, 0, 0));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("All Tickets");
        jPanel23.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        backTologin1.setBackground(new java.awt.Color(158, 51, 6));
        backTologin1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        backTologin1.setForeground(new java.awt.Color(255, 255, 255));
        backTologin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_back_to_35px.png"))); // NOI18N
        backTologin1.setBorder(new javax.swing.border.MatteBorder(null));
        backTologin1.setBorderPainted(false);
        backTologin1.setContentAreaFilled(false);
        backTologin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTologin1ActionPerformed(evt);
            }
        });
        jPanel23.add(backTologin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 40));

        jPanel20.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 930, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/01.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel20.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 340, -1, -1));

        jTabbedPane1.addTab("tab3", jPanel20);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 900, 590));

        jPanel6.setBackground(new java.awt.Color(102, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_film_reel_20px_1.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_Menu_20px_1_1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theatermain/image/icons8_Google_Home_20px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addGap(43, 43, 43)
                .addComponent(jLabel8)
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 590));

        setSize(new java.awt.Dimension(974, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
         jTabbedPane1.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        jTabbedPane1.setSelectedIndex(4);      // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableTicket.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        try {
            java.sql.Connection con = Cinema.connectDB();
            Statement stm = con.createStatement();

            String sqlMovie = "SELECT * FROM cycle_composit NATURAL JOIN cycle NATURAL JOIN movie";
            java.sql.ResultSet rs = stm.executeQuery(sqlMovie);

            while (rs.next()) {

                String movieName = rs.getString("movie_name");
                String date = rs.getString("cycle_date");
                String time = rs.getString("cycle.cycle_time_start_end");
                String room = rs.getString("room_id");

                String tbData[] = {date, time, room, movieName};

                DefaultTableModel tbModel3 = (DefaultTableModel) tableTicket.getModel();
                tbModel3.addRow(tbData);

            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    public void checkSeat(){
    
        try {
            
            String sql = "select ticket_seat from ticket where movie_id=? and cycle_id=?";
            
            Connection con = (Connection) Cinema.connectDB();
            pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, idMovie);
            pst.setString(2,idCycle);
            rs = (ResultSet) pst.executeQuery();
            
            if(rs!=null){  
                imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
                while(rs.next()){
                    System.out.println(rs.getString(1));
                       if(rs.getString("ticket_seat").toString().equals("F1")){
                           F1.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F2")){
                       
                           F2.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F3")){
                       
                           F3.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F4")){
                       
                           F4.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F5")){
                       
                           F5.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F6")){
                       
                           F6.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F7")){
                       
                           F7.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F8")){
                       
                           F8.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F9")){
                       
                           F9.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F10")){
                       
                           F10.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F11")){
                       
                           F11.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F12")){
                       
                           F12.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F13")){
                       
                           F13.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F14")){
                       
                           F14.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F15")){
                       
                           F15.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("F16")){
                       
                           F16.setIcon(imageicon);
                       }
                        else if(rs.getString("ticket_seat").toString().equals("E1")){
                           E1.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E2")){
                       
                           E2.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E3")){
                       
                           E3.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E4")){
                       
                           E4.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E5")){
                       
                           E5.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E6")){
                       
                           E6.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E7")){
                       
                           E7.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E8")){
                       
                           E8.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E9")){
                       
                           E9.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E10")){
                       
                           E10.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E11")){
                       
                           E11.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E12")){
                       
                           E12.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E13")){
                       
                           E13.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E14")){
                       
                           E14.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E15")){
                       
                           E15.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("E16")){
                       
                           E16.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D1")){
                           D1.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D2")){
                       
                           D2.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D3")){
                       
                           D3.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D4")){
                       
                           D4.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D5")){
                       
                           D5.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D6")){
                       
                           D6.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D7")){
                       
                           D7.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D8")){
                       
                           D8.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D9")){
                       
                           D9.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D10")){
                       
                           D10.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D11")){
                       
                           D11.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D12")){
                       
                           D12.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D13")){
                       
                           D13.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D14")){
                       
                           D14.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D15")){
                       
                           D15.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("D16")){
                       
                           D16.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C1")){
                           C1.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C2")){
                       
                           C2.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C3")){
                       
                           C3.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C4")){
                       
                           C4.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C5")){
                       
                           C5.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C6")){
                       
                           C6.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C7")){
                       
                           C7.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C8")){
                       
                           C8.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C9")){
                       
                           C9.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C10")){
                       
                           C10.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C11")){
                       
                           C11.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C12")){
                       
                           C12.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C13")){
                       
                           C13.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C14")){
                       
                           C14.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C15")){
                       
                           C15.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("C16")){
                       
                           C16.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B1")){
                           B1.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B2")){
                       
                           B2.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B3")){
                       
                           B3.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B4")){
                       
                           B4.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B5")){
                       
                           B5.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B6")){
                       
                           B6.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B7")){
                       
                           B7.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B8")){
                       
                           B8.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B9")){
                       
                           B9.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B10")){
                       
                           B10.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B11")){
                       
                           B11.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B12")){
                       
                           B12.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B13")){
                       
                           B13.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B14")){
                       
                           B14.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B15")){
                       
                           B15.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("B16")){
                       
                           B16.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A1")){
                           A1.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A2")){
                       
                           A2.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A3")){
                       
                           A3.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A4")){
                       
                           A4.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A5")){
                       
                           A5.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A6")){
                       
                           A6.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A7")){
                       
                           A7.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A8")){
                       
                           A8.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A9")){
                       
                           A9.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A10")){
                       
                           A10.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A11")){
                       
                           A11.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A12")){
                       
                           A12.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A13")){
                       
                           A13.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A14")){
                       
                           A14.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A15")){
                       
                           A15.setIcon(imageicon);
                       }
                       else if(rs.getString("ticket_seat").toString().equals("A16")){
                       
                           A16.setIcon(imageicon);
                       }
               }
            }
            else
            {
                System.out.println("1235484654654");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }
    
    
    
    
    
    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        jTabbedPane1.setSelectedIndex(4); 
        DefaultTableModel model = (DefaultTableModel) tableTicket.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        try {
            java.sql.Connection con = Cinema.connectDB();
            Statement stm = con.createStatement();

            String sqlMovie = "SELECT * FROM cycle_composit NATURAL JOIN cycle NATURAL JOIN movie";
            java.sql.ResultSet rs = stm.executeQuery(sqlMovie);

            while (rs.next()) {

                String movieName = rs.getString("movie_name");
                String date = rs.getString("cycle_date");
                String time = rs.getString("cycle.cycle_time_start_end");
                String room = rs.getString("room_id");

                String tbData[] = {date, time, room, movieName};

                DefaultTableModel tbModel3 = (DefaultTableModel) tableTicket.getModel();
                tbModel3.addRow(tbData);

            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_jLabel29MouseClicked
        
    //............F...............
    private void F9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F9MouseClicked
        // TODO add your handling code here:
        
        String a =F9.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F9.setIcon(imageicon);
            seat.unSeat("F9", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F9.setIcon(imageicon);
            seat = new Seat("F9",200);
        }
    }//GEN-LAST:event_F9MouseClicked

    private void F10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F10MouseClicked
        // TODO add your handling code here:
        
        String a =F10.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F10.setIcon(imageicon);
            seat.unSeat("F10", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F10.setIcon(imageicon);
            seat = new Seat("F10",200);
        }
    }//GEN-LAST:event_F10MouseClicked

    private void F7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F7MouseClicked
        // TODO add your handling code here:
        
        String a =F7.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F7.setIcon(imageicon);
            seat.unSeat("F7", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F7.setIcon(imageicon);
            seat = new Seat("F7",200);
        }
    }//GEN-LAST:event_F7MouseClicked

    private void F8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F8MouseClicked
        // TODO add your handling code here:
        
        String a =F8.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F8.setIcon(imageicon);
            seat.unSeat("F8", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F8.setIcon(imageicon);
            seat = new Seat("F8",200);
        }
    }//GEN-LAST:event_F8MouseClicked

    private void F5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F5MouseClicked
        // TODO add your handling code here:
       
        String a =F5.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F5.setIcon(imageicon);
            seat.unSeat("F5", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F5.setIcon(imageicon);
            seat = new Seat("F5",200);
        }
    }//GEN-LAST:event_F5MouseClicked

    private void F6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F6MouseClicked
        // TODO add your handling code here:
       
        String a =F6.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F6.setIcon(imageicon);
            seat.unSeat("F6", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F6.setIcon(imageicon);
            seat = new Seat("F6",200);
        }
    }//GEN-LAST:event_F6MouseClicked

    private void F3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F3MouseClicked
       
        String a =F3.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F3.setIcon(imageicon);
            seat.unSeat("F3", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F3.setIcon(imageicon);
            seat = new Seat("F3",200);
        }
    }//GEN-LAST:event_F3MouseClicked

    private void F4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F4MouseClicked
        // TODO add your handling code here:
       
        String a =F4.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F4.setIcon(imageicon);
            seat.unSeat("F4", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F4.setIcon(imageicon);
            seat = new Seat("F4",200);
        }
    }//GEN-LAST:event_F4MouseClicked

    private void F2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F2MouseClicked
     
        String a =F2.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F2.setIcon(imageicon);
            seat.unSeat("F2", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F2.setIcon(imageicon);
            seat = new Seat("F2",200);
        }
    }//GEN-LAST:event_F2MouseClicked

    private void F1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F1MouseClicked

        String a =F1.getIcon().toString();
        
        //cancel
        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F1.setIcon(imageicon);
            seat.unSeat("F1", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F1.setIcon(imageicon);
            seat = new Seat("F1",200);
        }
    }//GEN-LAST:event_F1MouseClicked

    private void F16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F16MouseClicked
       
        String a =F16.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F16.setIcon(imageicon);
            seat.unSeat("F16", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F16.setIcon(imageicon);
            seat = new Seat("F16",200);
        }
    }//GEN-LAST:event_F16MouseClicked

    private void F15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F15MouseClicked
       
        String a =F15.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F15.setIcon(imageicon);
            seat.unSeat("F15", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F15.setIcon(imageicon);
            seat = new Seat("F15",200);
        }
    }//GEN-LAST:event_F15MouseClicked

    private void F14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F14MouseClicked
       
        String a =F14.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F14.setIcon(imageicon);
            seat.unSeat("F14", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F14.setIcon(imageicon);
            seat = new Seat("F14",200);
        }
    }//GEN-LAST:event_F14MouseClicked

    private void F13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F13MouseClicked
       
        String a =F13.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F13.setIcon(imageicon);
            seat.unSeat("F13", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F13.setIcon(imageicon);
            seat = new Seat("F13",200);
        }
    }//GEN-LAST:event_F13MouseClicked

    private void F12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F12MouseClicked
      
        String a =F12.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F12.setIcon(imageicon);
            seat.unSeat("F12", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F12.setIcon(imageicon);
            seat = new Seat("F12",200);
        }
    }//GEN-LAST:event_F12MouseClicked

    private void F11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_F11MouseEntered

    private void F11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F11MouseClicked
       
        String a =F11.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            F11.setIcon(imageicon);
            seat.unSeat("F11", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            F11.setIcon(imageicon);
            seat = new Seat("F11",200);
        }
    }//GEN-LAST:event_F11MouseClicked
    //............F...............
    
    
    //............E..............
    private void E1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E1MouseClicked
       
        String a =E1.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E1.setIcon(imageicon);
            seat.unSeat("E1", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E1.setIcon(imageicon);
            seat = new Seat("E1",200);
        }
    }//GEN-LAST:event_E1MouseClicked

    private void E2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E2MouseClicked
       
        String a =E2.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E2.setIcon(imageicon);
            seat.unSeat("E2", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E2.setIcon(imageicon);
            seat = new Seat("E2",200);
        }
    }//GEN-LAST:event_E2MouseClicked

    private void E3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E3MouseClicked
      
        String a =E3.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E3.setIcon(imageicon);
            seat.unSeat("E3", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E3.setIcon(imageicon);
            seat = new Seat("E3",200);
        }
    }//GEN-LAST:event_E3MouseClicked

    private void E4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E4MouseClicked
      
        String a =E4.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E4.setIcon(imageicon);
            seat.unSeat("E4", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E4.setIcon(imageicon);
            seat = new Seat("E4",200);
        }
    }//GEN-LAST:event_E4MouseClicked

    private void E5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E5MouseClicked
        
        String a =E5.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E5.setIcon(imageicon);
            seat.unSeat("E5", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E5.setIcon(imageicon);
            seat = new Seat("E5",200);
        }
    }//GEN-LAST:event_E5MouseClicked

    private void E6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E6MouseClicked
      
        String a =E6.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E6.setIcon(imageicon);
            seat.unSeat("E6", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E6.setIcon(imageicon);
            seat = new Seat("E6",200);
        }
    }//GEN-LAST:event_E6MouseClicked

    private void E7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E7MouseClicked
       
        String a =E7.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E7.setIcon(imageicon);
            seat.unSeat("E7", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E7.setIcon(imageicon);
            seat = new Seat("E7",200);
        }
    }//GEN-LAST:event_E7MouseClicked

    private void E8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E8MouseClicked
       
        String a =E8.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E8.setIcon(imageicon);
            seat.unSeat("E8", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E8.setIcon(imageicon);
            seat = new Seat("E8",200);
        }
    }//GEN-LAST:event_E8MouseClicked

    private void E9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E9MouseClicked
        
        String a =E9.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E9.setIcon(imageicon);
            seat.unSeat("E9", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E9.setIcon(imageicon);
            seat = new Seat("E9",200);
        }
    }//GEN-LAST:event_E9MouseClicked

    private void E10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E10MouseClicked
       
        String a =E10.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E10.setIcon(imageicon);
            seat.unSeat("E10", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E10.setIcon(imageicon);
            seat = new Seat("E10",200);
        }
    }//GEN-LAST:event_E10MouseClicked

    private void E11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E11MouseClicked
  
        String a =E11.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E11.setIcon(imageicon);
            seat.unSeat("E11", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E11.setIcon(imageicon);
            seat = new Seat("E11",200);
        }
    }//GEN-LAST:event_E11MouseClicked

    private void E12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E12MouseClicked
        
        String a =E12.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E12.setIcon(imageicon);
            seat.unSeat("E12", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E12.setIcon(imageicon);
            seat = new Seat("E12",200);
        }
    }//GEN-LAST:event_E12MouseClicked

    private void E13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E13MouseClicked
       
        String a =E13.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E13.setIcon(imageicon);
            seat.unSeat("E13", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E13.setIcon(imageicon);
            seat = new Seat("E13",200);
        }
    }//GEN-LAST:event_E13MouseClicked

    private void E14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E14MouseClicked
      
        String a =E14.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E14.setIcon(imageicon);
            seat.unSeat("E14", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E14.setIcon(imageicon);
            seat = new Seat("E14",200);
        }
    }//GEN-LAST:event_E14MouseClicked

    private void E15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E15MouseClicked
      
        String a =E15.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E15.setIcon(imageicon);
            seat.unSeat("E15", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E15.setIcon(imageicon);
            seat = new Seat("E15",200);
        }
    }//GEN-LAST:event_E15MouseClicked

    private void E16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E16MouseClicked
        
        String a =E16.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            E16.setIcon(imageicon);
            seat.unSeat("E16", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            E16.setIcon(imageicon);
            seat = new Seat("E16",200);
        }
    }//GEN-LAST:event_E16MouseClicked
    
    //.............E..................
    
    
    //.............D................
    private void D1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D1MouseClicked
      
        String a =D1.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D1.setIcon(imageicon);
            seat.unSeat("D1", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D1.setIcon(imageicon);
            seat = new Seat("D1",200);
        }
    }//GEN-LAST:event_D1MouseClicked

    private void D2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D2MouseClicked
        
        String a =D2.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D2.setIcon(imageicon);
            seat.unSeat("D2", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D2.setIcon(imageicon);
            seat = new Seat("D2",200);
        }
    }//GEN-LAST:event_D2MouseClicked

    private void D3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D3MouseClicked
        
        String a =D3.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D3.setIcon(imageicon);
            seat.unSeat("D3", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D3.setIcon(imageicon);
            seat = new Seat("D3",200);
        }
    }//GEN-LAST:event_D3MouseClicked

    private void D4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D4MouseClicked
      
        String a =D4.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D4.setIcon(imageicon);
            seat.unSeat("D4", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D4.setIcon(imageicon);
            seat = new Seat("D4",200);
        }
    }//GEN-LAST:event_D4MouseClicked

    private void D5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D5MouseClicked
      
        String a =D5.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D5.setIcon(imageicon);
            seat.unSeat("D5", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D5.setIcon(imageicon);
            seat = new Seat("D5",200);
        }
    }//GEN-LAST:event_D5MouseClicked

    private void D6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D6MouseClicked
      
        String a =D6.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D6.setIcon(imageicon);
            seat.unSeat("D6", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D6.setIcon(imageicon);
            seat = new Seat("D6",200);
        }
    }//GEN-LAST:event_D6MouseClicked

    private void D7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D7MouseClicked
      
        String a =D7.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D7.setIcon(imageicon);
            seat.unSeat("D7", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D7.setIcon(imageicon);
            seat = new Seat("D7",200);
        }
    }//GEN-LAST:event_D7MouseClicked

    private void D8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D8MouseClicked
       
        String a =D8.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D8.setIcon(imageicon);
            seat.unSeat("D8", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D8.setIcon(imageicon);
            seat = new Seat("D8",200);
        }
    }//GEN-LAST:event_D8MouseClicked

    private void D9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D9MouseClicked
       
        String a =D9.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D9.setIcon(imageicon);
            seat.unSeat("D9", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D9.setIcon(imageicon);
            seat = new Seat("D9",200);
        }
    }//GEN-LAST:event_D9MouseClicked

    private void D10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D10MouseClicked
     
        String a =D10.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D10.setIcon(imageicon);
            seat.unSeat("D10", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D10.setIcon(imageicon);
            seat = new Seat("D10",200);
        }
    }//GEN-LAST:event_D10MouseClicked

    private void D11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D11MouseClicked
        
        String a =D11.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D11.setIcon(imageicon);
            seat.unSeat("D11", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D11.setIcon(imageicon);
            seat = new Seat("D11",200);
        }
    }//GEN-LAST:event_D11MouseClicked

    private void D12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D12MouseClicked
        
        String a =D12.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D12.setIcon(imageicon);
            seat.unSeat("D12", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D12.setIcon(imageicon);
            seat = new Seat("D12",200);
        }
    }//GEN-LAST:event_D12MouseClicked

    private void D13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D13MouseClicked
       
        String a =D13.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D13.setIcon(imageicon);
            seat.unSeat("D1", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D13.setIcon(imageicon);
            seat = new Seat("D13",200);
        }
    }//GEN-LAST:event_D13MouseClicked

    private void D14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D14MouseClicked
        
        String a =D14.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D14.setIcon(imageicon);
            seat.unSeat("D14", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D14.setIcon(imageicon);
            seat = new Seat("D14",200);
        }
    }//GEN-LAST:event_D14MouseClicked

    private void D15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D15MouseClicked
        
        String a =D15.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D15.setIcon(imageicon);
            seat.unSeat("D15", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D15.setIcon(imageicon);
            seat = new Seat("D15",200);
        }
    }//GEN-LAST:event_D15MouseClicked

    private void D16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D16MouseClicked
       
        String a =D16.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px.png");
            D16.setIcon(imageicon);
            seat.unSeat("D16", 200);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            D16.setIcon(imageicon);
            seat = new Seat("D16",200);
        }
    }//GEN-LAST:event_D16MouseClicked

     //...............D................
    
    
    //.................C................
    
    private void C1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C1MouseClicked
        
        String a =C1.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C1.setIcon(imageicon);
            seat.unSeat("C1", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C1.setIcon(imageicon);
            seat = new Seat("C1",250);
        }
    }//GEN-LAST:event_C1MouseClicked

    private void C2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C2MouseClicked
       
        String a =C2.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C2.setIcon(imageicon);
            seat.unSeat("C2", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C2.setIcon(imageicon);
            seat = new Seat("C2",250);
        }
    }//GEN-LAST:event_C2MouseClicked

    private void C3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C3MouseClicked
        
        String a =C3.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C3.setIcon(imageicon);
            seat.unSeat("C3", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C3.setIcon(imageicon);
            seat = new Seat("C3",250);
        }
    }//GEN-LAST:event_C3MouseClicked

    private void C4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C4MouseClicked
       
        String a =C4.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C4.setIcon(imageicon);
            seat.unSeat("C4", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C4.setIcon(imageicon);
            seat = new Seat("C4",250);
        }
    }//GEN-LAST:event_C4MouseClicked

    private void C5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C5MouseClicked
       
        String a =C5.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C5.setIcon(imageicon);
            seat.unSeat("C5", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C5.setIcon(imageicon);
            seat = new Seat("C5",250);
        }
    }//GEN-LAST:event_C5MouseClicked

    private void C7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C7MouseClicked
      
        String a =C7.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C7.setIcon(imageicon);
            seat.unSeat("C7", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C7.setIcon(imageicon);
            seat = new Seat("C7",250);
        }
    }//GEN-LAST:event_C7MouseClicked

    private void C8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C8MouseClicked
     
        String a =C8.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C8.setIcon(imageicon);
            seat.unSeat("C8", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C8.setIcon(imageicon);
            seat = new Seat("C8",250);
        }
    }//GEN-LAST:event_C8MouseClicked

    private void C9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C9MouseClicked
       
        String a =C9.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C9.setIcon(imageicon);
            seat.unSeat("C9", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C9.setIcon(imageicon);
            seat = new Seat("C9",250);
        }
    }//GEN-LAST:event_C9MouseClicked

    private void C10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C10MouseClicked
      
        String a =C10.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C10.setIcon(imageicon);
            seat.unSeat("C10", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C10.setIcon(imageicon);
            seat = new Seat("C10",250);
        }
    }//GEN-LAST:event_C10MouseClicked

    private void C11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C11MouseClicked
      
        String a =C11.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C11.setIcon(imageicon);
            seat.unSeat("C11", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C11.setIcon(imageicon);
            seat = new Seat("C11",250);
        }
    }//GEN-LAST:event_C11MouseClicked

    private void C12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C12MouseClicked
      
        String a =C12.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C12.setIcon(imageicon);
            seat.unSeat("C12", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C12.setIcon(imageicon);
            seat = new Seat("C12",250);
        }
    }//GEN-LAST:event_C12MouseClicked

    private void C13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C13MouseClicked
      
        String a =C13.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C13.setIcon(imageicon);
            seat.unSeat("C13", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C13.setIcon(imageicon);
            seat = new Seat("C13",250);
        }
    }//GEN-LAST:event_C13MouseClicked

    private void C14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C14MouseClicked
       
        String a =C14.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C14.setIcon(imageicon);
            seat.unSeat("C14", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C14.setIcon(imageicon);
            seat = new Seat("C14",250);
        }
    }//GEN-LAST:event_C14MouseClicked

    private void C15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C15MouseClicked
      
        String a =C15.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C15.setIcon(imageicon);
            seat.unSeat("C15", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C15.setIcon(imageicon);
            seat = new Seat("C15",250);
        }
    }//GEN-LAST:event_C15MouseClicked

    private void C16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C16MouseClicked
     
        String a =C16.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            C16.setIcon(imageicon);
            seat.unSeat("C16", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            C16.setIcon(imageicon);
            seat = new Seat("C16",250);
        }
    }//GEN-LAST:event_C16MouseClicked
    //................C....................
    
    //...............B.............
    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
       
        String a =B1.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B1.setIcon(imageicon);
            seat.unSeat("B1", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B1.setIcon(imageicon);
            seat = new Seat("B1",250);
        }
    }//GEN-LAST:event_B1MouseClicked

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
      
        String a =B2.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B2.setIcon(imageicon);
            seat.unSeat("B2", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B2.setIcon(imageicon);
            seat = new Seat("B2",250);
        }
    }//GEN-LAST:event_B2MouseClicked

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked
        
        String a =B3.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B3.setIcon(imageicon);
            seat.unSeat("B3", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B3.setIcon(imageicon);
            seat = new Seat("B3",250);
        }
    }//GEN-LAST:event_B3MouseClicked

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked
       
        String a =B4.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B4.setIcon(imageicon);
            seat.unSeat("B4", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B4.setIcon(imageicon);
            seat = new Seat("B4",250);
        }
    }//GEN-LAST:event_B4MouseClicked

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked
       
        String a =B5.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B5.setIcon(imageicon);
            seat.unSeat("B5", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B5.setIcon(imageicon);
            seat = new Seat("B5",250);
        }
    }//GEN-LAST:event_B5MouseClicked

    private void B6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B6MouseClicked
       
        String a =B6.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B6.setIcon(imageicon);
            seat.unSeat("B6", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B6.setIcon(imageicon);
            seat = new Seat("B6",250);
        }
    }//GEN-LAST:event_B6MouseClicked

    private void B7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseClicked
       
        String a =B6.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B6.setIcon(imageicon);
            seat.unSeat("B6", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B6.setIcon(imageicon);
            seat = new Seat("B6",250);
        }
    }//GEN-LAST:event_B7MouseClicked

    private void B8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B8MouseClicked
        
        String a =B8.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B8.setIcon(imageicon);
            seat.unSeat("B8", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B8.setIcon(imageicon);
            seat = new Seat("B8",250);
        }
    }//GEN-LAST:event_B8MouseClicked

    private void B9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseClicked
       
        String a =B9.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B9.setIcon(imageicon);
            seat.unSeat("B9", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B9.setIcon(imageicon);
            seat = new Seat("B9",250);
        }
    }//GEN-LAST:event_B9MouseClicked

    private void B10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B10MouseClicked
       
        String a =B10.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B10.setIcon(imageicon);
            seat.unSeat("B10", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B10.setIcon(imageicon);
            seat = new Seat("B10",250);
        }
    }//GEN-LAST:event_B10MouseClicked

    private void B11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B11MouseClicked
       
        String a =B11.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B11.setIcon(imageicon);
            seat.unSeat("B11", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B11.setIcon(imageicon);
            seat = new Seat("B11",250);
        }
    }//GEN-LAST:event_B11MouseClicked

    private void B12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B12MouseClicked
    
        String a =B12.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B12.setIcon(imageicon);
            seat.unSeat("B12", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B12.setIcon(imageicon);
            seat = new Seat("B12",250);
        }
    }//GEN-LAST:event_B12MouseClicked

    private void B13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B13MouseClicked
       
        String a =B13.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B13.setIcon(imageicon);
            seat.unSeat("B13", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B13.setIcon(imageicon);
            seat = new Seat("B13",250);
        }
    }//GEN-LAST:event_B13MouseClicked

    private void B14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B14MouseClicked
       
        String a =B14.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B14.setIcon(imageicon);
            seat.unSeat("B14", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B14.setIcon(imageicon);
            seat = new Seat("B14",250);
        }
    }//GEN-LAST:event_B14MouseClicked

    private void B15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B15MouseClicked
       
        String a =B15.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B15.setIcon(imageicon);
            seat.unSeat("B15", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B15.setIcon(imageicon);
            seat = new Seat("B15",250);
        }
    }//GEN-LAST:event_B15MouseClicked

    private void B16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B16MouseClicked
        
        String a =B16.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            B16.setIcon(imageicon);
            seat.unSeat("B16", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            B16.setIcon(imageicon);
            seat = new Seat("B16",250);
        }
    }//GEN-LAST:event_B16MouseClicked

    //..............B.............
    
    //..............A.............
    
    private void A1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A1MouseClicked
       
        String a =A1.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A1.setIcon(imageicon);
            seat.unSeat("A1", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A1.setIcon(imageicon);
            seat = new Seat("A1",250);
        }
    }//GEN-LAST:event_A1MouseClicked

    private void A2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A2MouseClicked
       
        String a =A2.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A2.setIcon(imageicon);
            seat.unSeat("A2", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A2.setIcon(imageicon);
            seat = new Seat("A2",250);
        }
    }//GEN-LAST:event_A2MouseClicked

    private void A3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A3MouseClicked
     
        String a =A3.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A3.setIcon(imageicon);
            seat.unSeat("A3", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A3.setIcon(imageicon);
            seat = new Seat("A3",250);
        }
    }//GEN-LAST:event_A3MouseClicked

    private void A4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A4MouseClicked
       
        String a =A4.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A4.setIcon(imageicon);
            seat.unSeat("A4", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A4.setIcon(imageicon);
            seat = new Seat("A4",250);
        }
    }//GEN-LAST:event_A4MouseClicked

    private void A5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A5MouseClicked
       
        String a =A5.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A5.setIcon(imageicon);
            seat.unSeat("A5", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A5.setIcon(imageicon);
            seat = new Seat("A5",250);
        }
    }//GEN-LAST:event_A5MouseClicked

    private void A6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseClicked
        String a =A6.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A6.setIcon(imageicon);
            seat.unSeat("A6", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A6.setIcon(imageicon);
            seat = new Seat("A6",250);
        }
    }//GEN-LAST:event_A6MouseClicked

    private void A7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A7MouseClicked
        String a =A7.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A7.setIcon(imageicon);
            seat.unSeat("A7", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A7.setIcon(imageicon);
            seat = new Seat("A7",250);
        }
    }//GEN-LAST:event_A7MouseClicked

    private void A8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A8MouseClicked
        String a =A8.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A8.setIcon(imageicon);
            seat.unSeat("A8", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A8.setIcon(imageicon);
            seat = new Seat("A8",250);
        }
    }//GEN-LAST:event_A8MouseClicked

    private void A9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A9MouseClicked
        String a =A9.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A9.setIcon(imageicon);
            seat.unSeat("A9", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A9.setIcon(imageicon);
            seat = new Seat("A9",250);
        }
    }//GEN-LAST:event_A9MouseClicked

    private void A10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A10MouseClicked
        String a =A10.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A10.setIcon(imageicon);
            seat.unSeat("A10", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A10.setIcon(imageicon);
            seat = new Seat("A10",250);
        }
    }//GEN-LAST:event_A10MouseClicked

    private void A11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A11MouseClicked
        String a =A11.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A11.setIcon(imageicon);
            seat.unSeat("A11", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A11.setIcon(imageicon);
            seat = new Seat("A11",250);
        }
    }//GEN-LAST:event_A11MouseClicked

    private void A12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A12MouseClicked
        String a =A12.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A12.setIcon(imageicon);
            seat.unSeat("A12", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A12.setIcon(imageicon);
            seat = new Seat("A12",250);
        }
    }//GEN-LAST:event_A12MouseClicked

    private void A13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A13MouseClicked
        String a =A13.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A13.setIcon(imageicon);
            seat.unSeat("A13", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A13.setIcon(imageicon);
            seat = new Seat("A13",250);
        }
    }//GEN-LAST:event_A13MouseClicked

    private void A14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A14MouseClicked
        String a =A14.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A14.setIcon(imageicon);
            seat.unSeat("A14", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A14.setIcon(imageicon);
            seat = new Seat("A14",250);
        }
    }//GEN-LAST:event_A14MouseClicked

    private void A15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A15MouseClicked
        String a =A15.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A15.setIcon(imageicon);
            seat.unSeat("A15", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A15.setIcon(imageicon);
            seat = new Seat("A15",250);
        }
    }//GEN-LAST:event_A15MouseClicked

    private void A16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A16MouseClicked
        String a =A16.getIcon().toString();

        if(a.equals("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png")){
            check = false;
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_armchair_20px_1_2.png");
            A16.setIcon(imageicon);
            seat.unSeat("A16", 250);

        }
        else{
            imageicon = new ImageIcon("D:\\TheaterMain\\src\\theatermain\\image\\icons8_ok_20px_2.png");
            A16.setIcon(imageicon);
            seat = new Seat("A16",250);
        }
    }//GEN-LAST:event_A16MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backTologin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTologin1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_backTologin1ActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        jTabbedPane1.setSelectedIndex(6);
        
        DefaultTableModel model = (DefaultTableModel) ticketShow.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        
         try{
            java.sql.Connection con = Cinema.connectDB();
            Statement stm = con.createStatement();
            
            String sqlUser = "SELECT movie_name, cycle_date, cycle_time_start_end, room_id, ticket_seat, ticket_price FROM ticket NATURAL JOIN member NATURAL JOIN movie NATURAL JOIN cycle NATURAL JOIN cycle_composit NATURAL JOIN room WHERE member.user = '"+users+"' ;";
            
            java.sql.ResultSet rs = stm.executeQuery(sqlUser);
            while(rs.next())
            {
                    String movie_name = rs.getString("movie_name");
                    String cycle_date = rs.getString("cycle_date");
                    String cycle_time_start_end = rs.getString("cycle_time_start_end");
                    String room_id = rs.getString("room_id");
                    String ticket_seat = rs.getString("ticket_seat");
                    String ticket_price = rs.getString("ticket_price");
                    //System.out.println("Try================================"+showTime+movie_name);

                    String tbData[] = {movie_name, cycle_date, cycle_time_start_end, room_id, ticket_seat, ticket_price};

                    DefaultTableModel tbModel2 = (DefaultTableModel)ticketShow.getModel();    

                     tbModel2.addRow(tbData);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int input = JOptionPane.showConfirmDialog(null,
                "Comfirm ticket buy", "Comfirm Ticket Buy.", JOptionPane.YES_NO_OPTION);

        // 0=yes, 1=no, 
        if (input == 0) {
            Seat seat = new Seat();
            this.seatList = seat.showSeat();
            /*System.out.println(idmem);
            System.out.println(UserPage.idCycle+"........");*/
            for(int i=0;i<seatList.size();i++){
                Ticket ticket = new Ticket(UserPage.idCycle, idMovie, UserPage.idmem,seatList.get(i).getSeat(),seatList.get(i).getPrice());

            }

            String reportTicket = "namemovie: "+MOVIENAME.getText()+"\n"+"time: "+TIME.getText()+"\n"+"cycle: "+CYCLE.getText()
                    +"\n"+"room: "+ROOMID.getText()+"\n"+"seat: "+SEAT.getText()+"\n"+"price: "+PRICE.getText();

            try {
                Writer writer = new FileWriter("Report_Ticket.txt");
                writer.write(reportTicket);
                writer.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


            jTabbedPane1.setSelectedIndex(0); 
        }
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void imgmovieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgmovieMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_imgmovieMouseClicked

    private void NameMovieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMovieMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameMovieMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
        Login l1 = new Login();
        l1.setVisible(true);
        //System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void backTologin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTologin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backTologin2ActionPerformed

    private void backTologin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backTologin2MouseClicked
         jTabbedPane1.setSelectedIndex(0); // TODO add your handling code here:
    }//GEN-LAST:event_backTologin2MouseClicked

    private void backTologin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTologin3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backTologin3ActionPerformed

    private void backTologin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backTologin3MouseClicked
        jTabbedPane1.setSelectedIndex(4); // TODO add your handling code here:
    }//GEN-LAST:event_backTologin3MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        jTabbedPane1.setSelectedIndex(1);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
    
        Connection conMovie = (Connection) Cinema.connectDB();
        PreparedStatement pst;
        int row = tableTicket.getSelectedRow();

        
        //String cycleID = (String) tableTicket.getModel().getValueAt(row, 0);
        this.date = (String) tableTicket.getModel().getValueAt(row, 0);
        this.time = (String) tableTicket.getModel().getValueAt(row, 1);
        this.room = (String) tableTicket.getModel().getValueAt(row, 2);
        this.nameMovie = (String) tableTicket.getModel().getValueAt(row, 3);
        //System.out.println(date+" "+time+" "+room+" "+nameMovie);
        showDetailBooking();
        
        jTabbedPane1.setSelectedIndex(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        jTabbedPane1.setSelectedIndex(5);
        showDataImgMovieTicket();
        showDetailBookingTicket();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked
   
    //...................A...............
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A1;
    private javax.swing.JLabel A10;
    private javax.swing.JLabel A11;
    private javax.swing.JLabel A12;
    private javax.swing.JLabel A13;
    private javax.swing.JLabel A14;
    private javax.swing.JLabel A15;
    private javax.swing.JLabel A16;
    private javax.swing.JLabel A2;
    private javax.swing.JLabel A3;
    private javax.swing.JLabel A4;
    private javax.swing.JLabel A5;
    private javax.swing.JLabel A6;
    private javax.swing.JLabel A7;
    private javax.swing.JLabel A8;
    private javax.swing.JLabel A9;
    private javax.swing.JLabel B1;
    private javax.swing.JLabel B10;
    private javax.swing.JLabel B11;
    private javax.swing.JLabel B12;
    private javax.swing.JLabel B13;
    private javax.swing.JLabel B14;
    private javax.swing.JLabel B15;
    private javax.swing.JLabel B16;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JLabel B6;
    private javax.swing.JLabel B7;
    private javax.swing.JLabel B8;
    private javax.swing.JLabel B9;
    private javax.swing.JLabel C1;
    private javax.swing.JLabel C10;
    private javax.swing.JLabel C11;
    private javax.swing.JLabel C12;
    private javax.swing.JLabel C13;
    private javax.swing.JLabel C14;
    private javax.swing.JLabel C15;
    private javax.swing.JLabel C16;
    private javax.swing.JLabel C2;
    private javax.swing.JLabel C3;
    private javax.swing.JLabel C4;
    private javax.swing.JLabel C5;
    private javax.swing.JLabel C6;
    private javax.swing.JLabel C7;
    private javax.swing.JLabel C8;
    private javax.swing.JLabel C9;
    private javax.swing.JLabel CYCLE;
    private javax.swing.JLabel D1;
    private javax.swing.JLabel D10;
    private javax.swing.JLabel D11;
    private javax.swing.JLabel D12;
    private javax.swing.JLabel D13;
    private javax.swing.JLabel D14;
    private javax.swing.JLabel D15;
    private javax.swing.JLabel D16;
    private javax.swing.JLabel D2;
    private javax.swing.JLabel D3;
    private javax.swing.JLabel D4;
    private javax.swing.JLabel D5;
    private javax.swing.JLabel D6;
    private javax.swing.JLabel D7;
    private javax.swing.JLabel D8;
    private javax.swing.JLabel D9;
    private javax.swing.JLabel DATE;
    private javax.swing.JLabel Description;
    private javax.swing.JLabel E1;
    private javax.swing.JLabel E10;
    private javax.swing.JLabel E11;
    private javax.swing.JLabel E12;
    private javax.swing.JLabel E13;
    private javax.swing.JLabel E14;
    private javax.swing.JLabel E15;
    private javax.swing.JLabel E16;
    private javax.swing.JLabel E2;
    private javax.swing.JLabel E3;
    private javax.swing.JLabel E4;
    private javax.swing.JLabel E5;
    private javax.swing.JLabel E6;
    private javax.swing.JLabel E7;
    private javax.swing.JLabel E8;
    private javax.swing.JLabel E9;
    private javax.swing.JLabel F1;
    private javax.swing.JLabel F10;
    private javax.swing.JLabel F11;
    private javax.swing.JLabel F12;
    private javax.swing.JLabel F13;
    private javax.swing.JLabel F14;
    private javax.swing.JLabel F15;
    private javax.swing.JLabel F16;
    private javax.swing.JLabel F2;
    private javax.swing.JLabel F3;
    private javax.swing.JLabel F4;
    private javax.swing.JLabel F5;
    private javax.swing.JLabel F6;
    private javax.swing.JLabel F7;
    private javax.swing.JLabel F8;
    private javax.swing.JLabel F9;
    private javax.swing.JLabel IMGMOVIE;
    private javax.swing.JLabel MOVIENAME;
    private javax.swing.JLabel NameMovie;
    private javax.swing.JLabel PRICE;
    private javax.swing.JLabel ROOMID;
    private javax.swing.JLabel SEAT;
    private javax.swing.JLabel TIME;
    private javax.swing.JButton backTologin1;
    private javax.swing.JButton backTologin2;
    private javax.swing.JButton backTologin3;
    private javax.swing.JLabel cycle;
    private javax.swing.JLabel datedetail;
    private javax.swing.JLabel imgmovie;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel minutes;
    private javax.swing.JLabel roomdetail;
    private javax.swing.JTable tableTicket;
    private javax.swing.JTable ticketShow;
    private javax.swing.JLabel userTab;
    // End of variables declaration//GEN-END:variables
}
