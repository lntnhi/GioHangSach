package Bean;

public class CTHDBean {
	private long maCTHD;
	private String maSach;
	private String tenSach;
	private int soLuongMua;
	private long gia;
	private String maLoai;
	private String soTap;
	private String anh;
	private String tacGia;
	private long maHD;
	
	public CTHDBean() {
		super();
	}
	public CTHDBean(long maCTHD, String maSach, String tenSach, int soLuongMua, long gia, String maLoai, String soTap,
			String anh, String tacGia, long maHD) {
		super();
		this.maCTHD = maCTHD;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soLuongMua = soLuongMua;
		this.gia = gia;
		this.maLoai = maLoai;
		this.soTap = soTap;
		this.anh = anh;
		this.tacGia = tacGia;
		this.maHD = maHD;
	}

	public long getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(long maCTHD) {
		this.maCTHD = maCTHD;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getSoTap() {
		return soTap;
	}

	public void setSoTap(String soTap) {
		this.soTap = soTap;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public long getMaHD() {
		return maHD;
	}

	public void setMaHD(long maHD) {
		this.maHD = maHD;
	}
}
