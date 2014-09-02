<%-- 
    Document   : logout
    Created on : Mar 14, 2013, 7:56:09 PM
    Author     : KaNnA
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     Connection con=null;
                String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		con = DriverManager.getConnection(url+db,"root","root");    
    %>
    </body>
</html>
