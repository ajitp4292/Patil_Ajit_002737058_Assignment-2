package Model;

public class Patient extends Person{
	
	private int patientId;
	//private String patientName;
	//private int patientAge;
	private String patientCity;
	private String patientAddress;
	
	public int getPatientId () {
		return patientId;
	}
	
	public String getName() {
		return Patient.super.getName();
		
	}

	public int getAge() {
		return Patient.super.getAge();
	}




public String getPatientCity () {
	return patientCity;
}

public String getPatientAddress () {
	return patientAddress;
}


public void setPatientId(int patientId) {
	this.patientId = patientId;
}


public void setName(String name) {
Patient.super.setName(name);

}

public void setAge(int age) {
Patient.super.setAge(age);
}


public void setPatientCity(String patientCity) {
	this.patientCity = patientCity;
}


public void setPatientAddress(String patientAddress) {
	this.patientAddress = patientAddress;
}




}


