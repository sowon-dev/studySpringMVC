<%@page import="org.springframework.ui.Model"%>
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

<input type="button" value="회원정보조회" class="btn" onclick="location.href='/member/info'">
<input type="button" value="회원정보수정" class="btn" onclick="location.href='/member/update'">
<input type="button" value="로그아웃" class="btn" onclick="location.href='/member/logout'">
<input type="button" value="회원탈퇴" class="btn" onclick="location.href='/member/delete'">

<!-- 관리자일때만 메뉴확인가능 -->
<% 
if(id != null){
 if(id.equals("admin")){ %>
  <input type="button" value="회원전체목록(관리자용)" class="btn" onclick="location.href='/member/memberList'">
  <input type="button" value="상품전체목록(관리자용)" class="btn" onclick="location.href='/member/adminGoodsList'">
  <input type="button" value="주문전체목록(관리자용)" class="btn" onclick="location.href='/member/adminOrderList'">  
<%
 }
}
%>

</body>
</html>