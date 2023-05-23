/**
 * 
 */

let pageNumBtns = document.querySelectorAll(".page-info a");
let moveForm = document.getElementById("moveForm");

pageNumBtns.forEach((element)=>{
	
	element.addEventListener("click",function(event){
		event.preventDefault();
		
		let pageNum = document.getElementsByName("pageNum")[0];
		pageNum.value = element.getAttribute("href");
		
		moveForm.setAttribute("action","/bibaboo/admin/alterations");
		moveForm.submit();
	});
});