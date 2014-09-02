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
@WebServlet(name = "joingame", urlPatterns = {"/joingame"})
public class joingame extends HttpServlet {

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
        String uname=(String) session.getAttribute("username");
        String gname=request.getParameter("gops");
        String col=request.getParameter("col");
        
        session.setAttribute("game",gname);
        Connection con=null;
        String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		 con = DriverManager.getConnection(url+db,"root","root");
           PreparedStatement p=con.prepareStatement("select max_players,count from game_details where game_name=?");
           p.setString(1,gname);
           ResultSet r1=p.executeQuery();
           r1.next();
            if(r1.getInt(1)==r1.getInt(2)){response.sendRedirect("board.jsp"); }
            if(r1.getInt(1)>r1.getInt(2)){
           try {
            PreparedStatement pst=con.prepareStatement("Insert into player_details values(?,?,?,?,?)");
                pst.setString(1,uname);
                pst.setString(2,gname);
                pst.setString(3,col);
                pst.setInt(4,0);
                pst.setInt(5,0);
                pst.executeUpdate();
                 PreparedStatement prs=con.prepareStatement("Insert into turn values(?,?)");
                    prs.setString(1,uname);
                    prs.setInt(2,0);
                    prs.executeUpdate();
                PreparedStatement pst1=con.prepareStatement(" update game_details set count=count+1 where game_name=?");
                pst1.setString(1,gname); 
                pst1.executeUpdate();
                response.sendRedirect("wait.jsp");
        } finally {            
            out.close();
        }}
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
            Logger.getLogger(joingame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(joingame.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(joingame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(joingame.class.getName()).log(Level.SEVERE, null, ex);
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
