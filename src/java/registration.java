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

/**
 *
 * @author KaNnA
 */
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        System.out.println("in service");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        int val;
		String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		 con = DriverManager.getConnection(url+db,"root","root");
        try {
        String fname=request.getParameter("FName");
        String lname=request.getParameter("LName");
        String uname=request.getParameter("UName");
        String date=request.getParameter("yy")+"-"+request.getParameter("mm")+"-"+request.getParameter("dd");
        String sex=request.getParameter("Sex");
        String email=request.getParameter("Mail");
        String pwd=request.getParameter("Pwd");
         System.out.println(pwd);
        String addr=request.getParameter("Address");
         System.out.println(addr);
        String ques=request.getParameter("select");
        String ans=request.getParameter("Ans");
        System.out.println(ques);
        
        PreparedStatement pstmt=con.prepareStatement("select username from registration where username=?");
        pstmt.setString(1,uname);
        ResultSet rs=pstmt.executeQuery();
        
                    if(rs.next())
                    {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Username already registered</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1><center> Username already registered </h1>");
                out.println("</body>");
                out.println("</html>");
                    }
                    else                
                    {
        
                    PreparedStatement pstmt1=con.prepareStatement("Insert into registration values(?,?,?,?,?,?,?,?,?,?)");
                    pstmt1.setString(1, fname);
                    pstmt1.setString(2, lname);
                    pstmt1.setString(3, uname);
                    pstmt1.setString(4, date);
                    pstmt1.setString(5, sex);
                    pstmt1.setString(6, email);
                    pstmt1.setString(7, pwd);
                    pstmt1.setString(8, addr);
                    pstmt1.setString(9, ques);
                    pstmt1.setString(10, ans);
                    int countInserted = pstmt1.executeUpdate();
                    System.out.println(countInserted + " records inserted.\n");
                    System.out.println("The records selected are:"); 
                    out.println("<html>");
                    out.println("<head>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1><center>Registration Successfull</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    }
        }
                    catch(SQLException ex) {
                    ex.printStackTrace();
                      }
                    catch(Exception e)
                    {
                        e.printStackTrace();
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
                    try {
                        processRequest(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
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
                    try {
                        processRequest(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
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
