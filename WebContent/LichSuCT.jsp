<%@page import="Bean.CTHDBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.KhachHangBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Chi tiết hóa đơn</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="Content/bootstrap.css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="Content/shop-homepage.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
         <!-- Brand and toggle get grouped for better mobile display -->
         <div class="navbar-header">
             <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                 <span class="sr-only">Toggle navigation</span>
                 <span class="icon-bar"></span>
                 <span class="icon-bar"></span>
                 <span class="icon-bar"></span>
             </button>
             <a class="navbar-brand" href="#">Website Name</a>
         </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
         <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
             <ul class="nav navbar-nav">
                 <li>
                     <a href="HienThiSachController">Home</a>
                 </li>
			    <%if (session.getAttribute("gh")!=null) { 
		    	long tongSoLuong = (long) request.getAttribute("tongSoLuong");
			    long tongTien = (long) request.getAttribute("tongTien");%>
                 <li>
                     <a href="/Giohang/Giohang" text-decoration: none;">
                         Giỏ Hàng (<%=tongSoLuong %>:<%=tongTien %>)</a>
                 </li>
                 <%} else { %>
                 <li>
                     <a href="/Giohang/Giohang" text-decoration: none;">
                         Giỏ Hàng (0)</a>
                 </li>
                 <%}%>
                 <% if (session.getAttribute("un")!=null) { 
                 	KhachHangBean bean = (KhachHangBean)session.getAttribute("un");%>
                 <li>
                     <a href="LichSuController"><% out.print("Lịch sử mua hàng"); %></a>
                 </li>
                 <%} else {
			      	response.sendRedirect("ktController");
			      } %>
             </ul>
         </div>
      </div>
</nav>
<div class="container">
	<table class="table">
		<thead class="thead-dark">
		    <tr>
		      <th scope="col"></th>
		      <th scope="col">Mã CTHD</th>
		      <th scope="col">Tên Sách</th>
		      <th scope="col">Số Lượng Mua</th>
		      <th scope="col">Giá</th>
		      <th scope="col">Số Tập</th>
		      <th scope="col">Tác Giả</th>
		      <th scope="col">Mã Loại</th>
		      <th scope="col">Mã Hóa Đơn</th>
		    </tr>
	  	</thead>
	  	<tbody>
		<%ArrayList<CTHDBean> ds = (ArrayList<CTHDBean>) request.getAttribute("ds");
			for (CTHDBean hd: ds) {%>
				<tr>
					<td><img width = "70px" height = "110px" src="<%=hd.getAnh() %>"></td>
					<th scope="row"><%=hd.getMaCTHD() %></th>
					<td><%=hd.getTenSach() %></td>
					<td><%=hd.getSoLuongMua() %></td>
					<td><%=hd.getGia() %></td>
					<td><%=hd.getSoTap() %></td>
					<td><%=hd.getTacGia() %></td>
					<td><%=hd.getMaLoai() %></td>
					<td><%=hd.getMaHD() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
</body>
</html>