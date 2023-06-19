/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	reviewCheck();
});

function reviewCheck(){
	let writeReviewButtons = document.querySelectorAll(".write-review-btn");
	
	writeReviewButtons.forEach((element)=>{
		element.addEventListener("click",function(event){
			event.preventDefault(); // 해당 이벤트의 기본 동작을 실행하지 않도록 하는 코드
			
			let userId = element.parentElement.querySelector(".user-id").value;
			let orderCategoryId = element.parentElement.querySelector(".order-category-id").value;
			
			let reviewCheckForm={
				userId : userId,
				orderCategoryId : orderCategoryId
			}
			
			let xhr = new XMLHttpRequest();
			xhr.addEventListener("load",function(){
				if(xhr.status == 200){
					let writeReviewForm = document.querySelector(".write-review-form");
					writeReviewForm.submit();
				}
				
				if(xhr.status == 403){
					alert("이미 리뷰가 작성되었습니다.");
				}
				
			});
			
			xhr.open("post", "/bibaboo/review/check", true);
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.send(JSON.stringify(reviewCheckForm));
			
		});
	});
};