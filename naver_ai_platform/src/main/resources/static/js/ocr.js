/**
 * ocr.js
 */
 
 $(document).ready(function() {
	$('#ocrForm').on('submit', function(){
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();

 		// 폼 데이터 읽어 오기
 		var formData = new FormData($('#ocrForm')[0]);
 		
 		// 업로드된 파일명 알아오기
 		var fileName = $('#uploadFile').val().split("\\").pop();
 		// alert(fileName);
 		
 		$.ajax({
 			type:"post",
 			url:"OCRGeneral",
 			enctype: 'multipart/form-data',
 			processData:false,
 			contentType:false,
 			data:formData,
			success:function(result){
 				// imageBox에 이미지 출력
 				//var imgHtml = `<img src="/images/${fileName}" />`;
 				//$('#imageBox').html(imgHtml);
 				//$('#imageBox').empty();
 				//$('#imageBox').append('<img src="/images/'+fileName+'">');
 				
 				$('#imageBox').html('<img src="/images/'+fileName+'">');
 				
 				// resultBox에 출력
 				//$('#resultBox').html(result);
 				$('#resultBox').text(result);
			},
			error:function(){
				// 오류있을 경우 수행 되는 함수
				alert("전송 실패");
			},
 		}); // ajax 끝
 	}); // submit 끝
});