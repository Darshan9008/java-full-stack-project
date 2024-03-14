<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

.fo{
 max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #F5DEB3; /* Background color for the form */

}

.fo label {
    display: block;
    margin-bottom: 8px;
    color: #333;
}

.fo input[type="text"],
input[type="email"],
input[type="date"],
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 16px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.fo input[type="submit"] {
    background-color: #4caf50;
    color: #fff;
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.fo input[type="submit"]:hover {
    background-color: #45a049;
}


</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
function uniqueEmail(){
      console.log("running uniqueMail");
      let emails=document.getElementById("email").value;
      console.log(emails);
      
      if(emails.length > 10 && emails.length < 30 ){
    	  console.log("email is valid...");
    	  document.getElementById("emailError").innerHTML="";
    	  
    	  const xhttp=new XMLHttpRequest();
    	  xhttp.open("GET","http://localhost:8099/vendorManagementSystem/uniqueEmail/" +emails);               //this line is not completed
    	  xhttp.send();
    	  
    	  xhttp.onload=function() {
    		  console.log(this);
    		  document.getElementById("emailErrorAjax").innerHTML=this.responseText;
    		  
    	  }    	  
      }
      else
      {
    	  
    	  console.log("in-valid email");
    	  document.getElementById("emailError").innerHTML="<span style='color:red'>please enter valid email</span>";
      
      }      
}

function contactNumberValidation(){
	console.log("running contactNumber");
	var contactNumber=document.getElementById("contactNumber").value;
	console.log(contactNumber);
	
	if(contactNumber!=null && contactNumber!="" && contactNumber.length==10){
	     console.log("contact number is valid");
	     document.getElementById("contactError").innerHTML="";
	     
	     const xhttp=new XMLHttpRequest();
	     xhttp.open("GET","http://localhost:8099/vendorManagementSystem/uniqueContactNumber/"+contactNumber);              //this line is in---complete
	     xttp.send();
	     
	     xhttp.onload=function()
	     {
	    	 document.getElementById("contactError").innerHTML=this.responseText;
	    	 
	    	 
	     }
}
else
{ 
	console.log("invalid contact number");
	document.getElementById("contactError").innerHTML="please enter valid contact number"
	
}
}

function gstNumberValidation(){
	
	console.log("running gstNumber....");
	var gstNo=document.getElementById("gstNo").value;
	console.log(gstNo);
	
	if(gstNo!=null && gstNo!="" && gstNo.length<30){
		
		console.log("gstno is valid .........");
		document.getElementById("gstError").innerHTML="";
		const xhttp=new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8099/vendorManagementSystem/uniqueGstNo/"+gstNo);             //this line is in-complete
		xttp.send();
		
		xhttp.onload=function()
		{
			document.getElementById("gstError").innerHTML=this.responseText;	
		}
	}
	else{
		console.log("invalid gst No");
		document.getElementById("gstError").innerHTML="please enter valid gst no";
	}	
}

function websiteValidation(){
	console.log("running website");
	var website=document.getElementById("website").value;
	console.log(website);
	
	if(website!=null && website!="" && website.length>5 && website.length<30){
		
		console.log("website is valid......");
		document.getElementById("websiteError").innerHTML="";
		const xhttp=new XMLHttpRequest();
		xhttp.open("GET","http://localhost:8099/vendorManagementSystem/uniqueWebsite/"+website);
		xhttp.send();
		
		xhttp.onload=function()
		{
			document.getElementById("websiteError").innerHTML=this.responseText;
		}
	}
	else{
		console.log("invalid website");
		document.getElementById("websiteError").innerHTML="please enter the valid website";
	}
	
}
</script>

<nav class="navbar navbar-expand-lg "
		style="background-color: LightGray;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">VENDOR</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp"><b>HOME</b></a>  
          
           <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Login.jsp"><b>LOGIN</b></a>  
      
      </ul
>      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<span>${isExistError}</span>

<form action="virat" method="post" class="fo">
<h4>Registration Form</h4>
<br>




<div>
<label> Name : </label>         
<input type="text" name="name" id="name"/>
</div>

  
 
<div>
<label> Location : </label>         
<input type="text" name="location" id="location"/>
</div>



<div>
<span id="gstError" style="color:red;"></span>
<label> GST No : </label>         
<input type="text" name="gstNo" id="gstNo" onchange="gstNumberValidation()"/>
</div>



<div>
<label> Company Start Date : </label>         
<input type="date" name="date" id="date"/>
</div>


<div>
<label> Owner Name : </label>         
<input type="text" name="ownerName" id="ownerName"/>
</div>



<label>   
Service Type :  
</label>   
<select name="serviceType">  
<option value="water">Water Service</option>  
<option value="plumbing">Plumbing Service</option>  
<option value="electric">Electric Service</option>  
<option value="chair">Chair Service</option>  
<option value="seat">Seat Service</option>  
<option value="tyre">Tyre Service</option>  
<option value="grocery">Grocery Service</option>  
</select>   
 <br>
 
 

<div>
<span id="contactError" style="color:red;"></span>
<label> Contact Number : </label>         
<input type="text" name="contactNumber" id="contactNumber" onchange="contactNumberValidation()"/>
</div>



<div>
<label> Alternate Number : </label>         
<input type="text" name="alternateNumber" id="alternateNumber"/>
</div>



<div>
<span id="emailErrorAjax" style="color:red;"></span>
<span id="emailError" style="color:red;"></span>
<label> Email : </label>         
<input type="email" name="email" id="email" onblur="uniqueEmail()">
</div>

 

<div>
<span id="websiteError" style="color:red;"></span>
<label> Website : </label>         
<input type="text" name="website" id="website" onchange="websiteValidation()">
</div>
<br>


<input type="submit" value="send" class="btn btn-primary">
</form>

</body>
</html>