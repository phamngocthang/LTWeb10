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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    
    <!-- Customized Bootstrap Stylesheet -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
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
						<c:if test="${!sessionScope.user.userName.contains('@')}">
						<a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab" aria-controls="password" aria-selected="false">
							<i class="fa fa-key text-center mr-1"></i> 
							Password
						</a>
						</c:if>
						<a class="nav-link" id="notification-tab" data-toggle="pill" href="#notification" role="tab" aria-controls="notification" aria-selected="false">
							<i class="fa fa-bell text-center mr-1"></i> 
							Notification
						</a>
						<a class="nav-link" id="checkoutbill-tab" data-toggle="pill" href="#checkoutbill" role="tab" aria-controls="checkoutbill" aria-selected="false">
							<i class="fa fa-money-bill text-center mr-1"></i> 
							Check-Out Bill
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
							<input id="statusmanage" value="${statusmanage}" hidden />
        					<input id="check_insert" value="${checkinsert}" hidden /> 
        					<input id="mess_insert" value="${messinsert}" hidden /> 
        					<input id="check_update" value="${checkupdate}" hidden /> 
        					<input id="mess_update" value="${messupdate}" hidden />
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
					<div class="tab-pane fade" id="checkoutbill" role="tabpanel" aria-labelledby="checkoutbill-tab">
						<div class='pb-4'>
							<h1 class='uppercase text-2xl font-semibold text-center p-4'>My bill list</h1>
							<table
								class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
								<thead class='bg-yellow-500'>
									<tr>
										<th class='p-2 text-white'>Mã hóa đơn</th>
										<th class='p-2 text-white'>Khách hàng</th>
										<th class='p-2 text-white'>Ngày lập</th>
										<th class='p-2 text-white'>Xem chi tiết</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listBill}" var="p">
										<tr class='bg-gray-100 odd:bg-gray-200'>
											<td class='p-2 pl-4'>${p.idBill}</td>
											<td class='p-2 pl-4'>${p.account.customer.firstName}
												${p.account.customer.lastName}</td>
											<td class='p-2 pl-4'>${p.date}</td>
											<td class='p-2 pl-4 text-center'><a
												href='MyBillDetail?billId=${p.idBill}'
												class='hover:text-yellow-500'> <i
													class="fa-solid fa-eye"></i>
											</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>						
				</div>
			</div>
		</div>
	</section>
	
	<script>
    let checkstatus = document.getElementById("statusmanage");
    let insertaccount = document.getElementById("check_insert");
    let updateaccount = document.getElementById("check_update");
    let messinsert = document.getElementById("mess_insert");
    let messupdate = document.getElementById("mess_update");
    
    let checkinsert = insertaccount.value;
    let mess_in= messinsert.value;
    let checkupdate = updateaccount.value;
    let mess_up= messupdate.value;
    let status = checkstatus.value;
    console.log(status)
    console.log(checkinsert)
    console.log(mess_in)
    if (status === 'true'){
		if (checkinsert === 'true')
			if(mess_in === 'true')
				swal("Thông Báo!", "Thêm Tài Khoản Thành Công","success");
			else
				swal("Thông Báo!", "Thêm Tài Khoản Không Thành Công UserName Đã Tồn Tại","error");
		if (checkupdate === 'true')
			if(mess_up === 'true')
				swal("Thông Báo!", "Cập Nhật Tài Khoản Thành Công","success");
			else
				swal("Thông Báo!", "Cập Nhật Tài Khoản Không Thành Công","error");
    }
  	</script>

	<%@ include file="footer.jsp" %>
		
</body>
</html>