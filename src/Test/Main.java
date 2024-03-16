package Test;

import java.util.ArrayList;

import javax.swing.UIManager;

import View.QLSV_View;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSV_View();
		} catch (Exception e) {
			// TODO: handle exception
		
			e.printStackTrace();
		}
		
	}
}
