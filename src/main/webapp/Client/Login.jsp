<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha384-xBuQ/xzmlsLoJpyjoggmTEz8OWUFM0/RC5BsqQBDX2v5cMvDHcMakNTNrHIW2I5f" crossorigin="anonymous"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-style.css">
    <title>Bootstrap 4 Login/Register Form</title>
</head>
<body>
    <div id="logreg-forms">
        <form class="form-signin" action="${pageContext.request.contextPath}/Login" method="post">
        	 <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}"><!-- CSRF Token được gửi kèm theo -->
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
            <div class="social-login">
                <button class="btn facebook-btn social-btn" type="button" onclick="location.href='https://www.facebook.com/dialog/oauth?client_id=3382507702029634&redirect_uri=https://localhost:8999/WebApp/login-facebook'"><span><i class="fab fa-facebook-f"></i> Sign in with Facebook</span> </button>
                <button class="btn google-btn social-btn" type="button" onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://nhom10-app.herokuapp.com/login-google&response_type=code&client_id=998202632275-0a5fp9m07oq440p1c6bec8g3t47itono.apps.googleusercontent.com&approval_prompt=force';"><span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span> </button>
                <!--<button class="btn google-btn social-btn" type="button" onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://localhost:8999/WebApp/login-google&response_type=code&client_id=998202632275-0a5fp9m07oq440p1c6bec8g3t47itono.apps.googleusercontent.com&approval_prompt=force';"><span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span> </button>-->
            </div>
            	<%
            	String err = request.getParameter("err");
        		if ("1".equals(err)) {
        			out.print("<center> <h6 style=\"color: red;\">Login fail! Username or Password is incorrect</h6> </center>");
        			}
				%>
            <p style="text-align:center"> OR  </p>
            <input name="user" type="text" id="inputUsername" class="form-control" placeholder="Username" required="" autofocus="">
            <input name="pass" type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
            
            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
            <a href="#" id="forgot_pswd">Forgot password?</a>
            <hr>
            <!-- <p>Don't have an account!</p>  -->
            <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
        </form>

            <form action="/reset/password/" class="form-reset">
                <input type="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                <button class="btn btn-primary btn-block" type="submit">Reset Password</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            
            <form action="${pageContext.request.contextPath}/Signup" method="post" class="form-signup">                
                <p style="text-align:center">OR</p>
                <%
                String err2 = request.getParameter("err2");
        		if ("2".equals(err2)) {
        			out.print("<center> <h6 style=\"color: red;\">Signup fail! Username or Password is invalid</h6> </center>");
        			}
        		if ("3".equals(err2)) {
        			out.print("<center> <h6 style=\"color: red;\">Signup fail! The password must contain 1 uppercase letter, 1 lowercase letter, 1 number, and be between 6-20 characters long</h6> </center>");
        			}
				%>
                <input name="user_signup" type="text" id="user-name" class="form-control" placeholder="Username" required="" autofocus="">
                <input name="pass_signup" type="password" id="user-pass" class="form-control" placeholder="Password" required="" autofocus="">
                <input name="repass_signup" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required="" autofocus="">

                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
                <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>
            
    </div>
    <p style="text-align:center">
        <a href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}
function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}
$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})g" target="_blank" style="color:black">Group 10</a>
    </p>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha384-xBuQ/xzmlsLoJpyjoggmTEz8OWUFM0/RC5BsqQBDX2v5cMvDHcMakNTNrHIW2I5f" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/login.js"></script>
</body>
</html>