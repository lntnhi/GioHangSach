<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	 <a class="navbar-brand" href="#">WebSiteName</a>
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="ktController">Home</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="GioHangController">Giỏ Hàng</a>
	    </li>
	  </ul>
	</nav>
	<form method="post" action="ktController">
		Username 
		<input type="text" name="username" value=""> <br>
		Password
		<input type="password" name="pass" value=""> <br>
		<input type="submit" name="btn" value="Dang nhap"> 
	</form>
	<a href="ktController?kt=2">Gọi lên servlet</a>
</body>
</html>