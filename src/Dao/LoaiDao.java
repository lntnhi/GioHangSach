package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.LoaiBean;

public class LoaiDao {
	DungChung dc = new DungChung();
	public ArrayList<LoaiBean> getLoai () throws Exception {
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM loai";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maLoai = rs.getString("maloai");
			String tenLoai = rs.getString("tenloai");
			LoaiBean bean = new LoaiBean(maLoai, tenLoai);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
	
	public boolean trungMa (String maLoai) throws Exception {
		String sql = "SELECT maloai FROM loai WHERE maloai = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}
	public int them (String maLoai, String tenLoai) throws Exception {
		dc.KetNoi();
		if (trungMa(maLoai)==false) {
			String sql = "insert into loai(maloai, tenloai) values (?,?)";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, maLoai);
			cmd.setString(2, tenLoai);
			int kq = cmd.executeUpdate();
			dc.cn.close();
			return kq;
		}
		else return 0;
	}
	public int sua (String maLoai, String tenLoai) throws Exception {
		dc.KetNoi();
		String sql = "update loai set tenloai=? where maloai=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenLoai);
		cmd.setString(2, maLoai);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	public boolean kiemTraLoai (String maLoai) throws Exception { //ktra xem loại đó có quyển sách nào hay không
		String sql = "SELECT masach FROM sach WHERE maloai = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		ResultSet rs = cmd.executeQuery();
		boolean kq = rs.next();
		rs.close();
		return kq;
	}
	public int xoa (String maLoai) throws Exception {
		dc.KetNoi();
		if (kiemTraLoai(maLoai)==false) {
			String sql = "DELETE FROM loai WHERE maloai = ?";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			cmd.setString(1, maLoai);
			int kq = cmd.executeUpdate();
			dc.cn.close();
			return kq;
		}
		else return 0;
	}
	public LoaiBean getLoaiByMa (String maLoai) throws Exception {	
		dc.KetNoi();
		String sql = "SELECT * FROM loai WHERE maloai = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, maLoai);
		ResultSet rs = cmd.executeQuery();
		LoaiBean bean = null;
		if (rs.next()) {
			String ma = rs.getString("maloai");
			String tenLoai = rs.getString("tenloai");
			bean = new LoaiBean(maLoai, tenLoai);
		}
		rs.close();
		dc.cn.close();
		return bean;
	}
}
