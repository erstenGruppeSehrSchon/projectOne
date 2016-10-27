getShopsAndDishes = function(merchantId) {
	// Ajax to request shops and dishes
	$.ajax({
    	url: "getMerchantByMid",
    	dataType: "json",
    	method: "get",
    	data: {
    		mid: merchantId
    	},
    	success: function(merchant) {
    		if (merchant.shops.length > 0) {
	    		var dishRow = document.getElementById("dishRow");
	    		
	    		for (var i=0; i<merchant.shops.length; i++) {
	    			for (var j=0; j<merchant.shops[i].dishes.length; j++) {
		    			var td = document.createElement("td");
		    			
		    			var a = document.createElement("a");
		    			a.href = "showDishDetailPage?did=" + merchant.shops[i].dishes[j].did;
		    			
		    			var img = document.createElement("img");
		    			if (merchant.shops[i].dishes[j].dishImages.length > 0)
		    			img.src = merchant.shops[i].dishes[j].dishImages[0].imgPath;

		    			var shopNamePar = document.createElement("p");
		    			shopNamePar.innerHTML = merchant.shops[i].name;
		    			var dishNamePar = document.createElement("p");
		    			dishNamePar.innerHTML = merchant.shops[i].dishes[j].name;

		    			
		    			a.appendChild(img);
		    			a.appendChild(shopNamePar);
		    			a.appendChild(dishNamePar);
		    			td.appendChild(a);
		    			dishRow.appendChild(td);
	    			}
	    		}
    		}
    	}
	});
}