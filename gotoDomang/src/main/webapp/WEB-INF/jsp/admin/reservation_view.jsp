<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="contents ml-5">
                <h2 class="text-center font-weight-bold m-4">예약 목록 보기</h2>
                <table class="table text-center">
                    <thead>
                        <tr>
                            <th>이름</th>
                            <th>예약날짜</th>
                            <th>숙박일수</th>
                            <th>숙박인원</th>
                            <th>전화번호</th>
                            <th>예약상태</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="booking" items="${bookingList}">
                        <tr>
                            <td>${booking.name}</td>
                            <td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일" /></td>
                            <td>${booking.day}</td>
                            <td>${booking.headcount}</td>
                            <td>${booking.phoneNumber}</td>
                            <td>
                            <a href="#">
                            	<c:choose>
                            		<c:when test="${booking.state eq '확정'}">
                            			<span class="text-success">${booking.state}</span>
                            		</c:when>
                            		<c:when test="${booking.state eq '대기중'}">
                            			<span class="text-info">${booking.state}</span>
                            		</c:when>
                            		<c:when test="${booking.state eq '취소'}">
                            			<span class="text-danger">${booking.state}</span>
                            		</c:when>
                            	</c:choose>
                            	</a>
                            </td>
                            <td>
                            	<button type="button" class="btn btn-danger delBtn" data-booking-id="${booking.id}">삭제</button>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
<script>
  $(document).ready(function() {
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
}); 
</script>