<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/style.css" rel="stylesheet" />
</head>
<body>
insertMember.jsp 입니다
<h1>views의 폴더명은 컨트롤러의 모듈명과 동일</h1>

<fieldset>
<legend>회원가입</legend>
	<form action="/member/insert" method="post" name="fr">
		아이디 <input type="text" name="userid" required><br>
		비밀번호 <input type="password" name="userpw"><br>
		이름 <input type="text" name="username"><br>
		이메일 <input type="text" name="usereamail"><br>
		<input type="submit" class="btn" value="회원가입하기">
		<input type="button" onclick="location.href='/main'" value="메인으로 돌아가기">
	</form>
</fieldset>

</body>
</html>