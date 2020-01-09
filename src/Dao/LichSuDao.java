package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.LichSuBean;


public class LichSuDao {
	DungChung dc = new DungChung();
	public ArrayList<LichSuBean> getLS(long maKH) throws Exception {
		ArrayList<LichSuBean> ds = new ArrayList<LichSuBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM dbo.VLichSu WHERE makh = ? ORDER BY NgayMua DESC";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maKH);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHD = rs.getLong("MaHoaDon");
			String ngayMua = rs.getString("NgayMua");
			boolean daMua = rs.getBoolean("damua");
			long tongSL = rs.getLong("TongSL");
			long thanhTien = rs.getLong("ThanhTien");
			LichSuBean bean = new LichSuBean(maHD, maKH, ngayMua, daMua, tongSL, thanhTien);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
}
