let usernameElement = document.getElementById("username");
let passwordElement = document.getElementById("password");
let submitBtn = document.getElementById("submit-btn");
let errorMessage = document.getElementById("login-error");
submitBtn.addEventListener("click", login);

async function login() {
	
	errorMessage.innerText = "";
	
	console.log("We handled the click event of the submit button");
	//Lets get the username from the form field
	let username = usernameElement.value;
	//Lets get the password from the form field
	let password = passwordElement.value;
	
	let loginObj = {
		username,
		password
	}
	
	console.log("Ready to login: ", loginObj);
	
	try{
		//If the request is successful all is well, if it fails/returns !200 it will be in the catch
		let req = await fetch("http://localhost:8080/BankingApp/api/login", {
			method: 'POST',
			headers: {'Content-type': 'application/json'},
			body: JSON.stringify(loginObj)
		});
		
		let res = await req.json();
		
		console.log("push user to the next page");
		console.log(res);
		window.location.href = "./profile.html";
		
	} catch(e){
		errorMessage.innerText = "Username or password incorrect";
		console.log("The user did not login sucessfully");
		console.log(e);
	}
	
	
	
}


