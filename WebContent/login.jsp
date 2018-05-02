<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<p>ログイン画面を表示するJSP</p>
	<br>
	<form action="/chat_test/servlet/LoginServlet" method="get">
		ログインID <input type="text" name="loginId" value="">
		<p>
			パスワード <input type="password" name="loginPass" value="">
		<p>
			<input type="submit" value="ログイン">
	</form>
</body>
</html>
