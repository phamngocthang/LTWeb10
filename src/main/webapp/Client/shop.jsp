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
    <link rel="stylesheet" href="js/add.js" type="text/css">
    <link href="css/waiting.css" rel="stylesheet">
    
</head>

<body>
	<%@ include file="header.jsp" %>

    <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="#">Shop</a>
                    <span class="breadcrumb-item active">Shop List</span>
                </nav>
                <div class="col-lg-4 col-6 text-left" style="margin-left: 500px;">
                <form action="">
                    <div class="input-group">
                        <input oninput="searchByName(this)" id="searchname" type="text" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Shop Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <!-- Shop Sidebar Start -->
            <div class="col-lg-3 col-md-4">
            	<!-- Catagory Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by Category</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-all" ${subcateID == -1 ?"checked":""} onclick='window.location.href="shop?subcateID=-1&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-all">All Product</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-1" ${subcateID == 1 ?"checked":""} onclick='window.location.href="shop?subcateID=1&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-1">Giày Sandals Nam</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-2" ${subcateID == 2 ?"checked":""} onclick='window.location.href="shop?subcateID=2&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-2">Giày Lười Nam</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-3" ${subcateID == 3 ?"checked":""} onclick='window.location.href="shop?subcateID=3&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-3">Giày Sneaker Nam</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-4" ${subcateID == 4 ?"checked":""} onclick='window.location.href="shop?subcateID=4&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-4">Giày Thể Thao Nam</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-5" ${subcateID == 5 ?"checked":""} onclick='window.location.href="shop?subcateID=5&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-5">Giày Cao Gót Nữ</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-6" ${subcateID == 6 ?"checked":""} onclick='window.location.href="shop?subcateID=6&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-6">Giày Sneaker Nữ</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-7" ${subcateID == 7 ?"checked":""} onclick='window.location.href="shop?subcateID=7&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-7">Giày Thể Thao Nữ</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-8" ${subcateID == 8 ?"checked":""} onclick='window.location.href="shop?subcateID=8&index=1&showP=3"'>
                            <label class="custom-control-label" for="cate-8">Giày Đế Bệ Nữ</label>
                        </div>
                    </form>
                </div>
                <!-- Price End -->
                <!-- Price Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by price</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-1" onclick="SearchByPrice(1, 3)">
                            <label class="custom-control-label" for="price-1">Dưới 300k</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-2" onclick="SearchByPrice(1, 3)">
                            <label class="custom-control-label" for="price-2">300k - 800k</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-3" onclick="SearchByPrice(1, 3)">
                            <label class="custom-control-label" for="price-3">Trên 800k</label>
                        </div>
                    </form>
                </div>
                <!-- Price End -->
                
                <!-- Color Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by color</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-1" onclick="SearchByPrice(1, 3)">
                            <label class="custom-control-label" for="color-1">Black</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-2" onclick="SearchByPrice(1, 3)">
                            <label class="custom-control-label" for="color-2">White</label>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-3" onclick="SearchByPrice(1, 3)">
                            <label class="custom-control-label" for="color-3">Blue</label>
                        </div>
                    </form>
                </div>
                <!-- Color End -->
            </div>
            <!-- Shop Sidebar End -->


            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-8">
            	<div class="loader" id="loader" hidden="hidden"></div> 
                <div class="row pb-3" id="content">
					<div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <div>
                            </div>
                            <div class="ml-2">
                                <div class="btn-group ml-2">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="shop?subcateID=${subcateID}&index=1&showP=3">3</a>
                                        <a class="dropdown-item" href="shop?subcateID=${subcateID}&index=1&showP=6">6</a>
                                        <a class="dropdown-item" href="shop?subcateID=${subcateID}&index=1&showP=9">9</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${listP}" var="o">
	                    <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
	                        <div class="product-item bg-light mb-4">
	                            <div class="product-img position-relative overflow-hidden">
	                            	<c:set var="img_o" value="${o.image}" />
	                                <img class="img-fluid w-100" src="${img_o.pathMiddle}" alt="">
	                                <div class="product-action">
	                                    <a class="btn btn-outline-dark btn-square" onclick="AddCartAjax(${o.id_P}, ${o.status})"><i class="fa fa-shopping-cart"></i></a>
	                                    <a class="btn btn-outline-dark btn-square" onclick="AddFavoriteProductAjax(${o.id_P})"><i class="far fa-heart"></i></a>
	                                    <c:if test="${o.status == 0}">
		                                        <button type="button" class="btn btn-warning" id="expired">
											      Hết hàng
											    </button>
										    </c:if>
	                                </div>
	                            </div>
	                            <div class="text-center py-4">
	                                <a class="h6 text-decoration-none text-truncate" href="${pageContext.request.contextPath}/detail?id=${o.id_P}&brand=${o.brand}">${o.name_P}</a>
	                                <div class="d-flex align-items-center justify-content-center mt-2">
	                                    <h5>${o.price} VNĐ</h5>
	                                </div>
	                                <div class="d-flex align-items-center justify-content-center mt-2">
	                                    <h6>Size: ${o.size}</h6>
	                                </div>
	                                <div class="d-flex align-items-center justify-content-center mb-1">
	                                    <small class="fa fa-star text-primary mr-1"></small>
	                                    <small class="fa fa-star text-primary mr-1"></small>
	                                    <small class="fa fa-star text-primary mr-1"></small>
	                                    <small class="fa fa-star text-primary mr-1"></small>
	                                    <small class="fa fa-star-half-alt text-primary mr-1"></small>
	                                    <small>(99)</small>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </c:forEach>
                    <div class="col-12">
                        <nav>
                          <!--  
                          <ul class="pagination justify-content-center">
	                        <li class="page-item ${tag == 1?"disabled":""}"><a class="page-link" href="shop?subcateID=${subcateID}&index=${tag-1}&showP=${showtag}">Previous</span></a></li>
	                        <c:forEach begin="1" end="${endP}" var="i">
		                        <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="shop?subcateID=${subcateID}&index=${i}&showP=${showtag}">${i}</a></li>          
	                        </c:forEach>
	                        <li class="page-item ${tag == endP?"disabled":""}"><a class="page-link" href="shop?subcateID=${subcateID}&index=${tag+1}&showP=${showtag}">Next</a></li>
                          </ul>
                          -->
                          <ul class="pagination justify-content-center">
	                        <li class="page-item ${tag == 1?"disabled":""}"><a class="page-link" href="shop?subcateID=${subcateID}&index=${tag-1}&showP=${showtag}">Previous</span></a></li>
	                        <c:forEach begin="1" end="${endP}" var="i">
		                        <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="shop?subcateID=${subcateID}&index=${i}&showP=${showtag}">${i}</a></li>          
	                        </c:forEach>
	                        <li class="page-item ${tag == endP?"disabled":""}"><a class="page-link" href="shop?subcateID=${subcateID}&index=${tag+1}&showP=${showtag}">Next</a></li>
                          </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
	<!-- Shop End -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <%@ include file="footer.jsp" %>>
</body>
<script>
    	function SearchByPrice(indexp, showp){
   	   	 $.ajax({
   	            url: location.origin + "/SearchProductByPrice",
   	            type: "get", //send it through get method
   	            data: {
   	            	price1: document.getElementById("price-1").checked.toString(),
   	            	price2: document.getElementById("price-2").checked.toString(),
   	            	price3: document.getElementById("price-3").checked.toString(),
   	            	color1: document.getElementById("color-1").checked.toString(),
   	            	color2: document.getElementById("color-2").checked.toString(),
   	            	color3: document.getElementById("color-3").checked.toString(),
   	            	indexP: indexp,
   	            	showP: showp,
   	            	subcateID: '${subcateID}'
   	            },
   	            beforeSend: function() {
   	            	// Set Button Loadding là Hidden
   	            	var row = document.getElementById("content");
   	            	row.setAttribute("hidden", "hidden");
   	            	// Ân button Loading
   	            	var load = document.getElementById("loader");
   	            	load.removeAttribute("hidden");
   	            },
   	            success: function (data) {
   	            	// Đưa data lên page
   	                var row = document.getElementById("content");
   	               	row.innerHTML = data;
   	               	// Ân button Loading
   	               	var load = document.getElementById("loader");
   	            	load.setAttribute("hidden", "hidden");
   	            	// Hiện sản phẩm lên form
   	               	row.removeAttribute("hidden");
   	            }
   	        });
   	   }
   		function searchByName(param){
   	         var txtSearch = param.value;﻿
   	         document.getElementById("cate-all").checked = true
   	         document.getElementById("price-1").checked = false;
            	document.getElementById("price-2").checked = false;
            	document.getElementById("price-3").checked = false;
            	document.getElementById("color-1").checked = false;
            	document.getElementById("color-2").checked = false;
            	document.getElementById("color-3").checked = false;
   	         $.ajax({
   	             url: location.origin + "/SearchByName",
   	             type: "get", //send it through get method
   	             data: {
   	                 txt: txtSearch
   	             },
   	             beforeSend: function() {
   		            	// Set Button Loadding là Hidden
   		            	var row = document.getElementById("content");
   		            	row.setAttribute("hidden", "hidden");
   		            	// Ân button Loading
   		            	var load = document.getElementById("loader");
   		            	load.removeAttribute("hidden");
   		         },
   	             success: function (data) {
   	                 var row = document.getElementById("content");
   	                 row.innerHTML = data;
   	                 
   	                 var load = document.getElementById("loader");
   		             load.setAttribute("hidden", "hidden");
   		             // Hiện sản phẩm lên form
   		             row.removeAttribute("hidden");
   	             },
   	             error: function (xhr) {
   	                 //Do Something to handle error
   	             }
   	         });
   		}
</script>
</html>