/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	let moveForm = document.querySelector(".moveForm");
	movePage(moveForm);
});

function movePage(moveForm){
	let pageNumInput = document.getElementsByName("pageNum")[0];
	
	let pageInfoDiv = document.querySelector(".page-info");
	pageInfoDiv.addEventListener("click",function(e){
		e.preventDefault();
		
		if(e.target.tagName=='A'){
			pageNumInput.value = e.target.getAttribute("href");
			moveForm.submit();
		}
	});
}