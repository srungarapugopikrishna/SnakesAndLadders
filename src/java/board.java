/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KaNnA
 */
@WebServlet(name = "board", urlPatterns = {"/board"})
public class board extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con=null;
        String url = "jdbc:mysql://localhost:3306/";
	String db = "snakes_ladders";
	String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
	con = DriverManager.getConnection(url+db,"root","root");
        HttpSession session=request.getSession(true);
        String name=(String) session.getAttribute("username");
        String game=(String) session.getAttribute("game");
        
        PreparedStatement pst11=con.prepareStatement(" update turn set rank=rank+1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
         
         PreparedStatement pst=con.prepareStatement("select current_position from player_details where player_name=?");
        pst.setString(1,name);
        ResultSet rs=pst.executeQuery();
         rs.next();
         
        
         
         int current_position=rs.getInt(1);
         int present =current_position;
          PreparedStatement pst2=con.prepareStatement(" update player_details set previous_position="+current_position+" where player_name=?");
                pst2.setString(1,name); 
                pst2.executeUpdate();
        Random randomNumbers = new Random();
        int start =1;       
        int end = 6;      
   
        int die = start + randomNumbers.nextInt( end - start + 1 ); 
        
        if(current_position+die<=100) {
                    present=die+current_position;
                }
      //////Snakes  
        if(present==17) {
                    present=7;
                }
        if(present==54) {
                    present=34;
                }
        if(present==62) {
                    present=19;
                }
        if(present==64) {
                    present=60;
                }
        if(present==87) {
                    present=24;
                }
        if(present==93) {
                    present=73;
                }
        if(present==95) {
                    present=75;
                }
        if(present==98) {
                    present=79;
                }
        
        //////Ladders
        if(present==1) {
                    present=38;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==4) {
                    present=14;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==9) {
                    present=31;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==28) {
                    present=84;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==21) {
                    present=42;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==51) {
                    present=67;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==71) {
                    present=91;
                    pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(present==80) {
                    present=100;
              //      pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
                }
        if(die==6){
        pst11=con.prepareStatement(" update turn set rank=rank-1 where player=?");
         pst11.setString(1,name);       
         pst11.executeUpdate();
        }
         
        PreparedStatement pst1=con.prepareStatement(" update player_details set current_position="+present+" where player_name=?");
                pst1.setString(1,name); 
                pst1.executeUpdate();
       
        session.setAttribute("position",die);
        boolean tru=true;
  /*      response.sendRedirect("board.html");
       
         while(tru){
        String sql="select player from turn where rank=(select min(rank) from turn) limit 1";
        Statement st=con.createStatement();
	ResultSet r=st.executeQuery(sql);
	r.next();
		 
		 String nme=r.getString(1);
	//	 String uname=(String)session.getAttribute("name");
		 if(name.equals(nme))
		 {
			 
			 tru=false;
		 
		 }
		 else
		 {
			 tru=true;
			 
		 
		 }
               
        } 
    */     
        try {
            /* TODO output your page here. You may use following sample code. */
            response.sendRedirect("board.jsp");
        //    out.println(number);
        } finally {            
        //    out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
