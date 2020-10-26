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
<h1>member</h1>
<%
// 로그인 처리 -> 로그인 x (로그인페이지 이동)
String id = (String) session.getAttribute("id");
if( id == null ){
	 response.sendRedirect("/test/member/main");
}
%> 
<fieldset>
	<legend>회원탈퇴</legend>
	<form action="/test/member/delete" method="post">
	<!-- input타입중 hidden은 화면에 있는 해당 input태그를 숨겨서 정보 전달   -->
		아이디 : <input type="text" name="userid" value="<%=id %>" readonly><br>
		비밀번호 : <input type="password" name="userpw" required><br>
		<input type="submit" class="btn" value="탈퇴하기">
		<input type="button" class="btn" value="뒤로가기" onclick="location.href='/test/member/main'">
	</form>
</fieldset>
</body>
</html>