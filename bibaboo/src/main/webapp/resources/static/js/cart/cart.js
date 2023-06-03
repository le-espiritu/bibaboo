/**
 * 
 */
//제이쿼리의 $(document).ready(function(){}); 과 동일 
document.addEventListener("DOMContentLoaded",function(){
	console.log('로딩이 완료되었습니다.');
	
	totalInfo();
	doButtons();
	countModify();
	deleteCart();
});

function totalInfo(){
	
	let sumPrice = 0;
	let sumCount = 0;
	
	document.querySelectorAll(".cart-info-tr").forEach((element)=>{
		sumPrice += Number(element.querySelector(".total-price-td").innerText);
		//sumCount += Number(element.querySelector(".count-td").innerText);
		sumCount += Number(element.querySelector(".count-input").value);
	});
	
	document.querySelector(".sum-count-span").innerText=sumCount;
	document.querySelector(".sum-price-span").innerText=sumPrice;
};

function doButtons(){
	let minusBtns = document.querySelectorAll(".minus-btn");
	minusBtns.forEach((element)=>{
		element.addEventListener("click",function(){
			let countValue = element.parentElement.querySelector(".count-input").value;
			if(countValue > 1){
				element.parentElement.querySelector(".count-input").value = --countValue;
			}
			
		});
	});
	
	let plusBtns = document.querySelectorAll(".plus-btn");
	plusBtns.forEach((element)=>{
		element.addEventListener("click",function(){
			let countValue= element.parentElement.querySelector(".count-input").value;
			element.parentElement.querySelector(".count-input").value=++countValue;
		});
	});
};

function countModify(){
	let modifyBtns = document.querySelectorAll(".modify-btn");
	modifyBtns.forEach((element)=>{
		element.addEventListener("click",function(){
			let form={
				id : element.parentElement.parentElement.querySelector(".cart-id").value,
				userId : element.parentElement.parentElement.querySelector(".cart-user-id").value,
				count : element.parentElement.querySelector(".count-input").value
			}
			
			//AJAX
			let xhr = new XMLHttpRequest();
			xhr.addEventListener("load",function(){
				if(xhr.status == 200){
					alert("수량이 변경되었습니다.");
					location.href="/bibaboo/cart/"+form.userId;
				}
				
			});
			
			xhr.open("put", "/bibaboo/cart", true); /* true는 비동기적, false는 동기적 */
			xhr.setRequestHeader("Content-Type", "application/json"); /* json 전송시 사용 , post 방식일때만 적어줌*/
			xhr.send(JSON.stringify(form)); //데이터를 문자열로 동봉해서 전송한다.
		});
	});
}

function deleteCart(){
	let deleteButtons = document.querySelectorAll(".delete-btn");
	
	deleteButtons.forEach((element)=>{
		element.addEventListener("click",function(){
			let confirmCheck = confirm("정말로 삭제하시겠습니까?");
			
			if(confirmCheck == true){
				let cartId = element.parentElement.parentElement.querySelector(".cart-id").value;
				let userId = element.parentElement.parentElement.querySelector(".cart-user-id").value;
			
				let xhr = new XMLHttpRequest();
				xhr.addEventListener("load",function(){
					if(xhr.status == 200){
						alert("삭제되었습니다.");
						location.href="/bibaboo/cart/"+userId;
					}
					
				});
				
				xhr.open("delete","/bibaboo/cart?id="+cartId);
				xhr.send();
			}
			
		});
	});
}