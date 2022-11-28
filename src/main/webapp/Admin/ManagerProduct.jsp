<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>

<body>
 <!-- Add Form -->
  <input class='hidden' type="checkbox" name="" id="openAdd">
  <div id='addForm'
    class='hidden bg-white fixed min-w-[350px] top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Thêm sản phẩm</h1>
    <form class='' action="${pageContext.request.contextPath}/InsertProduct" method="post">
      <div class="flex flex-col gap-2">
        <label class='' for="product-name">Tên sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-name"
          id="product-name" placeholder='Vui lòng nhập tên sản phẩm...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-category">Mã danh mục sản phẩm</label>
        	<select name="product-category" id="product-category">
        	  <option value="1">Giày Nam</option>
	          <option value= "2" >Giày Nữ</option>
	        </select>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Brand sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-brand"
          id="product-brand" placeholder='Vui lòng nhập thương hiệu...'>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-price">Giá sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="number" name="product-price"
          id="product-price" placeholder='Vui lòng nhập giá sản phẩm...'>
      </div>
      <!-- Color -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Màu sản phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-color"
          id="product-color" placeholder='Vui lòng nhập màu sản phẩm...'>
      </div>
      <div class='flex gap-2'>
        <div class="flex flex-col gap-2">
          <label class='' for="product-img-left">Hình bên trái</label>
          <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-img-left"
            id="product-img-left" placeholder='Url...'>
        </div>
        <div class="flex flex-col gap-2">
          <label class='' for="product-img-center">Hình chính diện</label>
          <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-img-center"
            id="product-img-center" placeholder='Url...'>
        </div>
        <div class="flex flex-col gap-2">
          <label class='' for="product-img-right">Hình bên phải</label>
          <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-img-right"
            id="product-img-right" placeholder='Url...'>
        </div>
      </div>
      <!-- Size -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-size">Kích cỡ sản phẩm</label>
        <select name="product-size" id="product-size">
          <option value="S">S</option>
          <option value="M">M</option>
          <option value="L">L</option>
          <option value="XL">XL</option>
        </select>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-desc">Mô tả</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="product-desc"
          id="product-desc" placeholder='Nhập mô tả cho sản phẩm...'>
      </div>
      <!-- Amount -->
      <br />
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type = "submit">Thêm</button>
      <button type='button' onclick='closeAddForm()'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Hủy</button>
    </form>
  </div>
  
  
  <main class='grid grid-cols-[200px_1fr] p-4 min-h-screen gap-4 max-w-[1200px] mx-auto pt-10'>

    <aside>
      <nav>
        <ul>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-gauge"></i>
            <a href="DashboardHome.html">Dashboard</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-money-bill"></i>
            <a href="DashboardHome.html">Hóa đơn</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-user"></i>
            <a href="./Manage.html">Quản lý tài khoản</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-shoe-prints"></i>
            <a href="ManagerProduct">Quản lý sản phẩm</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-chart-simple"></i>
            <a href="TopServlet">Top 10</a>
          </li>
        </ul>
      </nav>
    </aside>
    <article>
      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Quản lý sản phẩm</h1>

        <button onclick="openAddForm()"
          class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'>Thêm
          sản phẩm</button>
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>Product Name</th>
              <th class='p-2 text-white'>Price</th>
              <th class='p-2 text-white'>Color</th>
              <th class='p-2 text-white'>Brand</th>
              <th class='p-2 text-white'></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach begin="0" end="${fn:length(listProduct) - 1}" step="1" varStatus="position">
		        <tr class='bg-gray-100 odd:bg-gray-200'>
	              <td class='p-2 pl-4'>${listProduct[position.current].name_P}</td>
	              <td class='p-2 pl-4'>${Double.toString(listProduct[position.current].price).substring(0,Double.toString(listProduct[position.current].price).length()-2)} VNĐ</td>
	              <td class='p-2 pl-4'>${listProduct[position.current].color}</td>
	              <td class='p-2 pl-4 flex justify-center gap-4 items-center'>${listProduct[position.current].brand}</td>
	              <td>
	              <a href ="getProduct?id_P=${listProduct[position.current].id_P}">
	              <button>
                  		<i class="fa-solid fa-pen-to-square hover:text-yellow-500 cursor-pointer"></i>
	              </button>
	              </a>
	              <a href ="deleteProduct?id_P=${listProduct[position.current].id_P}">
	              <button>
						<i class="fa-solid fa-delete-left hover:text-red-600 cursor-pointer"></i>
	              </button>
	              </a>
	              </td>
	            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </article>
  </main>
  <script>
    const openAdd = document.getElementById('openAdd');
    const addForm = document.getElementById('addForm');
    
    const openUpdate = document.getElementById('openUpdate');
    const UpdateForm = document.getElementById('UpdateForm');

    console.log(openAdd.checked)
    
    function openUpdateForm(id) {
      openUpdate.checked = true;
      fetch("/")
      openUpdate.dispatchEvent(new Event('change')); 
    }

    function closeUpdateForm() {
      openUpdate.checked = false;
      openUpdate.dispatchEvent(new Event('change'));
    }

    function openAddForm() {
      openAdd.checked = true;
      openAdd.dispatchEvent(new Event('change'));
    }

    function closeAddForm() {
      openAdd.checked = false;
      openAdd.dispatchEvent(new Event('change'));
    }

    openAdd.addEventListener('change', () => {
      console.log("Changed");
      if (openAdd.checked) {
        addForm.classList.remove('hidden');
      } else {
        addForm.classList.add('hidden');
      }
    })
    openUpdate.addEventListener('change', () => {
      if (openUpdate.checked) {
        UpdateForm.classList.remove('hidden');
        
      } else {
        UpdateForm.classList.add('hidden');
      }
     
     function showMessage(message, time) {
		var thongBao = document.querySelector('#thongBao');
				clearTimeout(timeoutId);
                thongBao.style.display = "block";
                thongBao.innerText=message;
                timeoutId = setTimeout(() => {
					thongBao.style.display = "none";
				}, time)
	}
    })

  </script>
</body>

</html>