<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="d-flex justify-content-end mt-5">
	
		<div class=" contents-box col-12">
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
				<button id="deleteBtn" class="btn btn-danger mr-2" data-hotel-id="${hotel.id}" >삭제하기</button>
				<!--<button id="upateBtn" class="btn btn-success " >수정하기</button>
				 <a href="/post/post_detail_view?postId=${post.id}">${post.subject}</a>  -->
			</div>
		</c:forEach>
		</div>
	
</div>

<script>

	$(document).ready(function() {
		$('#deleteBtn').on('click', function(e) {
			e.preventDefault();
			let hotelId = $('#deleteBtn').data('hotel-id');
			alert(hotelId);
			
			$.ajax({
				type:'delete'
				, url: '/hotel/delete'
				, data: {"hotelId" : hotelId}
				, success: function(data) {
					if (data.result == 'success') {
						alert("삭제 됐습니다.");
						location.reload();
					}
				}
				, error: function(e) {
					alert('삭제하는데 실패했습니다.' + e);
				}
			});
		});
	}); 
</script>
