/**
 * 
 */

let pageNumBtns = document.querySelectorAll(".page-info a");
let moveForm = document.getElementById("moveForm");

pageNumBtns.forEach((element)=>{
	element.addEventListener("click",function(event){
		event.preventDefault(); /*해당 이벤트의 기본 동작을 실행하지 않도록 하는 코드 (여기서는 a태그의 href 이동 동작을 무력화함) */
		
		let pageNum = document.getElementsByName("pageNum")[0];
		pageNum.value = element.getAttribute("href");
		
		moveForm.setAttribute("action","/bibaboo/admin/alterations");
		moveForm.submit();
	});
});