package Bean;

public class GioHangBean {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private Long gia;
	private Long soLuong;
	private Long thanhTien;

	public GioHangBean() {
		super();
	}
	public GioHangBean(String maSach, String tenSach, String tacGia, Long gia, Long soLuong) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = gia * soLuong;
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
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
	public Long getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien() {
		this.thanhTien = getSoLuong()*getGia();
	}
	
}
