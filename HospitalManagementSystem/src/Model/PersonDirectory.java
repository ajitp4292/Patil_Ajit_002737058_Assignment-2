package Model;

import java.util.ArrayList;

public class PersonDirectory {

private ArrayList <Person> personDirectory;

	
	public PersonDirectory() {
		
		this.personDirectory= new ArrayList <Person>();
		
	}

	public ArrayList<Person> getPerson() {
		return personDirectory;
	}

	

	public Person addNewPerson(House h) {
		 

		//Community newComm= new Community();
		Person newPerson=new Person(h);
		personDirectory.add(newPerson);
		return newPerson;
		
		
	}
	
	
	public void deletePerson (int p) {
		personDirectory.remove(p);
	}
	
	/*public void deleteCommunity (Community com) {
		communityList.remove(com);
	}*/
	
	
	public int getPosition(int pos) {
		personDirectory.indexOf(pos);
		return pos-1;
		
	}
	
	public int getSize() {
	int size=personDirectory.size();
	return size;
	}
	
	
    public void modifyCommunity(Person currentPerson, Person newPerson,int position) 
    {
        //System.out.println(position);
        if(position >= 0) {
            modifyPerson(position, newPerson);
        }
        
    }
        
        private void modifyPerson(int position, Person newPerson) {
        	personDirectory.set(position, newPerson);
           // System.out.println("Grocery item " + (position+1) + " has been modified.");
        }
	
       

	
}
