package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.SachBean;

public class SachDao {
	DungChung dc = new DungChung();
	public ArrayList<SachBean> getSach () throws Exception {
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		
		dc.KetNoi();
		String sql = "SELECT * FROM sach";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach");
			String tacGia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String ngayNhap = rs.getString("ngaynhap");
			String maLoai = rs.getString("maloai");
			SachBean bean = new SachBean(maSach, tenSach, tacGia, gia, anh, ngayNhap, maLoai);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
	
	public ArrayList<SachBean> getSachByLoai (String maLoai) throws Exception {
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		
		dc.KetNoi();
		String sql = "SELECT * FROM sach INNER JOIN loai ON loai.maloai = sach.maloai WHERE loai.maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maSach = rs.getString("masach");
			String tenSach = rs.getString("tensach");
			String tacGia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String ngayNhap = rs.getString("ngaynhap");
			SachBean bean = new SachBean(maSach, tenSach, tacGia, gia, anh, ngayNhap, maLoai);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
}
