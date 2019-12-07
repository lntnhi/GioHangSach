package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.LoaiBo;

/**
 * Servlet implementation class AdminLoaiController
 */
@WebServlet("/AdminLoaiController")
public class AdminLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    LoaiBo bo = new LoaiBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String maLoai = request.getParameter("txtMaLoai");
			String tenLoai = request.getParameter("txtTenLoai");
			if (request.getParameter("btnThem")!=null) {
				int n = bo.them(maLoai, tenLoai);
				if (n==0) request.setAttribute("kqThem", 0);
			}
			if (request.getParameter("btnSua")!=null) {
				bo.sua(maLoai, tenLoai);
			}
			if (request.getParameter("maLoaiChon")!=null) {
				request.setAttribute("loaiChon", bo.getLoaiByMa(request.getParameter("maLoaiChon")));
			}
			if (request.getParameter("maLoaiXoa")!=null) {
				int n = bo.xoa(request.getParameter("maLoaiXoa"));
				if (n==0) request.setAttribute("kqXoa", 0);
			}
			request.setAttribute("dsLoai", bo.getLoai());
			RequestDispatcher rd = request.getRequestDispatcher("QuanLyLoai.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
