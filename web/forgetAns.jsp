<html>
<head>
<link href="css2.css" rel="stylesheet" type="text/css"></style>
 
</head>

<body background="bgr.jpg"><%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %><%@ page import="javax.servlet.*" %><%@ page import="java.util.*" %> 
    <% Connection con=null;
                String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		con = DriverManager.getConnection(url+db,"root","root"); 
                String answr=request.getParameter("Ans");
                 
                 String name=(String) session.getAttribute("usr");
            %>
<div class="main">
<div class="links"><font size="4.5" ><pre><p><a href="home.html" style="text-decoration:none;color:66FF00">              HOME            </a><a href="reg.jsp" style="text-decoration:none;color:66FF00">  REGISTER            </a><a style="color:66FF00;text-decoration:none"href="rules.html">  RULES            </a><a style="color:66FF00;text-decoration:none"href="creategame.html">  CREATE GAME            </a><a style="color:66FF00;text-decoration:none"href="contactus.html">  CONTACT US            </a></p></pre></font></div>
 <div class="head"><img style="width:100%;height:100%;"src="question.jpg"></div>
  
  <div class="da"> </div>
  <div class="db">
	<form name="myForm"   action="LogIn.html" method=post >	<pre><font size="4" color="orange"><br>
			  <% 
                PreparedStatement pst=con.prepareStatement("Select password from registration where username=? and ans=?");
                pst.setString(1,name);
                pst.setString(2,answr);
                System.out.println(name+"---"+answr);
                ResultSet rs=pst.executeQuery();
    if(rs.next()){%> <b>Your Password: <%=rs.getString(1) %><%}else{%>Sorry!!!!! Answer doesn't matched...<%}%></b><br><br>
			</b><br><br>
					<input type="submit" value="OK"/></pre>

  </div>
  <div class="dc"> </div>
   <div class="foot"><font size="5" color="black" ><p align="center"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>
 </div>
</body>
</html>