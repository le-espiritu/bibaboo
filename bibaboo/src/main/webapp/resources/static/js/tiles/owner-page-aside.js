/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	alterationsExistCheck();
});

function alterationsExistCheck(){
	let gotoRegisterPagePTag= document.querySelector(".goto-register-page");
	
	gotoRegisterPagePTag.addEventListener("click",function(event){
		event.preventDefault();
		
		let userId = document.querySelector(".user-id-input").value;
		let form={
			userId : userId
		};
		
		let xhr = new XMLHttpRequest();
		xhr.addEventListener("load",function(){
			if(xhr.status==200){
				location.href="/bibaboo/owner/owner-page/alterations-register-page";
			}
			
			if(xhr.status==400){
				alert("이미 등록되어있습니다.");
			}
		});
		
		xhr.open("post","/bibaboo/alterations/check",true);
		xhr.setRequestHeader("Content-Type","application/json");
		xhr.send(JSON.stringify(form));
	});
}