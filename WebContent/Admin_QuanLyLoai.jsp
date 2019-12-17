<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin - Quản lý loại</title>
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
<% if (request.getAttribute("kqThem")!=null) {
	out.print("<script>alert('Trùng mã!')</script>");
	}
	if (request.getAttribute("kqXoa")!=null) {
		out.print("<script>alert('Loại có sách không xóa được!')</script>");
	}
	LoaiBean loaiChon = (LoaiBean)request.getAttribute("loaiChon");
%>
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
<form action="AdminLoaiController">
	<label>Mã loại</label>
	<input type="text" name="txtMaLoai" value="<%if (loaiChon!=null) out.print(loaiChon.getMaLoai()); %>" class="form-control"> <br>
	<label>Tên loại</label>
	<input type="text" name="txtTenLoai" value="<%if (loaiChon!=null) out.print(loaiChon.getTenLoai()); %>" class="form-control"> <br>
	<input type="submit" name="btnThem" value="Thêm" class="btn btn-primary">
	<input type="submit" name="btnSua" value="Sửa" class="btn btn-primary"> <br>
</form>
<table class="table">
    <thead class="thead-dark">
      <tr>
        <th scope="col">Mã Loại</th>
        <th scope="col">Tên Loại</th>
        <th scope="col">Thao tác</th>
      </tr>
    </thead>
    <tbody>
       <% ArrayList<LoaiBean> dsLoai = (ArrayList<LoaiBean>) request.getAttribute("dsLoai");
		for (int i =0; i<dsLoai.size(); i++) {
			LoaiBean loai = dsLoai.get(i); %>
			<tr>
				<td><%=loai.getMaLoai() %></td>
				<td><%=loai.getTenLoai() %></td>
				<td class="d-flex">
		         <a href="AdminLoaiController?maLoaiChon=<%=loai.getMaLoai()%>" class="btn btn-primary mr-2">Chọn</a>
		         <a href="AdminLoaiController?maLoaiXoa=<%=loai.getMaLoai()%>" class="btn btn-danger">Xóa</a>
		       </td>
		     </tr>	
		<%} %>   
    </tbody>
  </table>
</div>
</body>
</html>