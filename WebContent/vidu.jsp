<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Gia tri cua session <%=session.getAttribute("un")%> <hr>
Gia tri so <%=(long)request.getAttribute("gt1") %> <hr>
Gia tri chu <%=request.getAttribute("gt2") %> <hr>
Gia tri chuoi <% String[] ds=(String[])request.getAttribute("ds"); 
	for (String ht:ds) 
		out.print(ht);%>
</body>
</html>