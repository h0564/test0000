<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="login" method="post">
		아이디 : <input type="text" name="id" maxlength="10"> <br>
		비밀번호 : <input type="password" name="pwd" maxlength="10"> <br>
		<br> <input type="submit" value="로그인"> &nbsp; <input
			type="reset" value="지우기">
	</form>
</body>
</html>