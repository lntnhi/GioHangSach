<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.HoaDonBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lịch sử mua hàng</title>
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
         <a class="navbar-brand" href="HienThiSachController">Website Name</a>
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
                 <a href="GioHangController" text-decoration: none;">
                     Giỏ Hàng (<%=tongSoLuong %>:<%=tongTien %>)</a>
             </li>
             <%} else { %>
             <li>
                 <a href="GioHangController" text-decoration: none;">
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
     <li>
                 <a href="DangXuatController"><% out.print("Đăng xuất"); %></a>
             </li>
             <li style="margin: 20px 0 0 250px;"><!-- Tìm kiếm -->
             <form action="HienThiSachController" method="post">
             	<label style="color:white">Tìm kiếm</lablel> 
             	<input type="text" name="txtTimKiem" style="color:black">
             </form>
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
		      <th scope="col">Ngày Mua</th>
		      <th scope="col">Trạng Thái</th>
		    </tr>
	  	</thead>
	  	<tbody>
		<%ArrayList<HoaDonBean> ds = (ArrayList<HoaDonBean>) request.getAttribute("ds");
			for (HoaDonBean hd: ds) {%>
				<tr>
					<th scope="row"><a href="LichSuCTController?maHD=<%=hd.getMaHD() %>"><%=hd.getMaHD() %></a></th>
					<td><%=hd.getDate() %></td>
					<td><% if(hd.isDaMua()==true) out.print("Đã chuyển tiền"); else out.print("Chưa chuyển tiền"); %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
</body>
</html>