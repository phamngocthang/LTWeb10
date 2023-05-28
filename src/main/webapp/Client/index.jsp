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
            <link href="css/style.css" rel="stylesheet">
            <link href="css/waiting.css" rel="stylesheet">

            <!-- JSP Usebeen -->

    </head>

    <body>
        <%@ include file="header.jsp" %>


            <!-- Carousel Start -->
            <div class="container-fluid mb-3">
                <div class="row px-xl-5">
                    <div class="col-lg-8">
                        <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0"
                            data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                                <li data-target="#header-carousel" data-slide-to="1"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item position-relative active" style="height: 430px;">
                                    <img class="position-absolute w-100 h-100" src="img/mens-banner.jpg"
                                        style="object-fit: cover;">
                                    <div
                                        class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                        <div class="p-3" style="max-width: 700px;">
                                            <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">
                                                Men Fashion</h1>
                                            <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Lorem rebum
                                                magna amet lorem magna erat diam stet. Sadips duo stet amet amet ndiam
                                                elitr ipsum diam</p>
                                            <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                                href="shop?subcateID=-1&index=1&showP=3">Shop Now</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item position-relative" style="height: 430px;">
                                    <img class="position-absolute w-100 h-100" src="img/woman-banner.jpg"
                                        style="object-fit: cover;">
                                    <div
                                        class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                        <div class="p-3" style="max-width: 700px;">
                                            <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">
                                                Women Fashion</h1>
                                            <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Lorem rebum
                                                magna amet lorem magna erat diam stet. Sadips duo stet amet amet ndiam
                                                elitr ipsum diam</p>
                                            <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
                                                href="shop?subcateID=-1&index=1&showP=3">Shop Now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-offer mb-30" style="height: 200px;">
                            <img class="img-fluid" src="img/men-offer.jpg" alt="">
                            <div class="offer-text">
                                <h6 class="text-white text-uppercase">New Product</h6>
                                <h3 class="text-white mb-3">Special Offer</h3>
                                <a href="" class="btn btn-primary">Shop Now</a>
                            </div>
                        </div>
                        <div class="product-offer mb-30" style="height: 200px;">
                            <img class="img-fluid" src="img/men-offer2.jpg" alt="">
                            <div class="offer-text">
                                <h6 class="text-white text-uppercase">New Product</h6>
                                <h3 class="text-white mb-3">Special Offer</h3>
                                <a href="" class="btn btn-primary">Shop Now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Carousel End -->


            <!-- Featured Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5 pb-3">
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                            <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                            <h5 class="font-weight-semi-bold m-0">Quality Product</h5>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                            <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                            <h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                            <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                            <h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                            <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                            <h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Featured End -->

            <!-- Categories Start -->
            <div class="container-fluid pt-5">
                <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span
                        class="bg-secondary pr-3">Categories</span></h2>
                <div class="row px-xl-5 pb-3">
                    <!-- Get category in session and then for each -->
                    <c:forEach items="${allCategories}" var="c">
                        <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                            <a class="text-decoration-none" href="shop?subcateID=${c.id_SubCate}&index=1&showP=3">
                                <div class="cat-item d-flex align-items-center mb-4">
                                    <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                        <img class="img-fluid" src="img/icon-cate.jpg" alt="">
                                    </div>
                                    <div class="flex-fill pl-3">
                                        <h6>${c.subCate_Name}</h6>
                                        <small class="text-body">
                                            <c:out value="${countProduct.get(c.id_SubCate)}" />
                                            Products
                                        </small>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>

                </div>
            </div>
            <!-- Categories End -->
            <!-- Products Start -->

            <div class="container-fluid pt-5 pb-3">
                <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span
                        class="bg-secondary pr-3">Popular Products</span></h2>
                <div class="row px-xl-5">
                    <c:forEach items="${bestSellerProducts}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                            <div class="product-item bg-light mb-4">
                                <div class="product-img position-relative overflow-hidden">
                                    <img class="img-fluid w-100" src="${p.image.pathMiddle}" alt="">
                                    <div class="product-action">
                                        <a class="btn btn-outline-dark btn-square" onclick="AddCartAjax(${p.id_P}, ${p.status})"><i
                                                class="fa fa-shopping-cart"></i></a>
                                        <a class="btn btn-outline-dark btn-square"
                                            onclick="AddFavoriteProductAjax(${p.id_P})"><i class="far fa-heart"></i></a>
                                            <c:if test="${p.status == 0}">
		                                        <button type="button" class="btn btn-warning" id="expired">
											      Hết hàng
											    </button>
										    </c:if>				    
                                    </div>
                                </div>
                                <div class="text-center py-4">
                                    <a class="h6 text-decoration-none text-truncate"
                                        href="${pageContext.request.contextPath}/detail?id=${p.id_P}&brand=${p.brand}">${p.name_P}</a>
                                    <div class="d-flex align-items-center justify-content-center mt-2">
                                        <h5>${p.price}</h5>
                                        <!-- <h6 class="text-muted ml-2"><del>$123.00</del></h6> -->
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center mb-1">
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small>(99)</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>

            <!-- Products Start -->
            <div class="container-fluid pt-5 pb-3">
                <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span
                        class="bg-secondary pr-3">Recent Products</span></h2>
                <div class="row px-xl-5">
                    <c:forEach items="${recentProducts}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                            <div class="product-item bg-light mb-4">
                                <div class="product-img position-relative overflow-hidden">
                                    <img class="img-fluid w-100" src="${p.image.pathMiddle}" alt="">
                                    <div class="product-action">
                                        <a class="btn btn-outline-dark btn-square" onclick="AddCartAjax(${p.id_P})"><i
                                                class="fa fa-shopping-cart"></i></a>
                                        <a class="btn btn-outline-dark btn-square"
                                            onclick="AddFavoriteProductAjax(${p.id_P})"><i class="far fa-heart"></i></a>

                                    </div>
                                </div>
                                <div class="text-center py-4">
                                    <a class="h6 text-decoration-none text-truncate"
                                        href="${pageContext.request.contextPath}/detail?id=${p.id_P}&brand=${p.brand}">${p.name_P}</a>
                                    <div class="d-flex align-items-center justify-content-center mt-2">
                                        <h5>${p.price}</h5>
                                        <!-- <h6 class="text-muted ml-2"><del>$123.00</del></h6> -->
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center mb-1">
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small class="fa fa-star text-primary mr-1"></small>
                                        <small>(99)</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>
            <!-- Products End -->

            <!-- Footer  -->
            <%@ include file="footer.jsp" %>
    </body>

    </html>