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
					<textarea id="hotel-detail" rows="9" cols="50" class="form-control mt-2" placeholder="호텔 설명을 입력해주세요"></textarea>
					
					<div class="d-flex justify-content-end mt-5">
						<input type="file" id="file" class="m-2" accept=".jpg,.jpeg,.png,.gif">
					</div>
					
				</div>
			</div>
			<div  class="d-flex justify-content-center">
				<button id="registrationBtn" class="btn btn-block ">호텔 등록</button>
			</div>
	</div>
</div>