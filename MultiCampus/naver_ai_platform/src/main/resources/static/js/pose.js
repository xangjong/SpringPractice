/**
 * pose.js
 */
 
 $(document).ready(function(){
 	$('#poseForm').on('submit', function(){
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();
 		
 		// 폼 데이터 읽어오기
 		var formData = new FormData($('#poseForm')[0]);
 		
 		//  업로도된 파일명 알아오기
 		var fileName = $('#uploadFile').val().split("\\").pop(); 		
 		//var fileName = $('#uploadFile').val(); 	// C:\fakepath\run.jpg (보안상 fakepath로 지정)
 		 alert(fileName);
 		
 		
 		$.ajax({
 			type: "post",
 			url: "poseDetect",
 			enctype: 'multipart/form-data',
 			data: formData,
 			processData: false,   // multipart 사용하기 위한 필수
 			contentType: false,
			success: function(result){
				drawCanvas(result, fileName); 
			},
			error: function(){
				// 오류 있을 경우 수행되는 함수
				alert("전송 실패");
			}
 		}); // ajax 끝
 	}); // submit 끝
 
 
 	function drawCanvas(result, fileName) {
 		//canvas 객체 생성
 		var canvas = document.getElementById("poseCanvas");
 		var context = canvas.getContext("2d");
 		 		
 		// 이미지 설정 : 경로, 파일명, 크기
 		var poseImage = new Image();
 		poseImage.src = "/images/" + fileName;
 		poseImage.width = canvas.width;
 		poseImage.height = canvas.height;
 		
 		// 이미지 로드되었을 때 context, 색상, 위치 배열 설정
 		poseImage.onload = function(){
 			context.drawImage(poseImage, 0, 0, poseImage.width, poseImage.height);
 			
 			var colors = ["red", "blue", "yellow", "yellow","yellow","green", "green",
									"green", "skyblue","skyblue","skyblue","black","black","black",
									"pink","gold", "orange","brown"];		
									
			var position = ["코", "목", "오른쪽 어깨", "오른쪽 팔굼치", "오른쪽 손목", 
										"왼쪽 어깨", "왼쪽 팔굼치", "왼쪽 손목", "오른쪽 엉덩이", "오른쪽 무릎",
										"오른쪽 발목", "왼쪽 엉덩이", "왼쪽 무릎", "왼쪽 발목", "오른쪽 눈",
										"왼쪽 눈", "오른쪽 귀", "왼쪽 귀"];	 
 		
 		// 각 신체부위별 좌표 표시
 		var values = "";
 		
 		$.each(result, function(i) {
 			if(this.x != 0 | this.y != 0 ){
 				context.strokeStyle = colors[i]; // 색상
 				context.strokeRect(this.x * poseImage.width, this.y * poseImage.height, 2, 2); // 출력 위치
 				var text = this.x.toFixed(2) + ", " + this.y.toFixed(2); // 소수점 2자리로 지정
 				context.font = '10px serif'; // 폰트
 				context.strokeText(text, this.x * poseImage.width, this.y * poseImage.height); // 텍스트 출력
 			};
 			
 			values += position[i] + "(" + this.x + ", " + this.y + ")<br>";
 		});
 		
 		// resultBox에 출력
 		$('#resultBox').html(values);
 		
 		};
 		
 	}
 
  });
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  