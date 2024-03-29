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
                    
                    <h3 class="font-weight-semi-bold mb-4">${Double.toString(detail.price).substring(0,Double.toString(detail.price).length()-2)} VND</h3>
                    <p class="mb-4">${detail.description}</p>
                    <div class="d-flex mb-3">
                        <strong class="text-dark mr-3">Sizes:</strong>
                        <label class="custom" for="size-1">${detail.size}</label>
                    </div>
                    <div class="d-flex mb-4">
                        <strong class="text-dark mr-3">Colors:</strong>
                         <label class="custom" for="color-1">${detail.color}</label>
                    </div>
                    <div class="d-flex align-items-center mb-4 pt-2">
                    	<form action="addCart?pid=${detail.id_P}" method="post">
                    		<input type="hidden" name="csrfToken" value="123Qaz!@#">
	                        <div class="input-group quantity mr-3" style="width: 130px; margin-bottom: 15px;">
		                         <div class="input-group-btn">
	                                <button type="button" class="btn btn-primary btn-minus">
	                                    <i class="fa fa-minus"></i>
	                                </button>
	                            </div>
	                            <input class="form-control bg-secondary border-0 text-center" min="0" name="quantity" value="1" type="number">
		                        <div class="input-group-btn">
	                                <button type="button" class="btn btn-primary btn-plus">
	                                    <i class="fa fa-plus"></i>
	                                </button>
	                            </div>
	                        </div>
	                        <button type="${detail.status == 0 ? 'button': '' }" class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To
	                            Cart</button> 
	                        <c:if test="${detail.status == 0}">
	                        	<button type="button" class="btn btn-light px-3 disabled" id="label-expired">(Hết hàng)</button>
	                        </c:if>
	                     </form>
                    </div>
                </div>
            </div>
        	
        </div>
    	<div class="row px-xl-5">
            <div class="col">
                <div class="bg-light p-30">
                    <div class="nav nav-tabs mb-4">
                        <a class="nav-item nav-link text-dark active" data-toggle="tab" href="#tab-pane-1">Description</a>
                        <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-2">Information</a>
                        <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-3">Reviews </a>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="tab-pane-1">
                            <h4 class="mb-3">Product Description</h4>
                            <p>Thoải mái và phong cách, sản phầm này chắc chắn sẽ trở thành món đồ mới của bạn.</p>
                            <p>Mẫu giày được thiết kế theo phong cách cổ điển với màu sắc đơn giản, nhẹ nhàng</p>
                        </div>
                        <div class="tab-pane fade" id="tab-pane-2">
                            <h4 class="mb-3">Additional Information</h4>
                            <div class="row">
                                <div class="col-md-6">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item px-0">
                                            Thoáng khí, lưới phía trên.
                                        </li>
                                        <li class="list-group-item px-0">
                                            Lớp lót dệt và đế xốp EVA.
                                        </li>
                                        <li class="list-group-item px-0">
                                            Kiểu đóng ren truyền thống.
                                        </li>
                                        <li class="list-group-item px-0">
                                            Kéo tab để thêm thoải mái.
                                        </li>
                                      </ul> 
                                </div>
                                <div class="col-md-6">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item px-0">
                                            Bóng ngón chân tròn. Đế giữa bằng xốp EVA với công nghệ 10 ô.
                                        </li>
                                        <li class="list-group-item px-0">
                                            Đế ngoài cao su kéo nhập khẩu.
                                        </li>
                                        <li class="list-group-item px-0">
                                            Trọng lượng của giày dựa trên một mặt hàng, không phải một đôi.
                                        </li>
                                        <li class="list-group-item px-0">
                                            Đo: Trọng lượng giày đơn: 9,6 Oz.
                                        </li>
                                      </ul> 
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab-pane-3">
                            <div class="row">
                                <div class="col-md-6" id="reviews">
                                    <h4 class="mb-4">Review for Product</h4>
                                    <c:forEach items="${feedback}" var="fb">
                                    
                                    	<c:set var="user" value="${fb.customer}" />
	                                    <div class="media mb-4">
		                                    <div class="media-body">
			                                    <h6>${user.userName }<small> - <i>${fb.date}</i></small></h6>
			                                    <p>${fb.content}</p>
		                                  	</div>
	                                    </div>
                                    </c:forEach>
                                </div>
                                <c:choose>
	                                <c:when test="${sessionScope.user != null}">
		                                <div class="col-md-6">
		                                    <h4 class="mb-4">Leave a review</h4>
		                                    <small>Your email address will not be published. Required fields are marked *</small>
		                                    <form>
		                                        <div class="form-group">
		                                            <label for="message">Your Review *</label>
		                                            <textarea id="message" cols="30" rows="5" class="form-control"></textarea>
		                                        </div>
		                                        <div class="form-group mb-0">
		                                            <input value="Leave Your Review" class="btn btn-primary px-3" onclick="AddReviews(${detail.id_P})">
		                                        </div>
		                                    </form>
		                                </div>
	                                </c:when>
	                                <c:otherwise>
		                                <div class="col-md-6" style="left:150px;">
		                                    <h4 class="mb-4">Login to view Reviews</h4>
		                                    <small>Your email address will not be published. Required fields are marked *</small>
		                                    <form action="Login" method="get">
		                                    	<input type="hidden" name="csrfToken" value="123Qaz!@#">
		                                        <div class="form-group mb-0" style="margin-left:150px; margin-top:20px">
		                                            <input type="submit" value="   Login  " class="btn btn-primary px-3">
		                                        </div>
		                                    </form>
	                                	</div>
	                                </c:otherwise>
	                            </c:choose>
                                
                            </div>
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
    <script src="https://cdn.jsdelivr.net/npm/dompurify@2.3.2/dist/purify.min.js"></script>

    <%@ include file="footer.jsp" %>
    

</body>
</html>
