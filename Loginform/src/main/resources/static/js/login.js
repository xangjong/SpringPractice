/**
 * login.js 
 */
 
 
$(document).ready(function(){

 	$('#loginForm').on('submit', function(){
 	
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();
 		
 		var id = $('#id').val();
 		var pw = $('#pw').val();
 		
 		$.ajax({
 			type:"post",
 			url:"login",
 			data:{"id":id,
 						"pw":pw},
 			dataType:"text",
 			success:function(result){
 				// 성공 시 수행되는 함수 
 				// 반환되는 값을  result로 받음
 				if(result == "success") {
 					alert("login ok");
 				} else
 					alert("login fail");
 					
 				
 			},
 			error:function(){
 				// 오류있을 경우 수행되는 함수
 				alert("전송 실패");
 			}
 		}); 	// ajax 끝
 	}); // submit 끝 
 });  // ready 끝