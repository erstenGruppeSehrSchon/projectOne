$(function() {
	
	// Current advertisements
	$.ajax({
    	url: "getAdvertisementsByStatus",
    	dataType: 'json',
    	method: 'get',
    	data: {
    		status: "Accepted"
    	},
    	success: function(advertisements) {
    		//table use
    		var table = document.getElementById("acceptedAdvertisementTable");
    		for (var i=0; i<advertisements.length; i++) {
        		var tr = document.createElement("tr");
        		  
        		// Id
        		var tdInfo = document.createElement("td");
           		var idHidden = document.createElement("input");
           		idHidden.setAttribute("type", "hidden");
           		idHidden.setAttribute("value", advertisements[i].advId);
        		tdInfo.appendChild(idHidden);
        		
        		var tdImg = document.createElement("td");
        		var imgTag = document.createElement("img");
        		imgTag.setAttribute("src", advertisements[i].imgPath);
        		tdImg.appendChild(imgTag);
        		
        		var tdReject = document.createElement("td");
        		var rejectButton = document.createElement("button");
        		rejectButton.innerHTML = "Reject";
        		rejectButton.setAttribute("class", "btn btn btn-default");
        		rejectButton.onclick = function(event) {
        			var source = event.target || event.srcElement;
        			var id = source.parentNode.parentNode.childNodes[0].lastChild.value;
        			updateAdvertisementStatus(id, "Rejected");
        		};
        		tdReject.appendChild(rejectButton);
        		
	    		tr.appendChild(tdInfo);
	    		tr.appendChild(tdImg);
	    		tr.appendChild(tdReject);
	    		table.appendChild(tr);
    		}
    		
    		//slider
    		var slider = document.getElementById("sliderShow");
    		for (var i=0; i<advertisements.length; i++) {
    			var div = document.createElement("div");
    			if(i==0){
    				div.setAttribute("class","item active");
    			}else{
    				div.setAttribute("class","item");
    			}
    			var img = document.createElement("img");
    			img.setAttribute("src", advertisements[i].imgPath);
    			img.setAttribute("alt", "ads "+(i+1));
    			
    			div.appendChild(img);
    			slider.appendChild(div);
    		}

    		
    	},
    	error: function(xhr, status, error) {
    		alert("load fail");
    	}
    });
	
	// Pending advertisement
	$.ajax({
    	url: "getAdvertisementsByStatus",
    	dataType: 'json',
    	method: 'get',
    	data: {
    		status: "Pending"
    	},
    	success: function(advertisements) {

    		var table = document.getElementById("pendingAdvertisementTable");
    		for (var i=0; i<advertisements.length; i++) {
        		var tr = document.createElement("tr");
        		  
        		// Id
        		var tdInfo = document.createElement("td");
           		var idHidden = document.createElement("input");
           		idHidden.setAttribute("type", "hidden");
           		idHidden.setAttribute("value", advertisements[i].advId);
        		tdInfo.appendChild(idHidden);
        		
        		var tdImg = document.createElement("td");
        		var imgTag = document.createElement("img");
        		imgTag.setAttribute("src", advertisements[i].imgPath);
        		tdImg.appendChild(imgTag);
        		
        		var tdAccept = document.createElement("td");
        		var acceptButton = document.createElement("button");
        		acceptButton.innerHTML = "Accept";
        		acceptButton.setAttribute("class", "btn btn btn-default");
        		acceptButton.onclick = function(event) {
        			var source = event.target || event.srcElement;
        			var id = source.parentNode.parentNode.childNodes[0].lastChild.value;
        			updateAdvertisementStatus(id, "Accepted");
        		};
        		tdAccept.appendChild(acceptButton);
        		
        		var tdReject = document.createElement("td");
        		var rejectButton = document.createElement("button");
        		rejectButton.innerHTML = "Reject";
        		rejectButton.setAttribute("class", "btn btn btn-default");
        		rejectButton.onclick = function(event) {
        			var source = event.target || event.srcElement;
        			var id = source.parentNode.parentNode.childNodes[0].lastChild.value;
        			updateAdvertisementStatus(id, "Rejected");
        		};
        		tdReject.appendChild(rejectButton);
        		
	    		tr.appendChild(tdInfo);
	    		tr.appendChild(tdImg);
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

updateAdvertisementStatus = function(advertisementId, advertisementStatus) {
	$.ajax({
    	url: "updateAdvertisementStatus",
    	dataType: "json",
    	method: "post",
    	data: {
    		advId: advertisementId, 
    		status: advertisementStatus
    	},
    	success: function(merchant) {
    		location.reload();
    	},
    	error: function(xhr, status, error) {
    		alert("update fail");
    	}
	});
};


