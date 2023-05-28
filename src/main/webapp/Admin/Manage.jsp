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
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>ThÃªm tÃ i khoáº£n</h1>
    <form class='' action="">
      <!-- username, password, isadmin checkbox -->
      <div class="flex flex-col gap-2">
        <label class='' for="username">TÃªn tÃ i khoáº£n</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="username"
          id="username" placeholder='Vui lÃ²ng nháº­p tÃªn tÃ i khoáº£n...'>
      </div>
      <div class="flex flex-col gap-2">
        <label for="password">Máº­t kháº©u</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="password"
          id="password" placeholder='Vui lÃ²ng nháº­p máº­t kháº©u cho tÃ i khoáº£n nÃ y...'>
      </div>
      <div class="flex gap-2 items-center py-2">
        <label for="isAdmin">LÃ  admin?</label>
        <input type="checkbox" name="isAdmin" id="isAdmin">
      </div>
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'>ThÃªm</button>
      <button type='button' onclick='closeAddForm()'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Há»§y</button>
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
        <h1 class='uppercase text-2xl font-semibold text-center p-4'>Quáº£n lÃ½ tÃ i khoáº£n</h1>

        <button onclick="openAddForm()"
          class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md'>ThÃªm
          tÃ i
          khoáº£n</button>
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