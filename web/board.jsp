 
<html>
<head>
<link href="css1.css" rel="stylesheet" type="text/css"></style>
</head>
<script type="text/javascript">
    
    
    </script>
<body background="bgr.jpg"><meta http-equiv="refresh" content="1"/>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %><%@ page import="javax.servlet.*" %><%@ page import="java.util.*" %> 
    <%   int pawn=0;int n=0;String pa="",pb="",pc="";int a1=0,a2=0,a3=0;
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
                ResultSet r1=p.executeQuery(); %>
                <% 
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
                
%>
<div class="main">
<div class="links"><font size="4.5" ><pre><p><a href="home.html" style="text-decoration:none;color:66FF00">  HOME            </a><a style="color:66FF00;text-decoration:none"href="reg.html" target="blank">  REGISTER            </a><a style="color:66FF00;text-decoration:none"href="rules.html" target="blank">  RULES            </a><a style="color:66FF00;text-decoration:none"href="aboutus.html" target="blank">ABOUT US            </a><a style="color:66FF00;text-decoration:none"href="contactus.html" target="blank">  CONTACT US            </a><a style="color:66FF00;text-decoration:none"href="chatroom.html" target="blank">CHAT ROOM            </a></p></pre></font></div>
 
  
  
 <div class="dd">  <br>
 <table align="center" width="1000" height="520" border="1" background="slb.gif">
     <% 
int arr[]={100,99,98,97,96,95,94,93,92,91,81,82,83,84,85,86,87,88,89,90,80,79,78,77,76,75,74,73,72,71,61,62,63,64,65,66,67,68,69,70,60,59,58,57,56,55,54,53,52,51,41,42,43,44,45,46,47,48,49,50,40,39,38,37,36,35,34,33,32,31,21,22,23,24,25,26,27,28,29,30,20,19,18,17,16,15,14,13,12,11,1,2,3,4,5,6,7,8,9,10};     
    for(int i=1;i<=10;i++){%> 
         <tr>  
             <% for(int j=1;j<=10;j++){ //System.out.println(uname+"n"+n+"pawn"+pawn);
             //   for(int k=0){}
             %> 
                    <% if(arr[n]==pawn){
              
                             n++; %>
                            <td width="80" height="49" > <img align="center" height="30" width="30" src=<%=pwn%> ></td>
                         <% } 
                        else if(arr[n]==a1 && !pa.equals("")){  
                            n++;%>
                            <td width="80" height="49" > <img align="center" height="30" width="30" src=<%=pa%> ></td>
                          <% }else if(arr[n]==a2 && !pb.equals("")){  
                            n++;%>
                            <td width="80" height="49" > <img align="center" height="30" width="30" src=<%=pb%> ></td>
                          <% }else if(arr[n]==a2 && !pc.equals("")){  
                            n++;%>
                            <td width="80" height="49" > <img align="center" height="30" width="30" src=<%=pc%> ></td>
                          <% } else{  
                            n++;%>
                            <td width="80" height="49">&nbsp;</td>
                          <% }
                    %>
                <%}%>
           </tr>  
      <%}%>
  </table>

 </div>
 
                
                
               
                         
 <div class="dc"> <br><pre>
<%  p=con.prepareStatement("select  player_name,player_color,current_position from player_details where game_name=?");
                p.setString(1,game);
                 r1=p.executeQuery(); %>
<table border="1" align="center" width="20%"height="10%" bgcolor="#ADFF2F" cellpadding="5">
    <tr>
        <td>Player_Name</td>
    <td>Color</td>
    <td>Position</td></tr><tr>
    <% while(r1.next()){%>
<td><%=r1.getString(1) %></td>
    <td><%=r1.getString(2) %></td>
    <td><%=r1.getInt(3) %> </td>
    
</tr>  <%} %>
</table>
<table border="1" align="center" width="20%"height="10%" bgcolor="#ADFF2F" cellpadding="5">
    
         <% PreparedStatement p1=con.prepareStatement("select  player_name,current_position,previous_position from player_details where game_name=?");
                p1.setString(1,game);
                ResultSet r2=p1.executeQuery(); %>  
         <%       while(r2.next()){
                if(r2.getInt(2)>=100){%>
    <tr> <td> <%=r2.getString(1) %> won the game </td></tr>
                <%}
                }%>    

</table>                
                
<% int position=Integer.parseInt(session.getAttribute("position").toString());
 p1=con.prepareStatement("select  current_position,previous_position from player_details where player_name=? and game_name=?");
                p1.setString(1,uname);p1.setString(2,game);
                r2=p1.executeQuery();r2.next();
                
   if((r2.getInt(1))==100){
       
        
                response.sendRedirect("win.html");
                     
   }else{
       %>

<% if((r2.getInt(1))-(r2.getInt(2))==6){%><table border="1" align="center" width="15%"height="10%" bgcolor="#ADFF2F" cellpadding="5">
    <tr><td>Extra Chance</td></tr></table><%} %>
    <%--<% if((r2.getInt(1))-(r2.getInt(2))>6){%><table border="1" align="center" width="15%"height="10%" bgcolor="#ADFF2F" cellpadding="5">
    <tr><td>Extra Chance. You Climbed Ladder </td></tr></table><%} %>
<% if((r2.getInt(1))-(r2.getInt(2))<0){%><table border="1" align="center" width="15%"height="10%" bgcolor="#ADFF2F" cellpadding="5">
    <tr><td>Sarparaj Katre...</td></tr></table><%} %> --%>

       <table border="1" align="center" width="5%"height="10%" bgcolor="#ADFF2F" cellpadding="5"><tr><td>
               <%=position %> 
</td></tr></table>
<%
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
%>
<% if(trn){   %>             <a href="board" style="text-decoration:none;"><button type="button">Roll Dice</button> </a> <%}else{%> 
                <button type="button">Roll Dice</button>  <%}}%>
<br>
		   </div>
	</pre>
 <div class="foot"><font size="5" color=66FF00 ><p align="center"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>
 </div>
</body>
</html>