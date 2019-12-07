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

import Bo.GioHangBo;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy giá trị từ client gửi lên
		HttpSession session = request.getSession();
		String username =  request.getParameter("username");
		String pass =  request.getParameter("pass");
		String kt =  request.getParameter("kt");
		if (username != null) 
			session.setAttribute("un", username);
		if (session.getAttribute("un")==null) { 
			//chạy lần đầu thì mở trang dangnhap.jsp
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
