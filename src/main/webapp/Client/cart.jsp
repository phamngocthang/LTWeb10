<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js" integrity="sha384-RIQuldGV8mnjGdob13cay/K1AJa+LR7VKHqSXrrB5DPGryn4pMUXRLh92Ev8KlGF" crossorigin="anonymous"></script>
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
    <%@ include file="header.jsp"%>


    <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="#">Shop</a>
                    <span class="breadcrumb-item active">Shopping Cart</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5" id="ShoppingCart">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    	<c:forEach items="${sessionScope.listCart}" var="c">
                    		<c:set var="cp" value="${c.product}" />
                    		<c:forEach items="${sessionScope.listProduct}" var="p">
                    			<c:if test="${cp.id_P == p.id_P}">
				                        <tr>
				                        	<c:set var="img" value="${p.image}" />
				                            <td class="align-middle"><img src="${img.pathMiddle}" alt="" style="width: 50px;"> ${p.name_P}</td>
				                            <td class="align-middle">${Double.toString(p.price).substring(0,Double.toString(p.price).length()-2)} VND</td>
				                            <td class="align-middle">
				                                <div class="input-group quantity mx-auto" style="width: 100px;">
				                                    <div class="input-group-btn">
				                                        <button class="btn btn-sm btn-primary btn-minus" id="btnSubAmount" onclick="EditCart(${p.id_P}, true, ${c.amount})">
				                                        <i class="fa fa-minus"></i>
				                                        </button>
				                                    </div>
				                                    <input type="text" id="valueAmount" class="form-control form-control-sm bg-secondary border-0 text-center" value="${c.amount }">
				                                    <div class="input-group-btn">
				                                        <button class="btn btn-sm btn-primary btn-plus" id="btnAddAmount" onclick="EditCart(${p.id_P}, false, ${c.amount})">
				                                            <i class="fa fa-plus"></i>
				                                        </button>
				                                    </div>
				                                </div>
				                            </td>
				                            <td class="align-middle">${Double.toString(p.price*c.amount).substring(0,Double.toString(p.price*c.amount).length()-2)} VND</td>
				                            <td class="align-middle"><button class="btn btn-sm btn-danger" onclick="DeleteCart(${p.id_P})"><i class="fa fa-times"></i></button></td>
				                        </tr>
			                    </c:if>
		                     </c:forEach>
	                     </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart Summary</span></h5>
                <div class="bg-light p-30 mb-5" id="charge">
                    <div class="border-bottom pb-2">
                        <div class="d-flex justify-content-between mb-3">
                            <h6>Subtotal</h6>
                            <h6>${subTotal} VND</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium">35000 VND</h6>
                        </div>
                    </div>
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Total</h5>
                            <h5>${totalPrice} VND</h5>
                        </div>
                        <button class="btn btn-block btn-primary font-weight-bold my-3 py-3" onclick="location.href='Checkout'">Proceed To Checkout</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Cart End -->
	<input id="check_insert" value="${checkinsert}" hidden /> 
    <input id="statusmanage" value="${statusmanage}" hidden />

    <%@ include file="footer.jsp"%>
    
    <script>
	  
	let insert = document.getElementById("check_insert");
	let checkstatus = document.getElementById("statusmanage");
	
	
	let checkinsert = insert.value;
	let status = checkstatus.value;
	
	if (status === 'true'){
		if (checkinsert === 'true')
			swal("Thông Báo!", "Đặt Hàng Thành Công",
			"success");
	}
	if (status === 'true'){
		if (checkinsert === 'false')
			swal("Thông Báo!", "Đặt Hàng Không Thành Công!",
			"success");
	}
  	</script>
</body>

</html>