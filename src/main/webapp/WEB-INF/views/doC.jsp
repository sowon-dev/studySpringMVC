<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 doC.jsp입니다<br>

<p></p>

<%-- <strong>(el태그 사용)</strong> 전달받은 파라미터는 ${msg } 입니다. 너의 이름은? ${name }<br>
<strong>(jsp표현식 사용)</strong> 전달받은 파라미터는 <%=request.getParameter("msg") %> 입니다. 너의 이름은? <%=request.getParameter("name") %><br>
 --%>
<strong>(el태그 사용)</strong> 전달받은 파라미터로 이름: ${name }, 전화번호: ${tel }<br>

<p></p>

두가지 표현방식 중 주로 EL표현식을 사용 할 예정이다.
그 이유는 EL표현식은 데이터가 NULL일때 컴파일에러가 없이 빈 공백으로 표시되기때문에 안정성이 높아서이다.
</body>
</html>