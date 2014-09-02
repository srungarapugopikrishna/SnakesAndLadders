package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"css1.css\" rel=\"stylesheet\" type=\"text/css\"></style>\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    </script>\n");
      out.write("<body background=\"bgr.jpg\"><meta http-equiv=\"refresh\" content=\"1\"/>\n");
      out.write("    \n");
      out.write("     \n");
      out.write("    ");
   int pawn=0;int n=0;String pa="",pb="",pc="";int a1=0,a2=0,a3=0;
                Connection con=null;
                String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		con = DriverManager.getConnection(url+db,"root","root");
                session=request.getSession(true);
                String uname=(String)session.getAttribute("username");
                String game=(String)session.getAttribute("game");
                PreparedStatement p=con.prepareStatement("select  player_name,current_position,player_color from player_details where game_name=?");
                p.setString(1,game);
                String c="";String pwn="";
                char d;
                ResultSet r1=p.executeQuery(); 
      out.write("\n");
      out.write("                ");
 
                while(r1.next()){  
                if(uname.equals(r1.getString(1))){
                    pawn=r1.getInt(2);
                    c=r1.getString(3);
                    d=c.toLowerCase().charAt(0);
                   pwn=d+".jpg";
                     
                }  
                 else{
                    if(pa.equals("")){
                    a1=r1.getInt(2);
                    c=r1.getString(3);
                    d=c.toLowerCase().charAt(0);
                    pa=d+".jpg";
                    }else if(pb.equals("")){
                    a2=r1.getInt(2);
                    c=r1.getString(3);
                    d=c.toLowerCase().charAt(0);
                    pb=d+".jpg";
                    }else if(pc.equals("")){
                    a3=r1.getInt(2);
                    c=r1.getString(3);
                    d=c.toLowerCase().charAt(0);
                    pc=d+".jpg";
                    }
                                    }     
                }
                

      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("<div class=\"links\"><font size=\"4.5\" ><pre><p><a href=\"home.html\" style=\"text-decoration:none;color:66FF00\">  HOME            </a><a style=\"color:66FF00;text-decoration:none\"href=\"reg.html\" target=\"blank\">  REGISTER            </a><a style=\"color:66FF00;text-decoration:none\"href=\"rules.html\" target=\"blank\">  RULES            </a><a style=\"color:66FF00;text-decoration:none\"href=\"creategame.html\" target=\"blank\">CREATE GAME            </a><a style=\"color:66FF00;text-decoration:none\"href=\"join.html\" target=\"blank\">JOIN GAME            </a><a style=\"color:66FF00;text-decoration:none\"href=\"aboutus.html\" target=\"blank\">ABOUT US            </a><a style=\"color:66FF00;text-decoration:none\"href=\"contactus.html\" target=\"blank\">  CONTACT US            </a><a style=\"color:66FF00;text-decoration:none\"href=\"demo.html\" target=\"blank\">DEMO            </a></p></pre></font></div>\n");
      out.write(" \n");
      out.write("  \n");
      out.write("  \n");
      out.write(" <div class=\"dd\">  <br>\n");
      out.write(" <table align=\"center\" width=\"1000\" height=\"520\" border=\"1\" background=\"slb.gif\">\n");
      out.write("     ");
 
int arr[]={100,99,98,97,96,95,94,93,92,91,81,82,83,84,85,86,87,88,89,90,80,79,78,77,76,75,74,73,72,71,61,62,63,64,65,66,67,68,69,70,60,59,58,57,56,55,54,53,52,51,41,42,43,44,45,46,47,48,49,50,40,39,38,37,36,35,34,33,32,31,21,22,23,24,25,26,27,28,29,30,20,19,18,17,16,15,14,13,12,11,1,2,3,4,5,6,7,8,9,10};     
    for(int i=1;i<=10;i++){
      out.write(" \n");
      out.write("         <tr>  \n");
      out.write("             ");
 for(int j=1;j<=10;j++){ //System.out.println(uname+"n"+n+"pawn"+pawn);
             //   for(int k=0){}
             
      out.write(" \n");
      out.write("                    ");
 if(arr[n]==pawn){
              
                             n++; 
      out.write("\n");
      out.write("                            <td width=\"80\" height=\"49\" > <img align=\"center\" height=\"30\" width=\"30\" src=");
      out.print(pwn);
      out.write(" ></td>\n");
      out.write("                         ");
 } 
                        else if(arr[n]==a1 && !pa.equals("")){  
                            n++;
      out.write("\n");
      out.write("                            <td width=\"80\" height=\"49\" > <img align=\"center\" height=\"30\" width=\"30\" src=");
      out.print(pa);
      out.write(" ></td>\n");
      out.write("                          ");
 }else if(arr[n]==a2 && !pb.equals("")){  
                            n++;
      out.write("\n");
      out.write("                            <td width=\"80\" height=\"49\" > <img align=\"center\" height=\"30\" width=\"30\" src=");
      out.print(pb);
      out.write(" ></td>\n");
      out.write("                          ");
 }else if(arr[n]==a2 && !pc.equals("")){  
                            n++;
      out.write("\n");
      out.write("                            <td width=\"80\" height=\"49\" > <img align=\"center\" height=\"30\" width=\"30\" src=");
      out.print(pc);
      out.write(" ></td>\n");
      out.write("                          ");
 } else{  
                            n++;
      out.write("\n");
      out.write("                            <td width=\"80\" height=\"49\">&nbsp;</td>\n");
      out.write("                          ");
 }
                    
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("           </tr>  \n");
      out.write("      ");
}
      out.write("\n");
      out.write("  </table>\n");
      out.write("\n");
      out.write(" </div>\n");
      out.write(" \n");
      out.write("                \n");
      out.write("                \n");
      out.write("               \n");
      out.write("                         \n");
      out.write(" <div class=\"dc\"> <br><pre>\n");
  p=con.prepareStatement("select  player_name,player_color,current_position from player_details where game_name=?");
                p.setString(1,game);
                 r1=p.executeQuery(); 
      out.write("\n");
      out.write("<table border=\"1\" align=\"center\" width=\"20%\"height=\"10%\" bgcolor=\"#ADFF2F\" cellpadding=\"5\">\n");
      out.write("    <tr>\n");
      out.write("        <td>Player_Name</td>\n");
      out.write("    <td>Color</td>\n");
      out.write("    <td>Position</td></tr><tr>\n");
      out.write("    ");
 while(r1.next()){
      out.write("\n");
      out.write("<td>");
      out.print(r1.getString(1) );
      out.write("</td>\n");
      out.write("    <td>");
      out.print(r1.getString(2) );
      out.write("</td>\n");
      out.write("    <td>");
      out.print(r1.getInt(3) );
      out.write(" </td>\n");
      out.write("    \n");
      out.write("</tr>  ");
} 
      out.write("\n");
      out.write("</table>\n");
      out.write("<table border=\"1\" align=\"center\" width=\"20%\"height=\"10%\" bgcolor=\"#ADFF2F\" cellpadding=\"5\">\n");
      out.write("    \n");
      out.write("         ");
 PreparedStatement p1=con.prepareStatement("select  player_name,current_position,previous_position from player_details where game_name=?");
                p1.setString(1,game);
                ResultSet r2=p1.executeQuery(); 
      out.write("  \n");
      out.write("         ");
       while(r2.next()){
                if(r2.getInt(2)>=100){
      out.write("\n");
      out.write("    <tr> <td> ");
      out.print(r2.getString(1) );
      out.write(" won the game </td></tr>\n");
      out.write("                ");
}
                }
      out.write("    \n");
      out.write("\n");
      out.write("</table>                \n");
      out.write("                \n");
 int position=Integer.parseInt(session.getAttribute("position").toString());
 p1=con.prepareStatement("select  current_position,previous_position from player_details where player_name=? and game_name=?");
                p1.setString(1,uname);p1.setString(2,game);
                r2=p1.executeQuery();r2.next();
                
   if((r2.getInt(1))==100){
       
       PreparedStatement pst2=con.prepareStatement(" delete from game_details where game_name=?");
                pst2.setString(1,game); 
                pst2.executeUpdate();
                response.sendRedirect("win.html");
                    session.invalidate();
   }else{
       
      out.write('\n');
      out.write('\n');
 if((r2.getInt(1))-(r2.getInt(2))==6){
      out.write("<table border=\"1\" align=\"center\" width=\"15%\"height=\"10%\" bgcolor=\"#ADFF2F\" cellpadding=\"5\">\n");
      out.write("    <tr><td>Extra Chance</td></tr></table>");
} 
      out.write("\n");
      out.write("    ");
      out.write(";\n");
      out.write("       <table border=\"1\" align=\"center\" width=\"5%\"height=\"10%\" bgcolor=\"#ADFF2F\" cellpadding=\"5\"><tr><td>\n");
      out.write("               ");
      out.print(position );
      out.write(" \n");
      out.write("</td></tr></table>\n");

  PreparedStatement pp=con.prepareStatement("select  current_position from player_details where game_name=?");
                pp.setString(1,game);
                ResultSet rr=pp.executeQuery();
                boolean b=true;
                while(rr.next()){
                if((rr.getInt(1))==100){b=false;}
                }
String sql="select player from turn where rank=(select min(rank) from turn) limit 1";
Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	rs.next();
		boolean trn=false;
		 String name=rs.getString(1);
	//	 String uname=(String)session.getAttribute("name");
		 if(name.equals(uname))
		 {
			 out.println("<h3>            Your Turn<h3>");
			 trn=true;
		 
		 }
		 else
		 {
			 trn=false;
			 out.println("<h3>          "+name+"'s Turn<h3>");
		 
		 }

      out.write('\n');
 if(trn){   
      out.write("             <a href=\"board\" style=\"text-decoration:none;\"><button type=\"button\">Roll Dice</button> </a> ");
}else{
      out.write(" \n");
      out.write("                <button type=\"button\">Roll Dice</button>  ");
}}
      out.write("\n");
      out.write("<br>\n");
      out.write("\t\t   </div>\n");
      out.write("\t</pre>\n");
      out.write(" <div class=\"foot\"><font size=\"5\" color=66FF00 ><p align=\"center\"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>\n");
      out.write(" </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
