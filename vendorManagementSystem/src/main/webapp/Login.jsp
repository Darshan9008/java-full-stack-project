<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor SignIn</title>
<style>
body {
	padding-top: 60px;
}

.container {
	width: 40%;
	margin: auto;
	border: 2px solid #ccc;
	border-radius: 10px;
	padding: 20px;
}

label {
	font-weight: bold;
}

input[type="text"], input[type="number"], input[type="email"], input[type="tel"],
	input[type="url"], select {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

li {
	color: rgb(0, 0, 0);
}

.btn {
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}

.btn-success {
	background-color: #28a745;
	color: #fff;
	border: none;
}

.btn-success:hover {
	background-color: #218838;
}

.btn-danger {
	background-color: #dc3545;
	color: #fff;
	border: none;
}

.btn-danger:hover {
	background-color: #c82333;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Vendor SignIn</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
	<br>
	<form action="singIn" method="post" class="container">
		<h3 style='text-align: center'>SIGN-IN</h3>
		<div class="row">
			<div class="col">
				<label for="email">Enter mail</label> <input type="email"
					name="email" class="form-control" id="email"
					placeholder="Enter mail" onchange="loginMail()"
					value="${dto.email}"> <span style='color: red;'
					id="emailMsg"></span> <br>
					
					 <label for="otp">OTP</label> <input
					type="number" class="form-control" name="otp" id="otp"
					placeholder="Enter OTP" onchange="validateOTP()" value="${dto.otp}">
				<span style='color: red;' id="otpErr"></span><br>
			</div>
		</div>

		<div class="design">
			<button type="button" id="otpButton" class="btn btn-primary"
				onclick="generateOtp()" disabled="disabled">Generate OTP</button>
			<button type="submit" id="loginBtn" class="btn btn-success"
				disabled="disabled">LogIn</button>
		</div>
	</form>
	<script>
		function loginMail() {
			const email = document.getElementById("email").value;
			const generatedOtp = document.getElementById("otpButton");
			if (email == "" || email == null) {
				document.getElementById("emailMsg").innerHTML = "Email can't be empty";
				console.log("Email can't be empty");
				generatedOtp.setAttribute("disabled", "");
			} else if (!email.match(/^([a-zA-Z0-9\.]+@+[a-zA-Z]+(\.)+[a-zA-Z]{2,})$/)){
					 
				document.getElementById("emailMsg").innerHTML = "Email should be in format";
				console.log("Email should be in format");
				generatedOtp.setAttribute("disabled", "");
			} else if (email !== "" || email !== null) {

				const xhttp = new XMLHttpRequest();
				xhttp.open("GET","http://localhost:8099/vendorManagementSystem/loginEmailAjax/"+ email);			
				xhttp.send();

				xhttp.onload = function() {

					const response = document.getElementById("emailMsg").innerHTML = this.responseText;
					if (response == "") {
						generatedOtp.removeAttribute("disabled");
					} else {
						generatedOtp.setAttribute("disabled", "");
					}

				}
			}
		}

		function generateOtp() {
			const email = document.getElementById("email").value;
			const xhttp = new XMLHttpRequest();
			xhttp.open("GET",
					"http://localhost:8099/vendorManagementSystem/loginOtpEmailMsg/"
							+ email);
			xhttp.send();

			xhttp.onload = function() {
				document.getElementById("otpErr").innerHTML = this.responseText;
			}
		}

		function validateOTP() {
			const otp = document.getElementById("otp").value;
			const loginButton = document.getElementById("loginBtn");

			if (otp == null || otp == "") {

				console.log("OTP cannot be empty");
				document.getElementById("otpErr").innerHTML = "OTP cannot be empty";
			} else if (otp.length > 6 || otp.length < 6) {
				console.log("OTP should be format");
				document.getElementById("otpErr").innerHTML = "OTP should be format";
			} else if (otp != "") {
				const xhttp = new XMLHttpRequest();
				xhttp.open("GET",
						"http://localhost:8099/vendorManagementSystem/loginOtpAjax/"
								+ otp);
				xhttp.send();

				xhttp.onload = function() {
					const response = document.getElementById("otpErr").innerHTML = this.responseText;
					if (response == "OTP matched") {
						loginButton.removeAttribute("disabled");
					} else {
						loginButton.setAttribute("disabled", "false");
					}

				}
			}
		}
	</script>
</body>
</html>