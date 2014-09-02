<html>
<head>
<link href="css3.css" rel="stylesheet" type="text/css"></style>

</head>
<body background="bgr.jpg"><meta http-equiv="refresh" content="5"/>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %><%@ page import="javax.servlet.*" %><%@ page import="java.util.*" %> 
    <%   
                Connection con=null;
                String url = "jdbc:mysql://localhost:3306/";
		String db = "snakes_ladders";
		String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
		con = DriverManager.getConnection(url+db,"root","root");
                session=request.getSession(true);
                String game=(String)session.getAttribute("game");
                PreparedStatement p=con.prepareStatement("select max_players,count from game_details where game_name=?");
                p.setString(1,game);
                ResultSet r1=p.executeQuery();
                r1.next();
              
                 if(r1.getInt(1)==r1.getInt(2)){response.sendRedirect("board.jsp");}
                 
                            %>
<div class="main">
<div class="links"><font size="4.5" ><pre><p><a href="home.html" style="text-decoration:none;color:66FF00">  HOME            </a><a href="reg.html" style="text-decoration:none;color:66FF00">  REGISTER            </a><a style="color:66FF00;text-decoration:none"href="rules.html">  RULES            </a><a style="color:66FF00;text-decoration:none"href="chatroom.html">  CHAT ROOM            </a><a style="color:66FF00;text-decoration:none"href="contactus.html">  CONTACT US            </a><a style="color:66FF00;text-decoration:none"href="demo.html">  DEMO            </a></p></pre></font></div>
   
  <div class="da"><img width="100%" height="100%" src="wait.gif"> </div>
   <div class="foot"><font size="5" color="black" ><p align="center"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>
 </div>
</body>
</html>