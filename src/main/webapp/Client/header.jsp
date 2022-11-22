<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
	<style>
	#thongBao {
		 position: fixed; display: none; top: 1rem;
		 left: 50%;
		 transform: translateX(-50%);
		 background-color: #ffd333;
		 padding: 10px;
		 border-radius: 8px;
		 z-index: 100;
		 color: white;
	}
	</style>
</head>
<body>
	<!-- Topbar Start -->
    <div id="thongBao"></div>
    <div class="container-fluid">
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="home" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">NHÓM</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">10</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
            </div>
            <div class="col-lg-4 col-6 text-right">
            	<c:if test="${sessionScope.user == null }">
            		<div class="btn-group mx-2">
                    	<button type="button" class="btn btn-primary" data-toggle="dropdown" onclick="location.href='Login';" >Login</button>
                	</div>
            	</c:if>
                
                <c:if test="${sessionScope.user != null }">
	                <div class="btn-group">
	                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">${sessionScope.user.userName}</button>
	                    <div class="dropdown-menu dropdown-menu-right">
	                        <button class="dropdown-item" type="button" onclick="location.href='MyAccount';">My Account</button>
	                        <button class="dropdown-item" type="button" onclick="location.href='Logout';">Log Out</button>
	                    </div>
	                </div>
                </c:if>
            </div>
        </div>
    </div>x
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid bg-dark mb-30">
        <div class="row px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                    <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown dropright">
                            <a href="#" class="nav-link dropdown-toggle" id="test-hover" data-toggle="dropdown">Giày Nam <i class="fa fa-angle-right float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute rounded-0 border-0 m-0">
                                <a href="shop?subcateID=1&index=1&showP=3" class="dropdown-item">Giày Sandals Nam</a>
                                <a href="shop?subcateID=2&index=1&showP=3" class="dropdown-item">Giày Lười Nam</a>
                                <a href="shop?subcateID=3&index=1&showP=3" class="dropdown-item">Giày Sneaker Nam</a>
                                <a href="shop?subcateID=4&index=1&showP=3" class="dropdown-item">Giày Thể Thao Nam</a>
                            </div>      
                        </div>
                        <div class="nav-item dropdown dropright">
                            <a href="#" class="nav-link dropdown-toggle" id="test-hover" data-toggle="dropdown">Giày Nữ <i class="fa fa-angle-right float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute rounded-0 border-0 m-0">
                                <a href="shop?subcateID=5&index=1&showP=3" class="dropdown-item">Giày Cao Gót Nữ</a>
                                <a href="shop?subcateID=6&index=1&showP=3" class="dropdown-item">Giày Sneaker Nữ</a>
                                <a href="shop?subcateID=7&index=1&showP=3" class="dropdown-item">Giày Thể Thao Nữ</a>
                                <a href="shop?subcateID=8&index=1&showP=3" class="dropdown-item">Giày Đế Bệ Nữ</a>
                            </div>   
                        </div>
                    </div>
                </nav>
            </div>
            
            <div class="col-lg-9-navsearch">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <span class="h1 text-uppercase text-dark bg-light px-2">Multi</span>
                        <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="home" class="nav-item nav-link">Home</a>
                            <a href="shop?subcateID=-1&index=1&showP=3" class="nav-item nav-link">Shop</a>
                            <a href="${pageContext.request.contextPath}/Client/contact.jsp" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                            <c:if test="${sessionScope.user != null }">
                            <a href="managerFavoriteProduct" class="btn px-0">
                                <i class="fas fa-heart text-primary"></i>
                                <span id="amountfproduct" class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">
                                				${amountfProduct}
                                </span>
                            </a>
                            </c:if> 
	                        <a href="managerCart" class="btn px-0 ml-3">
	                                <i class="fas fa-shopping-cart text-primary"></i>
		                                <span id="amountcart" class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">
		                                		${amountCart}
		                                </span>
	                         </a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End-->
</body>
</html>
