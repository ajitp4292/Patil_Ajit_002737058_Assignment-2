package Model;

import java.util.ArrayList;

public class EncounterHistory {
	
	

		private ArrayList <Encounter> encounterHistory;

			
			public EncounterHistory() {
				
				this.encounterHistory= new ArrayList <Encounter>();
				
			}

			public ArrayList<Encounter> getEncounter() {
				return encounterHistory;
			}

			

			public Encounter addNewEncounter(VitalSigns vs) {
				 

				Encounter newEncounter= new Encounter(vs);
				encounterHistory.add(newEncounter);
				return newEncounter;
				
				
			}
			
			
			public void deleteEncounter (int p) {
				encounterHistory.remove(p);
			}
			
			/*public void deleteCommunity (Community com) {
				communityList.remove(com);
			}*/
			
			
			public int getPosition(int pos) {
				encounterHistory.indexOf(pos);
				return pos-1;
				
			}
			
			public int getSize() {
			int size=encounterHistory.size();
			return size;
			}
			
			
		    public void modifyEncounter(Encounter currentEncounter, Encounter newEncounter,int position) 
		    {
		        //System.out.println(position);
		        if(position >= 0) {
		            modifyEncounter(position, newEncounter);
		        }
		        
		    }
		        
		        private void modifyEncounter(int position, Encounter newEncounter) {
		            encounterHistory.set(position, newEncounter);
		           // System.out.println("Grocery item " + (position+1) + " has been modified.");
		        }
			
		       /* public int  FindCommunityIdByZipcd(int zipCd) {
		        	int CommID = 0;
		        	for(Community com:communityList) {
		        		if (com.getcommunityZipcd()==zipCd) {
		        		int comID= com.getCommunityId();
		        		CommID=comID;
		        		}
		        		
		        	}
		        	return CommID;	
		        }*/

}
