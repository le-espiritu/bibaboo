/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	gerReviewUpdateView();
});

function gerReviewUpdateView(){
	let reviewUpdateViewButtons = document.querySelectorAll(".update-view-btn");
	
	reviewUpdateViewButtons.forEach((element)=>{
		element.addEventListener("click",function(event){
			event.preventDefault();
			
			let userId = element.parentElement.querySelector(".user-id").value;
			let reviewId = element.parentElement.querySelector(".review-id").value;
			
			let popUrl = "/bibaboo/review/update-page?id=" + reviewId +"&userId=" + userId;	
			let popOption = "width = 490px, height=400px, top=300px, left=300px, scrollbars=yes"	
			
			window.open(popUrl,"리뷰 수정",popOption);	
		});
	});
};