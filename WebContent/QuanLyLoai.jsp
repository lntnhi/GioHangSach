<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Quản lý loại</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<div class="container">
<form action="AdminLoaiController">
	<label>Mã loại</label>
	<input type="text" name="txtMaLoai" value="<%if (loaiChon!=null) out.print(loaiChon.getMaLoai()); %>" class="form-control"> <br>
	<label>Tên loại</label>
	<input type="text" name="txtTenLoai" value="<%if (loaiChon!=null) out.print(loaiChon.getTenLoai()); %>" class="form-control"> <br>
	<input type="submit" name="btnThem" value="Thêm" class="btn btn-outline-info">
	<input type="submit" name="btnSua" value="Sửa" class="btn btn-outline-info"> <br>
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
		         <a href="AdminLoaiController?maLoaiChon=<%=loai.getMaLoai()%>" class="btn btn-outline-info">Chọn</a>
		         <a href="AdminLoaiController?maLoaiXoa=<%=loai.getMaLoai()%>" class="btn btn-outline-danger">Xóa</a>
		       </td>
		     </tr>	
		<%} %>   
    </tbody>
  </table>
</div>
</body>
</html>