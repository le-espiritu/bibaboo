/**
 * 
 */
let moveForm = document.getElementById("moveForm");

let searchBtn = document.querySelector(".search-section button");
searchBtn.addEventListener("click",function(){
	
	let searchKeyword = document.querySelector(".search-section input").value;
	let typeValue = document.querySelector(".search-section select").value;
	
	if(!typeValue){
		alert("검색 종류를 선택하세요");
		return false;
	}
	
	if(!searchKeyword){
		alert("키워드를 입력하세요.");
		return false;
	}
	
	let inputNode = document.createElement("INPUT");
	inputNode.setAttribute("type","hidden");
	inputNode.setAttribute("name","keyword");
	inputNode.setAttribute("value",searchKeyword);
	
	let inputNodeForType = document.createElement("INPUT");
	inputNodeForType.setAttribute("type","hidden");
	inputNodeForType.setAttribute("name","type");
	inputNodeForType.setAttribute("value",typeValue);
	
	moveForm.appendChild(inputNode);
	moveForm.appendChild(inputNodeForType);
	
	/*moveForm.lastElementChild.value=searchKeyword;*/
	document.getElementsByName("pageNum")[0].value=1;
	moveForm.submit();	
	/*<form> 태그에 action 속성을 통해 url을 지정해주지 않으면 
	전송하였을 때 현재의 url경로의 매핑 메서드를 호출하게 됩니다.*/ 
});

let pageNumBtns = document.querySelectorAll(".page-info a");
pageNumBtns.forEach((element)=>{
	element.addEventListener("click",function(event){
		event.preventDefault(); /*해당 이벤트의 기본 동작을 실행하지 않도록 하는 코드 (여기서는 a태그의 href 이동 동작을 무력화함) */
		
		let pageNum = document.getElementsByName("pageNum")[0];
		pageNum.value = element.getAttribute("href");
		
		moveForm.setAttribute("action","/bibaboo/admin/alterations");
		moveForm.submit();
	});
});