<html>
<head>
<link href="css2.css" rel="stylesheet" type="text/css"></style>

<script type="text/javascript">
   
   
    
function validate(form)
{
//alert(form.UName.value.charAt(1));
   
  if (form.BName.value==null || form.BName.value=="" || form.BName.value==" ")
  {
  alert("Enter Board Name Name");
  return (false);
  }
  
}
function submit1()
{
    document.forms[0].action="join1.jsp";
    document.forms[0].submit();
}
</script>

</head>
<body background="bgr.jpg">
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %><%@ page import="javax.servlet.*" %><%@ page import="java.util.*" %>
<div class="main">
<div class="links"><font size="4.5" ><pre><p><a href="home.html" style="text-decoration:none;color:66FF00">  HOME            </a><a href="reg.html" style="text-decoration:none;color:66FF00">  REGISTER            </a><a style="color:66FF00;text-decoration:none"href="rules.html">  RULES            </a><a style="color:66FF00;text-decoration:none"href="chatroom.html">  CHAT ROOM            </a><a style="color:66FF00;text-decoration:none"href="contactus.html">  CONTACT US            </a><a style="color:66FF00;text-decoration:none"href="demo.html">  DEMO            </a></p></pre></font></div>
 <div class="head"><img style="width:100%;height:100%;"src="gamezone.jpg"></div>
  
  <div class="da"> </div>
  <div class="db">
	<form name="myForm"  action="joingame" method=post onsubmit="return validate(this)">	<pre><font size="4" color="orange"><br>
			  
<b>  Board Name:                <% Connection con=null;
     String url = "jdbc:mysql://localhost:3306/";
     String db = "snakes_ladders";
     String driver = "com.mysql.jdbc.Driver";
     Class.forName(driver);
     con = DriverManager.getConnection(url+db,"root","root");
     PreparedStatement pst1=con.prepareStatement("Select game_name from game_details");
     ResultSet rs1=pst1.executeQuery();%><select name="gops" onchange="submit1()"><option value="<%=request.getParameter("gops") %>"><%=request.getParameter("gops") %></option>
   <% while(rs1.next()) { %><option value="<%=rs1.getString(1)%>" ><%=rs1.getString(1)%></option>
   <% }%> </select>
                                           
			 
   
   <% Connection con1=null;
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
      } }%>Select Die Color:<%
      for(int i=0;i<al.size();i++){%>       <input type="radio" name="col" value="<%=al.get(i)%>"> <font color="<%=al.get(i)%>"><%=al.get(i)%> </font>
      <% } %>
                 
                
                </b>       
                                     <br>
					<input type="submit" value="Submit"/></pre>

  </div>
  <div class="dc"> </div>
   <div class="foot"><font size="5" color="black" ><p align="center"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>
 </div>
</body>
</html>