package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.GioHangBo;
import Bo.LoaiBo;
import Bo.SachBo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/HienThiSachController")
public class HienThiSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HienThiSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    SachBo bo = new SachBo();
    LoaiBo loaiBo = new LoaiBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String maLoai = request.getParameter("maLoai");
			String key = request.getParameter("txtTimKiem");
			if (session.getAttribute("gh")!=null) {
				GioHangBo ghBo = (GioHangBo)session.getAttribute("gh");
				request.setAttribute("ds", ghBo.ds);
				request.setAttribute("tongTien", ghBo.tongTien());
				request.setAttribute("tongSoLuong", ghBo.tongSoLuong());
			}
			request.setAttribute("dsloai", loaiBo.getLoai());
			if (maLoai!=null) {
				request.setAttribute("ds", bo.getSachByLoai(maLoai));
			}
			else {
				if (key!=null)
					request.setAttribute("ds", bo.timSach(key));	
				else request.setAttribute("ds", bo.getSach());	
			}
			RequestDispatcher rd = request.getRequestDispatcher("HienThiSach.jsp");
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
