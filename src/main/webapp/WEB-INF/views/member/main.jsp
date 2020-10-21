<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member/main.jsp</h1>
<%
String id = (String) session.getAttribute("id");
if(id == null) response.sendRedirect("/member/login");
%>
jsp표현식 세션 : <%= id %> <br>
el표현식 세션: ${id } <br>
그냥 : ${username } , ${useremail } <br>
mvo그냥 : ${mvo.username } , ${mvo.useremail } <br>

<hr>
<input type="button" onclick="location.href='/member/logout'" value="로그아웃">

</body>
</html>