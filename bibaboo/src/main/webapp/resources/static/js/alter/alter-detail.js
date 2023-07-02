/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	const criPageNum =1;
	const criAmount = 10;
	getReviews(criPageNum, criAmount);
	changePage()
	getUpdateViewForDynamicTag(); //동적 태그를 위한 함수
	deleteReviewForDynamicTag(); //동적 태그를 위한 함수 
	
	gerReviewUpdateView();
	deleteReview();
	
});

function makebuttons(element){
	let principalUsername = document.querySelector(".principal-username").value;
	//alert(principalUsername);
	let userEmail = element.querySelector(".user-email").value;
	//alert(userEmail);
	if(principalUsername == userEmail){
		let btnsDivHtml ="";
		btnsDivHtml +='<button class="update-view-btn">';
		btnsDivHtml +='수정';
		btnsDivHtml +='</button>';
		btnsDivHtml +='<button class="delete-review-btn">';
		btnsDivHtml +='삭제';
		btnsDivHtml +='</button>';
		
		let btnsDiv = element.querySelector(".btns-div");
		btnsDiv.innerHTML=btnsDivHtml;
	}
	
}

function makeReviewContent(reviewPageDTO){
	if(reviewPageDTO.reviewList.length ===0){
		document.querySelector(".review-list").innerHTML="";
		document.querySelector(".review-not-section").innerHTML="<span>리뷰가 없습니다.</span>";
		document.querySelector(".review-page-section").innerHTML="";
	}else{
		document.querySelector(".review-not-section").innerHTML="";
		
		const pageInfo = reviewPageDTO.pageDTO;
		
		let reviewHtml = document.querySelector("#template-review-tbody-tr").innerHTML;
		let resultHtml = "";
		for(let i =0; i<reviewPageDTO.reviewList.length; i++){
			resultHtml += reviewHtml.replace("{score}",reviewPageDTO.reviewList[i].score)
									.replace("{categoryName}",reviewPageDTO.reviewList[i].categoryName)
									.replace("{content}",reviewPageDTO.reviewList[i].content)
									.replace("{hiddenUserId}",reviewPageDTO.reviewList[i].userId)
									.replace("{hiddenUserEmail}",reviewPageDTO.reviewList[i].userEmail)
									.replace("{reviewId}",reviewPageDTO.reviewList[i].id)
									.replace("{alterId}",reviewPageDTO.reviewList[i].alterId)
									.replace("{categoryId}",reviewPageDTO.reviewList[i].categoryId)
									.replace("{hiddenScore}",reviewPageDTO.reviewList[i].score)
									.replace("{userEmail}",reviewPageDTO.reviewList[i].userEmail)
									.replace("{createDate}",reviewPageDTO.reviewList[i].createDate);
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
			
			makebuttons(element);
		});
		
		//페이지 버튼 동적 구현
		let pageHtml = "";
		
		pageHtml+="<ul>";
		
		if(pageInfo.prev){
			let prevNum = pageInfo.startPage-1;
			pageHtml += "<li class='page-btn page-prev'>";
			pageHtml += "<a href='"+prevNum+"'>이전</a>";
			pageHtml += "</li>";
		}
		
		for(let i= pageInfo.startPage; i<pageInfo.endPage+1; i++){
			pageHtml += "<li class='page-btn";
			if(pageInfo.criteria.pageNum === i){
				pageHtml += " active";
			}
			pageHtml += "'>";
			pageHtml += "<a href='"+i+"'>"+i+"</a>";
			pageHtml += "</li>";
		}
		
		if(pageInfo.next){
			let nextNum = pageInfo.endPage+1;
			pageHtml += "<li class='page-btn page-next'>";
			pageHtml += "<a href='"+nextNum+"'>다음</a>";
			pageHtml += "</li>";
		}
		
		pageHtml+="</ul>";
		
		document.querySelector(".review-page-section").innerHTML=pageHtml;
		
	}
}

function getReviews(criPageNum, criAmount){
	let alterId = document.querySelector(".alter-id-input").value;
	let xhr = new XMLHttpRequest();	
	xhr.addEventListener("load",function(){
		if(xhr.status==200){
			let reviewPageDTO = JSON.parse(this.responseText);
			makeReviewContent(reviewPageDTO);
		}
	});
	xhr.open("GET", "/bibaboo/review/"+alterId+"?pageNum="+criPageNum+"&amount="+criAmount, true);
	xhr.send();
};

function getUpdateViewForDynamicTag(){
	//동적으로 생성된 태그에는 기존에 작성해놓았던 eventListener가 작동하지 않는다.
	//따라서 동적으로 생성된 태그의 부모 태그중 동적으로 생성되지 않은 태그에 이벤트를 위임해야한다. (이벤트 델리게이션)
	
	let reviewDiv = document.querySelector(".review");
	//document.addEventListener("click",function(e){ //document에 이벤트를 위임함
	//document에 이벤트를 위임하면 별점을 눌렀을때 채워지는 css가 동작하지 않기 때문에 아래 코드로 바꿔줌 
	reviewDiv.addEventListener("click",function(e){ //reviewDiv에 이벤트를 위임함
		
		if(e.target.className=="update-view-btn"){
			e.preventDefault();
			
			let userEmail = e.target.parentElement.parentElement.querySelector(".user-email").value;
			let reviewId = e.target.parentElement.parentElement.querySelector(".review-id").value;
			
			let popUrl = "/bibaboo/review/update-page?id=" + reviewId +"&userEmail=" + userEmail;	
			let popOption = "width = 490px, height=400px, top=300px, left=300px, scrollbars=yes"	
			
			window.open(popUrl,"리뷰 수정",popOption);	
		}
	});
}

function deleteReviewForDynamicTag(){
	
	let reviewDiv = document.querySelector(".review");
	//document.addEventListener("click",function(e){ //document에 이벤트를 위임함
	//document에 이벤트를 위임하면 별점을 눌렀을때 채워지는 css가 동작하지 않기 때문에 아래 코드로 바꿔줌 
	reviewDiv.addEventListener("click",function(e){ //reviewDiv에 이벤트를 위임함
		if(e.target.className=="delete-review-btn"){
			e.preventDefault();
			
			let result = confirm("정말로 삭제하시겠습니까?");
			
			if(result==true){
				let reviewId = e.target.parentElement.parentElement.querySelector(".review-id").value;
				let userId = e.target.parentElement.parentElement.querySelector(".user-id").value;
				let userEmail = e.target.parentElement.parentElement.querySelector(".user-email").value;
				let alterId = e.target.parentElement.parentElement.querySelector(".alter-id").value;
				let categoryId = e.target.parentElement.parentElement.querySelector(".category-id").value;
				let previousScore = e.target.parentElement.parentElement.querySelector(".score-input").value;
				
				let form ={
					userId : userId,
					id : reviewId,
					userEmail : userEmail,
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
					if(xhr.status == 403){
						alert("권한이 없습니다.");
					}
				});
				
				xhr.open("delete", "/bibaboo/review", true);
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.send(JSON.stringify(form));
				}
		}
	});
};


function changePage(){
	let reviewPageSection = document.querySelector(".review-page-section");
	//document.addEventListener("click",function(e){ //document에 이벤트를 위임함
	//document에 이벤트를 위임하면 별점을 눌렀을때 채워지는 css가 동작하지 않기 때문에 아래 코드로 바꿔줌 
	reviewPageSection.addEventListener("click",function(e){ //reviewPageSection에 이벤트를 위임함
		e.preventDefault();
		if(e.target.parentElement.className=="page-btn"){
			let pageNumValue = e.target.getAttribute("href");
			
			getReviews(pageNumValue, 10);
		}
	});
}







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

