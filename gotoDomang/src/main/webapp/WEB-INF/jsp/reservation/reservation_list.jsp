<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			</tr>
		</thead>
		<c:forEach var="hotel" items="${hotelList}">
		<tbody>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>${hotel.hotelName}</td>
			<td>${hotel.hotelNumber}</td>
			<td></td>
		</tr>
		</tbody>
		</c:forEach>
		</table>

</div>