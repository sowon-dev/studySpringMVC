<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>member/logout.jsp</h2>
<%
/* session.invalidate(); */
%>
<script type="text/javascript">
	alert("정상적으로 로그아웃 되었습니다");
	location.href="/test/member/main";
</script>
</body>
</html>