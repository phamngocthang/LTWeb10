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
                            <input type="radio" name="radiocate" class="custom-control-input" checked id="cate-all">
                            <label class="custom-control-label" for="cate-all">All Product</label>
                            <span class="badge border font-weight-normal">1000</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-1">
                            <label class="custom-control-label" for="cate-1">Giày Sandals Nam</label>
                            <span class="badge border font-weight-normal">150</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-2">
                            <label class="custom-control-label" for="cate-2">Giày Lười Nam</label>
                            <span class="badge border font-weight-normal">295</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="radio" name="radiocate" class="custom-control-input" id="cate-3">
                            <label class="custom-control-label" for="cate-3">Giày Sneaker Nam</label>
                            <span class="badge border font-weight-normal">246</span>
                        </div>
                    </form>
                </div>
                <!-- Price End -->
                <!-- Price Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by price</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="price-all">
                            <label class="custom-control-label" for="price-all">All Price</label>
                            <span class="badge border font-weight-normal">1000</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-1" onclick="SearchByPrice()">
                            <label class="custom-control-label" for="price-1">Dưới 300k</label>
                            <span class="badge border font-weight-normal">150</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-2" onclick="SearchByPrice()">
                            <label class="custom-control-label" for="price-2">300k - 800k</label>
                            <span class="badge border font-weight-normal">295</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-3" onclick="SearchByPrice()">
                            <label class="custom-control-label" for="price-3">Trên 800k</label>
                            <span class="badge border font-weight-normal">246</span>
                        </div>
                    </form>
                </div>
                <!-- Price End -->
                
                <!-- Color Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by color</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="color-all">
                            <label class="custom-control-label" for="price-all">All Color</label>
                            <span class="badge border font-weight-normal">1000</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-1">
                            <label class="custom-control-label" for="color-1">Black</label>
                            <span class="badge border font-weight-normal">150</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-2">
                            <label class="custom-control-label" for="color-2">White</label>
                            <span class="badge border font-weight-normal">295</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-3" onclick="SearchByPrice()">
                            <label class="custom-control-label" for="color-3">Red</label>
                            <span class="badge border font-weight-normal">246</span>
                        </div>
                    </form>
                </div>
                <!-- Color End -->

                <!-- Size Start -->
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by size</span></h5>
                <div class="bg-light p-4 mb-30">
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="size-all">
                            <label class="custom-control-label" for="size-all">All Size</label>
                            <span class="badge border font-weight-normal">1000</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="size-3">
                            <label class="custom-control-label" for="size-3">M</label>
                            <span class="badge border font-weight-normal">246</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="size-4">
                            <label class="custom-control-label" for="size-4">L</label>
                            <span class="badge border font-weight-normal">145</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                            <input type="checkbox" class="custom-control-input" id="size-5">
                            <label class="custom-control-label" for="size-5">XL</label>
                            <span class="badge border font-weight-normal">168</span>
                        </div>
                    </form>
                </div>
                <!-- Size End -->
            </div>
            <!-- Shop Sidebar End -->


            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-8">
            	<div class="loader" id="loader" hidden="hidden"></div> 
                <div class="row pb-3" id="content">
					<div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <div>
                                <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                                <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                            </div>
                            <div class="ml-2">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="#">Latest</a>
                                        <a class="dropdown-item" href="#">Popularity</a>
                                        <a class="dropdown-item" href="#">Best Rating</a>
                                    </div>
                                </div>
                                <div class="btn-group ml-2">
                                    <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="shop?index=${1}&showP=${3}">3</a>
                                        <a class="dropdown-item" href="shop?index=${1}&showP=${6}">6</a>
                                        <a class="dropdown-item" href="shop?index=${1}&showP=${9}">9</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${listP}" var="o">
	                    <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
	                        <div class="product-item bg-light mb-4">
	                            <div class="product-img position-relative overflow-hidden">
	                            	<c:set var="img_o" value="${o.img}" />
	                                <img class="img-fluid w-100" src="${img_o.path_middle}" alt="">
	                                <div class="product-action">
	                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
	                                    <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
	                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
	                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
	                                </div>
	                            </div>
	                            <div class="text-center py-4">
	                                <a class="h6 text-decoration-none text-truncate" href="https://www.facebook.com/">${o.name_P}</a>
	                                <div class="d-flex align-items-center justify-content-center mt-2">
	                                    <h5>${o.price} VNĐ</h5>
	                                </div>
	                                <div class="d-flex align-items-center justify-content-center mt-2">
	                                    <h6>Size: M</h6>
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
                          <ul class="pagination justify-content-center">
                          	<!--  
                          	<form action="shop" method="post">
                          		
	                            <li class="page-item ${tag == 1?"disabled":""}"><a class="page-link" href="shop?index=${tag-1}&showP=${showtag}">Previous</span></a></li>
	                            <c:forEach begin="1" end="${endP}" var="i">
		                            <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="shop?index=${i}&showP=${showtag}">${i}</a></li>          
	                            </c:forEach>
	                            <li class="page-item ${tag == endP?"disabled":""}"><a class="page-link" href="shop?index=${tag+1}&showP=${showtag}">Next</a></li>
	                            
	                            <li class="page-item ${tag == 1?"disabled":""}"><a class="page-link" href="#" onclick="this.parentNode.submit()" href="shop?index=${tag-1}&showP=${showtag}">Previous</span></a></li>
	                            <c:forEach begin="1" end="${endP}" var="i">
		                            <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="shop?index=${i}&showP=${showtag}">${i}</a></li>          
	                            </c:forEach>
	                            <li class="page-item ${tag == endP?"disabled":""}"><a class="page-link" href="shop?index=${tag+1}&showP=${showtag}">Next</a></li>
	                        </form>
	                        -->
	                        <li class="page-item ${tag == 1?"disabled":""}"><a class="page-link" href="shop?index=${tag-1}&showP=${showtag}">Previous</span></a></li>
	                        <c:forEach begin="1" end="${endP}" var="i">
		                        <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="shop?index=${i}&showP=${showtag}">${i}</a></li>          
	                        </c:forEach>
	                        <li class="page-item ${tag == endP?"disabled":""}"><a class="page-link" href="shop?index=${tag+1}&showP=${showtag}">Next</a></li>
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
	<script>
		function SearchByPrice(){
	   	 $.ajax({
	            url: "/WebApp/SearchProductByPrice",
	            type: "get", //send it through get method
	            data: {
	            	price1: document.getElementById("price-1").checked.toString(),
	            	price2: document.getElementById("price-2").checked.toString(),
	            	price3: document.getElementById("price-3").checked.toString()
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
	</script>

    <%@ include file="footer.jsp" %>>
</body>

</html>