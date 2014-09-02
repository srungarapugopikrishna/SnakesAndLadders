<html>
<head>
<link href="css2.css" rel="stylesheet" type="text/css"></style>
<script type="text/javascript" >
    
    
 
     
function secret(t1) {
	var http;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		http = new XMLHttpRequest();
	} else {// code for IE6, IE5
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200) {
                    document.getElementById("que").innerHTML	=  http.responseText;
                    }
	};
	http.open("GET", "ques?t1=" +t1, true);
	http.send();
}
</script>
 

</head>
<body background="bgr.jpg">
<div class="main">
<div class="links"><font size="4.5" ><pre><p><a href="home.html" style="text-decoration:none;color:66FF00">  HOME            </a><a href="reg.jsp" style="text-decoration:none;color:66FF00">  REGISTER            </a><a style="color:66FF00;text-decoration:none"href="rules.html">  RULES            </a><a style="color:66FF00;text-decoration:none"href="chatroom.html">  CHAT ROOM            </a><a style="color:66FF00;text-decoration:none"href="contactus.html">  CONTACT US            </a></p></pre></font></div>
 <div class="head"><img style="width:100%;height:100%;"src="question.jpg"></div>
  
  <div class="da"> </div>
  <div class="db">
	<form name="myForm"   action="passwordmail" method=post >	<pre><font size="4" color="orange"><br>
	<b>Enter Your User Name:  <input type="text" name="UName" value="" onchange= "secret(this.value)"></b><br><br>
        <FONT>Secret question</FONT>     :<span id="que" ></span><br>
   
        <FONT>Answer</FONT>              :<input type="text" name="Ans" value=""><br>
                        		<input type="submit" value="Submit"/></pre>

  </div>
  <div class="dc"> </div>
   <div class="foot"><font size="5" color="black" ><p align="center"> <b> &copy; Gopi Krishna Srungarapu</b></p></font></div>
 </div>
</body>
</html>