package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.CTHDBo;

/**
 * Servlet implementation class AdminCTHDController
 */
@WebServlet("/AdminCTHDController")
public class AdminCTHDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCTHDController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    CTHDBo bo = new CTHDBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String maXoa = request.getParameter("maXoa");
			if (maXoa!=null) {
				String maHDX = request.getParameter("maHDX");
				bo.xoa(Long.parseLong(maXoa));
				request.setAttribute("ds", bo.getCTHDByMa(Long.parseLong(maHDX)));	
				RequestDispatcher rd = request.getRequestDispatcher("Admin_CTHD.jsp");
				rd.forward(request, response);
			}
			
			String maHD = request.getParameter("maHD");
			request.setAttribute("ds", bo.getCTHDByMa(Long.parseLong(maHD)));	
			RequestDispatcher rd = request.getRequestDispatcher("Admin_CTHD.jsp");
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
