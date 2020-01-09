package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.XNDMBean;

public class XNDHDao {
	DungChung dc = new DungChung();
	public ArrayList<XNDMBean> getXNDM() throws Exception {
		ArrayList<XNDMBean> ds = new ArrayList<XNDMBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM dbo.VXacNhanDatMua";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHD = rs.getLong("MaHoaDon");
			long maKH = rs.getLong("MaKH");
			String hoTen = rs.getString("hoten");
			long tongSL = rs.getLong("TongSL");
			long thanhTien = rs.getLong("ThanhTien");
			XNDMBean bean = new XNDMBean(maHD, maKH, hoTen, tongSL, thanhTien);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
}
