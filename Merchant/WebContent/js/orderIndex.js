getOrders = function(shopId, shopName) {
	
	$.ajax({
	   	url: "getOrdersBySid",
    	dataType: "json",
    	method: "get",
    	data: {
    		sid: shopId
    	},
    	success: function(orders) {
    		var orderTable = document.getElementById("orderTable");
    		
    		for (var i=0; i<orders.length; i++) {
	    		var tr = document.createElement("tr");
	    		
	    		var orderInfoCol = document.createElement("td");
	    		// Order ID
	    		var oidLabelPar = document.createElement("p");
	    		oidLabelPar.innerHTML = "<b>Order Id:</b>";
	    		var oidPar = document.createElement("p");
	    		oidPar.innerHTML = orders[i].oid;
	    		orderInfoCol.appendChild(oidLabelPar);
	    		orderInfoCol.appendChild(oidPar);
	    		// Order Time
	    		var orderTimeLabelPar = document.createElement("p");
	    		orderTimeLabelPar.innerHTML = "<b>Order Time:</b>";
	    		var orderTimePar = document.createElement("p");
	    		orderTimePar.innerHTML = orders[i].orderTime;
	    		orderInfoCol.appendChild(orderTimeLabelPar);
	    		orderInfoCol.appendChild(orderTimePar);
	    		
	    		// Dish detail
	    		var dishDetailCol = document.createElement("td");
	    		var shopNameLabelPar = document.createElement("p");
	    		shopNameLabelPar.innerHTML = "<b>Shop Name:</b>";
	    		var shopNamePar = document.createElement("p");
	    		shopNamePar.innerHTML = shopName;
	    		dishDetailCol.appendChild(shopNameLabelPar);
	    		dishDetailCol.appendChild(shopNamePar);
	    	
	    		// Dishes
	    		var totalPrice = 0;
	    		for (var j=0; j<orders[i].orderDetails.length; j++) {
	    			var dishLabelPar = document.craeteElement("p");
	    			dishLabelPar.innerHTML = "<b>Dish:</b>";
	    			var dishPar = document.createElement("p");
	    			dishPar.innerHTML = orders[i].orderDetails[j].dish.name + " " + orders[i].orderDetails[j].quantity;
	    			dishDetailCol.appendChild(dishLabelPar);
	    			dishDetailCol.appendChil(dishPar);
	    			totalPrice = totalPrice + (orders[i].orderDetails[j].quantity * orders[i].orderDetails[j].dish.price);
	    		}
	    		
	    		// Append total to orderInfoCol
	    		var priceLabelPar = document.createElement("p");
	    		priceLabelPar.innerHTML = "<b>Total Price:</b>";
	    		var pricePar = document.createElement("p");
	    		pricePar.innerHTML = totalPrice;
	    		orderInfoCol.appendChild(priceLabelPar);
	    		orderInfoCol.appendChild(pricePar);
	    		
	    		// Create button
	    		var buttonRow = document.createElement("tr");
	    		var tdDum = document.createElement("td");
	    		var buttonCol = document.createElement("td");
	    		buttonCol.appendChild(createRejectButton(orders[i].oid));
	    		buttonCol.appendChild(createAcceptButton(orders[i].oid));
	    		buttonCol.appendChild(createDeliverButton(orders[i].oid));
	    		buttonRow.appendChild(tdDum);
	    		buttonRow.appendChild(buttonCol);
	    		
	    		// Append to table
	    		tr.appendChild(orderInfoCol);
	    		tr.appendChild(dishDetailCol);
	    		orderTable.appendChild(tr);
	    		orderTable.appendChild(buttonRow);
    		}
    	}
	});
}

createRejectButton = function(orderId) {
	var rejectButton = document.createElement("button");
	rejectButton.onclick = function() {
		updateOrderStatus(orderId, "Rejected");
	};
	rejectButton.innerHTML = "Rejected";
	return rejectButton;
}

createAcceptButton = function(orderId) {
	var acceptButton = document.createElement("button");
	acceptButton.onclick = function() {
		updateOrderStatus(orderId, "Accepted");
	};
	acceptButton.innerHTML = "Accepted";
	return acceptButton;
}

createDeliverButton = function(orderId) {
	var deliverButton = document.createElement("button");
	deliverButton.onclick = function() {
		updateOrderStatus(orderId, "Delivered");
	};
	deliverButton.innerHTML = "Deliver";
	return deliverButton;
}

updateOrderStatus = function(orderId, updateStatus) {
	$.ajax({
	   	url: "updateOrderStatus",
    	dataType: "json",
    	method: "post",
    	data: {
    		oid: orderId,
    		status: updateStatus
    	},
    	success: function(isUpdated) {
    		if (isUpdated) {
    			href.location("showOrderIndexPage");
    		}
    		alert("fail");
    	}
	});
}