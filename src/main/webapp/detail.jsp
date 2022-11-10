<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

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
	<%@ include file="header.jsp" %>
    <!-- Shop Detail Start -->
    <div class="container-fluid pb-5">
    	<c:set var="detail" value="${detail}" />
        <div class="row px-xl-5">
            <div class="col-lg-5 mb-30">
                <div id="product-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner bg-light" >
                    	<c:set var="img_o" value="${detail.image}" />
                        <div class="carousel-item active">
                            <img class="w-100 h-100" src="${img_o.pathMiddle}" alt="Image">
                        </div>
                        <div class="carousel-item">
                            <img class="w-100 h-100" src="${img_o.pathLeft}" alt="Image">
                        </div>
                        <div class="carousel-item">
                            <img class="w-100 h-100" src="${img_o.pathRight}" alt="Image">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
                        <i class="fa fa-2x fa-angle-left text-dark"></i>
                    </a>
                    <a class="carousel-control-next" href="#product-carousel" data-slide="next">
                        <i class="fa fa-2x fa-angle-right text-dark"></i>
                    </a>
                </div>
            </div>

            <div class="col-lg-7 h-auto mb-30">
                <div class="h-100 bg-light p-30">
                
                    <h3>${detail.name_P}</h3>
                    <div class="d-flex mb-3">
                        <div class="text-primary mr-2">
                            <small class="fas fa-star"></small>
                            <small class="fas fa-star"></small>
                            <small class="fas fa-star"></small>
                            <small class="fas fa-star-half-alt"></small>
                            <small class="far fa-star"></small>
                        </div>
                        <small class="pt-1">(99 Reviews)</small>
                    </div>
                    <h3 class="font-weight-semi-bold mb-4">${Double.toString(detail.price).substring(0,Double.toString(detail.price).length()-2)} VND</h3>
                    <p class="mb-4">${detail.description}</p>
                    <div class="d-flex mb-3">
                        <strong class="text-dark mr-3">Sizes:</strong>
                        <form>
                            <input type="radio" class="custom-control-input" id="size-1" name="size">
                            <label class="custom" for="size-1">${detail.size}</label>
                        </form>
                    </div>
                    <div class="d-flex mb-4">
                        <strong class="text-dark mr-3">Colors:</strong>
                        <form>
                            <input type="radio" class="custom-control-input" id="color-1" name="color">
                            <label class="custom" for="color-1">${detail.color}</label>
                        </form>
                    </div>
                    <div class="d-flex align-items-center mb-4 pt-2">
                        <div class="input-group quantity mr-3" style="width: 130px;">
                            <div class="input-group-btn">
                                <button class="btn btn-primary btn-minus">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control bg-secondary border-0 text-center" value="1">
                            <div class="input-group-btn">
                                <button class="btn btn-primary btn-plus">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                        <button class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To
                            Cart</button>
                    </div>
                    <div class="d-flex pt-2">
                        <strong class="text-dark mr-2">Share on:</strong>
                        <div class="d-inline-flex">
                            <a class="text-dark px-2" href ="https://www.facebook.com/sharer/sharer.php?u=https://nhap123.herokuapp.com/detail?id=${detail.id_P}&brand=${detail.brand}" target="_blank">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a class="text-dark px-2" href="http://www.twitter.com/share?url=https://nhap123.herokuapp.com/detail?id${detail.id_P}&brand=${detail.brand}">
                                <i class="fab fa-twitter"></i>
                            </a>
                            <a class="text-dark px-2" href="http://pinterest.com/pin/create/button/?url=https://nhap123.herokuapp.com/detail?id${detail.id_P}&brand=${detail.brand}">
                                <i class="fab fa-pinterest"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->


   <!-- Products Start -->
    <div class="container-fluid py-3">
        <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">You May Also Like</span></h2>
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel related-carousel">
                 <c:forEach items="${listNP}" var="o">
                    <div class="product-item bg-light">
                        <div class="product-img position-relative overflow-hidden">
                        	<c:set var="img_o" value="${o.image}" />
                            <img class="img-fluid w-100" src="${img_o.pathMiddle}" alt="">
                            <div class="product-action">
                                <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                            </div>
                        </div>
                        <div class="text-center py-4">
                            <a class="h6 text-decoration-none text-truncate" href="${pageContext.request.contextPath}/detail?id=${o.id_P}&brand=${o.brand}">${o.name_P}</a>
                            <div class="d-flex align-items-center justify-content-center mt-2">
                                <h5>${Double.toString(o.price).substring(0,Double.toString(o.price).length()-2)} VND</h5>
                            </div>
                        </div>
                    </div>
                 </c:forEach>
	            </div>
            </div>
        </div>
    </div>
    <!-- Products End -->

    <%@ include file="footer.jsp" %>
</body>

</html>
