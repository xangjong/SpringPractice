/**
 * tts3.js  : 업로드한 텍스트 파일 내용도 함께 받아서 뷰 페이지에 출력
 */
 
 
 $(document).ready(function(){
	$('#ttsForm').on('submit', function(){
		event.preventDefault();
		
		// 폼 데이터 읽어오기
		var formData = new FormData($('#ttsForm')[0]);
     	
		$.ajax({
			type:"post",
			url:"tts3",
			enctype:"multipart/form-data",
			data:formData,
			processData:false,	// multipart 사용하기 위해 필수
			contentType:false,
			success:function(result){
				$('#audioBox audio').prop('src', '/audioFile/' + result);
				// resultBox에 출력
	 			$('#resultBox').text(result.voiceFileName);	 			
	 			$('#resultBox').html(result.fileContents.replaceAll("\n", "<br>"));
				//result.text = result.text.replace(/(\n|\r\n)/g, '<br>');
				
			},
			error:function(){
				// 오류있을 경우 수행되는 함수
				alert("전송 실패");
			}
		}); // ajax 끝
    });// submit 끝
});