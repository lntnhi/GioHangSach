package Bo;

import java.util.ArrayList;

import Bean.HoaDonBean;
import Dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao dao = new HoaDonDao();
	
	public ArrayList<HoaDonBean> getHD() throws Exception {
		return dao.getHD();
	}
	
	public ArrayList<HoaDonBean> getHDByKH(long maKH) throws Exception {
		return dao.getHDByKH(maKH);
	}
	
	public int them (long maKH) throws Exception {
		return dao.them(maKH);
	}
	
	public long maHDmax() throws Exception {
		return dao.maHDmax();
	}
}
