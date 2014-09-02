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
@WebServlet(name = "creategame", urlPatterns = {"/creategame"})
public class creategame extends HttpServlet {

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
        HttpSession session=request.getSession(true);
        String name=(String) session.getAttribute("username");
       // out.println("name: "+name);
        String gname=request.getParameter("BName");
        session.setAttribute("game",gname);
        String pwd=request.getParameter("Pwd");
       String col=request.getParameter("col");
      //  int no=Integer.parseInt(request.getParameter("Players"));
        String n=request.getParameter("Players"); 
        
       // out.println(name+"   "+gname+"   "+pwd+"   "+n+"   "+col);
        int no=Integer.parseInt(n);
         int c=1;
         Connection con=null;
        String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		 con = DriverManager.getConnection(url+db,"root","root");
        try {
             
                PreparedStatement pst1=con.prepareStatement("Select game_name from game_details where game_name=?");
                pst1.setString(1,gname);
                ResultSet rs1=pst1.executeQuery();
                if(rs1.next()){}else {
                    PreparedStatement pstmt1=con.prepareStatement("Insert into game_details values(?,?,?,?,?)");
                    pstmt1.setString(1,gname);
                    pstmt1.setString(2,pwd);
                    pstmt1.setInt(3,no);
                    pstmt1.setString(4,name);
                    pstmt1.setInt(5,c);
                    int countInserted = pstmt1.executeUpdate();
                    System.out.println(countInserted + " records inserted.\n");
                    PreparedStatement pstmt11=con.prepareStatement("Insert into player_details values(?,?,?,?,?)");
                    int cu=0,pr=0;
                    pstmt11.setString(1,name);
                    pstmt11.setString(2,gname);
                    pstmt11.setString(3,col);
                    pstmt11.setInt(4,cu);
                    pstmt11.setInt(5,pr);
                    pstmt11.executeUpdate();
                    
                    PreparedStatement prs=con.prepareStatement("Insert into turn values(?,?)");
                    prs.setString(1,name);
                    prs.setInt(2,0);
                    prs.executeUpdate();
                PreparedStatement p=con.prepareStatement("select max_players,count from game_details where game_name=?");
           p.setString(1,gname);
           ResultSet r1=p.executeQuery();
           r1.next();
            if(r1.getInt(1)==r1.getInt(2)){response.sendRedirect("board.jsp"); }
            if(r1.getInt(1)>r1.getInt(2)){response.sendRedirect("wait.jsp");}
                }
        } catch(SQLException ex) {            
            ex.printStackTrace();
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
            Logger.getLogger(creategame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(creategame.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(creategame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(creategame.class.getName()).log(Level.SEVERE, null, ex);
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
