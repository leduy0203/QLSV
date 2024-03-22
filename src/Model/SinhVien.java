package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien implements Serializable{
	private int maThiSinh;
	private String tenThiSinh;
	private Tinh queQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private double diemMon1, diemMon2, diemMon3;

	public SinhVien(int maThiSinh, String tenThiSinh, Tinh queQuan, Date ngaySinh, boolean gioiTinh, double diemMon1,
			double diemMon2, double diemMon3) {
		super();
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
	}
	
	public SinhVien() {
		super();
	}


	public int getMaThiSinh() {
		return maThiSinh;
	}

	public void setMaThiSinh(int maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	public String getTenThiSinh() {
		return tenThiSinh;
	}

	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}

	public Tinh getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public double getDiemMon1() {
		return diemMon1;
	}

	public void setDiemMon1(double diemMon1) {
		this.diemMon1 = diemMon1;
	}

	public double getDiemMon2() {
		return diemMon2;
	}

	public void setDiemMon2(double diemMon2) {
		this.diemMon2 = diemMon2;
	}

	public double getDiemMon3() {
		return diemMon3;
	}

	public void setDiemMon3(double diemMon3) {
		this.diemMon3 = diemMon3;
	}

	public String format() {
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String formattedNgaySinh = outputFormat.format(this.getNgaySinh());
	    return formattedNgaySinh;
	}

	@Override
	public String toString() {
		return "SinhVien [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemMon1=" + diemMon1 + ", diemMon2="
				+ diemMon2 + ", diemMon3=" + diemMon3 + "]";
	}
	


	
}
