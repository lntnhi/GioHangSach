package Bo;

import java.util.ArrayList;

import Bean.XNDMBean;
import Dao.XNDHDao;

public class XNDMBo {
	XNDHDao dao = new XNDHDao();
	public ArrayList<XNDMBean> getXNDM() throws Exception {
		return dao.getXNDM();
	}
}
