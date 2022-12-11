<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
              <p class='text-3xl'>${sumBill} VNĐ</p>
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
        
        
        <div class='pb-4' styles="margin-top: 50px;">
          <!-- Section: Main chart 2 -->
		    <section class="mb-4" id="doanhThuThang">
		      <div class="card" id="none-border">
		        <h3 class="text-center text-danger" style="margin-bottom: 40px;">Doanh Thu Theo Tháng</h3>
		        <div class="card-body">
		          <canvas id="horizontalBar"></canvas>
		        </div>
		      </div>
		    </section>
	    <!-- Section: Main chart 2 -->
      </div>
      
      <div class="panel panel-default">
      <div class="panel-body">
      <div class="tab-content">
      <div class="tab-pane active" id="profile">
      <h3 class="text-center text-danger" style="margin-bottom: 40px;">Thống Kê Số Lượng Bán Theo Loại</h3>
      <div id="thongke_sinhvien_area">
      <div id="thongke_sinhvien_area">
			      <div class="row">
			        <div class="col-md-7" style="text-align: center!important;">
			            <canvas class="img-responsive" id="canvas_sv" height="400" width="400" style="width: 320px; height: 320px;"></canvas>
			            
			        </div>
			        <div class="col-md-5">
			            <div class="panel panel-default">
			                <div class="panel-heading">
			                    <h4>Chú thích</h4>
			                </div>
			                <a href="javascript:void();" class="list-group-item">Giày Sandals Nam  <span class="badge" id="sandals-nam" style="background-color: #2ecc71;">${listSL[0]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Lười Nam  <span class="badge" id="luoi-nam" style="background-color: #e74c3c;">${listSL[1]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Sneaker Nam  <span class="badge" id="sneaker-nam" style="background-color: #8e44ad;">${listSL[2]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Thể Thao Nam  <span class="badge" id="thethao-nam" style="background-color: #f39c12;">${listSL[3]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Cao Gót Nữ  <span class="badge" id="caogot" style="background-color: #dee2e6;">${listSL[4]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Sneaker Nữ  <span class="badge" id="sneaker-nu" style="background-color: yellow;">${listSL[5]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Thể Thao Nữ  <span class="badge" id="thethao-nu" style="background-color: violet;">${listSL[6]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Giày Đế Bệ Nữ  <span class="badge" id="debe-nu" style="background-color: blue;">${listSL[7]}</span></a>
			                <a href="javascript:void();" class="list-group-item">Tổng Cộng  <span class="badge" id="total">${total }</span></a>
			            </div>
			        </div>
			    </div>
	</div>
	</div>
	</div>
    </div>
    </div>
    </div>
      
      </article>
     </main>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!--Main layout-->
<!-- SCRIPTS -->
  <!-- JQuery -->
  <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
    <!-- MDB Ecommerce JavaScript -->
    <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
 <!-- MDB -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript" src="js/script.js"></script>
    <script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>s
<script>// Graph
  //Horizontal Bar Chart
   new Chart(document.getElementById("horizontalBar"), {
"type": "horizontalBar",
"data": {
"labels": ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
"datasets": [{
"label": "Doanh thu $",
"data": [${listBillInMon[0]}, ${listBillInMon[1]}, ${listBillInMon[2]}, ${listBillInMon[3]}, ${listBillInMon[4]}, ${listBillInMon[5]}, ${listBillInMon[6]}, ${listBillInMon[7]}, ${listBillInMon[8]}, ${listBillInMon[9]}, ${listBillInMon[10]}, ${listBillInMon[11]}],
"fill": false,
"backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)",
"rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)",
"rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)", "#99FF99", "#FFFF99", "#FFC1C1", "#FFB5C5", "#DDC488"
],
"borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)",
"rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)", "	#66FF99", "#FFFF66", "#EEB4B4", "#EEA9B8", "#ECAB53"
],
"borderWidth": 1
}]
},
"options": {
"scales": {
"xAxes": [{
"ticks": {
"beginAtZero": true
}
}]
}
}
});
</script>
<script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>


<script type="text/javascript" src="js/Chart.js"></script>
<script>
	var sandals1 = document.getElementById('sandals-nam').innerText;
	var luoinam = document.getElementById('luoi-nam').innerText;
	var sneaker1 = document.getElementById('sneaker-nam').innerText;
	var thethao1 = document.getElementById('thethao-nam').innerText;
	var caogot = document.getElementById('caogot').innerText;
	var sneaker2 = document.getElementById('sneaker-nu').innerText;
	var thethao2 = document.getElementById('thethao-nu').innerText;
	var debe = document.getElementById('debe-nu').innerText;
	var total = document.getElementById('total').innerText;
	var pieData = [
	        {
	            value: parseInt(sandals1)*100/parseInt(total),
	            color: "#2ecc71",
	            label: Math.round(parseInt(sandals1)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(luoinam)*100/parseInt(total).toFixed(),
	            color: "#e74c3c",
	            label: Math.round(parseInt(luoinam)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(sneaker1)*100/parseInt(total).toFixed(),
	            color: "#8e44ad",
	            label: Math.round(parseInt(sneaker1)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(thethao1)*100/parseInt(total).toFixed(),
	            color: "#f39c12",
	            label: Math.round(parseInt(thethao1)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(caogot)*100/parseInt(total).toFixed(),
	            color: "#dee2e6",
	            label: Math.round(parseInt(caogot)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(sneaker2)*100/parseInt(total).toFixed(),
	            color: "yellow",
	            label: Math.round(parseInt(sneaker2)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(thethao2)*100/parseInt(total).toFixed(),
	            color: "violet",
	            label: Math.round(parseInt(thethao2)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	        {
	            value: parseInt(debe)*100/parseInt(total).toFixed(),
	            color: "blue",
	            label: Math.round(parseInt(debe)*100/parseInt(total)) + '%',
	            labelColor: 'white',
	            labelFontSize: '100%',
	            labelAlign: 'center',
	        },
	
	];
	var options = {
	    tooltips: {
	        fontSize: '75.4%'
	    }
	};
	var myChart = new Chart(document.getElementById("canvas_sv").getContext("2d"), options);
	var myPie = myChart.Pie(pieData, {
	    animationSteps: 100,
	    animationEasing: 'easeOutBounce'
	});
	

  </script>
  
<script type="text/javascript" src="js/Chart.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
  </html>