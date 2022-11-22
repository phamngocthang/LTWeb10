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
            <a href="DashboardHome.html">Quản lý tài khoản</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-shoe-prints"></i>
            <a href="DashboardHome.html">Quản lý sản phẩm</a>
          </li>
          <li class='p-2 hover:bg-slate-200 rounded-md flex items-center gap-2'>
            <i class="w-[32px] fa-solid fa-chart-simple"></i>
            <a href="DashboardHome.html">Top 10</a>
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
              <th class='p-2 text-white'>Xem chi tiết</th>
            </tr>
          </thead>
          <tbody>
            <tr class='bg-gray-100 odd:bg-gray-200'>
              <td class='p-2 pl-4'>The Sliding Mr. Bones (Next Stop, Pottersville)</td>
              <td class='p-2 pl-4'>Malcolm Lockyer</td>
              <td class='p-2 pl-4'>1961</td>
              <td class='p-2 pl-4 text-center'><button class='hover:text-yellow-500'>
                  <i class="fa-solid fa-eye"></i>
                </button></td>
            </tr>
            <tr class='bg-gray-100 odd:bg-gray-200'>
              <td class='p-2 pl-4'>Witchy Woman</td>
              <td class='p-2 pl-4'>The Eagles</td>
              <td class='p-2 pl-4'>1972</td>
              <td class='p-2 pl-4 text-center'><button class='hover:text-yellow-500'>
                  <i class="fa-solid fa-eye"></i>
                </button></td>
            </tr>
            <tr class='bg-gray-100 odd:bg-gray-200'>
              <td class='p-2 pl-4'>Shining Star</td>
              <td class='p-2 pl-4'>Earth, Wind, and Fire</td>
              <td class='p-2 pl-4'>1975</td>
              <td class='p-2 pl-4 text-center'><button class='hover:text-yellow-500'>
                  <i class="fa-solid fa-eye"></i>
                </button></td>
            </tr>
          </tbody>
        </table>
      </div>

    </article>
  </main>
</body>

</html>