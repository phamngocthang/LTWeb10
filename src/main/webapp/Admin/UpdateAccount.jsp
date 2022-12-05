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
	<!-- Form Update -->
  <input class='hidden' type="checkbox" name="" id="openAdd">
  <div id='addForm'
    class='updateForm bg-white fixed w-[350px] top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Thêm tài khoản</h1>
    <form class='' action="updateAccount" method="post">
      <!-- username, password, isadmin checkbox -->
      <div class="flex flex-col gap-2">
        <label class='' for="username">Tên tài khoản</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="initial_username"
          id="username" value="${accountdetail.userName}">
      </div>
      <div class="flex flex-col gap-2">
        <label for="password">Mật khẩu cũ</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="initial_password"
          id="password">
      </div>
      <div class="flex flex-col gap-2">
        <label for="password">Mật khẩu mới</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="new_password"
          id="password" placeholder='Vui lòng nhập mật khẩu cho tài khoản này...'>
      </div>
      <div class="flex flex-col gap-2">
        <label for="password">Nhập lại mật khẩu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="re_newpassword"
          id="password" placeholder='Vui lòng nhập mật khẩu cho tài khoản này...'>
      </div>
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mt-4 rounded-md shadow-md' type='submit'>Cập nhật</button>
      <a href ="AccountManage">
      <button type='button'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mt-4 rounded-md shadow-md'>Hủy</button>
      </a>
    </form>
  </div>
</body>
</html>