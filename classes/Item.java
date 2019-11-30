package classes;

import java.io.Serializable;
import java.util.Calendar;

public class Item implements Serializable {
	private String name;
	private String category;
	private User owner;
	private int price;
	private Calendar calendar;
	private int maxavailableday;
	
	public Item() {}
	
	public Item(String name, String category, User owner) {
		this.name = name;
		this.category = category;
		this.owner = owner;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCategoryFlight() {
		this.category = "flight";
	}
	
	public void setCategorySuitcase() {
		this.category = "suitcase";
	}
	
	public void setCategoryCamera() {
		this.category = "camera";
	}
	
	public void setCategoryNecessities() {
		this.category = "necessities";
	}
	
	public void setCategoryOthers() {
		this.category = "others";
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setCalendar(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		
		this.calendar = cal;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}
	
	public void printCalendar() {
		System.out.println("등록일자: " + calendar.get(Calendar.YEAR) + "년 " + calendar.get(Calendar.MONTH)
                + "월 " + calendar.get(Calendar.DAY_OF_MONTH) + "일");
	}
	
	public int compareCalendar(Item anotherItem) {
		Calendar cal1 = calendar;
		Calendar cal2 = anotherItem.getCalendar();
		int compareValue = cal1.compareTo(cal2);
		return compareValue;
	}
	
	public void setMaxAvailableDay(int day) {
		this.maxavailableday = day;
	}
	
	public int getMaxAvailableDay() {
		return maxavailableday;
	}

}
