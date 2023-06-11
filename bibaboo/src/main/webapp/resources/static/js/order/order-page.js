/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	
	totalInfo();
	doPay();
});


function totalInfo(){
	
	let sumCount =0;
	let sumPrice =0;
	
	let orderInfoTds = document.querySelectorAll(".order-info-td");
	orderInfoTds.forEach((element)=>{
		sumCount += Number(element.querySelector(".count-input").value);
		sumPrice += Number(element.querySelector(".price-input").value);
	});
	
	document.querySelector(".sum-count-span").innerText=sumCount;
	document.querySelector(".sum-price-span").innerText=sumPrice;
	document.querySelector(".sum-price-input").value=sumPrice;
	document.querySelector(".btn-sum-price-span").innerText=sumPrice;
}

function doPay(){
	
	let payButton = document.querySelector(".pay-btn");
	payButton.addEventListener("click",function(){
		
		let form = document.createElement("form");
		form.setAttribute("method","post");
		form.setAttribute("action","/bibaboo/order");
		
		let orderInfoTds = document.querySelectorAll(".order-info-td");
		orderInfoTds.forEach((element,index)=>{
			let categoryId = element.querySelector(".category-id-input").value;
			let count = element.querySelector(".count-input").value;
			let alterId = element.querySelector(".alter-id-input").value;
			let totalPrice = element.querySelector(".price-input").value;
			
			let categoryInput = document.createElement("input");
			categoryInput.setAttribute("type","hidden");
			categoryInput.setAttribute("name","orders["+index+"].categoryId");
			categoryInput.setAttribute("value",categoryId);
			
			let countInput = document.createElement("input");
			countInput.setAttribute("type","hidden");
			countInput.setAttribute("name","orders["+index+"].count");
			countInput.setAttribute("value",count);
			
			let alterIdInput = document.createElement("input");
			alterIdInput.setAttribute("type","hidden");
			alterIdInput.setAttribute("name","orders["+index+"].alterId");
			alterIdInput.setAttribute("value",alterId);
			
			let totalPriceInput = document.createElement("input");
			totalPriceInput.setAttribute("type","hidden");
			totalPriceInput.setAttribute("name","orders["+index+"].totalPrice");
			totalPriceInput.setAttribute("value",totalPrice);
			
			form.appendChild(categoryInput);
			form.appendChild(countInput);
			form.appendChild(alterIdInput);
			form.appendChild(totalPriceInput);
		});
		
		let payPrice = document.querySelector(".sum-price-input").value;
		
		let payPriceInput = document.createElement("input");
		payPriceInput.setAttribute("type","hidden");
		payPriceInput.setAttribute("name","payPrice");
		payPriceInput.setAttribute("value",payPrice);
		
		form.appendChild(payPriceInput);
		
		document.body.appendChild(form);
		form.submit();
		
	});
	
}