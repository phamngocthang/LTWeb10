src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		window.onload = function() {
		  disableBtnSubAmount();
		};
		function disableBtnSubAmount() {
			var AmountInput = document.querySelectorAll('#valueAmount');
			var btnSubAmount = document.querySelectorAll('#btnSubAmount');
			var valueAmount;
			for(var i = 0; i < AmountInput.length; i++)
			{
				if(AmountInput[i] != null) {
					valueAmount = AmountInput[i].value;
					if(valueAmount == 1) {
						btnSubAmount[i].setAttribute('disabled', true);
					}
				}
				else {
					valueAmount = null;
				}
			}
		}
		
		var timeoutId;
		function showMessage(message, time) {
			var thongBao = document.querySelector('#thongBao');
					clearTimeout(timeoutId);
	                thongBao.style.display = "block";
	                thongBao.innerText=message;
	                timeoutId = setTimeout(() => {
						thongBao.style.display = "none";
					}, time)
		}
	    function AddCartAjax(pID, status){
			if(status == 0) {
				showMessage("Sản phẩm đã hết hàng! ", 3000);
				return;
			}﻿
	        $.ajax({
	            url: location.origin + "/AddCartAjax",
	            type: "get", //send it through get method
	            data: {
	            	productID: pID
	            },
	            success: function (data, status) {
	                var row = document.getElementById("amountcart");
	                const value = parseInt(row.innerText);
	                const dataValue = parseInt(data);
	                if(value === dataValue) {
						showMessage("Đã tăng số lượng sản phẩm! ", 3000)
					}
					else{
						showMessage("Đã thêm sản phẩm vào giỏ hàng! ", 3000)
					}
	                row.innerText = data;
	                
	            },
	            error: function (xhr) {
	                //Do Something to handle error
	            }
	        });
	    }
	    function AddFavoriteProductAjax(pID){﻿
	        $.ajax({
	            url: location.origin + "/addFavoriteProduct",
	            type: "get", //send it through get method
	            data: {
	            	productID: pID
	            },
	            success: function (data) {
	                var row = document.getElementById("amountfproduct");
	                
	                const value = parseInt(row.innerText);
	                
					row.innerText = data;
					const dataValue = parseInt(row.innerText);
	                if(value === dataValue) {
						showMessage("Sản phẩm này đã tồn tại trong mục yêu thích! ", 3000)
					}
					else{
						showMessage("Đã thích! ", 3000)
					}
	            },
	            error: function () {
	            }
	        });
	    }
	    function EditCart(pID, isSub, amount){﻿
	    
		    $.ajax({
		        url: location.origin + "/EditCart",
		        type: "get", //send it through get method
		        data: {
		        	//message: document.getElementById("message").value,
		        	productID: pID,
		        	isSub: isSub,
		        	amount: amount
		        },
		        success: function (data) {
					
					var ShoppingCart = document.getElementById("ShoppingCart");
					ShoppingCart.innerHTML = data;
					if(isSub == true) {
						showMessage("Giảm số lượng sản phẩm thành công! ", 3000)
					}
					else {
						showMessage("Tăng số lượng sản phẩm thành công! ", 3000)
					}
					disableBtnSubAmount();
		        },
		        error: function (xhr) {
		            //Do Something to handle error
		        }
		    });
		}
		function DeleteCart(pID){﻿
	    
		    $.ajax({
		        url: location.origin + "/deleteCart",
		        type: "get", //send it through get method
		        data: {
		        	//message: document.getElementById("message").value,
		        	productID: pID
		        },
		        success: function (data) {
					var amount = document.getElementById("amountcart");
					amount.innerHTML = data.slice(0, data.indexOf("<div"));
					
					var ShoppingCart = document.getElementById("ShoppingCart");
					ShoppingCart.innerHTML = data.slice(data.indexOf("<div"));
					
					
					showMessage("Xóa sản phẩm thành công! ", 3000);
					disableBtnSubAmount();
		        },
		        error: function (xhr) {
		            //Do Something to handle error
		        }
		    });
		}

		function DelFavoriteProductAjax(pID){﻿
	        $.ajax({
	            url: location.origin + "/deleteFavoriteProduct",
	            type: "get", //send it through get method
	            data: {
	            	productID: pID
	            },
	            success: function (data) {
					
					var amount = document.getElementById("amountfproduct");
					amount.innerText = data.slice(0, data.indexOf("<div"));
					
					var listFavorite = document.getElementById("listFavorite");
					listFavorite.innerHTML = data.slice(data.indexOf("<div"));
					
					
					showMessage("Đã xóa sản phẩm ra khỏi mục yêu thích! ", 3000)
	            },
	            error: function () {
	            }
	        });
	    }
	    
	   	function AddReviews(pID){﻿
	    
		    $.ajax({
		        url: location.origin + "/AddReviews",
		        type: "get", //send it through get method
		        data: {
		        	//message: document.getElementById("message").value,
		        	message: $("#message").val(),
		        	productID: pID
		        },
		        success: function (data) {
		            var row = document.getElementById("reviews");
		            row.innerHTML += $(data).filter('#testrv').html();
		            document.querySelector('#message').value = ""
		        },
		        error: function (xhr) {
		            //Do Something to handle error
		        }
		    });
		}