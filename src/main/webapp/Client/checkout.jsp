<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
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
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>

<body>
	<%@ include file ="header.jsp" %>

    <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="#">Shop</a>
                    <span class="breadcrumb-item active">Checkout</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->


    <!-- Checkout Start -->
    <div class="container-fluid">
    	<span class="bg-secondary pr-3" style="font-size: x-large;">${mess}</span>
    	<form action="PlaceOrder" method="post">
	        <div class="row px-xl-5">
	            <div class="col-lg-8">
	                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
	                <div class="bg-light p-30 mb-5">
	                    <div class="row">
	                        <div class="col-md-6 form-group">
	                            <label>First Name</label>
	                            <input class="form-control" name="firstname" placeholder="John" value="${sessionScope.Customer.firstName}" required>
	                        </div>
	                        <div class="col-md-6 form-group">
	                            <label>Last Name</label>
	                            <input class="form-control" name="lastname" type="lastname" placeholder="Doe" value="${sessionScope.Customer.lastName}" required>
	                        </div>
	                        <div class="col-md-6 form-group">
	                            <label>E-mail</label>
	                            <input class="form-control" name="email" type="text" placeholder="example@email.com" value="${sessionScope.Customer.email}" required>
	                        </div>
	                        <div class="col-md-6 form-group">
	                            <label>Mobile No</label>
	                            <input class="form-control" name="phonenumber" type="text" placeholder="+123 456 789" value="${sessionScope.Customer.phonenumber}" required>
	                        </div>
	                        <div class="col-md-6 form-group">
	                            <label>Address Line 1</label>
	                            <input class="form-control" name="address" placeholder="123 Street" value="${sessionScope.Customer.address}" required>
	                        </div>
	                        <div class="col-md-6 form-group">
	                            <label>City</label>
	                            <input class="form-control" type="text" placeholder="Viet Nam" value="Viet Nam" required>
	                        </div>
	                    </div>
	                </div>
	                <div class="collapse mb-5" id="shipping-address">
	                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Shipping Address</span></h5>
	                    <div class="bg-light p-30">
	                        <div class="row">
	                            <div class="col-md-6 form-group">
	                                <label>First Name</label>
	                                <input class="form-control" type="text" placeholder="John">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>Last Name</label>
	                                <input class="form-control" type="text" placeholder="Doe">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>E-mail</label>
	                                <input class="form-control" type="text" placeholder="example@email.com">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>Mobile No</label>
	                                <input class="form-control" type="text" placeholder="+123 456 789">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>Address Line 1</label>
	                                <input class="form-control" type="text" placeholder="123 Street">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>Address Line 2</label>
	                                <input class="form-control" type="text" placeholder="123 Street">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>Country</label>
	                                <select class="custom-select">
	                                    <option selected>United States</option>
	                                    <option>Afghanistan</option>
	                                    <option>Albania</option>
	                                    <option>Algeria</option>
	                                </select>
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>City</label>
	                                <input class="form-control" type="text" placeholder="New York">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>State</label>
	                                <input class="form-control" type="text" placeholder="New York">
	                            </div>
	                            <div class="col-md-6 form-group">
	                                <label>ZIP Code</label>
	                                <input class="form-control" type="text" placeholder="123">
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col-lg-4">
	                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
	                <div class="bg-light p-30 mb-5">
	                    <div class="border-bottom">
	                        <h6 class="mb-3">Products</h6>
	                        <c:forEach items="${sessionScope.listCart}" var="c">
	                        	<c:set var="cp" value="${c.product}" />
	                        	<c:forEach items="${sessionScope.listProduct}" var="p">
	                        		<c:if test="${cp.id_P == p.id_P}">
				                        <div class="d-flex justify-content-between">
				                            <p>${p.name_P}</p>
				                            <p>${Double.toString(p.price).substring(0,Double.toString(p.price).length()-2)} x${c.amount}</p>
				                        </div>
				                    </c:if>
			                    </c:forEach>
		                    </c:forEach>
	                    </div>
	                    <div class="border-bottom pt-3 pb-2">
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
	                    </div>
	                </div>
	                <div class="mb-5">
	                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
	                    <div class="bg-light p-30">
	                        <div class="form-group">
	                            <div class="custom-control custom-radio">
	                                <input type="radio" class="custom-control-input" name="payment" id="directcheck" checked>
	                                <label class="custom-control-label" for="directcheck">Direct Check</label>
	                            </div>
	                        </div>
	                        <button class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button>
	                    </div>
	                </div>
	            </div>
	        </div>
    	</form>
    </div>
    <!-- Checkout End -->


    <%@ include file="footer.jsp" %>
</body>

</html>