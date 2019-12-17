package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import Dao.SachDao;

public class SachBo {
	SachDao dao = new SachDao();
	ArrayList<SachBean> ds;
	
	public ArrayList<SachBean> getSach() throws Exception {
		ds= dao.getSach();
		return ds;
	}
	public ArrayList<SachBean> getSachByLoai(String maLoai) throws Exception {
		ds = dao.getSachByLoai(maLoai);
		return ds;
	}
	
	public ArrayList<SachBean> timSach(String key) throws Exception {
		ArrayList<SachBean> tam = new ArrayList<SachBean>();
		for (SachBean s : ds) {
			if (s.getTenSach().trim().toLowerCase().contains(key.trim().toLowerCase()) 
				|| s.getTacGia().trim().toLowerCase().contains(key.trim().toLowerCase()))
				tam.add(s);
		}
		return tam;
	}
	
	public SachBean getSachByMa (String maSach) throws Exception {
		return dao.getSachByMa(maSach);
	}
	
	public int them (String maSach, String tenSach, long soLuong, long gia, String maLoai, String soTap, String anh, String ngayNhap, String tacGia) throws Exception {
		return dao.them(maSach, tenSach, soLuong, gia, maLoai, soTap, anh, ngayNhap, tacGia);
	}
	
	public int sua (String maSach, String tenSach, long soLuong, long gia, String maLoai, String soTap, String anh, String ngayNhap, String tacGia) throws Exception {
		return dao.sua(maSach, tenSach, soLuong, gia, maLoai, soTap, anh, ngayNhap, tacGia);
	}
	
	public int suaNoImg (String maSach, String tenSach, long soLuong, long gia, String maLoai, String soTap, String ngayNhap, String tacGia) throws Exception {
		return dao.suaNoImg(maSach, tenSach, soLuong, gia, maLoai, soTap, ngayNhap, tacGia);
	}
	
	public int xoa (String maSach) throws Exception {
		return dao.xoa(maSach);
	}
}
