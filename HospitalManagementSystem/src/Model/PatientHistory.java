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
	
	/*public void deletePatients (Patient p) {
		patientHistory.remove(p);
	}*/
	
	public void deletePatients (int p) {
		patientHistory.remove(p);
	}
	
	
	public int getPosition(int pos) {
		patientHistory.indexOf(pos);
		return pos-1;
		
	}
	
	public int getSize() {
	int size=patientHistory.size();
	return size;
	}
	
	/*public void updatePatientDetails(int a , Patient p) {
		Patient p = new Patient();
		patientHistory.set(a, p);
		
	}*/
	
    public void modifyPatients(Patient currentPatient, Patient newPatient,int position) 
    {
       // int position = findPatient(currentPatient);
       // System.out.println(position);
        if(position >= 0) {
            modifyPatients(position, newPatient);
        }
        
    }
       /* private int findPatient(Patient searchPatient) {
            return patientHistory.indexOf(searchPatient);
            
        }*/
        
        private void modifyPatients(int position, Patient newPatient) {
            patientHistory.set(position, newPatient);
           // System.out.println("Grocery item " + (position+1) + " has been modified.");
        }
	
	
        public void printPatientlist() {
            System.out.println("You have " + patientHistory.size() + " patients in your list");
            for(int i=0; i< patientHistory.size(); i++) {
                System.out.println((i+1) + ". " + patientHistory.get(i));
            }
        }
}
