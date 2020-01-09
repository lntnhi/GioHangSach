package Bean;

public class XNDMBean {
	private long maHD;
	private long maKH;
	private String hoTen;
	private long tongSL;
	private long thanhTien;
	public XNDMBean() {
		super();
	}
	public XNDMBean(long maHD, long maKH, String hoTen, long tongSL, long thanhTien) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.tongSL = tongSL;
		this.thanhTien = thanhTien;
	}
	public long getMaHD() {
		return maHD;
	}
	public void setMaHD(long maHD) {
		this.maHD = maHD;
	}
	public long getMaKH() {
		return maKH;
	}
	public void setMaKH(long maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public long getTongSL() {
		return tongSL;
	}
	public void setTongSL(long tongSL) {
		this.tongSL = tongSL;
	}
	public long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
}
