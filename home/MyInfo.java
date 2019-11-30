package home;

public class MyInfo {
	
	public static String my_name;
	public static String my_id;
	public static String my_phone;
	
	public static void setName(String names) {
		my_name = names;
	}
	
	public static void setID(String ids) {
		my_id = ids;
	}
	
	public static void setPhone(String phones) {
		my_phone = phones;
	}
	
	public String getName() {
		return my_name;
	}
	
	public String getId() {
		return my_id;
	}
	
	public String getPhone() {
		return my_phone;
	}
}
