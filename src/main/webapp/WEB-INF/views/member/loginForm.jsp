<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" />
</head>
<body>
loginFrom.jsp
<h1>views의 폴더명은 컨트롤러의 모듈명과 동일</h1>

<fieldset>
<legend>로그인</legend>
	<form action="/test/member/login" method="post" name="fr">
		아이디 <input type="text" name="userid" required ><br>
		비밀번호 <input type="password" name="userpw"><br>
		<input type="submit" class="btn" value="로그인">
		<input type="button" class="btn" value="회원가입" onclick="location.href='/test/member/insert'">
	</form>
</fieldset>
</body>
</html>