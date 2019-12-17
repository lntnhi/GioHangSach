package Bean;

public class HoaDonBean {
	private long maHD;
	private long maKH;
	private String date;
	private boolean daMua;
	
	public HoaDonBean() {
		super();
	}
	public HoaDonBean(long maHD, long maKH, String date, boolean daMua) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.date = date;
		this.daMua = daMua;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isDaMua() {
		return daMua;
	}
	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
}
