<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center ml-5">
	<div class="sign-up-box">
		<h1 class="mb-4">호텔 등록</h1>
		
			<div class="d-flex">
					<div>
						<span>*호텔 이름</span>
						<input type="text" id="hotelName" name="hotelName"
							class="form-control" placeholder="호텔이름을 입력하세요."><br>
					
						<span>*호텔 주소</span>
						<input type="text" id="location" name="location"
							class="form-control" placeholder="호텔 주소를 입력하세요."><br>
						
						<span>*호텔 가격</span>
						<input type="text" id="price" name="price"
							class="form-control" placeholder="호텔가격 입력하세요."><br>
							
						<span>*호텔 번호</span>
						<input type="text" id="hotelNumber" name="hotelNumber"
							class="form-control" placeholder="호텔 전화번호를 입력하세요."><br>
						
						
					</div>
					<div class="ml-4">
						<span>*호텔 설명</span>
						<textarea id="content" rows="9" cols="50" class="form-control mt-2" placeholder="호텔 설명을 입력해주세요"></textarea>
						
						<div class="d-flex justify-content-end mt-5">
							<input type="file" id="imagePath" class="m-2" accept=".jpg,.jpeg,.png,.gif">
						</div>
						
					</div>
				</div>
				<div  class="d-flex justify-content-center">
					<button type="button" id="registrationBtn" class="btn btn-block">호텔 등록</button>
				<!--  <a id="registrationBtn" class="btn btn-block btn-sign-up" href="/hotel/manager_list">호텔 등록2</a> -->	
				</div>
			
	</div>
</div>

<script>
$(document).ready(function() {
	// 호텔등록버튼
	$('#registrationBtn').on('click', function(){
		
		let hotelName = $('#hotelName').val().trim();
		if (hotelName == '') {
			alert("호텔이름을 입력하세요");
			return;
		}
		
		let location = $('#location').val();
		if (location == ''){
			alert("호텔주소를 입력하세요");
			return;
		}
 
		let price = $('#price').val().trim();
		if (price ==''){
			alert("가격을 입력하세요");
			return;
		}
		let hotelNumber = $('#hotelNumber').val().trim();
		if (hotelNumber ==''){
			alert("호텔번호을 입력하세요");
			return;
		}
		let content = $('#content').val().trim();
		if (content ==''){
			alert("호텔설명를 입력하세요");
			return;
		}
			
		let imagePath = $('#imagePath').val();
		console.log("imagePath:" + imagePath);
		
		if (imagePath ==''){
			alert("사진을 올려주세요!");
			return;
		}
		if (imagePath != ''){
			let ext = imagePath.split('.').pop().toLowerCase()  //  split를 사용해서 .을 기준으로 나누고 pop()를 사용해서 마지막 배열을 가져온뒤toLowerCase()로 소문자로 만듬 // toLowerCase = 소문자로 바꿈, 대문자 => toUpperCase
			if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1 ){
				alert("이미지 파일만 업로드 할 수 있습니다.");
				$('#imagePath').val('') // 잘못된 파일을 비운다.
				return;
			}
		}
		
		// 폼태그를 자바스크립트에서 만든다.
		let formData = new FormData();
		formData.append('hotelName', hotelName);
		console.log(hotelName);
		formData.append('location', location);
		console.log(location);
		formData.append('price', price);
		console.log(price);
		formData.append('hotelNumber', hotelNumber);
		console.log(hotelNumber);
		formData.append('content', content);
		console.log(content);
		formData.append('imagePath', $('#imagePath')[0].files[0]);
		console.log(imagePath);
	
	
		// ajax
		$.ajax({
			type:'post' 
			, url: '/post/registration'
			, data: formData
			, enctype: 'mulitpart/form-data'
			, processData: false   
			, contentType: false   
			, success: function(data){
				if (data.result == 'success'){
					alert("호텔정보가 등록 됐습니다.");
					location.href ="/hotel/manager_list";
				}
			}, error: function(e){
				alert("호텔 정보 등록에 실패했습니다." + e);
			}
		});
	});
});
</script>

