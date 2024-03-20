package Model;

import java.util.ArrayList;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> DanhSach;
	private String luaChon;

	public DanhSachSinhVien() {
		super();
		DanhSach = new ArrayList<SinhVien>();
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
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

	public void remove(int index) {
		DanhSach.remove(index);
	}

	public void update(SinhVien sinhVien) {
		this.DanhSach.remove(sinhVien);
		this.DanhSach.add(sinhVien);
	}

	public boolean kiemTraTonTai(SinhVien sinhVien) {
		for (SinhVien sinhVien2 : DanhSach) {
			if (sinhVien2.getMaThiSinh() == sinhVien.getMaThiSinh()) {
				return false;
			}
		}
		return true;
	}

}
