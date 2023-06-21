/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	gerReviewUpdateView();
	deleteReview();
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

function deleteReview(){
	let deleteButtons = document.querySelectorAll(".delete-review-btn");
	
	deleteButtons.forEach((element)=>{
		element.addEventListener("click",function(event){
			event.preventDefault();
			
			confirm("정말로 삭제하시겠습니까?");
			
			let reviewId = element.parentElement.querySelector(".review-id").value;
			let userId = element.parentElement.querySelector(".user-id").value;
			let alterId = element.parentElement.querySelector(".alter-id").value;
			let categoryId = element.parentElement.querySelector(".category-id").value;
			let previousScore = elelement.parentElement.querySelector(".score-input").value;
			
			let form ={
				userId : userId,
				id : reviewId,
				alterId : alterId,
				categoryId : categoryId,
				previousScore : previousScore
			}
			
			let xhr = new XMLHttpRequest();
			xhr.addEventListener("load",function(){
				if(xhr.status == 200){
					alert("성공적으로 삭제되었습니다.");
					location.href="/bibaboo/alterations/"+alterId;
				}
			});
			
			xhr.open("delete", "/bibaboo/review", true);
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.send(JSON.stringify(form));
		});
	});
}