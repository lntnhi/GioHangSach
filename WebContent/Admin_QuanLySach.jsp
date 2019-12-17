<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Bean.SachBean"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Quản lý Sách</title>
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
<% if (request.getAttribute("kqThem")!=null) {
	out.print("<script>alert('Trùng mã!')</script>");
	}
	SachBean sachChon = (SachBean)request.getAttribute("sachChon");
%>
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
<div class="container mt-3">
<form method="post" action="AdminSachController" enctype= "multipart/form-data">
	<label>Mã sách</label>
	<input type="text" name="txtMaSach" value="<%if (sachChon!=null) out.print(sachChon.getMaSach()); %>" class="form-control"> <br>
	<label>Tên sách</label>
	<input type="text" name="txtTenSach" value="<%if (sachChon!=null) out.print(sachChon.getTenSach()); %>" class="form-control"> <br>
	<label>Tác giả</label>
	<input type="text" name="txtTacGia" value="<%if (sachChon!=null) out.print(sachChon.getTacGia()); %>" class="form-control"> <br>
	<label>Giá</label>
	<input type="number" name="txtGia" value="<%if (sachChon!=null) out.print(sachChon.getGia()); %>" class="form-control"> <br>
	<label>Số lượng</label>
	<input type="number" name="txtSoLuong" value="<%if (sachChon!=null) out.print(sachChon.getSoLuong()); %>" class="form-control"> <br>
	<label>Ngày nhập</label>
	<input type="date" name="txtNgayNhap" 
						value="<%if (sachChon!=null) {
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
								Date d1 = df.parse(sachChon.getNgayNhap());
								SimpleDateFormat y = new SimpleDateFormat("yyyy");
								String year = y.format(d1);
								SimpleDateFormat m = new SimpleDateFormat("MM");
								String month = m.format(d1);
								SimpleDateFormat d = new SimpleDateFormat("dd");
								String date = d.format(d1);
								out.print(year+"-"+month+"-"+date);
								} %>" 
						class="form-control"> <br>
	<label>Ảnh</label>
	<%if (sachChon!=null) {%> <img alt="anh" width="200px" src="<% out.print(sachChon.getAnh()); %>"> <%} %>
  	<input type="file" name="txtfile" class="form-control"><br>
  	<label>Số tập</label>
	<input type="text" name="txtSoTap" value="<%if (sachChon!=null) out.print(sachChon.getSoTap()); %>" class="form-control"> <br>
	<label>Loại</label>
	<select name="cbbMaLoai" class="form-control">
	  <% ArrayList<LoaiBean> dsLoai = (ArrayList<LoaiBean>) request.getAttribute("dsLoai");
		for (int i =0; i<dsLoai.size(); i++) {
			LoaiBean bean = dsLoai.get(i); %>
	    <option value="<%=bean.getMaLoai() %>" 
	    <% if (sachChon!=null)
	    	if (bean.getMaLoai().equals(sachChon.getMaLoai())) out.print("selected"); %>>
	    <%=bean.getTenLoai() %>
	    </option>
	    <%} %>
	</select> <br>
	<input type="submit" name="btnThem" value="Thêm" class="btn btn-primary">
	<input type="submit" name="btnSua" value="Sửa" class="btn btn-primary"> <br>
</form> 
<table class="table mt-3">
    <thead class="thead-dark">
      <tr>
        <th scope="col">Mã Sách</th>
        <th scope="col">Tên Sách</th>
        <th scope="col">Tác Giả</th>
        <th scope="col">Giá</th>
        <th scope="col">Số Lượng</th>
        <th scope="col">Mã Loại</th>
        <th scope="col">Ngày Nhập</th>
        <th scope="col">Ảnh</th>
        <th scope="col">Số Tập</th>
        <th scope="col">Thao Tác</th>
      </tr>
    </thead>
    <tbody>
       <% ArrayList<SachBean> dsSach = (ArrayList<SachBean>) request.getAttribute("dsSach");
		for (int i =0; i<dsSach.size(); i++) {
			SachBean bean = dsSach.get(i); %>
			<tr>
				<td><%=bean.getMaSach() %></td>
				<td><%=bean.getTenSach() %></td>
				<td><%=bean.getTacGia() %></td>
				<td><%=bean.getGia() %></td>
				<td><%=bean.getSoLuong() %></td>
				<td><%=bean.getMaLoai() %></td>
				<td><%=bean.getNgayNhap() %></td>
				<td><%=bean.getAnh() %></td>
				<td><%=bean.getSoTap() %></td>
				<td class="d-flex">
		         <a href="AdminSachController?maChon=<%=bean.getMaSach()%>" class="btn btn-primary mr-2">Chọn</a>
		         <a href="AdminSachController?maXoa=<%=bean.getMaSach()%>" class="btn btn-danger">Xóa</a>
		       </td>
		     </tr>	
		<%} %>   
    </tbody>
</table>
</div>
</body>
</html>