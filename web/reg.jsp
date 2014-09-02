<html>
<head>
<link href="css2.css" rel="stylesheet" type="text/css"></style>
</head>
<script type="text/javascript">
    
    window.onbeforeunload = confirmExit;
window.onunload = logout;

function confirmExit() {
    return "Are you sure you want to leave?";
}

function logout() {
   <% session.invalidate();    %>
}

function validate(form)
{
if (form.FName.value==null || form.FName.value=="" || form.FName.value==" ")
  {
  alert("Enter First Name");
  return (false);
  }
  if(form.FName.value.length<5){
  alert("FirstName Should be in between 5-10 digits");
  return (false);
  }
  if(form.FName.value.length>20){
  alert("FirstName Should be in between 5-10 digits");
  return (false);
  }
  if (form.LName.value==null || form.LName.value=="" || form.LName.value==" ")
  {
  alert("Enter Last Name");
  return (false);
  }
  if(form.LName.value.length<5){
  alert("LastName Should be in between 5-10 digits");
  return (false);
  }
  if(form.FName.value.length>20){
  alert("LastName Should be in between 5-10 digits");
  return (false);
  }
  
if (form.UName.value==null || form.UName.value=="" || form.UName.value==" ")
  {
  alert("Enter User Name");
  return (false);
  }
var u1=/^[`~!@#$%^&*()-_]+$/;
  if(u1.test(form.UName.value.charAt(1)))
  {
  alert("UserName Shlout Not start with Special character");
  return (false);
  }
  
  var email = form.Mail.value;
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email)) {
    alert(email);
	alert('Please provide a valid email address');
    return false;}
	if(form.Pwd.value.length<5){
  alert("Password Should be in between 5-10 digits");
  return (false);
  }
  if(form.Pwd.value.length>10){
  alert("Password Should be in between 5-10 digits");
  return (false);
  }
  if (form.Pwd.value==null || form.Pwd.value=="" || form.Pwd.value==" ")
  {
  alert("Enter Password");
  return (false);
  }
  if (!form.Pwd.value==form.Pwd.value)
  {
  alert("Enter Correct Password");
  return (false);
  }
  
  
  
  
  }
</script>
<body background="bgr.jpg">
<div class="main">
<div class="links"><font size="4.5" ><pre><p><a href="home.html" style="text-decoration:none;color:66FF00">             HOME            </a><a style="color:66FF00;text-decoration:none"href="rules.html" target="blank">RULES            </a><a style="color:66FF00;text-decoration:none"href="creategame.html" target="blank">  CREATE GAME            </a><a style="color:66FF00;text-decoration:none"href="chatroom.html">  CHAT ROOM            </a><a style="color:66FF00;text-decoration:none"href="contactus.html" target="blank">CONTACT US            </a></p></pre></font></div>
 <div class="head"><img style="width:100%;height:100%;"src="reg.jpg"></div>
  <div class="da"></div>
 <div class="d1">
 
 <form action="registration"name="myForm"   method=post onsubmit="return validate(this)"><pre><font size="3.5" color="white">
   <b>First name:</b>		<input type="text" name="FName" value="">		<b>Last name:</b>	<input type="text" name="LName" value=""><br>
   <b>User name:</b>		<input type="text" name="UName" value="">		<b>Date of Birth*:</b>    <input type="hidden" name="DOB" value="" /><select name="dd" id="dd">
<option value="0">Day</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="1">4</option>
<option value="2">5</option>
<option value="3">6</option>
<option value="1">7</option>
<option value="2">8</option>
<option value="3">9</option>
<option value="1">10</option>
<option value="2">11</option>
<option value="3">12</option>
<option value="1">13</option>
<option value="2">14</option>
<option value="3">15</option>
<option value="1">16</option>
<option value="2">17</option>
<option value="3">18</option>
<option value="1">19</option>
<option value="2">20</option>
<option value="3">21</option>
<option value="1">22</option>
<option value="2">23</option>
<option value="3">24</option>
<option value="3">25</option>
<option value="1">26</option>
<option value="2">27</option>
<option value="3">28</option>
<option value="1">29</option>
<option value="2">30</option>
<option value="3">31</option></select><select name="mm" id="mm">

<option value="0">Month</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="1">4</option>
<option value="2">5</option>
<option value="3">6</option>
<option value="1">7</option>
<option value="2">8</option>
<option value="3">9</option>
<option value="1">10</option>
<option value="2">11</option>
<option value="3">12</option></select><select name="yy" id="yy">

<option value="0">Year</option>
<option value="Year">1950</option>
<option value="1991">1951</option>
<option value="1992">1952</option>
<option value="Year">1953</option>
<option value="1991">1954</option>
<option value="1992">1955</option>
<option value="Year">1956</option>
<option value="1991">1957</option>
<option value="1992">1958</option>
<option value="Year">1959</option>
<option value="1991">1960</option>
<option value="1992">1961</option>
<option value="Year">1962</option>
<option value="1991">1963</option>
<option value="1992">1964</option>
<option value="Year">1965</option>
<option value="1991">1966</option>
<option value="1992">1967</option>
<option value="Year">1968</option>
<option value="1991">1969</option>
<option value="1992">1970</option>
<option value="Year">1971</option>
<option value="1991">1972</option>
<option value="1992">1973</option>
<option value="Year">1974</option>
<option value="1991">1975</option>
<option value="1992">1976</option>
<option value="Year">1977</option>
<option value="1991">1978</option>
<option value="1992">1979</option>
<option value="Year">1980</option>
<option value="1991">1981</option>
<option value="1992">1982</option>
<option value="Year">1983</option>
<option value="1991">1984</option>
<option value="1992">1985</option>
<option value="Year">1986</option>
<option value="1991">1987</option>
<option value="1992">1988</option>
<option value="Year">1989</option>
<option value="1991">1990</option>
<option value="1992">1991</option>
<option value="Year">1992</option>
<option value="1991">1993</option>
<option value="1992">1994</option>
<option value="Year">1995</option>
<option value="1991">1996</option>
<option value="1992">1997</option>
<option value="Year">1998</option>
<option value="1991">1999</option>
<option value="1992">2000</option>
<option value="Year">2001</option>
<option value="1991">2002</option>
<option value="1992">2003</option>
<option value="Year">2004</option>
<option value="1991">2005</option>
<option value="1992">2006</option>
<option value="Year">2007</option>
<option value="1991">2008</option>
</select></select>

   <b>Sex:</b>			Male<input type="radio" name="Sex" value="Male"> Female<input type="radio" name="Sex" value="Male"> <br>
   <b>Email:</b>		<input type="text" name="Mail" value=""><br>
   <b>Password:</b>		<input type="password" name="Pwd" value="">		  <b>Re-type Password:</b><input type="password" name="RPwd" value=""><br>
   <b>Address:</b>		<input type="text" name="Address" value=""><br>
   <b>Secret Question:</b>  	<select id="select" name="select">
    <option value="" disabled="disabled" selected="selected">Please select a questione</option>
    <option value="Whom do you trust more">Whom do you trust more</option>
    <option value="What is your favourite pass time">What is your favourite pass time</option>
</select><br>
   <b>Type your ans:</b>	<input type="text" name="Ans" value=""><br>
   <b>Alternate Email:</b>	<input type="text" name="AlMail" value="">		<b>Phone Number:</b>	<input type="text" name="Phone" value=" "><br>
					   <input type="submit" value="Submit"/></pre></font>
</form>
 
 </div>
 <div class="d2"></div>
   <div class="foot"><font size="5";color=66FF00 ><p align="center"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>
 </div>
</body>
</html>