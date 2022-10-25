package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Patient;
import Model.PatientHistory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientJPanel extends JPanel {
	private JTextField patienttxt;
	private JTextField patientNametxt;
	private JTextField patientAgetxt;
	private JTextField patientCitytxt;
	private JTextField patientAddresstxt;
PatientHistory patientHistory;
private JPanel PatientJPanel;
	/**
	 * Create the panel.
	 */
	public PatientJPanel(PatientHistory patientHistory) {
		this.patientHistory=patientHistory;
		setLayout(null);
		
		JLabel patientIdlb = new JLabel("PatientId");
		patientIdlb.setBounds(129, 65, 61, 16);
		add(patientIdlb);
		
		patienttxt = new JTextField();
		patienttxt.setBounds(225, 60, 130, 26);
		add(patienttxt);
		patienttxt.setColumns(10);
		
		patienttxt.setText("1");
		
		JLabel patientNamelb = new JLabel("Name");
		patientNamelb.setBounds(129, 117, 61, 16);
		add(patientNamelb);
		
		patientNametxt = new JTextField();
		patientNametxt.setBounds(225, 112, 130, 26);
		add(patientNametxt);
		patientNametxt.setColumns(10);
		
		JLabel patientAgelb = new JLabel("Age");
		patientAgelb.setBounds(129, 172, 61, 16);
		add(patientAgelb);
		
		patientAgetxt = new JTextField();
		patientAgetxt.setBounds(225, 167, 130, 26);
		add(patientAgetxt);
		patientAgetxt.setColumns(10);
		
		JLabel patientCitylb = new JLabel("City");
		patientCitylb.setBounds(129, 226, 61, 16);
		add(patientCitylb);
		
		patientCitytxt = new JTextField();
		patientCitytxt.setBounds(225, 221, 130, 26);
		add(patientCitytxt);
		patientCitytxt.setColumns(10);
		
		JLabel patientAddrlb = new JLabel("Address");
		patientAddrlb.setBounds(129, 288, 61, 16);
		add(patientAddrlb);
		
		patientAddresstxt = new JTextField();
		patientAddresstxt.setBounds(225, 283, 130, 26);
		add(patientAddresstxt);
		patientAddresstxt.setColumns(10);
		
		JButton patientdatasavebtn = new JButton("Save");
		patientdatasavebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientId=patienttxt.getText();
				//System.out.println(patientId);
				String patientIdtrim=patientId.trim();
				String name= patientNametxt.getText();
				String age=patientAgetxt.getText();
				String ageTrim=age.trim();
		String city=patientCitytxt.getText();
		String Address=patientAddresstxt.getText();
				
		int patientID=Integer.parseInt(patientIdtrim);
		int patientAge=Integer.parseInt(ageTrim);
		System.out.println(patientID);
		Patient p = patientHistory.addNewPatients();
		p.setPatientId(patientID);
		p.setAge(patientAge);
		p.setName(name);
		p.setPatientCity(city);
		p.setPatientAddress(Address);
		
		JOptionPane.showMessageDialog(PatientJPanel, "Patient Added successfully.");
		
		//System.out.println(patientHistory.getHistory());
		
		patienttxt.setText(" ");
		patientNametxt.setText(" ");
		patientAgetxt.setText(" ");
		patientCitytxt.setText(" ");
		patientAddresstxt.setText(" ");
		
		
		
			}
		});
		patientdatasavebtn.setBounds(238, 356, 117, 29);
		add(patientdatasavebtn);

	}
}
