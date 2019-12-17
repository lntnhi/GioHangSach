package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.KhachHangBean;
import Bo.CTHDBo;
import Bo.GioHangBo;
import Bo.HoaDonBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		* Thêm sách
		*/
		String maSach = request.getParameter("ma");
		String tenSach = request.getParameter("ten");
		String tacGia = request.getParameter("tacgia");
		String g = request.getParameter("gia");
		HttpSession session = request.getSession();
		if (g!=null) {
			Long gia = Long.parseLong(g);
			GioHangBo ghBo = null;
			//kiểm tra xem đã tạo ra session chưa, nếu chưa thì tạo một ss để lưu sách
			if (session.getAttribute("gh")==null) {
				ghBo = new GioHangBo(); //giỏ hàng chỉ được new ra 1 lần thôi
				session.setAttribute("gh", ghBo);
			}
			//b1. lấy ss lưu vào biến ghBo
			ghBo = (GioHangBo)session.getAttribute("gh");
			//b2. thay đổi ghBo: gọi hàm thêm
			ghBo.them(maSach, tenSach, tacGia, gia, (long)1);
			//b3. lưu biến vào ss
			session.setAttribute("gh", ghBo);
			//Hiển thị giỏ hàng
			request.setAttribute("ds", ghBo.ds);
			request.setAttribute("tongTien", ghBo.tongTien());
			request.setAttribute("tongSoLuong", ghBo.tongSoLuong());
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
			rd.forward(request, response);
		}
		/**
		* Sửa số lượng
		*/
		GioHangBo bo = (GioHangBo)session.getAttribute("gh");
		String maAdd = request.getParameter("btnAdd");
		String num[] = request.getParameterValues("number");
		Long number = (long)0;
		if (maAdd!=null && maAdd!="" && num!=null) {
			for (String no : num) {
				if (no!="") {
					number = Long.parseLong(no);
					bo.updateSoLuong(maAdd, number, bo.ds);
					request.setAttribute("ds", bo.ds);
					request.setAttribute("tongTien", bo.tongTien());
					request.setAttribute("tongSoLuong", bo.tongSoLuong());
					RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
					rd.forward(request, response);
				}
			}		
		}
		/**
		* Xóa
		*/
		String maDel = request.getParameter("btnDel");
		if (maDel!= null) {
			bo.delete(maDel, bo.ds);
			request.setAttribute("ds", bo.ds);
			request.setAttribute("tongTien", bo.tongTien());
			request.setAttribute("tongSoLuong", bo.tongSoLuong());
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
			rd.forward(request, response);
		}
		/**
		* Xóa checkbox
		*/
		String checkbox[] = request.getParameterValues("checkbox");
		String delCheckbox = request.getParameter("delCheckbox");
		if (checkbox!=null && delCheckbox!=null) {
			for (String chk: checkbox)
				bo.delCheckbox(chk);
			request.setAttribute("ds", bo.ds);
			request.setAttribute("tongTien", bo.tongTien());
			request.setAttribute("tongSoLuong", bo.tongSoLuong());
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
			rd.forward(request, response);
		}
		
		/**
		 * Đặt mua
		 */
		KhachHangBean kh = null;
		if (session.getAttribute("un")!=null) 
         	kh = (KhachHangBean)session.getAttribute("un");
		HoaDonBo hdBo = new HoaDonBo();
		CTHDBo ctBo = new CTHDBo();
		String btnBuy = request.getParameter("btnBuy");
		if (btnBuy!=null) {
			try {
				hdBo.them(kh.getMaKH());
				long maHD = hdBo.maHDmax();
				for (GioHangBean gh: bo.ds) {
					ctBo.them(gh.getMaSach(), gh.getSoLuong(), maHD);					
				}				
				session.setAttribute("gh", null);
				RequestDispatcher rd = request.getRequestDispatcher("LichSuController");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (session.getAttribute("gh")==null) {
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("ds", bo.ds);
			request.setAttribute("tongTien", bo.tongTien());
			request.setAttribute("tongSoLuong", bo.tongSoLuong());
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
