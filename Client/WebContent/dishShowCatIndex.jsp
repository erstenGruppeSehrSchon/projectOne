<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -Customer System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp" />
<!--*********container*********-->
<div class="container">
<jsp:include page="menu.jsp" />

	
	<!--*********Recommended dish*********--> <!-- THREE IN ONE LINK -->
	<div class="recommendDish">
	<!-- Please detect the below title -->
		<h3 class="h3_title_index">- Recommended ** -</h3>

			
        <div id="dishList"></div>
		
		
	</div>
</div>




<script>
$(function(){
    window.onload = function(){
        loadShop();
    };
});

function loadShop (){
	
	   document.getElementById("dishList").innerHTML = '';
	
	
       var criteria = ${param.criteria};
       console.log(criteria.id);
       $.ajax({
    	   type:'GET',
    	   url:'getDishesByCriteria',
    	   data:{type:criteria.id},
    	   success: function(Dishlist){
    		      console.log(Dishlist);
    		      console.log(Dishlist[0].name);
    		   	  if(Dishlist){
    			  
    				  var tableOP = $('<table>');
                      $(tableOP).appendTo('#dishList');
                      
                      $.each(Dishlist, function(index, value){
                    	  
                    	                   
                          // open of new row
                          if(index % 3 == 0){
                              var rowOP = $('<tr>');
                              $(rowOP).appendTo('#dishList'); 
                          }
                          
                          
						  var did =  Dishlist[index].did;
                          var name = Dishlist[index].name;
                          var type = Dishlist[index].type;
                          var price = Dishlist[index].price;
                          var description = Dishlist[index].description;
                          var img = Dishlist[index].dishImages[0].imgPath;
                          
                          

                          var shopInfo = $('<td><a href="./dishDetails.jsp?did='+ did+ '"><img src="'+ img +'" title= "'+ name +'" id= "' + did + '"   /></br><p>'+name+'</p></a></td>');
                          $(shopInfo).appendTo('#dishList');

                          // end of new row
                          if(index % 3 == 0){
                              var rowEn = $('</tr>');
                              $(rowEn).appendTo('#dishList');
                          }
                      });
                      
                      var tableEn = $('</table>');
                      $(tableEn).appendTo('#dishList');
                      
    		   	  }else{
                      var noShop = $('<p>No Dishes Show</p>');
                      $(noShop).appendTo('#dishList');
                  }
 		   
    	   },
    	   error:function(){
    		   console.log("Error");
    	   }
       });
       
};

</script>
</body>






</html>