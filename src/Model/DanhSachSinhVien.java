package Model;

import java.util.ArrayList;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> DanhSach;

	public DanhSachSinhVien() {
		super();
		DanhSach = new ArrayList<SinhVien>();
	}

	public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
		super();
		DanhSach = danhSach;
	}

	public ArrayList<SinhVien> getDanhSach() {
		return DanhSach;
	}

	public void setDanhSach(ArrayList<SinhVien> danhSach) {
		DanhSach = danhSach;
	}
	
	public void insert(SinhVien sinhVien) {
		this.DanhSach.add(sinhVien);
	}
	
	public void remove(SinhVien sinhVien) {
		this.DanhSach.remove(sinhVien);
	}
	
	public void update(SinhVien sinhVien) {
		this.DanhSach.remove(sinhVien);
		this.DanhSach.add(sinhVien);
	}
	
	
	
}
