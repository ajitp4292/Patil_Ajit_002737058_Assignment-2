package Model;

public class Hospital  {
	private int hospitalID;
	private  String hospitalName;
	
	Community comm;
	
	public Hospital(Community comm) {
		this.comm = comm;
	}
	
	
	public int getHospitalID () {
		return hospitalID;
	}

	public int getCommunityId() {
		return comm.getCommunityId();
	}
	
	public String getCommunityName() {
		
		return comm.getCommunityName();
		
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalID(int hospitalID) {
		this.hospitalID=hospitalID;

		}
	
	public void setCommunityId(int communityID) {
		comm.setCommunityId(communityID);
	}
	
	public void setCommunityName(String communityName) {
		comm.setCommunityName(communityName);
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName=hospitalName;
		
	}
}
