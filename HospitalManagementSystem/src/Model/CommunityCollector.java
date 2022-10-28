package Model;

import java.util.ArrayList;

public class CommunityCollector {

private ArrayList <Community> communityList;
	
	public CommunityCollector() {
		
		this.communityList= new ArrayList <Community>();
		
	}

	public ArrayList<Community> getCommunity() {
		return communityList;
	}

	

	public Community addNewCommunity() {
		 

		Community newCommunity= new Community();
		communityList.add(newCommunity);
		return newCommunity;
		
		
	}
	
	
	public void deleteCommunity (int p) {
		communityList.remove(p);
	}
	
	
	public int getPosition(int pos) {
		communityList.indexOf(pos);
		return pos-1;
		
	}
	
	public int getSize() {
	int size=communityList.size();
	return size;
	}
	
	
    public void modifyCommunity(Community currentCommunity, Community newCommunity,int position) 
    {
        //System.out.println(position);
        if(position >= 0) {
            modifyCommunity(position, newCommunity);
        }
        
    }
        
        private void modifyCommunity(int position, Community newCommunity) {
            communityList.set(position, newCommunity);
           // System.out.println("Grocery item " + (position+1) + " has been modified.");
        }
	
	
       
}
