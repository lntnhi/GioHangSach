<%@page import="Bean.XNDMBean"%>
<%@page import="Bean.HoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin - Quản lý Hóa đơn</title>
    <meta name="viewport" content="width=device-width" />
    <meta charset="utf-8">
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
                     <a href="AdminLoaiController">Loại</a>
                 </li>
                 <li>
                     <a href="AdminSachController">Sách</a>
                 </li>
                 <li>
                     <a href="AdminHDController">Hóa Đơn</a>
                 </li>
             </ul>
         </div>
      </div>
</nav>
<div class="container">
	<table class="table">
		<thead class="thead-dark">
		    <tr>
		      <th scope="col">Mã Hóa Đơn</th>
		      <th scope="col">Mã Khách Hàng</th>
		      <th scope="col">Họ Tên</th>
		      <th scope="col">Tổng Số Lượng</th>
		      <th scope="col">Thành Tiền</th>
		      <th scope="col">Trạng Thái</th>
		    </tr>
	  	</thead>
	  	<tbody>
		<%ArrayList<XNDMBean> ds = (ArrayList<XNDMBean>) request.getAttribute("ds");
			for (XNDMBean hd: ds) {%>
				<tr>
					<th scope="row"><a href="AdminCTHDController?maHD=<%=hd.getMaHD() %>"><%=hd.getMaHD() %></a></th>
					<td><%=hd.getMaKH() %></td>
					<td><%=hd.getHoTen() %></td>
					<td><%=hd.getTongSL() %></td>
					<td><%=hd.getThanhTien() %></td>
					<td><a href="AdminHDController?btnConfirm=<%=hd.getMaHD() %>" class="btn btn-primary mr-2">Xác nhận</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
</body>
</html>