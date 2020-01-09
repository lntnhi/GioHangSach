package Bean;

public class LichSuBean {
	private long maHD;
	private long maKH;
	private String ngayMua;
	private boolean daMua;
	private long tongSL;
	private long thanhTien;
	public LichSuBean() {
		super();
	}
	public LichSuBean(long maHD, long maKH, String ngayMua, boolean daMua, long tongSL, long thanhTien) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
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
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public boolean isDaMua() {
		return daMua;
	}
	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
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
