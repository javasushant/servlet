/**
 * 
 */

function validate(frm){
	//read form data
	let name = frm.pname.value;
	let age = frm.page.value;
	let flag = true;
	
	// client side form validation logic
	if(name==""){  // required rules
		alert("Person name is required");
		frm.pname.focus();  // text box gains the focus
		flag=false
	}
	else if(name.length<4){ // min length
		alert(" person name must be atleast 5 character");
		frm.pname.focus();
		flag = false;
	}
	if(age==""){
		alert("Person age is required");
		frm.page.focus();
		flag = false;
	}
	else if(isNaN(age)){
		alert("Person Age is not a number");
		frm.page.focus();
		flag = false;
	}
	else if(age<1 || age>125){
		alert("Person age must be between 1 to 125");
		frm.page.focus();
		flag = false;
	}
		
	return flag;
}//function