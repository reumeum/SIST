window.onload = function () {
	const myForm = document.getElementById("myForm");
	
	myForm.onsubmit = function () {
		const inputFields = document.querySelectorAll('input[type="text"], input[type="number"]');
		
		for (let i=0; i < inputFields.length; i++) {
			if (inputFields[i].value.trim() == "") {
				const label = document.querySelector('label[for="'+ inputFields[i].id +'"');
				
				alert(label.textContent + " 항목은 필수 입력");
				inputFields[i].value = "";
				inputFields[i].focus();
				return false;
			}
		}
	}
}