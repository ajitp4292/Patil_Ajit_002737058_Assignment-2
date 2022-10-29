package UI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import Model.Community;
import Model.Doctor;
import Model.DoctorDirectory;
import Model.Hospital;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorJPanel extends JPanel {
	private JTextField docIDTxt;
	private JTextField docNameTxt;
	private JTextField docSpecialityTxt;
	private JTextField docHospIdTxt;
	private JTextField docHospNameTxt;
	DoctorDirectory doctorDirectory;
	private JPanel DoctorJPanel;

	/**
	 * Create the panel.
	 */
	public DoctorJPanel(DoctorDirectory doctorDirectory) {
		
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		docIDTxt = new JTextField();
		docIDTxt.setBounds(182, 55, 130, 26);
		add(docIDTxt);
		docIDTxt.setColumns(10);
		
		int size=doctorDirectory.getSize();
		int id = (size+1);
		String pid=String.valueOf(id);
		
		if (size==0) {
			docIDTxt.setText("1");
		}
		else {
			docIDTxt.setText(pid);
		}
		
		docNameTxt = new JTextField();
		docNameTxt.setBounds(182, 111, 130, 26);
		add(docNameTxt);
		docNameTxt.setColumns(10);
		
		docSpecialityTxt = new JTextField();
		docSpecialityTxt.setBounds(182, 166, 130, 26);
		add(docSpecialityTxt);
		docSpecialityTxt.setColumns(10);
		
		docHospIdTxt = new JTextField();
		docHospIdTxt.setBounds(182, 228, 130, 26);
		add(docHospIdTxt);
		docHospIdTxt.setColumns(10);
		
		docHospNameTxt = new JTextField();
		docHospNameTxt.setBounds(182, 282, 130, 26);
		add(docHospNameTxt);
		docHospNameTxt.setColumns(10);
		
		JLabel docIDlb = new JLabel("Doctor ID");
		docIDlb.setBounds(109, 60, 61, 16);
		add(docIDlb);
		
		JLabel docNamelb = new JLabel("Doctor Name");
		docNamelb.setBounds(88, 116, 88, 16);
		add(docNamelb);
		
		JLabel docexplb = new JLabel("Specialist");
		docexplb.setBounds(109, 171, 61, 16);
		add(docexplb);
		
		JLabel hospIDlb = new JLabel("Hospital ID");
		hospIDlb.setBounds(99, 233, 71, 16);
		add(hospIDlb);
		
		JLabel hospNamelb = new JLabel("Hospital Name");
		hospNamelb.setBounds(77, 287, 93, 16);
		add(hospNamelb);
		
		JButton saveDoclb = new JButton("Save");
		saveDoclb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( docIDTxt.getText().equals("") || docNameTxt.getText().equals("") || docSpecialityTxt.getText().equals("")|| docHospIdTxt.getText().equals("") || docHospNameTxt.getText().equals(""))
				{
			JOptionPane.showMessageDialog(DoctorJPanel, "Please fill the information Completely.");
		}
		
		else {	
		String docId=docIDTxt.getText().trim();
		String docName=docNameTxt.getText().trim();
		String docSpeciality=docSpecialityTxt.getText().trim();
		String docHospID= docHospIdTxt.getText().trim();
		String docHospNm=docHospNameTxt.getText().trim();
		
int docIDvalue=Integer.parseInt(docId);
int docHospIDvalue=Integer.parseInt(docHospID);

Community comm= new Community();
Hospital hosp= new Hospital(comm);
Doctor doc=doctorDirectory.addNewDoctor(comm,hosp);
doc.setDoctorID(docIDvalue);
doc.setDoctorName(docName);
doc.setDoctorSpecialization(docSpeciality);
doc.setHospitalId(docHospIDvalue);
doc.setHopsitalName(docHospNm);

JOptionPane.showMessageDialog(DoctorJPanel, "Doctor Added successfully.");
//System.out.println(p.hashCode());
//p.getName();		
//System.out.println(p.getName());
//int p1 = p.hashCode();
docNameTxt.setText(" ");
docSpecialityTxt.setText(" ");
docHospIdTxt.setText(" ");
docHospNameTxt.setText(" ");

int size=doctorDirectory.getSize();
int id = (size+1);
String pid=String.valueOf(id);

if (size==0) {
	docIDTxt.setText("1");
}
else {
	docIDTxt.setText(pid);
}


		
	}
				
			}
		});
		saveDoclb.setBounds(182, 347, 117, 29);
		add(saveDoclb);

	}

}
