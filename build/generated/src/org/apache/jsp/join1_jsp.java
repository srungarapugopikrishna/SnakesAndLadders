package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

public final class join1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"css2.css\" rel=\"stylesheet\" type=\"text/css\"></style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function validate(form)\n");
      out.write("{\n");
      out.write("//alert(form.UName.value.charAt(1));\n");
      out.write("   \n");
      out.write("  if (form.BName.value==null || form.BName.value==\"\" || form.BName.value==\" \")\n");
      out.write("  {\n");
      out.write("  alert(\"Enter Board Name Name\");\n");
      out.write("  return (false);\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("}\n");
      out.write("function submit1()\n");
      out.write("{\n");
      out.write("    document.forms[0].action=\"join1.jsp\";\n");
      out.write("    document.forms[0].submit();\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body background=\"bgr.jpg\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("<div class=\"main\">\n");
      out.write("<div class=\"links\"><font size=\"4.5\" ><pre><p><a href=\"home.html\" style=\"text-decoration:none;color:66FF00\">  HOME            </a><a href=\"reg.html\" style=\"text-decoration:none;color:66FF00\">  REGISTER            </a><a style=\"color:66FF00;text-decoration:none\"href=\"rules.html\">  RULES            </a><a style=\"color:66FF00;text-decoration:none\"href=\"creategame.html\">  CREATE GAME            </a><a style=\"color:66FF00;text-decoration:none\"href=\"contactus.html\">  CONTACT US            </a><a style=\"color:66FF00;text-decoration:none\"href=\"demo.html\">  DEMO            </a></p></pre></font></div>\n");
      out.write(" <div class=\"head\"><img style=\"width:100%;height:100%;\"src=\"gamezone.jpg\"></div>\n");
      out.write("  \n");
      out.write("  <div class=\"da\"> </div>\n");
      out.write("  <div class=\"db\">\n");
      out.write("\t<form name=\"myForm\"  action=\"http://localhost:8084/JoinGame/joingame\" method=post onsubmit=\"return validate(this)\">\t<pre><font size=\"4\" color=\"orange\"><br>\n");
      out.write("\t\t\t  \n");
      out.write("<b>  Board Name:                ");
 Connection con=null;
     String url = "jdbc:mysql://localhost:3306/";
     String db = "snakes_ladders";
     String driver = "com.mysql.jdbc.Driver";
     Class.forName(driver);
     con = DriverManager.getConnection(url+db,"root","root");
     PreparedStatement pst1=con.prepareStatement("Select game_name from game_details");
     ResultSet rs1=pst1.executeQuery();
      out.write("<select name=\"gops\" onchange=\"submit1()\"><option value=\"");
      out.print(request.getParameter("gops") );
      out.write('"');
      out.write('>');
      out.print(request.getParameter("gops") );
      out.write("</option>\n");
      out.write("   ");
 while(rs1.next()) { 
      out.write("<option value=\"");
      out.print(rs1.getString(1));
      out.write("\" >");
      out.print(rs1.getString(1));
      out.write("</option>\n");
      out.write("   ");
 }
      out.write(" </select>\n");
      out.write("                                           \n");
      out.write("\t\t\t \n");
      out.write("   Select Die Color:\n");
      out.write("   ");
 Connection con1=null;
      String url1 = "jdbc:mysql://localhost:3306/";
      String db1 = "snakes_ladders";
      String driver1 = "com.mysql.jdbc.Driver";
      Class.forName(driver1);
      con1 = DriverManager.getConnection(url1+db1,"root","root");
      PreparedStatement pst11=con1.prepareStatement("Select player_color from player_details where game_name=?");
      String s=request.getParameter("gops");
      System.out.println(s);
      pst11.setString(1,s);
      ResultSet rs11=pst11.executeQuery();
      ArrayList al=new ArrayList();
      al.add("red");
      al.add("Green");
      al.add("Blue");
      al.add("Yellow");
      while(rs11.next()){
      String col=rs11.getString(1);
      System.out.println(col);
      if(al.contains(col)){
      al.remove(col);
      } }
      for(int i=0;i<al.size();i++){
      out.write("<input type=\"radio\" name=\"col\" value=\"");
      out.print(al.get(i));
      out.write("\"> <font color=\"");
      out.print(al.get(i));
      out.write("\"> ");
      out.print(al.get(i));
      out.write(" </font>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("                 \n");
      out.write("                \n");
      out.write("                </b>       \n");
      out.write("                                     <br>\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Submit\"/></pre>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <div class=\"dc\"> </div>\n");
      out.write("   <div class=\"foot\"><font size=\"5\" color=\"black\" ><p align=\"center\"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>\n");
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
