src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		
	    function AddCartAjax(pID){﻿
	        $.ajax({
	            url: location.origin + "/WebApp/AddCartAjax",
	            type: "get", //send it through get method
	            data: {
	            	productID: pID
	            },
	            success: function (data) {
	                var row = document.getElementById("amountcart");
	                row.innerHTML = data;
	            },
	            error: function (xhr) {
	                //Do Something to handle error
	            }
	        });
	    }
	    function AddFavoriteProductAjax(pID){﻿
	        $.ajax({
	            url: location.origin + "/WebApp/addFavoriteProduct",
	            type: "get", //send it through get method
	            data: {
	            	productID: pID
	            },
	            success: function (data) {
	                var row = document.getElementById("amountfproduct");
	                row.innerHTML = data;
	            },
	            error: function () {
	            }
	        });
	    }
	    
	   	function AddReviews(pID){﻿
	    
		    $.ajax({
		        url: location.origin + "/WebApp/AddReviews",
		        type: "get", //send it through get method
		        data: {
		        	//message: document.getElementById("message").value,
		        	message: $("#message").val(),
		        	productID: pID
		        },
		        success: function (data) {
		            var row = document.getElementById("reviews");
		            row.innerHTML += data;
		        },
		        error: function (xhr) {
		            //Do Something to handle error
		        }
		    });
		}
