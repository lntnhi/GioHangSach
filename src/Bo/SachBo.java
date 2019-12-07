package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import Dao.SachDao;

public class SachBo {
	SachDao dao = new SachDao();
	ArrayList<SachBean> ds;
	
	public ArrayList<SachBean> getSach() throws Exception {
		ds= dao.getSach();
		return ds;
	}
	public ArrayList<SachBean> getSachByLoai(String maLoai) throws Exception {
		ds = dao.getSachByLoai(maLoai);
		return ds;
	}
	
	public ArrayList<SachBean> timSach(String key) throws Exception {
		ArrayList<SachBean> tam = new ArrayList<SachBean>();
		for (SachBean s : ds) {
			if (s.getTenSach().trim().toLowerCase().contains(key.trim().toLowerCase()) 
				|| s.getTacGia().trim().toLowerCase().contains(key.trim().toLowerCase()))
				tam.add(s);
		}
		return tam;
	}
}
