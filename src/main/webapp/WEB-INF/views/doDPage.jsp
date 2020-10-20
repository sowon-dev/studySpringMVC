<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전달받은 객체 호출(doDpage.jsp)<br>
<!-- toString()를 통해서 출력 -->
<%=request.getAttribute("vo") %>
<p></p>
제품명 : ${vo.name } <br>
가격 : ${vo.price } <br>

<hr>
제품명 : ${productVO.name } <br>
가격 : ${productVO.price } <br>
</body>
</html>