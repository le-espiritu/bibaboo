/**
 * 
 */

function addCart(userId,categoryId,count){
	
	let form={
		userId : userId,
		categoryId : categoryId,
		count : count
	}
	
	let xhr = new XMLHttpRequest();
	xhr.addEventListener("load",function(){
		if(xhr.status == 200){
			alert("장바구니에 성공적으로 담겼습니다.");
		}
		
		if(xhr.status == 400){
			alert("이미 장바구니에 담겨져있습니다.");
		}
	});
	
	xhr.open("post", "/bibaboo/cart", true) /* true는 비동기적, false는 동기적 */
	xhr.setRequestHeader("Content-Type", "application/json"); /* json 전송시 사용 , post 방식일때만 적어줌*/
	xhr.send(JSON.stringify(form)); //데이터를 문자열로 동봉해서 전송한다.
	
}