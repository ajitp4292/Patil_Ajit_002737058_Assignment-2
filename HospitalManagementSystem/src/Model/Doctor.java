package Model;

public class Doctor {
	Hospital hosp;
	Community comm;
	
	public Doctor(Community comm,Hospital hosp) {
		this.comm=comm;
		this.hosp=hosp;
		

	}
	
	private int doctorId;
	private String doctorName;
	private String Expertise;
	
	
	public int getDoctorID () {
		return doctorId;
	}
	
public String getDoctorName() {
	return doctorName;
	
}


public String getDoctorSpecialization() {
	return Expertise;
	
}

public int getHospitalId() {
	return hosp.getHospitalID();
}

public String getHospital() {
	return hosp.getHospitalName();
}
	

public void setDoctorID(int doctorId) {
	this.doctorId=doctorId;

	}


public void setDoctorName(String doctorName) {
	this.doctorName= doctorName;

	}

public void setDoctorSpecialization(String Expertise) {
	this.Expertise= Expertise;

	}


public void setHospitalId(int hospitalId) {
	hosp.setHospitalID(hospitalId);
}

public void setHopsitalName(String hospitalName) {
	hosp.setHospitalName(hospitalName);
}
}
