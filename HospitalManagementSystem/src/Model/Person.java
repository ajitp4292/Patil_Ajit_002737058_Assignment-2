package Model;

public class Person {
	
	private String name;
	private int age;
	private String sex;
	House h;
	
	public Person(House h) {
		this.h = h;
	}
	public String getName() {
		return name;
		
	}
	
	public int getAge() {
		return age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getStreet() {
		return h.getStreet();
	}
	
	public int getAptNumber() {
		return h.getAptNumber();
	}
	
	public int getZipcode() {
		return h.getZipcode();
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSex(String sex) {
		this.sex=sex;
	}

	public void setStreet(String street) {
		h.setStreet(street);
	}
	
	public void setAptNumber(int aptNo) {
		h.setAptNumber(aptNo);
	}
	
	public void setZipcode(int zipCd) {
		h.setZipcode(zipCd);
	}
	
}
