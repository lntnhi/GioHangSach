<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.SachBean"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Hiển Thị Sách</title>
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
    <!-- Navigation -->
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
    
    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-3">
            	<!-- Loại sách -->
                <p class="lead"> CHỦ ĐỀ SÁCH</p>
                <div class="list-group">
	                <% ArrayList<LoaiBean> dsLoai = (ArrayList<LoaiBean>) request.getAttribute("dsloai");
					for (int i =0; i<dsLoai.size(); i++) {
						LoaiBean loai = dsLoai.get(i); %>
                    <a href="HienThiSachController?maLoai=<%=loai.getMaLoai()%>" class="list-group-item"><%=loai.getTenLoai() %></a>
                 	<%} %>
                </div>
            </div>
            
            <div class="col-md-9">
            	<!-- Slide ảnh -->
                <div class="row carousel-holder"> 
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1" ></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"class="active"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="images/ancient-place.jpg" alt="">

                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/riverside-city.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/kayaks.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                
                <!-- Book -->
                <div>
                    <h3 style="Text-align:Center; color:red"> SÁCH MỚI </h3>
                    <div class="row">
                    <% ArrayList<SachBean> ds = (ArrayList<SachBean>) request.getAttribute("ds");
					int n = ds.size();
					for (int i =0; i<n; i++) {
						SachBean sach = ds.get(i); %>
                        <div class="col-sm-4 col-lg-4 col-md-4" >
                            <div class="thumbnail">
                            <form method="post" action="GioHangController?ma=<%=sach.getMaSach()%>&ten=<%=sach.getTenSach()%>&tacgia=<%=sach.getTacGia()%>&gia=<%=sach.getGia()%>">
                            	<button type = "submit">
                            		<img alt="<%=sach.getTenSach() %>" src="<%=sach.getAnh() %>" style="height:280px; width:244px" />
                                    <div><br/>
                                        <h4 style="text-align:center; margin: 0; height:30px"><%=sach.getTenSach() %></h4>
                                        <p></p>
                                    </div>
                            	</button>
                            </form>
                            </div>
                        </div>
					<% } %>
                    </div>
                    Trang 1/3;
                    <div class="MenuTrang">
                        <div class="pagination-container"><ul class="pagination"><li class="active"><a>1</a></li><li><a href="/BookStore?page=2">2</a></li><li><a href="/BookStore?page=3">3</a></li><li class="PagedList-skipToNext"><a href="/BookStore?page=2" rel="next">»</a></li></ul></div>
                    </div>
                    <style>
                        .MenuTrang li {
                            display: inline;
                        }
                    </style>
                </div>
            </div>
        </div>
    </div>
    
    <!-- footer -->
    <div class="container">
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; MVC 5</p>
                </div>
            </div>
        </footer>
    </div>
    <!-- jQuery -->
    <script src="/Scripts/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/Scripts/bootstrap.min.js"></script>
</body>
</html>