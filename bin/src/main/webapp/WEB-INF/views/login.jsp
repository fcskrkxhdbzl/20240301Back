<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btnLogin").on("click", function() {
			$.ajax({
				type : "POST", // HTTP method type(GET, POST) 형식이다.
				url : "/login", // 컨트롤러에서 대기중인 URL 주소이다.
				data : {
					id : $("#id").val(),
					pw : $("#pw").val()
				}, // Json 형식의 데이터이다.
				success : function(res) {
					console.log(res);// 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
					alert(res.resMsg);
					$("#loginResult").show();
					$("#loginResult").text(res.resMsg);

					if (res.resCode == 'S')
						$("#loginResult").css('color', 'blue');
					else
						$("#loginResult").css('color', 'red');
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
					alert("로그인실패");
				}
			});
		});
	});
</script>
</head>
<body>
	아이디
	<input id="id"> 비밀번호
	<input id="pw">
	<button id="btnLogin" type="button">로그인</button>
	<span id="loginResult" style="display: none;">로그인 성공</span>
</body>
</html>