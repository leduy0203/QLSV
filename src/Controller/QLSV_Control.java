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
				this.qlsv_View.thucHienThem();
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
		} else if (src.equals("Xoá")) {
			this.qlsv_View.thucHienXoa();
		}

	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
		// s
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
