<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="d-flex justify-content-center mt-5">




	<div class="border rounded mt-3">

		<div class="p-2 d-flex justify-content-center">
			<span class="font-weight-bold">${hotel.hotelName}</span>
		</div>

		<div class="card-img">
			<img src="${hotel.imagePath}" width="300" height="300" alt="이미지">
		</div>

	</div>
</div>
<c:if test="${not empty userId}">
<div class="d-flex justify-content-center mt-5">
<div>
<div class="d-flex justify-content-center">
	<div class="star-rating">
	  <input type="radio" id="5-stars" class="point" name="rating" value="5" />
	  <label for="5-stars" class="star">&#9733;</label>
	  <input type="radio" id="4-stars" class="point" name="rating" value="4" />
	  <label for="4-stars" class="star">&#9733;</label>
	  <input type="radio" id="3-stars" class="point" name="rating" value="3" checked="checked" />
	  <label for="3-stars" class="star">&#9733;</label>
	  <input type="radio" id="2-stars" class="point" name="rating" value="2" />
	  <label for="2-stars" class="star">&#9733;</label>
	  <input type="radio" id="1-star" class="point" name="rating" value="1" />
	  <label  for="1-star" class="star">&#9733;</label>
	</div>
</div>
	<textarea rows="4" cols="40" id="reviewText${hotel.id}" class="form-control border-1 mr-2"
		placeholder="후기를 입력하세요"></textarea>
	</div>
	<div class="d-flex align-items-end ml-2">
		<button id="writeBtn" class="btn btn-info writeBtn" data-hotel-id="${hotel.id}">게시</button>
	</div>

</div>	
</c:if>
<c:forEach var="hotel" items="${reviewList}">
	<c:if test="${not empty hotel.review}">


		<div class="d-flex justify-content-center mt-5">
		
			<div class="contents-box col-9 rows-3">
				<div id="review-card" class="d-flex write-box border rounded m-3 review-detail">
					<div class="card w-100 h-100 border-0 ml-3">
						<div class="d-flex justify-content-center mt-2">
							<div>
								<c:if test="${hotel.point == 5}"><div>⭐⭐⭐⭐⭐</div></c:if>
								<c:if test="${hotel.point == 4}"><div>⭐⭐⭐⭐</div></c:if>
								<c:if test="${hotel.point == 3}"><div>⭐⭐⭐</div></c:if>
								<c:if test="${hotel.point == 2}"><div>⭐⭐</div></c:if>
								<c:if test="${hotel.point == 1}"><div>⭐</div></c:if>
								<div>${hotel.review}</div>
							</div>
						</div>
					</div>
					<c:if test="${userId eq hotel.userId}">
						<a href="#" class="reviewDelBtn" data-review-id="${hotel.id}">
							<img src="https://www.iconninja.com/files/603/22/506/x-icon.png"
							width="10px" height="10px">
						</a>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>
</c:forEach>
<script>

	// 리뷰 쓰기
		$('.writeBtn').on('click', function(e) {
			e.preventDefault();
			
			let hotelId = $(this).data('hotel-id');
			//alert(hotelId);
			
			let point = $("input[name='rating']:checked").val(); // 라디오 버튼 중 선택된 value
			//alert(point + "#");
	
			
			let reviewText = $('#reviewText' + hotelId).val().trim(); // 글에 대한 댓글을 가져오기 위해 아이디 뒤에 동적으로 hotelId를 붙인다.
			if (reviewText.length < 1) {
				alert("후기 내용을 입력해주세요.");
				return;
			}
			if (reviewText.length > 255) {
				alert("255자까지만 입력가능합니다.");
				return;
			}
			
//			alert(reviewText);
			$.ajax({
				type:'post',
				url:'/review/create',
				data: {"hotelId" : hotelId, "point" : point,"review" : reviewText},
				success: function(data) {
					if (data.result == 'success') {
						alert("리뷰가 등록 되었습니다");
						location.reload(); // 새로고침
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					var errorMsg = jqXHR.responseJSON.status;
					alert(errorMsg + ":" + textStatus);
				}
			});
		});
		$(document).ready(function() {
			$('.reviewDelBtn').on('click', function(e) {
				e.preventDefault();
				let reviewId = $('.reviewDelBtn').data('review-id');
				alert(reviewId);
				
				$.ajax({
					type:'delete'
					, url: 'review/delete'
					, data: {"reviewId" : reviewId}
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
