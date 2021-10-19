<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty userId}">
	<div class="login-info d-flex align-items-center justify-content-end p-2">
		<%-- session 정보가 있는경우에만 출력 --%>

		<span class="font-weight-bold mr-3">${userName}님 안녕하세요.</span> <a
			href="/user/sign_out" class="font-weight-bold mr-3">로그아웃</a>

	</div>
</c:if>