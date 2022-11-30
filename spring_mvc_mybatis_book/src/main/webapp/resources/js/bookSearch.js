/**
 * bookSearch.js 
 */
 
 
 $(document).ready(function(){

 	$('#bookSearchFrm').on('submit', function(){
 	
 	
 		event.preventDefault();
 	
 		
 		var formData = $(this).serialize();
 		
 		$.ajax({
 			type:"post",
 			url:"bookSearch", 
 			data:formData,
 			success: function(result){ // 컨트롤러에서 반환한 bookList를 result가 받음 
 			// 반환된 결과를 productResult <div>으로 삽입
 				// alert(result);
 				$('#searchResultBox').html(result);
 				
 			},
 			
 			error: function(){
 				// 오류있을 경우 수행되는 함수
 				alert("전송 실패");
 			}
 		}); // ajax 끝
 	}); // submit 끝 
 });  // ready 끝