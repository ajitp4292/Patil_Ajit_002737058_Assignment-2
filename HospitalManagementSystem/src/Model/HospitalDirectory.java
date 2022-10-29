package Model;

import java.util.ArrayList;

public class HospitalDirectory {
	
	private ArrayList <Hospital> hospitalDirectory;
	
public HospitalDirectory() {
		
		this.hospitalDirectory= new ArrayList <Hospital>();
		
	}

	public ArrayList<Hospital> getHospital() {
		return hospitalDirectory;
	}

	

	public Hospital addNewHospital(Community comm) {
		 
      
		Hospital newHospital= new Hospital(comm);
		hospitalDirectory.add(newHospital);
		return newHospital;
		
		
	}
	
	
	public void deleteHospital (int p) {
		hospitalDirectory.remove(p);
	}
	
	
	public int getPosition(int pos) {
		hospitalDirectory.indexOf(pos);
		return pos-1;
		
	}
	
	public int getSize() {
	int size=hospitalDirectory.size();
	return size;
	}
	
	
    public void modifyHospital(Hospital currentHospital, Hospital newHospital,int position) 
    {
        //System.out.println(position);
        if(position >= 0) {
        	
            modifyHospital(position, newHospital);
        }
        
    }
        
        private void modifyHospital(int position, Hospital newHospital) {
            hospitalDirectory.set(position, newHospital);
           // System.out.println("Grocery item " + (position+1) + " has been modified.");
        }
	

        public void showHopsitalList() {
        	
   for (Hospital hosp:hospitalDirectory) {
	   
	   System.out.println(hosp.getHospitalID());
   
            
            }
       
	
	
}
}
