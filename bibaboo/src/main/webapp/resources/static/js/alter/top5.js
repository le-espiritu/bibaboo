/**
 * 
 */

document.addEventListener("DOMContentLoaded",function(){
	getAlterDetail();
});

function getAlterDetail(){
	let tops = document.querySelectorAll(".tops");
	
	tops.forEach((element)=>{
		element.addEventListener("click",function(){
			let alterId = element.querySelector(".alter-id-input").value;
			
			location.href="/bibaboo/alterations/"+alterId;
		});
	});	
};