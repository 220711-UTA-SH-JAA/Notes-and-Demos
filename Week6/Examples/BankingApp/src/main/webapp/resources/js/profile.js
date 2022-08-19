//Have some function as soon as the window loads to laod the userdata from the server
//Immediately invoked function expressions, this is just an unnamed arrow function that will call itself as soon
//as the html loads

let user;
let accounts = [];

(async ()=> {
	let req = await fetch("http://localhost:8080/BankingApp/api/profile");
	
	user = await req.json();
	
	console.log("LoggedIn User: ", user);
	
	//We can append the welcome message
	document.getElementById("profile-welcome").innerText = `Welcome back ${user.firstName} ${user.lastName}`;
	
	updateAccountHtml();
})();

document.getElementById("new-account-btn").addEventListener("click", newAccount);

async function newAccount(){
	let type = document.getElementById("account-type").value;
	
	let newAccObj = {
		type
	}
	
	let req = await fetch("http://localhost:8080/BankingApp/api/account",{
		method: 'POST',
		body: JSON.stringify(newAccObj)
	});
	
	let res = await req.json();
	
	user.accounts.push(res);
	
	console.log(user);
	
	updateAccountHtml();
}

async function updateAccountHtml(){
	
	let req = await fetch("http://localhost:8080/BankingApp/api/accounts");
	
	accounts = await req.json();
	
	let accountList = document.getElementById("account-list");
	accountList.innerHTML = "";
	console.log(accountList);
	
	for(acc of accounts){
		let accountDiv = document.createElement("div");
		accountDiv.setAttribute("class", "account-item");
		
		// Appending the account number
		let accountNumber = document.createElement("h3");
		accountNumber.setAttribute("class", "account-num");
		accountNumber.innerText = acc.accountId;
		
		accountDiv.append(accountNumber);
		
		//Appending the account type
		let accountType = document.createElement("h3");
		accountType.setAttribute("class", "account-type");
		accountType.innerText = acc.type;
		
		accountDiv.append(accountType);
		
		//Appending the amount
		let accountAmount= document.createElement("h3");
		accountAmount.setAttribute("class", "account-amount");
		accountAmount.innerText = `$ ${acc.balance}`;
		
		accountDiv.append(accountAmount);
		
		accountList.append(accountDiv);
		console.log(acc);
	}
	
}

document.getElementById("show-transaction").addEventListener("click", displayTransaction);
document.getElementById("transaction-btn").addEventListener("click", makeTransaction);

function displayTransaction(){
	let transactionForm = document.getElementById("transaction-options");
	if(transactionForm.getAttribute("hidden")){
		transactionForm.removeAttribute("hidden");
	}else{
		transactionForm.setAttribute("hidden", true);
	}
}

async function makeTransaction(){
	
	let type = document.getElementById("transaction-type").value;
	let accountNumber = new String(document.getElementById("to-account").value);
	let amount = new String(document.getElementById("amount").value);
	let fromAccountNumber = new String(document.getElementById("from-account").value);
	
	console.log(type, accountNumber, amount, fromAccountNumber);
	
	if(type === 'DEPOSIT'){
		let req = await fetch("http://localhost:8080/BankingApp/api/deposit", {
			method: 'POST',
			body: JSON.stringify({
				accountNumber,
    			amount
			})
		});
		
		let res = await req.json();
		
		console.log(res);
	}
	
	if(type === 'WITHDRAW'){
		let req = await fetch("http://localhost:8080/BankingApp/api/withdraw", {
			method: 'POST',
			body: JSON.stringify({
				accountNumber,
    			amount
			})
		});
		
		let res = await req.json();
		
		console.log(res);
	}
	
	if(type === 'TRANSFER'){
		let req = await fetch("http://localhost:8080/BankingApp/api/transfer", {
			method: 'POST',
			body: JSON.stringify({
				to: accountNumber,
				from: fromAccountNumber,
    			amount
			})
		});
		
		let res = await req.json();
		
		console.log(res);
	}
	
	updateAccountHtml();
	
}
