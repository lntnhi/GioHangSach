package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.HoaDonBean;

public class HoaDonDao {
	DungChung dc = new DungChung();
	public ArrayList<HoaDonBean> getHD() throws Exception {
		ArrayList<HoaDonBean> ds = new ArrayList<HoaDonBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM hoadon ORDER BY NgayMua DESC";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHD = rs.getLong("MaHoaDon");
			long maKH = rs.getLong("makh");
			String ngayMua = rs.getString("NgayMua");
			boolean daMua = rs.getBoolean("damua");
			HoaDonBean bean = new HoaDonBean(maHD, maKH, ngayMua, daMua);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
	
	public ArrayList<HoaDonBean> getHDByKH(long maKH) throws Exception {
		ArrayList<HoaDonBean> ds = new ArrayList<HoaDonBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM hoadon WHERE makh=? ORDER BY NgayMua DESC";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maKH);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHD = rs.getLong("MaHoaDon");
			String ngayMua = rs.getString("NgayMua");
			boolean daMua = rs.getBoolean("damua");
			HoaDonBean bean = new HoaDonBean(maHD, maKH, ngayMua, daMua);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
	
	public int them (long maKH) throws Exception {
		dc.KetNoi();
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		String sql = "INSERT INTO hoadon(makh, NgayMua, damua) values (?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maKH);
		cmd.setDate(2, sqlDate);
		cmd.setBoolean(3, false);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public long maHDmax() throws Exception {	
		dc.KetNoi();
		String sql = "SELECT MAX(MaHoaDon) AS MaHoaDon FROM hoadon";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long maHDmax = 0;
		while (rs.next()) {
			long maHD = rs.getLong("MaHoaDon");
			if (maHD > maHDmax) maHDmax = maHD;
		}
		rs.close();
		dc.cn.close();
		return maHDmax;
	}
	
	public int xacNhan (long maHD) throws Exception {
		dc.KetNoi();
		String sql = "UPDATE hoadon SET damua=1 where MaHoaDon=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setLong(1, maHD);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
}
