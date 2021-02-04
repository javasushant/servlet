/**
 * 
 */

/**
 * 
 */
/**
 * 
 */

function validate(frm){
	//read form data
	alert("Client side");
	document.getElementById("nameErr").innerHTML = "";
	document.getElementById("ageErr").innerHTML = "";
	
	
	let name = frm.pname.value;
	let age = frm.page.value;
	let flag = true;
	
	// client side form validation logic
	if(name==""){  // required rules
	//	document.getElementById("nameErr").innerHTML = "<i>Person name is required<i>";
	//	document.getElementById("nameErr").innerText = "<i>Person name is required<i>";
	//	document.getElementById("nameErr").outerHTML = "<i>Person name is required<i>";
		document.getElementById("nameErr").outerText = "<i>Person name is required<i>";
		frm.pname.focus();  // text box gains the focus
		flag=false
	}
	else if(name.length<4){ // min length
		document.getElementById("nameErr").innerHTML = "Person name must be 5 character";
		frm.pname.focus();   // text box gains the focus
		flag = false;
	}
	if(age==""){
		document.getElementById("ageErr").innerHTML = "Person age is required";
		frm.page.focus();  // text box gains the focus
		flag = false;
	}
	else if(isNaN(age)){  // not a number
		document.getElementById("ageErr").innerHTML = "Enter numeric digit";
		frm.page.focus();  // text box gains the focus
		flag = false;
	}
	else if(age<1 || age>125){  // digit between 1 to 125 
		document.getElementById("ageErr").innerHTML = "Person age must be in the 1 to 125";
		frm.page.focus();  // text box gains the focus
		flag = false;
	}
		frm.vFlag.value = "yes";
	return flag;
}//function