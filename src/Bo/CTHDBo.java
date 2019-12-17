package Bo;

import java.util.ArrayList;

import Bean.CTHDBean;
import Dao.CTHDDao;

public class CTHDBo {
CTHDDao dao = new CTHDDao();
	
	public ArrayList<CTHDBean> getCTHD() throws Exception {
		return dao.getCTHD();
	}
	
	public ArrayList<CTHDBean> getCTHDByMa(long maHD) throws Exception {
		return dao.getCTHDByMa(maHD);
	}
	
	public int them (String maSach, long soLuongMua, long maHD) throws Exception {
		return dao.them(maSach, soLuongMua, maHD);
	}
}
