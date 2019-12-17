package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bo.LoaiBo;
import Bo.SachBo;

/**
 * Servlet implementation class AdminSach
 */
@WebServlet("/AdminSachController")
public class AdminSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    SachBo bo = new SachBo();
    LoaiBo boLoai = new LoaiBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {		
			List<FileItem> fileItems = new ArrayList<FileItem>();
			fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
			String nameimg = "";
			String maSach = "";
			String tenSach = "";
			String tacGia = "";
			long gia = (long)0;
			long soLuong = (long)0;
			String ngayNhap = "";
			String soTap = "";
			String maLoai = "";
			String btnThem = "";
			for (FileItem fileItem : fileItems) {
	 			if (!fileItem.isFormField()) { //Nếu ko phải các control=>upfile lên
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "files";
						File dir = new File(dirUrl);
						if (!dir.exists()) { //nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
			            File file = new File(fileImg);//tạo file
			            try {
			               fileItem.write(file);//lưu file
			               System.out.println("UPLOAD THÀNH CÔNG...!");
			               System.out.println("Đường dẫn lưu file là: "+dirUrl);
						 } catch (Exception e) {
						    e.printStackTrace();
						 }
					}
	 			}
				else {
					try {
						String tentk = fileItem.getFieldName();
						if(tentk.equals("txtMaSach"))
							maSach = fileItem.getString();
						if(tentk.equals("txtTenSach"))
							tenSach = fileItem.getString();
						if(tentk.equals("txtTacGia"))
							tacGia = fileItem.getString();
						if(tentk.equals("txtGia"))
							gia = Long.parseLong(fileItem.getString());
						if(tentk.equals("txtSoLuong"))
							soLuong = Long.parseLong(fileItem.getString());
						if(tentk.equals("txtNgayNhap"))
							ngayNhap = fileItem.getString();
						if(tentk.equals("txtSoTap"))
							soTap = fileItem.getString();
						if(tentk.equals("cbbMaLoai"))
							maLoai = fileItem.getString();
						if(tentk.equals("btnThem")) {
							int n = bo.them(maSach, tenSach, soLuong, gia, maLoai, soTap, "files/"+nameimg, ngayNhap, tacGia);
							if (n==0) request.setAttribute("kqThem", 0);
						}
						if(tentk.equals("btnSua")) {
							if (nameimg!="")
								bo.sua(maSach, tenSach, soLuong, gia, maLoai, soTap, "files/"+nameimg, ngayNhap, tacGia);
							else bo.suaNoImg(maSach, tenSach, soLuong, gia, maLoai, soTap, ngayNhap, tacGia);
						}
					} catch (Exception ex) {
					    ex.printStackTrace();
					}	
				}
			}
			try {
				request.setAttribute("dsSach", bo.getSach()); 
				request.setAttribute("dsLoai", boLoai.getLoai()); 
				RequestDispatcher rd = request.getRequestDispatcher("Admin_QuanLySach.jsp"); 
				rd.forward(request, response);	
			 } catch (Exception ex) {
			    ex.printStackTrace();
			 }			
		} catch (FileUploadException e) {
			try {
				if (request.getParameter("maChon")!=null) {
					request.setAttribute("sachChon", bo.getSachByMa(request.getParameter("maChon")));
				}
				if (request.getParameter("maXoa")!=null) {
					bo.xoa(request.getParameter("maXoa"));
				}
				request.setAttribute("dsSach", bo.getSach()); 
				request.setAttribute("dsLoai", boLoai.getLoai()); 
				RequestDispatcher rd = request.getRequestDispatcher("Admin_QuanLySach.jsp"); 
				rd.forward(request, response);	
			 } catch (Exception ex) {
			    ex.printStackTrace();
			 }
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
