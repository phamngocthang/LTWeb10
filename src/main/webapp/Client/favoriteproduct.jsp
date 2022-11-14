<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/img/favicon.ico" rel="icon">

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
    
</head>

<body>
	<%@ include file="header.jsp" %>

    <!-- Shop Start--> 
    <div class="container-fluid">
        <div class="row px-xl-5">
           	<c:forEach items="${sessionScope.listfproduct}" var="c">
           		<c:set var="cp" value="${c.product}" />
           		<c:forEach items="${sessionScope.listProduct}" var="p">
           			<c:if test="${cp.id_P == p.id_P}">
           			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                        <div class="product-item bg-light mb-4">
                            <div class="product-img position-relative overflow-hidden">
                                <img class="img-fluid w-100" src="${p.image.pathMiddle}" alt="">
                                <div class="product-action">
                                    <a class="btn btn-outline-dark btn-square" href=""><i
                                            class="fa fa-shopping-cart"></i></a>
                                    <a class="btn btn-outline-dark btn-square" onclick="location.href='deleteFavoriteProduct?productID=${p.id_P}';"><i
                                            class="fas fa-heart-broken" ></i></a>		
                                </div>
                            </div>
                            <div class="text-center py-4">
                                <a class="h6 text-decoration-none text-truncate"
                                    href="${pageContext.request.contextPath}/detail?id=${p.id_P}&brand=${p.brand}">${p.name_P}</a>
                                <div class="d-flex align-items-center justify-content-center mt-2">
                                    <h5>${Double.toString(p.price).substring(0,Double.toString(p.price).length()-2)} VND</h5>
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
                  <!--<tr>
                  	<c:set var="img" value="${p.image}" />
                      <td class="align-middle"><img src="${img.pathMiddle}" alt="" style="width: 50px;"> ${p.name_P}</td>
                      <td class="align-middle">${Double.toString(p.price).substring(0,Double.toString(p.price).length()-2)} VND</td>	                     
                      <td class="align-middle"><button class="btn btn-sm btn-danger" onclick="location.href='deleteCart?productID=${p.id_P}';"><i class="fa fa-times"></i></button></td>
                  </tr>-->
              		</c:if>
             	</c:forEach>
            </c:forEach> 
         </div>
         <span class="bg-secondary pr-3" style="font-size: x-large;">${mess1}</span>
    </div>
	<!-- Shop End -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <%@ include file="footer.jsp" %>>
</body>

</html>