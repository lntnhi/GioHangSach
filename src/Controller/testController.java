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

/**
 * Servlet implementation class testController
 */
@WebServlet("/testController")
public class testController extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Tạo ra đối tượng out
		PrintWriter out = response.getWriter(); 
		out.print("<html><body>Hello servlet</body></html>");
		
		//Tạo ra session
		HttpSession session = request.getSession();
		session.setAttribute("un", "hihi");
		request.setAttribute("gt1", (long)4*5);
		request.setAttribute("gt2", "Hiha");
		String[] ds = {"Haha", "Hihi", "Huhu", "Hehe", "Hoho"};
		request.setAttribute("ds", ds);
		//Điều hướng về vidu.jsp
		RequestDispatcher rd = request.getRequestDispatcher("vidu.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
