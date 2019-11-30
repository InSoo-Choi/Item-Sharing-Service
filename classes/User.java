package classes;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private int phoneNumber;
	private String ID;
	private String PW;
	private int numOfregItem;
	private int numOfrenItem;
	private int mileage;
	
	public User() {}
	
	public User(String name, String ID, String PW, int number, int i, int j, int k) {
		this.name = name;
		this.ID = ID;
		this.PW = PW;
		this.phoneNumber = number;
		this.numOfregItem = i;
		this.numOfrenItem = j;
		this.mileage = k;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setPW(String PW) {
		this.PW = PW;
	}
	
	public String getPW() {
		return PW;
	}
	
	public void setPhoneNumber(int number) {
		this.phoneNumber = number;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setNumOfregItem(int n) {
		this.numOfregItem = n;
	}
	
	public int getNumOfregItem() {
		return numOfregItem;
	}
	
	public void setNumOfrenItem(int n) {
		this.numOfrenItem = n;
	}
	
	public int getNumOfrenItem() {
		return numOfrenItem;
	}
	
	public void setMileage(int n) {
		this.mileage = n;
	}
	
	public int getMileage() {
		return mileage;
	}

}
