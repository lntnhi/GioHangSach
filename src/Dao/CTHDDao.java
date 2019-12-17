package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.CTHDBean;

public class CTHDDao {
	DungChung dc = new DungChung();
	public ArrayList<CTHDBean> getCTHD() throws Exception {
		ArrayList<CTHDBean> ds = new ArrayList<CTHDBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM dbo.CTHDwSach";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maCTHD = rs.getLong("MaChiTietHD");
			String maSach = rs.getString("MaSach");
			String tenSach = rs.getString("tensach");
			int soLuongMua = rs.getInt("SoLuongMua");
			long gia = rs.getLong("gia");
			String maLoai = rs.getString("maloai");
			String soTap = rs.getString("sotap");
			String anh = rs.getString("anh");
			String tacGia = rs.getString("tacgia");
			long maHD = rs.getLong("MaHoaDon");
			CTHDBean bean = new CTHDBean(maCTHD, maSach, tenSach, soLuongMua, gia, maLoai, soTap, anh, tacGia, maHD);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
	
	public ArrayList<CTHDBean> getCTHDByMa(long maHD) throws Exception {
		ArrayList<CTHDBean> ds = new ArrayList<CTHDBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM dbo.CTHDwSach WHERE MaHoaDon = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maHD);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maCTHD = rs.getLong("MaChiTietHD");
			String maSach = rs.getString("MaSach");
			String tenSach = rs.getString("tensach");
			int soLuongMua = rs.getInt("SoLuongMua");
			long gia = rs.getLong("gia");
			String maLoai = rs.getString("maloai");
			String soTap = rs.getString("sotap");
			String anh = rs.getString("anh");
			String tacGia = rs.getString("tacgia");
			CTHDBean bean = new CTHDBean(maCTHD, maSach, tenSach, soLuongMua, gia, maLoai, soTap, anh, tacGia, maHD);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}
	
	public int them (String maSach, long soLuongMua, long maHD) throws Exception {
		dc.KetNoi();
		String sql = "INSERT INTO ChiTietHoaDon (MaSach, SoLuongMua, MaHoaDon) values (?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maSach);
		cmd.setLong(2, soLuongMua);
		cmd.setLong(3, maHD);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
}
