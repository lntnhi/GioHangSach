package Bean;

public class SachBean {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private long gia;
	private long soLuong;
	private String soTap;
	private String anh;
	private String ngayNhap;
	private String maLoai;
	
	public SachBean() {
		super();
	}
	
	public SachBean(String maSach, String tenSach, String tacGia, long gia, long soLuong, String soTap, String anh,
			String ngayNhap, String maLoai) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.soLuong = soLuong;
		this.soTap = soTap;
		this.anh = anh;
		this.ngayNhap = ngayNhap;
		this.maLoai = maLoai;
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
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}	
	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	public String getSoTap() {
		return soTap;
	}

	public void setSoTap(String soTap) {
		this.soTap = soTap;
	}

	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
}
