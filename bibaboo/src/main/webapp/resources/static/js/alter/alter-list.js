/**
 * 
 */

let pageBtns = document.querySelectorAll(".page-info a");

pageBtns.forEach((element)=>{
	element.addEventListener("click",function(event){
		event.preventDefault(); /*해당 이벤트의 기본 동작을 실행하지 않도록 하는 코드 (여기서는 a태그의 href 이동 동작을 무력화함) */
		
		let pageNumValue = element.getAttribute("href");
		let pageNum = document.getElementsByName("pageNum")[0];
		pageNum.value = pageNumValue;
		
		let alterListMoveForm = document.getElementById("alterListMoveForm");
		alterListMoveForm.submit();
	});
});