package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.House;
import Model.Patient;
import Model.PatientHistory;
import Model.Person;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class PatientJPanel extends JPanel {
	private JTextField patienttxt;
	private JTextField patientNametxt;
	private JTextField patientAgetxt;
	private JTextField patientCitytxt;
	private JTextField patientAddresstxt;
PatientHistory patientHistory;
private JPanel PatientJPanel;
private JTextField patientZipcdTxt;

	/**
	 * Create the panel.
	 */
	public  PatientJPanel(PatientHistory patientHistory) {
		setBackground(UIManager.getColor("Desktop.background"));
		this.patientHistory=patientHistory;
		setLayout(null);
		
		JLabel patientIdlb = new JLabel("PatientId");
		patientIdlb.setBounds(129, 65, 61, 16);
		add(patientIdlb);
		
		patienttxt = new JTextField();
		patienttxt.setBounds(225, 60, 130, 26);
		add(patienttxt);
		patienttxt.setColumns(10);
		
		int size=patientHistory.getSize();
		int id = (size+1);
		String pid=String.valueOf(id);
		
		if (size==0) {
			patienttxt.setText("1");
		}
		else {
			patienttxt.setText(pid);
		}
		
		
		JLabel patientNamelb = new JLabel("Name");
		patientNamelb.setBounds(139, 117, 61, 16);
		add(patientNamelb);
		
		patientNametxt = new JTextField();
		patientNametxt.setBounds(225, 112, 130, 26);
		add(patientNametxt);
		patientNametxt.setColumns(10);
		
		JLabel patientAgelb = new JLabel("Age");
		patientAgelb.setBounds(152, 172, 32, 16);
		add(patientAgelb);
		
		patientAgetxt = new JTextField();
		patientAgetxt.setBounds(225, 167, 130, 26);
		add(patientAgetxt);
		patientAgetxt.setColumns(10);
		
		JLabel patientCitylb = new JLabel("City");
		patientCitylb.setBounds(158, 292, 32, 16);
		add(patientCitylb);
		
		patientCitytxt = new JTextField();
		patientCitytxt.setBounds(225, 287, 130, 26);
		add(patientCitytxt);
		patientCitytxt.setColumns(10);
		
		JLabel patientAddrlb = new JLabel("Address");
		patientAddrlb.setBounds(139, 346, 61, 16);
		add(patientAddrlb);
		
		patientAddresstxt = new JTextField();
		patientAddresstxt.setBounds(225, 341, 130, 26);
		add(patientAddresstxt);
		patientAddresstxt.setColumns(10);
		
		patientZipcdTxt = new JTextField();
		patientZipcdTxt.setBounds(225, 394, 130, 26);
		add(patientZipcdTxt);
		patientZipcdTxt.setColumns(10);
		
		JLabel patientZiplb = new JLabel("ZipCode");
		patientZiplb.setBounds(152, 399, 61, 16);
		add(patientZiplb);
		
		JLabel patientSexlb = new JLabel("Sex");
		patientSexlb.setBounds(152, 228, 32, 16);
		add(patientSexlb);
		
		JRadioButton maleradiobtn = new JRadioButton("Male");
		maleradiobtn.setBounds(213, 224, 70, 23);
		add(maleradiobtn);
		
		JRadioButton femaleradiobtn = new JRadioButton("Female");
		femaleradiobtn.setBounds(295, 224, 76, 23);
		add(femaleradiobtn);
		
		ButtonGroup group = new ButtonGroup();
		group.add(maleradiobtn);
		group.add(femaleradiobtn);
		
		JButton patientdatasavebtn = new JButton("Save");
		patientdatasavebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		patientdatasavebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> bg= group.getElements();
				JRadioButton jrd= (JRadioButton)bg.nextElement();
				String patientId=patienttxt.getText();
				//System.out.println(patientId);
				String patientIdtrim=patientId.trim();
				String name= patientNametxt.getText().trim();
				String age=patientAgetxt.getText();
				String ageTrim=age.trim();
				String sex=jrd.getText().trim();
		String city=patientCitytxt.getText().trim();
		String Address=patientAddresstxt.getText().trim();
	String 	Zipcd=patientZipcdTxt.getText().trim();
		int patientID=Integer.parseInt(patientIdtrim);
		int patientAge=Integer.parseInt(ageTrim);
		int patientZipcd=Integer.parseInt(Zipcd);;
		//System.out.println(patientID);
		House h= new House();
		Person p= new Person(h);
		Patient patient = patientHistory.addNewPatients(p,h);
		patient.setPatientId(patientID);
		patient.setAge(patientAge);
		patient.setName(name);
		patient.setSex(sex);
		patient.setPatientCity(city);
		patient.setPatientAddress(Address);
		patient.setZipcode(patientZipcd);
		
		//p.hashCode();
		
		JOptionPane.showMessageDialog(PatientJPanel, "Patient Added successfully.");
		//System.out.println(p.hashCode());
		//p.getName();		
		//System.out.println(p.getName());
		//int p1 = p.hashCode();
		patienttxt.setText(" ");
		patientNametxt.setText(" ");
		patientAgetxt.setText(" ");
		patientCitytxt.setText(" ");
		patientAddresstxt.setText(" ");
		patientZipcdTxt.setText(" ");
		
		//System.out.println(patientHistory.getSize());
		int size=patientHistory.getSize();
		int id = (size+1);
		String pid=String.valueOf(id);
		
		if (size==0) {
			patienttxt.setText("1");
		}
		else {
			patienttxt.setText(pid);
		}
		
		
		
			}
		});
		patientdatasavebtn.setBounds(238, 459, 117, 29);
		add(patientdatasavebtn);
		
		
		

	}
}
