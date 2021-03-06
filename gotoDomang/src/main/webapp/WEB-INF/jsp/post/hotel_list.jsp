<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="d-flex mt-5 justify-content-around">
	<c:if test="${not empty userId}">
			<a href="/user/reservation_list">예약확인</a>
	</c:if>
 
	<form method="get" action="/save.php">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="호텔 이름을 검색하세요!">
			<span class="input-group-btn">
				<button class="btn btn-secondary" type="button">찾기</button>
			</span>
		</div>
	</form>

	<select id="sel">
			<option>--선택하기--</option>
            <option value="lowPrice">가격 낮은순</option>
            <option value="highPrice">가격 높은순</option>
           <!-- <option value="lowPoint">별점 낮은순</option>
            <option value="highPoint">별점 높은순</option> --> 
        </select>
	</div>

<div class="d-flex justify-content-center mt-5">
	
		<div class=" contents-box col-10">
		<c:forEach var="hotel" items="${hotelList}">
			<div id="hotel-card" class="d-flex write-box border rounded m-3">

				<img
					src="${hotel.imagePath}"
					width="350" height="350" alt="이미지">
				<div id="hotel-detail"
					class="card-post w-100 h-100 border-0 ml-3 pt-2">
				
					<b>호텔 이름</b>: ${hotel.hotelName} <br> <br> 
					
					<b>호텔 주소</b>: ${hotel.location}<br> <br> 
					<b>호텔 설명</b>: <br>${hotel.content}<br>
					<br> 
					<b>호텔 가격</b>: ${hotel.price}원<br> <br>
					 <b>호텔 연락처</b>:
					${hotel.hotelNumber}<br>
				</div>
			</div>
			
			<div class="d-flex justify-content-end">
				<a id="revewBtn" class="btn btnReview mr-2 text-white" href="/user/review_view?hotelId=${hotel.id}">후기보기</a>
				<a id="reservationBtn" class="btn btnReservation text-white" href="/user/insert_reservation?hotelId=${hotel.id}">예약하기</a>
			</div>
		</c:forEach>
		</div>
	
</div>
<script>


	$(document).ready(function() {

		$('#sel').on('change', function(e) {
			e.preventDefault();
			alert($(this).val());
			let selectedValue = $('#sel option:selected').val();

			location.href = '/hotel/list_view?type=' + selectedValue;

		});

	});
</script>