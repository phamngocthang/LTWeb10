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
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-1 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center h-100">
                    <a class="text-body mr-3" href="">About</a>
                    <a class="text-body mr-3" href="">Contact</a>
                    <a class="text-body mr-3" href="">Help</a>
                    <a class="text-body mr-3" href="">FAQs</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                </div>
                <div class="d-inline-flex align-items-center d-block d-lg-none">
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-heart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-shopping-cart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="home" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">NHÓM 10</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">HOME</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
            </div>
            <div class="col-lg-4 col-6 text-right">
            	<c:if test="${sessionScope.user == null }">
            		<div class="btn-group mx-2">
                    	<button type="button" class="btn btn-sm btn-light" data-toggle="dropdown" onclick="location.href='Client/Login.jsp';" >Login</button>
                	</div>
            	</c:if>
                
                <c:if test="${sessionScope.user != null }">
	                <div class="btn-group">
	                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">${sessionScope.user.userName}</button>
	                    <div class="dropdown-menu dropdown-menu-right">
	                        <button class="dropdown-item" type="button">Tài khoản của tôi</button>
	                        <button class="dropdown-item" type="button" onclick="location.href='Logout';">Logout</button>
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
                            <a href="managerFavoriteProduct" id="amountfproduct"class="btn px-0">
                                <i class="fas fa-heart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">
                                				${amountfProduct}
                                </span>
                            </a>
                            </c:if> 
                            <c:if test="${sessionScope.user != null }">
	                            <a href="managerCart" id="amountcart" class="btn px-0 ml-3">
	                                <i class="fas fa-shopping-cart text-primary"></i>
		                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">
		                                		${amountCart}
		                                </span>
	                            </a>
                            </c:if>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End-->
</body>
</html>
