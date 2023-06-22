/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	getReviews();
	getUpdateViewForDynamicTag(); //동적 태그를 위한 함수
	deleteReviewForDynamicTag(); //동적 태그를 위한 함수 
	
	gerReviewUpdateView();
	deleteReview();
});

function getReviews(){
	let alterId = document.querySelector(".alter-id-input").value;
	let xhr = new XMLHttpRequest();	
	xhr.addEventListener("load",function(){
		if(xhr.status==200){
			let reviewPageDTO = JSON.parse(this.responseText);
			if(reviewPageDTO.reviewList.length ===0){
				document.querySelector(".review-list").innerHTML="";
				document.querySelector(".review-not-section").innerHTML="<span>리뷰가 없습니다.</span>";
				document.querySelector(".review-page-section").innerHTML="";
			}else{
				let reviewHtml = document.querySelector("#template-review-tbody-tr").innerHTML;
				let resultHtml = "";
				for(let i =0; i<reviewPageDTO.reviewList.length; i++){
					resultHtml += reviewHtml.replace("{score}",reviewPageDTO.reviewList[i].score)
											.replace("{categoryName}",reviewPageDTO.reviewList[i].categoryName)
											.replace("{content}",reviewPageDTO.reviewList[i].content)
											.replace("{hiddenUserId}",reviewPageDTO.reviewList[i].userId)
											.replace("{hiddenScore}",reviewPageDTO.reviewList[i].score)
											.replace("{userId}",reviewPageDTO.reviewList[i].userId)
											.replace("{createDate}",reviewPageDTO.reviewList[i].createDate)
											.replace("{reviewId}",reviewPageDTO.reviewList[i].id)
											.replace("{alterId}",reviewPageDTO.reviewList[i].alterId)
											.replace("{categoryId}",reviewPageDTO.reviewList[i].categoryId);
				}
				document.querySelector(".review-tbody").innerHTML=resultHtml;
				
				let reviewTrs = document.querySelectorAll(".review-tr");
				reviewTrs.forEach((element,index)=>{
					if(reviewPageDTO.reviewList[index].reviewPhotos.length>0){
						let reviewPhotoDiv = element.querySelector(".review-photo-div");
						let imgHtml = "";
						for(let i =0; i<reviewPageDTO.reviewList[index].reviewPhotos.length; i++ ){
							imgHtml +="<img alt='reviewPhotoImage' src='/bibaboo/img/upload/"+reviewPageDTO.reviewList[index].reviewPhotos[i].name+"'>";
						}
						reviewPhotoDiv.innerHTML = imgHtml;
					}
				})
			}
		}
	});
	xhr.open("GET", "/bibaboo/review/"+alterId, true);
	xhr.send();
};

function getUpdateViewForDynamicTag(){
	//동적으로 생성된 태그에는 기존에 작성해놓았던 eventListener가 작동하지 않는다.
	//따라서 동적으로 생성된 태그의 부모 태그중 동적으로 생성되지 않은 태그에 이벤트를 위임해야한다. (이벤트 델리게이션)
	
	document.addEventListener("click",function(e){ //document에 이벤트를 위임함
		
		if(e.target.className=="update-view-btn"){
			e.preventDefault();
			
			let userId = e.target.parentElement.querySelector(".user-id").value;
			let reviewId = e.target.parentElement.querySelector(".review-id").value;
			
			let popUrl = "/bibaboo/review/update-page?id=" + reviewId +"&userId=" + userId;	
			let popOption = "width = 490px, height=400px, top=300px, left=300px, scrollbars=yes"	
			
			window.open(popUrl,"리뷰 수정",popOption);	
		}
	});
}

function deleteReviewForDynamicTag(){
	
	document.addEventListener("click",function(e){
		if(e.target.className=="delete-review-btn"){
			e.preventDefault();
			
			confirm("정말로 삭제하시겠습니까?");
			
			let reviewId = e.target.parentElement.querySelector(".review-id").value;
			let userId = e.target.parentElement.querySelector(".user-id").value;
			let alterId = e.target.parentElement.querySelector(".alter-id").value;
			let categoryId = e.target.parentElement.querySelector(".category-id").value;
			let previousScore = e.target.parentElement.querySelector(".score-input").value;
			
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
		}
	});
};



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

