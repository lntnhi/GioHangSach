package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.GioHangBo;
import Bo.KhachHangBo;
import Bo.LoaiBo;
import Bo.SachBo;

/**
 * Servlet implementation class ktController
 */
@WebServlet("/ktController")
public class ktController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ktController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    KhachHangBo bo = new KhachHangBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy giá trị từ client gửi lên
		HttpSession session = request.getSession();
		String username =  request.getParameter("username");
		String pass =  request.getParameter("pass");
		try {
			KhachHangBean bean = bo.isExist(username, pass);
			if (bean!=null) 
				session.setAttribute("un", bean);
			if (session.getAttribute("un")==null) { //chạy lần đầu thì mở trang dangnhap.jsp
				RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
				rd.forward(request, response);
			}
			else {
				SachBo bo = new SachBo();
				LoaiBo loaiBo = new LoaiBo();
				try {
					request.setAttribute("ds", bo.getSach());
					request.setAttribute("dsloai", loaiBo.getLoai());
				} catch (Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("HienThiSach.jsp");
				rd.forward(request, response);
			}		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
