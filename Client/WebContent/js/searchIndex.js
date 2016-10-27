$(function() {
	$("#searchResultBox").hide();
});

search = function() {
	var resultTable = document.getElementById("resultTable");
	while (resultTable.childNodes.length > 2) {
		resultTable.removeChild(resultTable.childNodes[2]);
	}
	
	$.ajax({
    	url: "getShopsByCriteria",
    	dataType: "json",
    	method: "get",
    	data: {
    		name: document.getElementById("name").value,
    		type: document.getElementById("type").value,
			address: document.getElementById("address").value
    	},
    	success: function(shops) {
    		
    		if (shops.length > 0) {
	    		var resultTable = document.getElementById("resultTable");
	    		
	    		for (var i=0; i<shops.length; i++) {
	    			var tr = document.createElement("tr");
	    			var td = document.createElement("td");
	    			var img = document.createElement("img");
	    			img.src = shops[i].imgPath;
	    			img.onclick = function() {
	    				location.href = "getShopsBySid?sid=" + shops[i].sid;
	    			};
	    			
	    			var namePar = document.createElement("p");
	    			namePar.innerHTML = shops[i].name;
	    			var typePar = document.createElement("p");
	    			typePar.innerHTML = shops[i].type;
	    			var addressPar = document.createElement("p");
	    			addressPar.innerHTML = shops[i].shopContact.address;
	    			
	    			td.appendChild(img);
	    			td.appendChild(namePar);
	    			td.appendChild(typePar);
	    			td.appendChild(addressPar);
	    			tr.appendChild(td);
	    			resultTable.appendChild(tr);
	    		}
	    		
	    		//$("#searchResultBox").toggle(true);
	    		$("#searchResultBox").show();
    		} else {
	    		$("#searchResultBox").toggle(false);
    		}
    	}
	});
}