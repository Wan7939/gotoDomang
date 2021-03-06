<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center font-weight-bold m-4">예약 하기</h2>

<div class="d-flex justify-content-center">

	<div class="reservation-box">
	
		<div class="subject-text my-2 font-weight-bold">이름</div>
		<input id="inputSize" type="text" class="form-control" value="${userName}" name="name">

		<div class="subject-text my-2 font-weight-bold">예약날짜</div>
		<input type="text" class="form-control" name="date">

		<div class="subject-text my-2 font-weight-bold">숙박일수</div>
		<input type="text" class="form-control" name="day">

		<div class="subject-text my-2 font-weight-bold">숙박인원</div>
		<input type="text" class="form-control" name="headcount">

		<div class="subject-text my-2 font-weight-bold">전화번호</div>
		<input type="text" class="form-control" name="phoneNumber">
	
		<button type="button" id="reservationBtn"
			class="btn btn-warning btn-block mt-3" data-hotel-id="${hotelId}">예약하기</button>
			
	</div>
</div>

<script>
$(document).ready(function() {
	$('#reservationBtn').on('click', function() {
		// validation check
		let hotelId = $('#reservationBtn').data('hotel-id');
			//alert(hotelId);
			
		let name = $('input[name=name]').val().trim();
		let date = $('input[name=date]').val().trim();
		let day = $('input[name=day]').val().trim();
		let headcount = $('input[name=headcount]').val().trim();
		let phoneNumber = $('input[name=phoneNumber]').val().trim();
		//alert(name);
		//alert(date);
		//alert(day);
		//alert(headcount);
		//alert(phoneNumber);
		if (name == '') {
			alert("이름을 입력하세요.");
			return;
		}
		
		if (date == '') {
			alert("날짜를 선택하세요.");
			return;
		}
		 
		if (day == '') {
			alert("숙박일을 입력하세요.");
			return;
		}
		
		if (isNaN(day)) {
			alert("숙박 일수는 숫자만 입력 가능합니다.");
			return;
		}
		
		if (headcount == '') {
			alert("숙박인원을 입력하세요.");
			return;
		}
		
		if (isNaN(headcount)) {
			alert("숙박인원은 숫자만 입력 가능합니다.");
			return;
		}
		
		if (phoneNumber == '') {
			alert("전화번호를 입력하세요.");
			return;
		}
		
		$.ajax({
			type: 'POST'
			, url: '/insert_reservation'
			, data: {'hotelId':hotelId, 'name':name, 'date':date, 'day':day, 'headcount':headcount, 'phoneNumber':phoneNumber}
			, success:function(data) {
				if (data.result == 'success') {
					alert("예약되었습니다.");
					location.href='/hotel/list_view'
				}
			}
			, error:function(e) {
				alert("error " + e.message);
			}
		});
	});
	
	
	$('input[name=date]').datepicker({
		dateFormat:"yy-mm-dd"
		, minDate: 1 // 오늘부터 그 뒤 선택
		, showButtonPanel: true//하단 투데이 및 클로즈 버튼
	    ,  closeText: "닫기"
	});
	$.datepicker.setDefaults({
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
	    , dateFormat: 'yy-mm-dd'
	});

});

</script>