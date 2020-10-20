<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
loginFrom.jsp
<h1>views의 폴더명은 컨트롤러의 모듈명과 동일</h1>
<h1> 로그인 </h1>

<fieldset>
  <legend> ITWILL 로그인 </legend>
  <!-- <form action="/member/login" method="post"> -->
  <form action="" method="post">
    ID : <input type="text" name="userid"> <br>
    PW : <input type="password" name="userpw"> <br>
    <input type="submit" value="로그인">          
    <input type="button" onclick="location.href='/member/insert'" value="회원가입">          
  </form>  
</fieldset>
</body>
</html>