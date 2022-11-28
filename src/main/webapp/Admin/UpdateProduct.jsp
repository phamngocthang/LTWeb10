<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <style>
  	.updateForm {
  		width: 700px;
  		border: 1px solid orange;
  		margin: 0 auto;
  	}
  </style>
</head>
<body>
	<!-- Update Form -->
  <input class='hidden' type="checkbox" name="" id="openUpdate">
  <div id='UpdateForm'
    class='updateForm bg-white min-w-[350px] p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Sửa sản phẩm</h1>
    <form class='' action="${pageContext.request.contextPath}/updateProduct?id_P=${productdetail.id_P}" method="post">
    	<div class="flex flex-col gap-2">
        <label class='' for="product-id">Mã sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-id"
          id="product-id" disabled value = "${productdetail.id_P}" >
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-name">Tên sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-name"
          id="product-name" placeholder='Vui lòng nhập tên sản phẩm...' value = "${productdetail.name_P}" >
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-category">Mã danh mục sản phẩm</label>
         <c:choose>
		    <c:when test="${productdetail.category.id_Cate == 1}">
		    <select name="product-category" id="product-category">
        	  <option value=${productdetail.category.id_Cate }>${productdetail.category.name_Cate }</option>
	          <option value= "2" >Giày Nữ</option>
	        </select>
		    </c:when> 
		    <c:when test="${productdetail.category.id_Cate ==2}">
        	<select name="product-category" id="product-category">
        	  <option value=${productdetail.category.id_Cate }>${productdetail.category.name_Cate }</option>
	          <option value= "1" >Giày Nam</option>
	        </select>
		    </c:when> 
		  </c:choose>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Brand sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-brand"
          id="product-brand" placeholder='Vui lòng nhập thương hiệu...'value = "${productdetail.brand}" >
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-price">Giá sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="number" name="product-price"
          id="product-price" placeholder='Vui lòng nhập giá sản phẩm...'value = "${productdetail.price}" >
      </div>
      <!-- Color -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Màu sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-color"
          id="product-color" placeholder='Vui lòng nhập màu sản phẩm...'value = "${productdetail.color}" >
      </div>
      <div class='flex gap-2'>
        <div class="flex flex-col gap-2">
          <label class='' for="product-img-left">Hình bên trái</label>
          <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-img-left"
            id="product-img-left" placeholder='Url...'value = "${productdetail.image.pathLeft}" >
        </div>
        <div class="flex flex-col gap-2">
          <label class='' for="product-img-center">Hình chính diện</label>
          <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-img-center"
            id="product-img-center" placeholder='Url...'value = "${productdetail.image.pathMiddle}" >
        </div>
        <div class="flex flex-col gap-2">
          <label class='' for="product-img-right">Hình bên phải</label>
          <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-img-right"
            id="product-img-right" placeholder='Url...'value = "${productdetail.image.pathRight}" >
        </div>
      </div>
      <!-- Size -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-size">Kích cỡ sản phẩm</label>
          <c:choose>
		    <c:when test="${productdetail.size =='S'}">
		    <select name="product-size" id="product-size">
        	  <option value=${productdetail.size }>${productdetail.size }</option>
	          <option value="M">M</option>
	          <option value="L">L</option>
	          <option value="XL">XL</option>
	           </select>
		    </c:when> 
		    <c:when test="${productdetail.size =='M'}">
		    <select name="product-size" id="product-size">
        	  <option value=${productdetail.size }>${productdetail.size }</option>
	          <option value="S">S</option>
	          <option value="L">L</option>
	          <option value="XL">XL</option>
	           </select>
		    </c:when> 
		    <c:when test="${productdetail.size =='L'}">
		    <select name="product-size" id="product-size">
        	  <option value=${productdetail.size }>${productdetail.size }</option>
	          <option value="S">S</option>
	          <option value="M">M</option>
	          <option value="XL">XL</option>
	           </select>
		    </c:when> 
		    <c:when test="${productdetail.size =='XL'}">
		    <select name="product-size" id="product-size">
        	  <option value=${productdetail.size }>${productdetail.size }</option>
	          <option value="S">S</option>
	          <option value="M">M</option>
	          <option value="L">L</option>
	        </select>
		    </c:when> 
		  </c:choose>		   
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-desc">Mô tả</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-desc"
          id="product-desc" placeholder='Nhập mô tả cho sản phẩm...'value = "${productdetail.description}" >
      </div>
      <!-- Amount -->
      <br />
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type = "submit">Cập nhật</button>
      <a href ="ManagerProduct">
      <button type='button'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Hủy</button>
      </a>
    </form>
  </div>
</body>
</html>