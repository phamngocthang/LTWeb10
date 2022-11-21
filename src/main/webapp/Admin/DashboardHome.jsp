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
</head>

<body>
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
            <a href="Bill.html">Hóa Đơn</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-user"></i>
            <a href="./Manage.html">Quản Lý Tài Khoản</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-shoe-prints"></i>
            <a href="DashboardHome.html">Quản Lý Sản Phẩm</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-chart-simple"></i>
            <a href="TopServlet">Top 10</a>
          </li>
        </ul>
      </nav>
    </aside>
    <article>
      <div class='grid grid-cols-2 gap-4'>

        <div class='p-4 rounded-md bg-slate-200 flex gap-4 items-center'>
          <div class='text-3xl'>
            <i class="fa-solid fa-user"></i>
          </div>
          <div>
            <p class='text-lg'>Tổng Số Khách Hàng</p>
            <p class='text-3xl'>${amountCustomer}</p>
          </div>
        </div>
        <div class='p-4 rounded-md bg-slate-200 flex gap-4 items-center'>
          <div class='text-3xl'>
            <i class="fa-solid fa-user"></i>
          </div>
          <div>
            <p class='text-lg'>Tổng Số Sản Phẩm</p>
            <p class='text-3xl'>${amountProduct}</p>
          </div>
        </div>
        <div class='p-4 rounded-md bg-slate-200 flex gap-4 items-center'>
          <div class='text-3xl'>
            <i class="fa-solid fa-user"></i>
          </div>
          <div>
            <p class='text-lg'>Tổng Số Doanh Thu</p>
            <p class='text-3xl'>${sumBill}</p>
          </div>
        </div>
        <div class='p-4 rounded-md bg-slate-200 flex gap-4 items-center'>
          <div class='text-3xl'>
            <i class="fa-solid fa-user"></i>
          </div>
          <div>
            <p class='text-lg'>Tổng Số Đơn Đặt Hàng</p>
            <p class='text-3xl'>${countBill }</p>
          </div>
        </div>
      </div>
    </article>
  </main>
</body>

</html>