package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;

public class GioHangBo {
	
	public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
	public void them (String maSach, String tenSach, String tacGia, Long gia, Long soLuong) {
		if (tonTai(maSach, ds)==0) {
			GioHangBean bean = new GioHangBean(maSach, tenSach, tacGia, gia, soLuong);
			ds.add(bean);
		} else {
			for (GioHangBean ht: ds) {
				if (ht.getMaSach().equals(maSach)) {
					ht.setSoLuong(ht.getSoLuong()+1);
					ht.setThanhTien();
				}
			}
		}
	}
	
	public long tongTien() {
		long s=0;
		for (GioHangBean bean:ds) {
			s+=bean.getThanhTien();
		}
		return s;
	}
	
	public long tongSoLuong() {
		long s=0;
		for (GioHangBean bean:ds) {
			s+=bean.getSoLuong();
		}
		return s;
	}
	
	public int tonTai (String maSach, ArrayList<GioHangBean> ds) {
		for (GioHangBean bean : ds) {
			if (bean.getMaSach().equals(maSach))
				return 1;
		}
		return 0;
	}
	
	public void updateSoLuong (String ma, Long soLuong, ArrayList<GioHangBean> ds) {
		for (GioHangBean ht: ds) {
			if (ht.getMaSach().equals(ma)) {
				ht.setSoLuong(ht.getSoLuong() + soLuong);
				ht.setThanhTien();
			}
		}
	}
	
	public void delete (String ma, ArrayList<GioHangBean> ds) {
		for (int i = 0; i <ds.size(); i++) {
			if (ds.get(i).getMaSach().equals(ma)) {
				ds.remove(i);
			}
		}
	}
	
	public void delCheckbox(String name) {
		 for (int j=0; j<ds.size(); j++) 
			 if (ds.get(j).getMaSach().equals(name)) {
				 ds.remove(j);
			 }					 
	 }
}
