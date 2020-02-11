var emailpattern = "/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/";
$(document).ready(function () {
	$("#error").css("color", "red");
	 $('#dob').datepicker();
	$("#udetails" ).submit(function( event ) {
		event.preventDefault();
		validations();
//		insertUserDetails();
	});  
});

function validations(){
	if($('#firstName').val()==="" || $('#firstName').val()===null)
		{
			$('#error').html("Enter first name !!");
		}else if($('#lastName').val()==="" || $('#lastName').val()===null){
			$('#error').html("Enter last name!!");
		}else if($('#email').val()==="" || $('#email').val()===null){			
			$('#error').html("Enter email id!!");
		}else if(!($('#email').val().match(emailpattern))){
				$('#error').html("You have entered an invalid email address!!");
		}else{
			$('#error').html("");
			insertUserDetails();
		}
}


function insertUserDetails(){
    var pCode = {
    		firstName:$('#firstName').val(),
    		lastName:$('#lastName').val(),
    		email:$('#email').val()
    };
    alert(JSON.stringify(pCode));
    $.ajax({
        type: "POST",
        contentType: 'application/json',
//        url: 'userform/tteesst',
        dataType: 'json',
        data: JSON.stringify(pCode),
        success: function (response) {
        	alert(JSON.stringify(response));
            addOptions('#clRecveryMode', response);
        },
        error: function (error) {
        	alert(JSON.stringify(error));
        	console.log("Error :" + error);
            alert("Error :" + error);
        }
    });
}