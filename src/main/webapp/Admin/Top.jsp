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
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>

<body>
  <main class='grid grid-cols-[200px_1fr] p-4 min-h-screen gap-4 max-w-[1200px] mx-auto pt-10'>
    <aside>
      <nav>
        <ul>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-gauge"></i>
            <a href="DashBoard">Dashboard</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-money-bill"></i>
            <a href="BillManagement">Hóa Đơn</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-user"></i>
            <a href="AccountManage">Quản Lý Tài Khoản</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-shoe-prints"></i>
            <a href="ManagerProduct">Quản Lý Sản Phẩm</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-chart-simple"></i>
            <a href="TopServlet">Top 10</a>
          </li>
        </ul>
      </nav>
    </aside>
    <article>
      <!-- Top table -->
      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Top 5 Khách Hàng</h1>
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>UserName</th>
              <th class='p-2 text-white'>FirstName</th>
              <th class='p-2 text-white'>LastName</th>
              <th class='p-2 text-white'>Email</th>
              <th class='p-2 text-white'>Phone Number</th>
              <th class='p-2 text-white'>Total Spending </th>
            </tr>
          </thead>
          
          
          <tbody>

			<c:forEach begin="0" end="${fn:length(listTopCustomer) - 1}" step="1" varStatus="position">
		        <tr class='bg-gray-100 odd:bg-gray-200'>
	              <td class='p-2 pl-4'>${listTopCustomer[position.current].userName}</td>
	              <td class='p-2 pl-4'>${listTopCustomer[position.current].firstName}</td>
	              <td class='p-2 pl-4'>${listTopCustomer[position.current].lastName}</td>
	              <td class='p-2 pl-4'>${listTopCustomer[position.current].email}</td>
	              <td class='p-2 pl-4'>${listTopCustomer[position.current].phonenumber}</td>
	              <td class='p-2 pl-4'>${listTotal[position.current]} VNĐ</td>
            	</tr>
            	
            </c:forEach>
          </tbody>
        </table>
      </div>



      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Top 5 Sản Phẩm</h1>
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>Product Name</th>
              <th class='p-2 text-white'>Price</th>
              <th class='p-2 text-white'>Color</th>
              <th class='p-2 text-white'>Brand</th>
              <th class='p-2 text-white'>Total</th>
            </tr>
          </thead>
          <tbody>
			<c:forEach begin="0" end="${fn:length(listTopProduct) - 1}" step="1" varStatus="position">
		        <tr class='bg-gray-100 odd:bg-gray-200'>
	              <td class='p-2 pl-4'>${listTopProduct[position.current].name_P}</td>
	              <td class='p-2 pl-4'>${Double.toString(listTopProduct[position.current].price).substring(0,Double.toString(listTopProduct[position.current].price).length()-2)}</td>
	              <td class='p-2 pl-4'>${listTopProduct[position.current].color}</td>
	              <td class='p-2 pl-4'>${listTopProduct[position.current].brand}</td>
	              <td class='p-2 pl-4'>${listTotalProduct[position.current]} VNĐ</td>
            	</tr>
            </c:forEach>
          </tbody>
        </table>
      </div>

    </article>
  </main>
</body>

</html>