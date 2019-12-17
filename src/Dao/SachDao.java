package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.LoaiBean;
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
			long soLuong = rs.getLong("soluong");
			String soTap = rs.getString("sotap");
			String anh = rs.getString("anh");
			String ngayNhap = rs.getString("ngaynhap");
			String maLoai = rs.getString("maloai");
			SachBean bean = new SachBean(maSach, tenSach, tacGia, gia, soLuong, soTap, anh, ngayNhap, maLoai);
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
			long soLuong = rs.getLong("soluong");
			String soTap = rs.getString("sotap");
			String anh = rs.getString("anh");
			String ngayNhap = rs.getString("ngaynhap");
			SachBean bean = new SachBean(maSach, tenSach, tacGia, gia, soLuong, soTap, anh, ngayNhap, maLoai);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}
	
	public SachBean getSachByMa (String maSach) throws Exception {	
		dc.KetNoi();
		String sql = "SELECT * FROM sach WHERE masach = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maSach);
		ResultSet rs = cmd.executeQuery();
		SachBean bean = null;
		if (rs.next()) {
			String tenSach = rs.getString("tensach");
			String tacGia = rs.getString("tacgia");
			long gia = rs.getLong("gia");
			long soLuong = rs.getLong("soluong");
			String soTap = rs.getString("sotap");
			String anh = rs.getString("anh");
			String ngayNhap = rs.getString("NgayNhap");
			String maLoai = rs.getString("maloai");
			bean = new SachBean(maSach, tenSach, tacGia, gia, soLuong, soTap, anh, ngayNhap, maLoai);
		}
		rs.close();
		dc.cn.close();
		return bean;
	}
	
	public boolean trungMa (String maSach) throws Exception {
		String sql = "SELECT masach FROM sach WHERE masach = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maSach);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}
	
	public int them (String maSach, String tenSach, long soLuong, long gia, String maLoai, String soTap, String anh, String ngayNhap, String tacGia) throws Exception {
		dc.KetNoi();
		if (trungMa(maSach)==false) {
			String sql = "INSERT INTO sach(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, maSach);
			cmd.setString(2, tenSach);
			cmd.setLong(3, soLuong);
			cmd.setLong(4, gia);
			cmd.setString(5, maLoai);
			cmd.setString(6, soTap);
			cmd.setString(7, anh);
			cmd.setDate(8, java.sql.Date.valueOf(ngayNhap));
			cmd.setString(9, tacGia);
			int kq = cmd.executeUpdate();
			dc.cn.close();
			return kq;
		}
		else return 0;
	}
	
	public int sua (String maSach, String tenSach, long soLuong, long gia, String maLoai, String soTap, String anh, String ngayNhap, String tacGia) throws Exception {
		dc.KetNoi();
		String sql = "UPDATE sach SET tensach=?, soluong=?, gia=?, maLoai=?, soTap=?, anh=?, NgayNhap=?, tacgia=? where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenSach);
		cmd.setLong(2, soLuong);
		cmd.setLong(3, gia);
		cmd.setString(4, maLoai);
		cmd.setString(5, soTap);
		cmd.setString(6, anh);
		cmd.setString(7, ngayNhap);
		cmd.setString(8, tacGia);
		cmd.setString(9, maSach);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public int suaNoImg (String maSach, String tenSach, long soLuong, long gia, String maLoai, String soTap, String ngayNhap, String tacGia) throws Exception {
		dc.KetNoi();
		String sql = "UPDATE sach SET tensach=?, soluong=?, gia=?, maLoai=?, soTap=?, NgayNhap=?, tacgia=? where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenSach);
		cmd.setLong(2, soLuong);
		cmd.setLong(3, gia);
		cmd.setString(4, maLoai);
		cmd.setString(5, soTap);
		cmd.setString(6, ngayNhap);
		cmd.setString(7, tacGia);
		cmd.setString(8, maSach);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public int xoa (String maSach) throws Exception {
		dc.KetNoi();
		String sql = "DELETE FROM sach WHERE masach = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maSach);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
}
