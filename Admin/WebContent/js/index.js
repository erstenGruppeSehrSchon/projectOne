$(function() {
	$.ajax({
    	url: "getMerchantsByCriteria",
    	dataType: 'json',
    	method: 'get',
    	data: {
    		status: "Pending"
    	},
    	success: function(merchants) {

    		var table = document.getElementById("outstandingTable");
    		for (var i=0; i<merchants.length; i++) {
        		var tr = document.createElement("tr");
        		  
        		// Name and id
        		var tdInfo = document.createElement("td");
        		var spanName = document.createElement("span");
        		spanName.innerHTML = merchants[i].name;
           		var idHidden = document.createElement("input");
           		idHidden.setAttribute("type", "hidden");
           		idHidden.setAttribute("value", merchants[i].mid);
        		tdInfo.appendChild(spanName);
        		tdInfo.appendChild(idHidden);
        		
        		var tdAccept = document.createElement("td");
        		var acceptButton = document.createElement("button");
        		acceptButton.innerHTML = "Accept";
        		acceptButton.onclick = function(event) {
        			var source = event.target || event.srcElement;
        			var id = source.parentNode.parentNode.childNodes[0].lastChild.value;
        			updateMerchantStatus(id, "Accepted");
        		};
        		tdAccept.appendChild(acceptButton);
        		
        		var tdReject = document.createElement("td");
        		var rejectButton = document.createElement("button");
        		rejectButton.innerHTML = "Reject";
        		rejectButton.onclick = function(event) {
        			var source = event.target || event.srcElement;
        			var id = source.parentNode.parentNode.childNodes[0].lastChild.value;
        			updateMerchantStatus(id, "Rejected");
        		};
        		tdReject.appendChild(rejectButton);
        	
        		
	    		tr.appendChild(tdInfo);
	    		tr.appendChild(tdAccept);
	    		tr.appendChild(tdReject);
	    		table.appendChild(tr);
    		}

    		
    	},
    	error: function(xhr, status, error) {
    		alert("load fail");
    	}
    });
});

updateMerchantStatus = function(merchantId, merchantStatus) {
	$.ajax({
    	url: "updateMerchantStatus",
    	dataType: "json",
    	method: "post",
    	data: {
    		mid: merchantId, 
    		status: merchantStatus
    	},
    	success: function(merchant) {
    		location.reload();
    	},
    	error: function(xhr, status, error) {
    		alert("update fail");
    	}
	});
}


