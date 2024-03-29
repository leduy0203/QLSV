package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.QLSV_Control;
import Model.DanhSachSinhVien;
import Model.SinhVien;
import Model.Tinh;

import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;

public class QLSV_View extends JFrame {

	public JPanel contentPane;
	public JTextField textField_MaSinhVien;
	public JTable table;
	public JTextField textField_Mssv;
	public JTextField textField_Ten;
	public JTextField textField_NgaySinh;
	public JTextField textField_DiemMon1;
	public JTextField textField_DiemMon2;
	public JTextField textField_DiemMon3;
	public JTextField textField_TongDiem;
	public JButton button_Tim;
	public JRadioButton radioButton_Nam;
	public JRadioButton radioButton_Nu;
	public JButton button_Them;
	public JButton button_Xoa;
	public JButton button_CapNhat;
	public JButton button_Luu;
	public JButton button_Huy;
	public JComboBox comboBox_QueQuan;
	public JComboBox comboBox_QueQuan_1;
	public ButtonGroup buttonGroup;
	private DanhSachSinhVien danhSachSinhVien;
	private Set<Integer> idCanXoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSV_View frame = new QLSV_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSV_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 738);
		danhSachSinhVien = new DanhSachSinhVien();
		QLSV_Control qlsv_Control = new QLSV_Control(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 255, 255));
		setJMenuBar(menuBar);

		JMenu Menu_File = new JMenu("File");
		Menu_File.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(Menu_File);

		JMenuItem Menu_Item_Open = new JMenuItem("Open");
		Menu_Item_Open.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Menu_Item_Open.addActionListener(qlsv_Control);
		Menu_Item_Open.addActionListener(qlsv_Control);
		Menu_File.add(Menu_Item_Open);

		JMenuItem Menu_Item_Save = new JMenuItem("Save");
		Menu_Item_Save.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Menu_Item_Save.addActionListener(qlsv_Control);
		Menu_Item_Save.addActionListener(qlsv_Control);
		Menu_File.add(Menu_Item_Save);

		JSeparator separator = new JSeparator();
		Menu_File.add(separator);

		JMenuItem Menu_Item_Exit = new JMenuItem("Exit");
		Menu_Item_Exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Menu_Item_Exit.addActionListener(qlsv_Control);
		Menu_Item_Exit.addActionListener(qlsv_Control);
		Menu_File.add(Menu_Item_Exit);

		JMenu Menu_About = new JMenu("About");
		Menu_About.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(Menu_About);

		JMenuItem Menu_Item_AboutMe = new JMenuItem("About me");
		Menu_Item_AboutMe.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Menu_Item_AboutMe.addActionListener(qlsv_Control);
		Menu_About.add(Menu_Item_AboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(192, 192, 192));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Label_QueQuan = new JLabel("Quê quán");
		Label_QueQuan.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan.setBounds(20, 37, 73, 22);
		contentPane.add(Label_QueQuan);

		JLabel Label_ThongTin = new JLabel("Thông tin");
		Label_ThongTin.setForeground(new Color(0, 0, 0));
		Label_ThongTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_ThongTin.setBounds(20, 4, 89, 22);
		contentPane.add(Label_ThongTin);

		JLabel Label_MaSinhVien = new JLabel("Mã sinh viên");
		Label_MaSinhVien.setVerticalAlignment(SwingConstants.TOP);
		Label_MaSinhVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_MaSinhVien.setBounds(372, 37, 107, 27);
		contentPane.add(Label_MaSinhVien);

		textField_MaSinhVien = new JTextField();
		textField_MaSinhVien.setBackground(new Color(228, 228, 228));
		textField_MaSinhVien.setBounds(489, 32, 164, 32);
		contentPane.add(textField_MaSinhVien);
		textField_MaSinhVien.setColumns(10);

		button_Tim = new JButton("Tìm");
		button_Tim.setBackground(new Color(255, 128, 64));
		button_Tim.setForeground(new Color(0, 0, 0));
		button_Tim.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_Tim.setBounds(714, 19, 89, 54);
		button_Tim.addActionListener(qlsv_Control);
		contentPane.add(button_Tim);

		ArrayList<Tinh> arrayList = Tinh.ds();
		comboBox_QueQuan = new JComboBox();
		for (Tinh tinh : arrayList) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan.setBackground(new Color(232, 232, 232));
		comboBox_QueQuan.setForeground(new Color(0, 0, 0));
		comboBox_QueQuan.setBounds(120, 32, 170, 32);
		contentPane.add(comboBox_QueQuan);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(898, 11, -789, 15);
		contentPane.add(separator_2);

		JLabel Label_ThongTin_1 = new JLabel("Danh sách sinh viên");
		Label_ThongTin_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_ThongTin_1.setBounds(20, 97, 157, 22);
		contentPane.add(Label_ThongTin_1);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(228, 228, 228));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "MASV", "H\u1ECC V\u00C0 T\u00CAN", "\u0110\u1ECAA CH\u1EC8", "NG\u00C0Y SINH",
						"GI\u1EDAI T\u00CDNH", "\u0110I\u1EC2M M\u00D4N 1", "\u0110I\u1EC2M M\u00D4N 2",
						"\u0110I\u1EC2M M\u00D4N 3" }));
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 130, 922, 222);
		contentPane.add(jScrollPane);

		JLabel Label_ThongTin_1_1 = new JLabel("Thông tin sinh viên");
		Label_ThongTin_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_ThongTin_1_1.setBounds(20, 384, 157, 22);
		contentPane.add(Label_ThongTin_1_1);

		JLabel Label_QueQuan_1 = new JLabel("Mssv");
		Label_QueQuan_1.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1.setBounds(20, 429, 73, 22);
		contentPane.add(Label_QueQuan_1);

		textField_Mssv = new JTextField();
		textField_Mssv.setBackground(new Color(228, 228, 228));
		textField_Mssv.setColumns(10);
		textField_Mssv.setBounds(120, 424, 200, 29);
		contentPane.add(textField_Mssv);

		JLabel Label_QueQuan_1_1 = new JLabel("Tên");
		Label_QueQuan_1_1.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_1.setBounds(20, 465, 73, 22);
		contentPane.add(Label_QueQuan_1_1);

		JLabel Label_QueQuan_1_1_1 = new JLabel("Địa chỉ");
		Label_QueQuan_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_1_1.setBounds(20, 502, 73, 22);
		contentPane.add(Label_QueQuan_1_1_1);

		JLabel Label_QueQuan_1_1_2 = new JLabel("Ngày sinh");
		Label_QueQuan_1_1_2.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_1_2.setBounds(20, 535, 89, 22);
		contentPane.add(Label_QueQuan_1_1_2);

		textField_Ten = new JTextField();
		textField_Ten.setBackground(new Color(228, 228, 228));
		textField_Ten.setColumns(10);
		textField_Ten.setBounds(120, 459, 200, 30);
		contentPane.add(textField_Ten);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setBackground(new Color(228, 228, 228));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(120, 530, 200, 29);
		contentPane.add(textField_NgaySinh);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(0, 221, 221));
		separator_3.setForeground(new Color(0, 179, 179));
		separator_3.setBounds(20, 371, 879, 2);
		contentPane.add(separator_3);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBackground(new Color(0, 221, 221));
		separator_3_1.setBounds(20, 84, 879, 2);
		contentPane.add(separator_3_1);

		textField_DiemMon1 = new JTextField();
		textField_DiemMon1.setBackground(new Color(228, 228, 228));
		textField_DiemMon1.setColumns(10);
		textField_DiemMon1.setBounds(598, 424, 200, 29);
		contentPane.add(textField_DiemMon1);

		textField_DiemMon2 = new JTextField();
		textField_DiemMon2.setBackground(new Color(228, 228, 228));
		textField_DiemMon2.setColumns(10);
		textField_DiemMon2.setBounds(598, 460, 200, 29);
		contentPane.add(textField_DiemMon2);

		textField_DiemMon3 = new JTextField();
		textField_DiemMon3.setBackground(new Color(228, 228, 228));
		textField_DiemMon3.setColumns(10);
		textField_DiemMon3.setBounds(598, 495, 200, 29);
		contentPane.add(textField_DiemMon3);

		textField_TongDiem = new JTextField();
		textField_TongDiem.setBackground(new Color(228, 228, 228));
		textField_TongDiem.setColumns(10);
		textField_TongDiem.setBounds(598, 530, 200, 29);
		contentPane.add(textField_TongDiem);

		JLabel Label_QueQuan_1_2 = new JLabel("Điểm môn 1");
		Label_QueQuan_1_2.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_2.setBounds(482, 429, 89, 22);
		contentPane.add(Label_QueQuan_1_2);

		JLabel Label_QueQuan_1_3 = new JLabel("Điểm môn 2");
		Label_QueQuan_1_3.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_3.setBounds(482, 467, 89, 22);
		contentPane.add(Label_QueQuan_1_3);

		JLabel Label_QueQuan_1_4 = new JLabel("Điểm môn 3");
		Label_QueQuan_1_4.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_4.setBounds(482, 502, 89, 22);
		contentPane.add(Label_QueQuan_1_4);

		JLabel Label_QueQuan_1_5 = new JLabel("Tổng cộng :");
		Label_QueQuan_1_5.setVerticalAlignment(SwingConstants.TOP);
		Label_QueQuan_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_QueQuan_1_5.setBounds(482, 537, 89, 22);
		contentPane.add(Label_QueQuan_1_5);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 586, 886, 2);
		contentPane.add(separator_1);

		button_Them = new JButton("Thêm");
		button_Them.setBackground(new Color(255, 128, 64));
		button_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_Them.setBounds(44, 599, 103, 43);
		button_Them.addActionListener(qlsv_Control);
		contentPane.add(button_Them);

		button_Xoa = new JButton("Xoá");
		button_Xoa.setBackground(new Color(255, 128, 64));
		button_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_Xoa.setBounds(217, 599, 103, 43);
		button_Xoa.addActionListener(qlsv_Control);
		contentPane.add(button_Xoa);

		button_CapNhat = new JButton("Cập nhật");
		button_CapNhat.setBackground(new Color(255, 128, 64));
		button_CapNhat.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_CapNhat.setBounds(395, 599, 103, 43);
		button_CapNhat.addActionListener(qlsv_Control);
		contentPane.add(button_CapNhat);

		button_Luu = new JButton("Lưu");
		button_Luu.setBackground(new Color(255, 128, 64));
		button_Luu.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_Luu.setBounds(576, 599, 103, 43);
		button_Luu.addActionListener(qlsv_Control);
		contentPane.add(button_Luu);

		button_Huy = new JButton("Huỷ");
		button_Huy.setBackground(new Color(255, 128, 64));
		button_Huy.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_Huy.setBounds(755, 599, 103, 43);
		button_Huy.addActionListener(qlsv_Control);
		contentPane.add(button_Huy);

		ArrayList<Tinh> arrayList2 = Tinh.ds();
		comboBox_QueQuan_1 = new JComboBox();
		for (Tinh tinh : arrayList) {
			comboBox_QueQuan_1.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan_1.setForeground(new Color(0, 0, 0));
		comboBox_QueQuan_1.setBackground(new Color(232, 232, 232));
		comboBox_QueQuan_1.setBounds(120, 495, 200, 29);
		contentPane.add(comboBox_QueQuan_1);

		buttonGroup = new ButtonGroup();
		radioButton_Nam = new JRadioButton("Nam");
		radioButton_Nam.setBackground(new Color(128, 255, 255));
		radioButton_Nam.setForeground(new Color(0, 0, 0));
		radioButton_Nam.setActionCommand("Nam");
		radioButton_Nam.setBounds(337, 454, 60, 23);
		radioButton_Nam.addActionListener(qlsv_Control);
		buttonGroup.add(radioButton_Nam);

		radioButton_Nu = new JRadioButton("Nữ");
		radioButton_Nu.setForeground(Color.BLACK);
		radioButton_Nu.setActionCommand("Nữ");
		radioButton_Nu.setBackground(new Color(128, 255, 255));
		radioButton_Nu.setBounds(337, 480, 47, 23);
		radioButton_Nu.addActionListener(qlsv_Control);
		buttonGroup.add(radioButton_Nu);

		contentPane.add(radioButton_Nam);
		contentPane.add(radioButton_Nu);

		JButton button_HuyTim = new JButton("Huỷ tìm");
		button_HuyTim.setBackground(new Color(255, 128, 64));
		button_HuyTim.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_HuyTim.setBounds(817, 19, 103, 54);
		button_HuyTim.addActionListener(qlsv_Control);
		contentPane.add(button_HuyTim);
		this.setVisible(true);
	}

	public DanhSachSinhVien getDanhSachSinhVien() {
		return danhSachSinhVien;
	}

	public void setDanhSachSinhVien(DanhSachSinhVien danhSachSinhVien) {
		this.danhSachSinhVien = danhSachSinhVien;
	}

	public void xoaForm() {
		this.textField_DiemMon1.setText(null);
		this.textField_DiemMon2.setText(null);
		this.textField_DiemMon3.setText(null);
		this.textField_Mssv.setText(null);
		this.textField_Ten.setText(null);
		this.textField_TongDiem.setText(null);
		this.textField_Ten.setText(null);
		buttonGroup.clearSelection();
		this.comboBox_QueQuan_1.setSelectedItem(null);
		this.textField_NgaySinh.setText(null);
	}

	public void themSinhVienVaoTable(SinhVien sinhVien) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.addRow(new Object[] { sinhVien.getMaThiSinh() + "", sinhVien.getTenThiSinh() + "",
				sinhVien.getQueQuan().getTenTinh() + "", sinhVien.format() + "",
				sinhVien.isGioiTinh() ? "Nam" : "Nữ" + "", sinhVien.getDiemMon1() + "", +sinhVien.getDiemMon2() + "",
				sinhVien.getDiemMon3() + "" });
	}

	public void themHoacCapNhapSinhVien(SinhVien sinhVien) {
		if (this.danhSachSinhVien.kiemTraTonTai(sinhVien)) {
			this.danhSachSinhVien.insert(sinhVien);
			this.themSinhVienVaoTable(sinhVien);
		} else {
			this.danhSachSinhVien.update(sinhVien);
			int length_Row = table.getRowCount();
			int length_Column = table.getColumnCount();
			for (int i = 0; i < length_Row; i++) {
				String id = table.getValueAt(i, 0) + "";
				if (id.equals(sinhVien.getMaThiSinh() + "")) {
					table.setValueAt(sinhVien.getMaThiSinh(), i, 0);
					table.setValueAt(sinhVien.getTenThiSinh(), i, 1);
					table.setValueAt(sinhVien.getQueQuan().getTenTinh(), i, 2);
					table.setValueAt(sinhVien.format(), i, 3);
					table.setValueAt(sinhVien.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					table.setValueAt(sinhVien.getDiemMon1(), i, 5);
					table.setValueAt(sinhVien.getDiemMon2(), i, 6);
					table.setValueAt(sinhVien.getDiemMon3(), i, 7);
				}
			}
		}
	}

	public void hienThiThongTinDaChon() throws ParseException {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int x = table.getSelectedRow();
		int maThiSinh = Integer.valueOf(defaultTableModel.getValueAt(x, 0) + "");
		String tenThiSinh = defaultTableModel.getValueAt(x, 1) + "";

		Tinh tinh = Tinh.getTinhByTen(defaultTableModel.getValueAt(x, 2) + "");
		// Xử lý ngày sinh
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date ngaySinh = inputFormat.parse(defaultTableModel.getValueAt(x, 3) + "");
		String ngaySinhString = inputFormat.format(ngaySinh);

		String gioiTinhs = defaultTableModel.getValueAt(x, 4) + "";
		System.out.println(gioiTinhs);
		boolean gioiTinh;

		// Xử lý điểm môn học
		double diemMon1 = Double.valueOf(defaultTableModel.getValueAt(x, 5) + "");
		double diemMon2 = Double.valueOf(defaultTableModel.getValueAt(x, 6) + "");
		double diemMon3 = Double.valueOf(defaultTableModel.getValueAt(x, 7) + "");

		// Cập nhật lại thông tin vào bảng
		this.textField_Mssv.setText(maThiSinh + "");
		this.textField_Ten.setText(tenThiSinh);
		this.comboBox_QueQuan_1.setSelectedItem(tinh.getTenTinh());
		this.textField_NgaySinh.setText(ngaySinhString + "");
		gioiTinh = gioiTinhs.equals("false");
		if (gioiTinh) {
			radioButton_Nu.setSelected(true);
		} else {
			radioButton_Nam.setSelected(true);
		}
		this.textField_DiemMon1.setText(diemMon1 + "");
		this.textField_DiemMon2.setText(diemMon2 + "");
		this.textField_DiemMon3.setText(diemMon3 + "");
	}

	public void thucHienXoa() {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int x = table.getSelectedRow();
		System.out.println(x);
		this.danhSachSinhVien.remove(x);
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xoá không");
//		System.out.println(xString);
		if (luaChon == 0) {
			defaultTableModel.removeRow(x);
		}
//		System.out.println("-----------------------");
//		for (SinhVien sv : this.danhSachSinhVien.getDanhSach()) {
//			System.out.println(this.danhSachSinhVien.getDanhSach().indexOf(sv)+"+"+sv.toString());
//		}
	}

	public void thucHienThem() throws ParseException {
		// TODO Auto-generated method stub
		int maThiSinh = Integer.valueOf(this.textField_Mssv.getText());
		String tenThiSinh = this.textField_Ten.getText();
		int index = this.comboBox_QueQuan_1.getSelectedIndex();
		Tinh tinh = Tinh.getTinhById(index);

		// Xử lý ngày sinh
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date ngaySinh = inputFormat.parse(this.textField_NgaySinh.getText());
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedNgaySinh = outputFormat.format(ngaySinh);

		boolean gioiTinh;
		String chonString = this.buttonGroup.getSelection().getActionCommand();
		gioiTinh = chonString.equals("Nam");

		// Xử lý điểm môn học
		double diemMon1 = Double.valueOf(this.textField_DiemMon1.getText());
		double diemMon2 = Double.valueOf(this.textField_DiemMon2.getText());
		double diemMon3 = Double.valueOf(this.textField_DiemMon3.getText());

		// Sinh viên
		SinhVien sinhVien = new SinhVien(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);

		this.themHoacCapNhapSinhVien(sinhVien);
//		if (this.qlsv_View.getDanhSachSinhVien().getLuaChon().equals("Cập nhật")) {
//			this.qlsv_View.capNhapSv(sinhVien);
//		}
		System.out.println(sinhVien.toString());

	}

	public void thucHienTim() {
		thucHienTaiLenDuLieuTuDanhSach();
		int queQuan = this.comboBox_QueQuan.getSelectedIndex();
		String maThiSinhTimKiem = this.textField_MaSinhVien.getText();
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		Set<Integer> danhSachCanXoa = new HashSet<Integer>();
		int rowCount = table.getRowCount();

		// Xác định các dòng cần xóa và thêm chúng vào danhSachCanXoa
		for (int i = 0; i < rowCount; i++) {
			String tenTinh = table.getValueAt(i, 2) + "";
			String id = table.getValueAt(i, 0) + "";

			if (queQuan >= 0 && !tenTinh.equals(Tinh.getTinhById(queQuan).getTenTinh())) {
				danhSachCanXoa.add(i);
			}

			if (maThiSinhTimKiem.length() > 0 && !id.equals(maThiSinhTimKiem)) {
				danhSachCanXoa.add(i);
			}
		}

		// Loại bỏ các dòng cần xóa từ bảng (theo thứ tự giảm dần của chỉ mục)
		List<Integer> indexList = new ArrayList<>(danhSachCanXoa);
		Collections.sort(indexList, Collections.reverseOrder());
		for (Integer index : indexList) {
			System.out.println(index);
			defaultTableModel.removeRow(index);
		}
	}

	public void thucHienTaiLenDuLieuTuDanhSach() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int count = table.getRowCount();
		defaultTableModel.getDataVector().removeAllElements();
		// TODO Auto-generated method stub
		for (SinhVien x : this.danhSachSinhVien.getDanhSach()) {
			this.themSinhVienVaoTable(x);
		}
	}

	public void hienThiAbout() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Đây là phần mềm quản lý sinh viên");
	}

	public void thoatKhoiChuongTrinh() {
		// TODO Auto-generated method stub
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát khỏi chương trình hay không",
				"Confirm", JOptionPane.YES_NO_OPTION);
		if (luaChon == 0) {
			System.exit(0);
		}
	}

	public void save(String path) {
		try {
			this.danhSachSinhVien.setFileName(path);
			FileOutputStream fosStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fosStream);
			for (SinhVien x : this.danhSachSinhVien.getDanhSach()) {
				objectOutputStream.writeObject(x);
			}
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void thucHienLuuThongTin() {
		if (this.danhSachSinhVien.getFileName().length() > 0) {
			save(this.danhSachSinhVien.getFileName());
		} else {
			JFileChooser jFileChooser = new JFileChooser();
			int returnVal = jFileChooser.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				save(file.getAbsolutePath());
			}
		}
	}

	public void ThucHienMoFileThongTin() {
		JFileChooser jFileChooser = new JFileChooser();
		int returnVal = jFileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			openFile(file);
			thucHienTaiLenDuLieuTuDanhSach();
		}
	}

	private void openFile(File file) {
		ArrayList<SinhVien> arrayList = new ArrayList<SinhVien>();
		try {
			this.danhSachSinhVien.setFileName(file.getAbsolutePath());
			try (FileInputStream fisStream = new FileInputStream(file);
					ObjectInputStream objectInputStream = new ObjectInputStream(fisStream)) {

				SinhVien sVien = null;
				while (true) {
					try {
						sVien = (SinhVien) objectInputStream.readObject();
						arrayList.add(sVien);
					} catch (EOFException e) {
						break; // Kết thúc khi gặp cuối file
					}
				}
			}
		} catch (FileNotFoundException e) {
			// Xử lý FileNotFoundException
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// Xử lý ClassNotFoundException
			e.printStackTrace();
		} catch (IOException e) {
			// Xử lý IOException
			e.printStackTrace();
		}
		this.danhSachSinhVien.setDanhSach(arrayList);
	}

}
