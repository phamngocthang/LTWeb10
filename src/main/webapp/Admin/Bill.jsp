<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <title>Dashboard</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
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
          <h1 class='uppercase text-2xl font-semibold text-center p-4'>Danh sách hóa đơn</h1>
          <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
            <thead class='bg-yellow-500'>
              <tr>
                <th class='p-2 text-white'>Mã hóa đơn</th>
                <th class='p-2 text-white'>Khách hàng</th>
                <th class='p-2 text-white'>Tổng tiền</th>
                <th class='p-2 text-white'>Ngày lập</th>
                <th class='p-2 text-white'>Xem chi tiết</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${listBill}" var="p">
                <tr class='bg-gray-100 odd:bg-gray-200'>
                  <td class='p-2 pl-4'>${p.idBill}</td>
                  <td class='p-2 pl-4'>${p.account.customer.firstName} ${p.account.customer.lastName}</td>
                  <td class='p-2 pl-4'>${Double.toString(p.totalPrice).substring(0,Double.toString(p.totalPrice).length()-2)} VNĐ</td>
                  <td class='p-2 pl-4'>${p.date}</td>
                  <td class='p-2 pl-4 text-center'>
                    <a href='BillDetail?billId=${p.idBill}' class='hover:text-yellow-500'>
                      <i class="fa-solid fa-eye"></i>
                    </a>
                  </td>
                </tr>
              </c:forEach>

            </tbody>
          </table>
        </div>

      </article>
    </main>
  </body>

  </html>