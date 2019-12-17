package Bean;

public class KhachHangBean {
	private long maKH;
	private String hoTen;
	private String diaChi;
	private String sdt;
	private String email;
	private String tenDangNhap;
	private String pass;
	
	public KhachHangBean() {
		super();
	}
	public KhachHangBean(long maKH, String hoTen, String diaChi, String sdt, String email, String tenDangNhap,
			String pass) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.tenDangNhap = tenDangNhap;
		this.pass = pass;
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSDT() {
		return sdt;
	}
	public void setSDT(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
