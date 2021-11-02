<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="hotel" items="${hotelList}">
	<div class="d-flex justify-content-center mt-5">




		<div class="border rounded mt-3">

			<%-- 글쓴이 아이디 및 ... 버튼(삭제) : 이 둘을 한 행에 멀리 떨어뜨려 나타내기 위해 d-flex, between --%>
			<div class="p-2 d-flex justify-content-center">
				<span class="font-weight-bold">${hotel.hotelName}</span>
			</div>

			<div class="card-img">
				<img src="${hotel.imagePath}" width="300" height="300" alt="이미지">
			</div>

		</div>
	</div>
		
		<div class="d-flex justify-content-center mt-5">
			<textarea rows="4" cols="40" name="contents" class="form-control" placeholder="후기를 입력하세요"></textarea>
			<div class="d-flex align-items-end ml-2">
				<button id="writeBtn" class="btn btn-info">게시</button>
			</div>
		</div>
</c:forEach>