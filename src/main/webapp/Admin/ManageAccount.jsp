<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>
	<!-- Form Add -->
  <input class='hidden' type="checkbox" name="" id="openAdd">
  <div id='addForm'
    class='hidden bg-white fixed w-[350px] top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Thêm tài khoản</h1>
    <form class='' action="InsertAccount">
      <!-- username, password, isadmin checkbox -->
      <div class="flex flex-col gap-2">
        <label class='' for="username">Tên tài khoản</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="username"
          id="username" placeholder='Vui lòng nhập tên tài khoản...'>
      </div>
      <div class="flex flex-col gap-2">
        <label for="password">Mật khẩu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="password"
          id="password" placeholder='Vui lòng nhập mật khẩu cho tài khoản này...'>
      </div>
      <div class="flex gap-2 items-center py-2">
        <label for="isAdmin">Là admin?</label>
        <input type="checkbox" name="isAdmin" id="isAdmin">
      </div>
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type='submit'>Thêm</button>
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
      <div class='pb-4'>
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Quản lý tài khoản</h1>

        <button onclick="openAddForm()"
          class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'>Thêm
          tài
          khoản</button>
          		<%
            	String err = request.getParameter("err");
        		if ("1".equals(err)) {
        			out.print("<center> <h6 style=\"color: red;\">Add new account succesfully!</h6> </center>");
        			}
        		else if ("2".equals(err)) {
        			out.print("<center> <h6 style=\"color: red;\">Username is exist, add new account fail!</h6> </center>");
        			}
        		else if ("3".equals(err)) {
        			out.print("<center> <h6 style=\"color: red;\">Update account successfully!</h6> </center>");
        			}
				%>
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-1 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>UserName</th>
              <th class='p-2 text-white'>Password</th>
              <th class='p-2 text-white'>IsAdmin</th>
              <th class='p-2 text-white'></th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach items="${allAccounts}" var="a">
            <tr class='bg-gray-100 odd:bg-gray-200' align='center'>
              <td class='p-2 pl-4'>${a.userName}</td>
              <td class='p-2 pl-4'>${a.passWord }</td>
              <c:set var = "isAdmin" scope = "session" value = "${a.isAdmin}"/>
              <c:if test="${ isAdmin > 0 }">
              <td class='p-2 pl-4'>Yes</td>
			  </c:if>
			  <c:if test="${ isAdmin == 0 }">
              <td class='p-2 pl-4'>No</td>
			  </c:if>
              <td class='p-2 pl-4 flex justify-center gap-4 items-center'>
                <button>
                  <i class="fa-solid fa-pen-to-square hover:text-yellow-500 cursor-pointer" onclick="location.href='getAccount?username=${a.userName}';"></i>
                </button>
              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
        <input id="statusmanage" value="${statusmanage}" hidden />
        <input id="check_insert" value="${checkinsert}" hidden /> 
        <input id="mess_insert" value="${messinsert}" hidden /> 
        <input id="check_update" value="${checkupdate}" hidden /> 
        <input id="mess_update" value="${messupdate}" hidden /> 
      </div>
    </article>
  </main>
  <script>
    const openAdd = document.getElementById('openAdd');
    const addForm = document.getElementById('addForm');

    console.log(openAdd.checked)
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
    
    let checkstatus = document.getElementById("statusmanage");
    let insertaccount = document.getElementById("check_insert");
    let updateaccount = document.getElementById("check_update");
    let messinsert = document.getElementById("mess_insert");
    let messupdate = document.getElementById("mess_update");
    
    let checkinsert = insertaccount.value;
    let mess_in= messinsert.value;
    let checkupdate = updateaccount.value;
    let mess_up= messupdate.value;
    let status = checkstatus.value;
    console.log(status)
    console.log(checkinsert)
    console.log(mess_in)
    if (status === 'true'){
		if (checkinsert === 'true')
			if(mess_in === 'true')
				swal("Thông Báo!", "Thêm Tài Khoản Thành Công","success");
			else
				swal("Thông Báo!", "Thêm Tài Khoản Không Thành Công UserName Đã Tồn Tại","error");
		if (checkupdate === 'true')
			if(mess_up === 'true')
				swal("Thông Báo!", "Cập Nhật Password Thành Công","success");
			else
				swal("Thông Báo!", "Cập Nhật Password Không Thành Công","error");
    }
  </script>
</body>

</html>