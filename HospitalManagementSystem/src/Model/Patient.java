package Model;

public class Patient extends Person{
	
	private int patientId;
	//private String patientName;
	//private int patientAge;
	private String patientCity;
	private String patientAddress;
	
	

	public Patient(String name, int age,int patientId,String patientCity, String patientAddress) {
		//super(name, age);
		// TODO Auto-generated constructor stub
		this.patientId=patientId;
		this.patientCity=patientCity;
		this.patientAddress=patientAddress;
	}


public Integer getPatientId () {
	return patientId;
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

public void setPatientCity(String patientCity) {
	this.patientCity = patientCity;
}


public void setPatientAddress(String patientAddress) {
	this.patientAddress = patientAddress;
}


}


