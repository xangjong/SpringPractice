/**
 * bookNoCheck.js
 */
 
 $(document).ready(function(){
	
	$('#bookCheckBtn').on('click',function(){
 	
 	event.preventDefault();
 	
 	var bookNo = $('#bookNo').val();
 	
 	if(bookNo == ""){
 		alert("도서 번호를 입력하세요.");
 		return false;
 	} else {
 			$.ajax({
 			type:"post",
 			url:"/books/bookNoCheck",
 			data:{"bookNo": bookNo},
 			dataType:"text",
 			success:function(result){
 				if(result == "no_use")
 					alert("사용할 수 없는 도서번호입니다.");
 				else 
 					alert("사용 가능한 도서번호입니다.");
 			}, // success
 			
 			error:function(){
 				alert("전송 실패");	
 			},
 			
 			complete:function(){
 				// alert("작업 완료");
 			}
 			}); // ajax
 		
 		
 		
 		} // else 
 	}); // bookCheckBtn.click
 }); // document.ready 