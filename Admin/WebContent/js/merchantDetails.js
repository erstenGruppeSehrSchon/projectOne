createAcceptButton = function(merchantId) {
	var acceptButton = document.createElement("button");
	acceptButton.innerHTML = "Accept";
	acceptButton.onclick = function() {
		updateMerchantStatus(merchantId, "Accepted");
	};
	return acceptButton;
}

createRejectButton = function(merchantId) {
	var rejectButton = document.createElement("button");
	rejectButton.innerHTML = "Reject";
	rejectButton.onclick = function() {
		updateMerchantStatus(merchantId, "Rejected");
	};
	return rejectButton;
}

createBacklistButton = function(merchantId) {
	var backlistButton = document.createElement("button");
	backlistButton.innerHTML = "Backlist";
	backlistButton.onclick = function() {
		updateMerchantStatus(merchantId, "Frozen");
	};
	return backlistButton;
}

createResumeButton = function(merchantId) {
	var resumeButton = document.createElement("button");
	resumeButton.innerHTML = "Resume";
	resumeButton.onclick = function() {
		updateMerchantStatus(merchantId, "Accepted");
	};
	return resumeButton;
}

updateMerchantStatus = function(merchantId, merchantStatus) {
	$.ajax({
    	url: "updateMerchantStatus",
    	dataType: 'json',
    	method: 'post',
    	data: {
    		mid: merchantId, 
    		status: merchantStatus
    	},
    	success: function(merchant) {
    		// Update current status
    		var statusCol = document.getElementById("statusCol");
    		statusCol.innerHTML = merchant.status;
    		
    		// Update available buttons
    		createButtons(merchant.mid, merchant.status);
    	},
    	error: function(xhr, status, error) {
    		alert("update fail");
    	}
	});
}

createButtons = function(merchantId, merchantStatus) {
	var actionCol = document.getElementById("actionCol");
	while (actionCol.firstChild) {
		actionCol.removeChild(actionCol.firstChild);
	}
	
	if (merchantStatus == 'Accepted') {
		var backlistButton = createBacklistButton(merchantId);
		actionCol.appendChild(backlistButton);
	} else if (merchantStatus == 'Pending') {
		var acceptButton = createAcceptButton(merchantId);
		var rejectButton = createRejectButton(merchantId);
		actionCol.appendChild(acceptButton);
		actionCol.appendChild(rejectButton);
	} else if (merchantStatus == 'Frozen') {
		var resumeButton = createResumeButton(merchantId);
		actionCol.appendChild(resumeButton);
	} else if (merchantStatus == 'Rejected') {
		var acceptButton = createAcceptButton(merchantId);
		actionCol.appendChild(acceptButton);
	}
}