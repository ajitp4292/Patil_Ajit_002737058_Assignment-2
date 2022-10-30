package Model;

public class Patient{
	
	Person p;
	House h;
	private int patientId;
	private String patientCity;
	private String patientAddress;
	
	public Patient(Person p, House h) {
		this.p=p;
		this.h=h;
	}
	
	public int getPatientId () {
		return patientId;
	}
	
	public String getName() {
		return p.getName();
		
	}

	public int getAge() {
		return p.getAge();
	}

public String getSex() {
	return p.getSex();
}


public String getPatientCity () {
	return patientCity;
}

public String getPatientAddress () {
	return patientAddress;
}

public int getZipcode() {
	return h.getZipcode();
}


public void setPatientId(int patientId) {
	this.patientId = patientId;
}


public void setName(String name) {
p.setName(name);

}

public void setAge(int age) {
p.setAge(age);
}

public void setSex(String sex) {
	p.setSex(sex);
}

public void setPatientCity(String patientCity) {
	this.patientCity = patientCity;
}


public void setPatientAddress(String patientAddress) {
	this.patientAddress = patientAddress;
}

public void setZipcode(int zip) {
	h.setZipcode(zip);
}


}


