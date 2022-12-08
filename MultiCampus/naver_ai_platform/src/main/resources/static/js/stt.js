/**
 * stt.js
 */
 
 $(document).ready(function() {
	$('#sttForm').on('submit', function(){
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();

 		// 폼 데이터 읽어 오기
 		var formData = new FormData($('#sttForm')[0]);
 		
 		// 업로드된 파일명 알아오기
 		var fileName = $('#uploadFile').val().split("\\").pop();
 		// alert(fileName);
 		
 		$.ajax({
 			type:"post",
 			url:"stt",
 			enctype: 'multipart/form-data',
 			processData:false,
 			contentType:false,
 			data:formData,
			success:function(result){
 		
 			$('#resultBox').html(result);
 			$('#audioBox audio').prop('src','/audioFile/'+fileName); // 경로 및 파일명 설정
 			//	$('#audioBox audio').attr('src','/audioFile/'+fileName); 
 				 				
			},
			error:function(){
				// 오류있을 경우 수행 되는 함수
				alert("전송 실패");
			},
 		}); // ajax 끝
 	}); // submit 끝
});