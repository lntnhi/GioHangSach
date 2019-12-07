package Bo;

import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.LoaiDao;


public class LoaiBo {
	LoaiDao dao = new LoaiDao();
	
	public ArrayList<LoaiBean> getLoai() throws Exception {
		return dao.getLoai();
	}
	public int them (String maLoai, String tenLoai) throws Exception {
		return dao.them(maLoai, tenLoai);
	}
	public int sua (String maLoai, String tenLoai) throws Exception {
		return dao.sua(maLoai, tenLoai);
	}
	public int xoa (String maLoai) throws Exception {
		return dao.xoa(maLoai);
	}
	public LoaiBean getLoaiByMa (String maLoai) throws Exception {	
		return dao.getLoaiByMa(maLoai);
	}
}
