package Model;

public class Community {
	
private int communityId;
private String city;
private String communityName;
private int communityZipcode;


public int getCommunityId() {
	return communityId;
}
public String getCity() {
	return city;
}

public String getCommunityName() {
	
	return communityName;
	
}

public int getcommunityZipcd() {
	
	return communityZipcode;
}

public void setCommunityId(int communityId) {
	this.communityId=communityId;
}

public void setCity(String city) {
	this.city=city;
}

public void setCommunityName(String communityName) {
	this.communityName=communityName;
}

public void setcommunityZipcd(int communityZipcode) {
	this.communityZipcode=communityZipcode;
}

}
