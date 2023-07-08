/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	let moveForm = document.querySelector(".moveForm");
	search(moveForm);
	movePage(moveForm);
});

function search(moveForm){
	let searchButton = document.querySelector(".search-section button");
	
	searchButton.addEventListener("click",function(){
		let typeValue = document.querySelector(".search-section select").value;
		let keywordValue = document.querySelector(".keyword").value;
		
		if(!typeValue){
			alert("검색 종류를 선택하세요");
			return false;
		}
		if(!keywordValue){
			alert("검색어를 입력하세요");
			return false;
		}
		
		let typeInputNode = document.createElement("INPUT");
		typeInputNode.setAttribute("type","hidden");
		typeInputNode.setAttribute("name","type");
		typeInputNode.setAttribute("value",typeValue);
		
		let keywordInputNode = document.createElement("INPUT");
		keywordInputNode.setAttribute("type","hidden");
		keywordInputNode.setAttribute("name","keyword");
		keywordInputNode.setAttribute("value",keywordValue);
		
		moveForm.appendChild(typeInputNode);
		moveForm.appendChild(keywordInputNode);
		
		//moveForm.getElementsByName("pageNum")[0].value=1;
		document.getElementsByName("pageNum")[0].value=1;
		moveForm.submit();
		/*<form> 태그에 action 속성을 통해 url을 지정해주지 않으면 
		전송하였을 때 현재의 url경로의 매핑 메서드를 호출하게 됩니다.*/ 
		
	});
}

function movePage(moveForm){
	let pageNumInput = document.getElementsByName("pageNum")[0];
	
	let pageInfoDiv = document.querySelector(".page-info");
	pageInfoDiv.addEventListener("click",function(e){
		e.preventDefault();
		if(e.target.tagName=='A'){
			let pageNumber = e.target.getAttribute("href");
			pageNumInput.value = pageNumber;
			
			moveForm.submit();
		}
	});

}