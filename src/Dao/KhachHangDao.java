package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.KhachHangBean;

public class KhachHangDao {
	DungChung dc = new DungChung();
	public ArrayList<KhachHangBean> getKH() throws Exception {
		ArrayList<KhachHangBean> ds = new ArrayList<KhachHangBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM khachhang";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maKH = rs.getLong("makh");
			String hoTen = rs.getString("hoten");
			String diaChi = rs.getString("diachi");
			String sdt = rs.getString("sodt");
			String email = rs.getString("email");
			String tenDangNhap = rs.getString("tendn");
			String pass = rs.getString("pass");
			KhachHangBean bean = new KhachHangBean(maKH, hoTen, diaChi, sdt, email, tenDangNhap, pass);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
}
