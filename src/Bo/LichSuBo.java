package Bo;

import java.util.ArrayList;

import Bean.LichSuBean;
import Dao.LichSuDao;

public class LichSuBo {
	LichSuDao dao = new LichSuDao();
	public ArrayList<LichSuBean> getLS(long maKH) throws Exception {
		return dao.getLS(maKH);
	}
}
