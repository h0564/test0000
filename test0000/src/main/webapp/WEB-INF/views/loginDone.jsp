<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   alert('${login.name} 님 로그인 되었습니다.')
      location.href="list"
</script>
</head>
<body>
<h1>${login.name}정상</h1>

</body>
</html>