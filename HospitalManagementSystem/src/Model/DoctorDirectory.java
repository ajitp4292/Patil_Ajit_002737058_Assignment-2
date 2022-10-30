package Model;

import java.util.ArrayList;

public class DoctorDirectory {
	
private ArrayList <Doctor> doctorDirectory;

	
	public DoctorDirectory() {
		
		this.doctorDirectory= new ArrayList <Doctor>();
		
	}

	public ArrayList<Doctor> getDoctor() {
		return doctorDirectory;
	}

	

	public Doctor addNewDoctor(Community comm,Hospital hosp) {
		 

		Doctor newDoc= new Doctor(comm,hosp);
		doctorDirectory.add(newDoc);
		return newDoc;
		
		
	}
	
	
	public void deleteDoctor (int p) {
		doctorDirectory.remove(p);
	}
	
	/*public void deleteCommunity (Community com) {
		communityList.remove(com);
	}*/
	
	
	public int getPosition(int pos) {
		doctorDirectory.indexOf(pos);
		return pos-1;
		
	}
	
	public int getSize() {
	int size=doctorDirectory.size();
	return size;
	}
	
	
    public void modifyDoctor(Doctor currentDoctor, Doctor newDoctor,int position) 
    {
        //System.out.println(position);
        if(position >= 0) {
            modifyDoctor(position, newDoctor);
        }
        
    }
        
        private void modifyDoctor(int position, Doctor newDoctor) {
            doctorDirectory.set(position, newDoctor);
           // System.out.println("Grocery item " + (position+1) + " has been modified.");
        }
	

    	public ArrayList<String> showDoctorDetails(String hospName) {
    		//String[] hnames= new String[10];
    		System.out.println(hospName);
    		int a=doctorDirectory.size();
    		a=a-1;
    		//System.out.println(a);
    		int i;
    		ArrayList<String> doctorNames = new ArrayList<String>();

    			for (Doctor doc:doctorDirectory) {
    				//System.out.println(doc.getHospital());
    				System.out.println("Outside");
    				System.out.println(doc.getHospital());
    				for(i=0;i<a;i++) {
    				if (doc.getHospital().equals(hospName)) {
    					System.out.println("indide");
    					System.out.println(doc.getDoctorName());
    					
    			}
    				
    			}
    			
    		}
    			return doctorNames;
    	        
    	       
    		
    		}
	
}
