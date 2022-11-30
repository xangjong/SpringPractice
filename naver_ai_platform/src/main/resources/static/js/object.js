/**
 * object.js
 */
 
 $(document).ready(function(){
 	$('#objectForm').on('submit', function(){
 		// submit 이벤트 기본 기능 : 페이지 새로 고침
 		// 기본 기능 중단
 		event.preventDefault();
 		
 		// 폼 데이터 읽어오기
 		var formData = new FormData($('#objectForm')[0]);
 		
 		//  업로도된 파일명 알아오기
 		var fileName = $('#uploadFile').val().split("\\").pop(); 		
 		// alert(fileName);
 		
 		
 		$.ajax({
 			type: "post",
 			url: "objectDetect",
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
 		var canvas = document.getElementById("objectCanvas");
 		var context = canvas.getContext("2d");
 		 		
 		// 이미지 설정 : 경로, 파일명, 크기
 		var objectImage = new Image();
 		objectImage.src = "/images/" + fileName;
 		objectImage.width = canvas.width;
 		objectImage.height = canvas.height;
 		
 		// 이미지 로드되었을 때 context, 색상, 위치 배열 설정
 		objectImage.onload = function(){
 			context.drawImage(objectImage, 0, 0, objectImage.width, objectImage.height);
 		 		
 		// 각 신체부위별 좌표 표시
 		var values = "";
 		
 		$.each(result, function(i) {
 			// 사각형 그리기 위한 좌표 설정
 			var x1 = this.x1 * objectImage.width;
 			var y1 = this.y1 * objectImage.height;
 			var x2 = this.x2 * objectImage.width;
 			var y2 = this.y2 * objectImage.height;
 			
 			context.font = "15px batang"; // 폰트 크기, 글꼴 지정
 			context.fillStyle = "rgb(255, 0, 255)"; // 색상 지정
 			
 			//var text = ;
 			
 			context.strokeStyle = "red"; // 선 색상
 			context.lineWidth = 2;  // 선 굵기
 			//context.strokeRect(x1, y1, x2-x1, y2-y1); // (x, y, width, height)
 			//context.fillText(text, x1, y1);
 			context.fillText(this.name +":"+ i, y1, x1);
 			context.strokeRect(y1, x1,  y2-y1, x2-x1); 
 			
 			values += i + " : " + this.name + " (" + this.x1 + ", " + this.y1 + ", " + this.x2 + ", " +  this.y2 + ") <br>";		 			
 			
 		});
 		
 		// resultBox에 출력
 		$('#resultBox').html(values);
 		
 		};
 		
 	}
 
  });
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  