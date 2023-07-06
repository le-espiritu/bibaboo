/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	getUserInfoPopup();
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