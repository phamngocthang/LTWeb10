<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	 <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    
    <!-- Customized Bootstrap Stylesheet -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
	<%@ include file="header.jsp" %>
	<section class="py-5 my-5">
		<div class="container">
			<h1 class="mb-5">My Account</h1>
			<div class="bg-white shadow rounded-lg d-block d-sm-flex">
				<div class="profile-tab-nav border-right">
					<div class="p-4">
						<div class="img-circle text-center mb-3">
							<img src="${pageContext.request.contextPath}/img/user.jpg" alt="Image" class="shadow">
						</div>
						<h4 class="text-center">${curCustomer.firstName}  ${curCustomer.lastName}</h4>
					</div>
					<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="account-tab" data-toggle="pill" href="#account" role="tab" aria-controls="account" aria-selected="true">
							<i class="fa fa-home text-center mr-1"></i> 
							Account
						</a>
						<a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab" aria-controls="password" aria-selected="false">
							<i class="fa fa-key text-center mr-1"></i> 
							Password
						</a>
						<a class="nav-link" id="notification-tab" data-toggle="pill" href="#notification" role="tab" aria-controls="notification" aria-selected="false">
							<i class="fa fa-bell text-center mr-1"></i> 
							Notification
						</a>
					</div>
				</div>
				<div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
					<form class="tab-pane fade show active" action="${pageContext.request.contextPath}/UpdateCustomer" method="post" id="account" role="tabpanel" aria-labelledby="account-tab" >
						<h3 class="mb-4">Account Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>First Name</label>
								  	<input name="firstName" type="text" class="form-control" required="" autofocus="" value="${curCustomer.firstName}">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Last Name</label>
								  	<input name="lastName" type="text" class="form-control" required="" value="${curCustomer.lastName}">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Email</label>
								  	<input name="email" type="text" class="form-control" required="" value="${curCustomer.email}">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Phone number</label>
								  	<input name="phone" type="text" class="form-control" required="" value="${curCustomer.phonenumber}">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Address</label>
								  	<input name="address" type="text" class="form-control" required="" value="${curCustomer.address}">
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary" type="submit">Update</button>
						</div>
					</form>
					<form class="tab-pane fade" action="${pageContext.request.contextPath}/UpdatePassword" method="post" id="password" role="tabpanel" aria-labelledby="password-tab">
						<h3 class="mb-4">Password Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Old password</label>
								  	<input name="oldpass" type="password" class="form-control" required="" autofocus="">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>New password</label>
								  	<input name="newpass1" type="password" class="form-control" required="">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Confirm new password</label>
								  	<input name="newpass2" type="password" class="form-control" required="">
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary" type="submit">Update</button>
						</div>
					</form>	
					<div class="tab-pane fade" id="notification" role="tabpanel" aria-labelledby="notification-tab">
						<h3 class="mb-4">Notification Settings</h3>
						<div class="form-group">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="" id="notification1">
								<label class="form-check-label" for="notification1">
									Get latest news about recent products from our shop.
								</label>
							</div>
						</div>
						<div>
							<button class="btn btn-primary">Update</button>
						</div>
					</div>								
				</div>
			</div>
		</div>
	</section>

	<%@ include file="footer.jsp" %>
		
</body>
</html>