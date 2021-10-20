<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="d-flex mt-5 justify-content-around">
		<a href="#"><h5>예약확인</h5></a>

	<form method="get" action="/save.php">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="호텔 이름을 검색하세요!">
			<span class="input-group-btn">
				<button class="btn btn-secondary" type="button">찾기</button>
			</span>
		</div>
	</form>

	<select>
            <option>가격 낮은순</option>
            <option>가격 높은순</option>
            <option>별점 낮은순</option>
            <option>별점 높은순</option>
        </select>
	</div>

	<div class="d-flex justify-content-center mt-5">
		<div class=" contents-box col-10">
		
			<div id="hotel-card"class="d-flex write-box border rounded m-3" >
				<img src="https://content.r9cdn.net/rimg/himg/8d/79/64/revato-1383973-12136887-729771.jpg?width=915&height=345&xhint=1440&yhint=999&crop=true" width="350" height="350"  alt="이미지">
					<div id="hotel-detail" class="card-post w-100 h-100 border-0 ml-3 pt-2">
					<b>호텔 이름</b>: 시그니엘 서울  <br> <br>
					<b>호텔 주소</b>: 서울 송파구 올림픽로 300 롯데월드타워 76-101층<br> <br>
					<b>호텔 설명</b>: <br>시그니엘 서울은 롯데호텔앤리조트의 최상급 호텔 브랜드로,
					롯데월드타워 76층에서 101층에 위치해 있습니다. 지하철 2, 8호선 잠실역 1번 출구에서 도보로 약 5분 거리에
					있으며, 바로 앞에는 도심 쉼터인 석촌 호수가 걸어서 약 10분, 롯데월드까지는 10분이면 갈 수 있습니다. 호텔에는
					수영장, 피트니스센터, 사우나뿐 아니라, 한국 최초의 '에비앙' 스파 시설도 준비되어 있습니다. 이외에 여러 규모의
					연회장과 투숙객 전용 라운지도 있습니다. 총 235개의 객실을 보유하며, 서울 도심 또는 한강 전경을 감상하실 수
					있습니다. 객실은 슈퍼 프리미엄 베딩 시스템을 갖추었으며 맞춤형 베개와 턴다운 서비스도 제공합니다. 내부에는 에어컨,
					TV, 냉장고, 커피 메이커, 슬리퍼 등이 있으며 욕실도 구비되어 있습니다. 미쉐린 3스타 셰프가 선보이는 '스테이, 모던
					레스토랑' 에서는 프랑스 요리를 맛보실 수 있습니다. 미쉐린 1스타 레스토랑으로 선정된 '비채나(Bicena)'에서는
					고급스러운 분위기에서 한식을 드실 수 있습니다. 시그니엘서울의 '더라운지'에서는 아닉 일레노 셰프가 컨설팅한 메뉴를 비롯해
					프랑스식 애프터눈 티 세트와 다양한 커피 및 티를 선보여드립니다. 이외에 '바 81'와 회원제로 운영되는 '시그니엘 클럽
					다이닝 & 바'도 마련되어 있습니다.<br><br>
					<b>호텔 가격</b>: 471,900원<br> <br>
					
					<b>호텔 연락처</b>: 02-3427-7939<br>
					</div>
		</div>
		<div class="d-flex justify-content-end">
				<button id="revewBtn" class="btn btn-info mr-2">후기보기</button>
				<button id="reservationBtn" class="btn btn-info ">예약하기</button>
		</div>
	</div>
</div>

