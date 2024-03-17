package Model;

import java.util.ArrayList;

public class Tinh {
	private int maTinh;
	private String tenTinh;

	public Tinh(int maTinh, String tenTinh) {
		super();
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public Tinh() {

	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}

	public static ArrayList<Tinh> ds() {
		String[] arr = {null,"An Giang" ,"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng",
				"Cần Thơ", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai",
				"Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình",
				"Thành phố Hồ Chí Minh", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn",
				"Lào Cai", "Lâm Đồng", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ",
				"Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La",
				"Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh",
				"Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", };
		int x = 0;
		ArrayList<Tinh> tinhs = new ArrayList<Tinh>();
		for (String string : arr) {
			Tinh tinh = new Tinh(x , string);
			tinhs.add(tinh);
			x++;
		}
		return tinhs;
	}
	public static Tinh getTinhById(int index) {
		return Tinh.ds().get(index);
	}

	public static Tinh getTinhByTen(String tenTinh) {
		ArrayList<Tinh> listTinh = Tinh.ds();
		for (Tinh tinh : listTinh) {
			if(tinh.tenTinh.equals(tenTinh))
				return tinh;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Tinh tinh = new Tinh();
		tinh.setTenTinh("Bình Dương");
		ArrayList<Tinh> listTinh = Tinh.ds();
		for (Tinh tinh2 : Tinh.ds()) {
		    if(tinh2.getTenTinh().equals(tinh.getTenTinh())) {
		        System.out.println(tinh2);
		    }
		}
	}
}
