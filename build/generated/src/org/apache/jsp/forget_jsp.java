package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

public final class forget_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body background=\"bgr.jpg\">\n");
      out.write("     \n");
      out.write("    ");
 Connection con=null;
                String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		con = DriverManager.getConnection(url+db,"root","root"); 
            
            
      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("<div class=\"links\"><font size=\"4.5\" ><pre><p><a href=\"home.html\" style=\"text-decoration:none;color:66FF00\">  HOME            </a><a href=\"reg.html\" style=\"text-decoration:none;color:66FF00\">  REGISTER            </a><a style=\"color:66FF00;text-decoration:none\"href=\"rules.html\">  RULES            </a><a style=\"color:66FF00;text-decoration:none\"href=\"creategame.html\">  CREATE GAME            </a><a style=\"color:66FF00;text-decoration:none\"href=\"contactus.html\">  CONTACT US            </a><a style=\"color:66FF00;text-decoration:none\"href=\"demo.html\">  DEMO            </a></p></pre></font></div>\n");
      out.write(" <div class=\"head\"><img style=\"width:100%;height:100%;\"src=\"question.jpg\"></div>\n");
      out.write("  \n");
      out.write("  <div class=\"da\"> </div>\n");
      out.write("  <div class=\"db\">\n");
      out.write("\t<form name=\"myForm\"   action=\"http://localhost:8084/JoinGame/forgetQue.jsp\" method=post >\t<pre><font size=\"4\" color=\"orange\"><br>\n");
      out.write("\t\t\t<b>Enter Your User Name:  <input type=\"text\" name=\"UName\" value=\"\"></b><br><br>\n");
      out.write("                        \t\t<input type=\"submit\" value=\"Submit\"/></pre>\n");
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
