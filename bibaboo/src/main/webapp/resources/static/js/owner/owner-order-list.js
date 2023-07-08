/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	let moveForm = document.querySelector(".moveForm");
	
	getUserInfoPopup();
	updateState();
	search(moveForm);
	movePage(moveForm);
});

function getUserInfoPopup(){
	let orderListDiv = document.querySelector(".order-list");
	
	//이벤트 델리게이션 (이벤트 버블링)
	orderListDiv.addEventListener("click",function(e){
		if(e.target.className=="user-info-btn"){
			e.preventDefault();
			
			//popup창에 form데이터 전달하기 (post 방식으로 popup창 띄우기)
			let url="";
			let windowTargetName="userInfoPopup";
			let features = "width = 490px, height=400px, top=300px, left=300px, scrollbars=yes";
			
			window.open(url, windowTargetName, features);
			
			let userInfoForm = e.target.parentElement;
			
			userInfoForm.action="/bibaboo/owner/owner-page/user-info-popup";
			userInfoForm.method="post";
			userInfoForm.target=windowTargetName;
			userInfoForm.submit();
		}
	});
		
}

function updateState(){
	let orderListDiv = document.querySelector(".order-list");
	orderListDiv.addEventListener("click",function(e){
		if(e.target.className=="state-update-btn"){
			let stateValue = e.target.parentElement.parentElement.querySelector("select").value;
			let orderCategoryId = e.target.parentElement.parentElement.querySelector(".orderCategory-id-input").value;
			
			let form={
				state : stateValue,
				orderCategoryId : orderCategoryId
			}
			
			let xhr = new XMLHttpRequest();
			xhr.addEventListener("load",function(){
				if(xhr.status == 200){
					alert("주문 상태가 성공적으로 변경되었습니다.");
				}
			});
			
			xhr.open("put","/bibaboo/order/state", true);
			xhr.setRequestHeader("Content-Type","application/json");
			xhr.send(JSON.stringify(form));
		}
	})
}

function search(moveForm){
	let searchButton = document.querySelector(".search-section button");
	searchButton.addEventListener("click",function(){
		
		let typeValue = document.querySelector(".search-section select").value;
		let keywordValue = document.querySelector(".keyword").value;
		
		if(!typeValue){
			alert("검색 종류를 선택해 주세요.");
		}
		if(!keywordValue){
			alert("검색어를 입력해 주세요.");
		}
		
		let typeInput = document.createElement("INPUT");
		typeInput.setAttribute("type","hidden");
		typeInput.setAttribute("name","type");
		typeInput.setAttribute("value",typeValue);
		
		let keywordInput = document.createElement("INPUT");
		keywordInput.setAttribute("type","hidden");
		keywordInput.setAttribute("name","keyword");
		keywordInput.setAttribute("value",keywordValue);
		
		moveForm.appendChild(typeInput);
		moveForm.appendChild(keywordInput);
		
		document.getElementsByName("pageNum")[0].value=1;
		moveForm.submit();
	});
}

function movePage(moveForm){
	let pageNumInput = document.getElementsByName("pageNum")[0];
	
	let pageInfoDiv = document.querySelector(".page-info");
	pageInfoDiv.addEventListener("click",function(e){
		e.preventDefault();
		
		if(e.target.tagName == 'A'){
			pageNumInput.value=e.target.getAttribute("href");
			
			moveForm.submit();
		}
	});
}