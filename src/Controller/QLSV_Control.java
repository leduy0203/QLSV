package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Model.SinhVien;
import Model.Tinh;
import View.QLSV_View;

public class QLSV_Control implements Action {
	private QLSV_View qlsv_View;

	public QLSV_Control(QLSV_View qlsv_View) {
		super();
		this.qlsv_View = qlsv_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			this.qlsv_View.xoaForm();
			this.qlsv_View.getDanhSachSinhVien().setLuaChon("Thêm");
		} else if (src.equals("Lưu")) {
			try {
				int maThiSinh = Integer.valueOf(qlsv_View.textField_Mssv.getText());
				String tenThiSinh = qlsv_View.textField_Ten.getText();
				int index = qlsv_View.comboBox_QueQuan_1.getSelectedIndex();
				Tinh tinh = Tinh.getTinhById(index);

				// Xử lý ngày sinh
				SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date ngaySinh = inputFormat.parse(qlsv_View.textField_NgaySinh.getText());
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
				String formattedNgaySinh = outputFormat.format(ngaySinh);

				boolean gioiTinh;
				String chonString = this.qlsv_View.buttonGroup.getSelection().getActionCommand();
				gioiTinh = chonString.equals("Nam");

				// Xử lý điểm môn học
				double diemMon1 = Double.valueOf(this.qlsv_View.textField_DiemMon1.getText());
				double diemMon2 = Double.valueOf(this.qlsv_View.textField_DiemMon2.getText());
				double diemMon3 = Double.valueOf(this.qlsv_View.textField_DiemMon3.getText());

				// Sinh viên
				SinhVien sinhVien = new SinhVien(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2,
						diemMon3);

				this.qlsv_View.themSinhVien(sinhVien);
//				if (this.qlsv_View.getDanhSachSinhVien().getLuaChon().equals("Cập nhật")) {
//					this.qlsv_View.capNhapSv(sinhVien);
//				}
				System.out.println(sinhVien.toString());
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} else if (src.equals("Cập nhật")) {
			try {
				this.qlsv_View.hienThiThongTinDaChon();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

}
