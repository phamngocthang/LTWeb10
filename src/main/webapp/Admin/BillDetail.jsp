<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <title>Document</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
  </head>

  <body>
    <main class='p-4 max-w-[1200px] mx-auto pt-10'>
      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Chi tiết đơn hàng (Mã hóa đơn: ${billId})</h1>
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>Sản phẩm</th>
              <th class='p-2 text-white'>Giá thành</th>
              <th class='p-2 text-white'>Số lượng</th>
              <th class='p-2 text-white'>Tổng tiền</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${billDetail}" var="p">

              <tr class='bg-gray-100 odd:bg-gray-200'>
                <td class='p-2 pl-4'>${p.product.name_P}</td>
                <td class='p-2 pl-4 text-center'>${Double.toString(p.product.price).substring(0,Double.toString(p.product.price).length()-2)} VNĐ</td>
                <td class='p-2 pl-4 text-center'>${p.amount}</td>
                <td class='p-2 pl-4 text-center'>${Double.toString(p.amount * p.product.price).substring(0,Double.toString(p.amount * p.product.price).length()-2)} VND</td>
              </tr>
            </c:forEach>

          </tbody>
        </table>
        <div class='flex justify-between mt-4'>
          <div>
            <a class='underline text-gray-500 hover:text-gray-400' href="BillManagement">Trở về trang quản lý hóa đơn</a>
          </div>
          <div class='flex justify-end gap-2'>
            <p class='text-xl'>Tổng giá trị</p>
            <p class='text-3xl font-semibold'>${total} VND</p>
          </div>
        </div>
      </div>
    </main>
  </body>

  </html>