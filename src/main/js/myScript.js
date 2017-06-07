function whenLoading() {
	//alert("here");
   var textarea=document.getElementById("textarea");
   textarea.placeholder="Enter text here...";
}

function FormSubmitted() {
	var d=document.getElementById("div2");
	d.style.display = "none"; 
	var div=document.getElementById("div3");
	div.style.display = "block";
	//div.innerHTML="Processing...";
	var t=document.createTextNode("Processing...");

	//p.appendChild(t);
	div.appendChild(t);

/*
	var my_form=document.createElement("Form");
	my_form.name='myForm';
	my_form.method='POST';
	my_form.action='../php/new_action.php';
	var sub=document.createElement("Input");
	sub.type="Submit";
	sub.value="View Results";
	my_form.appendChild(sub);
	div.appendChild(my_form);*/

}