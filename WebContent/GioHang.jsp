<%@page import="Bean.KhachHangBean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Bean.GioHangBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width" />
    <title>Giỏ Hàng</title>
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
	<%if (session.getAttribute("gh")!=null) { %>
<form action="GioHangController" method="post">
	<div class="container">
	<table class="table">
		<thead class="thead-dark">
		    <tr>
		      <th scope="col" class="text-center">Mã Sách</th>
		      <th scope="col" class="text-center">Tên Sách</th>
		      <th scope="col" class="text-center">Tác Giả</th>
		      <th scope="col" class="text-center">Số Lượng</th>
		      <th scope="col" class="text-center">Thao tác <button type='submit' class="text-right btn btn-danger" name='delCheckbox' value='Xóa'>Xóa đã chọn</button></th>
		      <th scope="col" class="text-center">Đơn Giá</th>
		      <th scope="col" class="text-center">Thành Tiền</th>
		    </tr>
	  	</thead>
	  	<tbody>
		<%ArrayList<GioHangBean> ds = (ArrayList<GioHangBean>) request.getAttribute("ds");
			for (GioHangBean ht: ds) {%>
				<tr>
					<th scope="row"><input type="checkbox" name='checkbox' value='<%=ht.getMaSach()%>'><%=ht.getMaSach() %></th>
					<td><%=ht.getTenSach() %></td>
					<td><%=ht.getTacGia() %></td>
					<td><%=ht.getSoLuong() %></td>
					<td>
						<input type="number" name="number" value="">
						<button class ="btn btn-primary" type="submit" name="btnAdd" value="<%=ht.getMaSach()%>">Thêm</button>
						<button class ="btn btn-danger" type="submit" name="btnDel" value="<%=ht.getMaSach()%>">Xóa</button>
					</td>
					<td><%=ht.getGia() %></td>
					<td><%=ht.getThanhTien()%></td>
				</tr>
			<%}
			DecimalFormat dd = new DecimalFormat("###,###");%>
			<div class="text-right font-italic">
			<% long tongTien = (long) request.getAttribute("tongTien");
			out.print("Tổng tiền: <b>"+ dd.format(tongTien) + "</b>"); %>
			</div>
		<%} else {%>
			<h5 class="text-center mt-5">Giỏ hàng trống!</h5>
			<%}%>
		</tbody>
	</table>
	</div>
	<%if (session.getAttribute("gh")!=null) { %>
	<div class="container clearfix">
		<button type='submit' class="text-right btn btn-primary pull-right" name='btnBuy' value='buy'>Đặt hàng</button>
	</div>	
	<%} %>
</form>
</body>
</html>