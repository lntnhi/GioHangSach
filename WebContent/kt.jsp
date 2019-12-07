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
	String username =  request.getParameter("username");
	if (!username.isEmpty()) {
		session.setAttribute("un", username);
		response.sendRedirect("Trang1.jsp");
	} else {
		out.print("<script> alert('Đăng nhập sai'); </script>");
	}
%>
</body>
</html>