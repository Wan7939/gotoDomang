<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>이름</th>
				<th>날짜</th>
				<th>인원</th>
				<th>호텔명</th>
				<th>호텔전화번호</th>
				<th>상태</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach var="content" items="${contentList}">
			<tbody>
				<tr>
					<td>${content.booking.name}</td>
					<td><fmt:formatDate value="${content.booking.date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${content.booking.headcount}</td>
					<td>z</td>
					<td>${content.hotel.hotelNumber}</td>
					<td><c:choose>
							<c:when test="${content.booking.state eq '확정'}">
								<span class="text-success">${content.booking.state}</span>
							</c:when>
							<c:when test="${content.booking.state eq '대기중'}">
								<span class="text-info">${content.booking.state}</span>
							</c:when>
							<c:when test="${content.booking.state eq '취소'}">
								<span class="text-danger">${content.booking.state}</span>
							</c:when>
						</c:choose></td>
					<td>
						<button type="button" class="btn btn-danger delBtn"
							data-booking-id="${content.booking.id}">예약취소</button>
					</td>
				</tr>
			</tbody>
			#${content.booking.id}
		</c:forEach>
		
	</table>

</div>

<script>

	$('.delBtn').on('click', function(e) {
		e.preventDefault();
		let bookingId = $('.delBtn').data('booking-id');
		alert(bookingId);
		
		$.ajax({
			type:'delete'
			, url: 'booking/delete'
			, data: {"bookingId" : bookingId}
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

</script>