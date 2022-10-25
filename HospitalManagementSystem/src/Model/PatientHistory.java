package Model;
import java.util.ArrayList;

public class PatientHistory {
	
	

	
	private ArrayList <Patient> patientHistory;
	
	public PatientHistory() {
		
		this.patientHistory= new ArrayList <Patient>();
		
	}

	public ArrayList<Patient> getHistory() {
		return patientHistory;
	}

	/*public void setHistory(ArrayList<EmployeeInfo> history) {
		this.history = history;
	}*/

	public Patient addNewPatients() {
		 //String name;
		// int age;
		// int patientId;
		 //String patientCity;
		 //String patientAddress;

		Patient newPatients= new Patient();
		patientHistory.add(newPatients);
		return newPatients;
		
		
	}
	
	public void deletePatients (Patient p) {
		patientHistory.remove(p);
	}
	
	
	public void displayResults() {
		for (int i = 0; i < patientHistory.size(); i++) {
			
			System.out.print(patientHistory.get(i) + " ");
		}
	}
}
