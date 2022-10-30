package Model;

public class Encounter {
	
	VitalSigns vs;
	private int encounterId;
	private int patientId;
	private int doctorId;
	
	public Encounter(VitalSigns vs) {
		this.vs=vs;
	}

	public int getEncounterId() {
		return encounterId;
	}
	
	public void setEncounterId(int encounterId) {
		this.encounterId=encounterId;
	}
	
	public int getpatientId() {
		return patientId;
	}
	
	
	public void  setPatientID(int patientId) {
		this.patientId=patientId;
	}
	
	public int getDoctorID() {
		return doctorId;
	}
	
	
	public void  setDoctorID(int doctorId) {
		this.doctorId=doctorId;
	}
	
	
	public double getTemperature() {
		return vs.getTemperature();
	}
	
	public void setTemeprature(double temperature) {
		vs.setTemperature(temperature);
	}
	
	public double  getbloodPressure() {
		return vs.getbloodPressure();
	}
	
	public void setBloodPressure(double bloodPressure) {
		vs.setBloodPressure(bloodPressure);
	}
	
	public int getPulse() {
		return vs.getPulse();
	}
	
	public void  setPulse(int pulse) {
		vs.setPulse(pulse);
	}
	
	public String getDate() {
		return vs.getDate();
	}
	
	public void  setDate(String date) {
		vs.setDate(date);
	}
	
}


