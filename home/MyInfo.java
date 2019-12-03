package home;

import java.net.Socket;

public class MyInfo {
	
	public static String my_name;
	public static String my_id;
	public static String my_phone;
	public static boolean socketConnect = false;
	public static Socket socket = null;
	
	public static void setName(String names) {
		my_name = names;
	}
	
	public static void setID(String ids) {
		my_id = ids;
	}
	
	public static void setPhone(String phones) {
		my_phone = phones;
	}
	
	public static void setConnect(boolean state) {
		socketConnect = state;
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
	
	public Socket getSocket() {
		return socket;
	}
	
	public static void setSocket(Socket s) {
		socket = s;
	}
}
