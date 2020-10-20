<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
여기는 doF.jsp입니다.<br>
<h2>키값이 있는 파라미터 값 가져오기(객체는 안됨)</h2>
메세지(키값 msg) : ${msg }<br>
<hr>
<h2>키값이 없는 int 파라미터 값 가져오기</h2>
메세지(integer) : ${integer } 키값이 아니라서 안됨<br>
메세지(param.integer) : ${param.integer } 파람데이터영역에서 꺼내기때문에 가능<br>
메세지(requestScope.integer) : ${requestScope.integer } 왜안될까? <br>
<hr>
<h2>키값이 없는 String 파라미터 값 가져오기</h2>
메세지(string) : ${string }  키값이 아니라서 안됨<br>
메세지(param.string) : ${param.string }<br>
메세지(requestScope.string) : ${requestScope.string } 왜안될까? <br>

</body>
</html>