<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="../dist/output.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
</head>

<body>
  <input class='hidden' type="checkbox" name="" id="openAdd">
  <div id='addForm'
    class='hidden bg-white fixed w-[350px] top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Thêm tài khoản</h1>
    <form class='' action="">
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
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'>Thêm</button>
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
            <a href="DashboardHome.html">Quản lý sản phẩm</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-chart-simple"></i>
            <a href="./Top.html">Top 10</a>
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
        <table class='bg-gray-200 table-auto w-full shadow-md border-b-2 border-yellow-500'>
          <thead class='bg-yellow-500'>
            <tr>
              <th class='p-2 text-white'>Song</th>
              <th class='p-2 text-white'>Artist</th>
              <th class='p-2 text-white'>Year</th>
              <th class='p-2 text-white'></th>
            </tr>
          </thead>
          <tbody>
            <tr class='bg-gray-100 odd:bg-gray-200'>
              <td class='p-2 pl-4'>The Sliding Mr. Bones (Next Stop, Pottersville)</td>
              <td class='p-2 pl-4'>Malcolm Lockyer</td>
              <td class='p-2 pl-4'>1961</td>
              <td class='p-2 pl-4 flex justify-center gap-4 items-center'>
                <button>
                  <i class="fa-solid fa-pen-to-square hover:text-yellow-500 cursor-pointer"></i>
                </button>
                <button>

                  <i class="fa-solid fa-delete-left hover:text-red-600 cursor-pointer"></i>
                </button>
              </td>
            </tr>

            <tr class='bg-gray-100 odd:bg-gray-200'>
              <td class='p-2 pl-4'>The Sliding Mr. Bones (Next Stop, Pottersville)</td>
              <td class='p-2 pl-4'>Malcolm Lockyer</td>
              <td class='p-2 pl-4'>1961</td>
              <td class='p-2 pl-4 flex justify-center gap-4 items-center'>
                <button>
                  <i class="fa-solid fa-pen-to-square hover:text-yellow-500 cursor-pointer"></i>
                </button>
                <button>

                  <i class="fa-solid fa-delete-left hover:text-red-600 cursor-pointer"></i>
                </button>
              </td>
            </tr>
            <tr class='bg-gray-100 odd:bg-gray-200'>
              <td class='p-2 pl-4'>The Sliding Mr. Bones (Next Stop, Pottersville)</td>
              <td class='p-2 pl-4'>Malcolm Lockyer</td>
              <td class='p-2 pl-4'>1961</td>
              <td class='p-2 pl-4 flex justify-center gap-4 items-center'>
                <button>
                  <i class="fa-solid fa-pen-to-square hover:text-yellow-500 cursor-pointer"></i>
                </button>
                <button>

                  <i class="fa-solid fa-delete-left hover:text-red-600 cursor-pointer"></i>
                </button>
              </td>
            </tr>
          </tbody>
        </table>
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

  </script>
</body>

</html>