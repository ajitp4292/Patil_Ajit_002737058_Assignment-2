package UI;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.CommunityCollector;
import Model.DoctorDirectory;
import Model.HospitalDirectory;
import Model.House;
import Model.Patient;
import Model.PatientHistory;
import Model.Person;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class PatientViewPanel extends JPanel {
	private JTable table;
private JPanel PatientViewPanel;
	PatientHistory patientHistory;
	CommunityCollector communityList;
	HospitalDirectory hospitalDirectory;
	DoctorDirectory doctorDirectory;
	Patient p ;
	DefaultTableModel model;
	private JTextField patientIdTxt;
	private JTextField patientNameTxt;
	private JTextField patientAgeTxt;
	private JTextField patientCityTxt;
	private JTextField patientAddressTxt;
	private JTextField patientSexTxt;
	private JTextField patientZipTxt;
	private JTextField commIdTxt;
	private static JComboBox<String> comboBox;
	private static JComboBox<String> comboBox_1;
	/**
	 * Create the panel.
	 */
	public PatientViewPanel(PatientHistory patientHistory , Patient p,CommunityCollector communityList,HospitalDirectory hospitalDirectory,DoctorDirectory doctorDirectory) {
		setBackground(UIManager.getColor("Desktop.background"));
		this.patientHistory=patientHistory;
		this.communityList=communityList;
		this.hospitalDirectory=hospitalDirectory;
		this.doctorDirectory=doctorDirectory;
		//p.getAge();
		//System.out.println(p.getAge());
		/*Patient p = new Patient();
		System.out.println(p.getName());*/
		//System.out.println(p.size());
		
		model= new DefaultTableModel();
		Object[] column= {"PatientId","Name","Age","Sex","City","Address","Zipcode"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		setLayout(null);
		
		JLabel patientViewlb = new JLabel("View Patient Details");
		patientViewlb.setBounds(185, 29, 173, 43);
		add(patientViewlb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 93, 422, 119);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		patientIdTxt = new JTextField();
		patientIdTxt.setBounds(89, 286, 93, 26);
		add(patientIdTxt);
		patientIdTxt.setColumns(10);
		
		patientNameTxt = new JTextField();
		patientNameTxt.setBounds(89, 334, 93, 26);
		add(patientNameTxt);
		patientNameTxt.setColumns(10);
		
		patientAgeTxt = new JTextField();
		patientAgeTxt.setBounds(89, 377, 93, 26);
		add(patientAgeTxt);
		patientAgeTxt.setColumns(10);
		
		patientCityTxt = new JTextField();
		patientCityTxt.setBounds(284, 377, 104, 26);
		add(patientCityTxt);
		patientCityTxt.setColumns(10);
		
		patientAddressTxt = new JTextField();
		patientAddressTxt.setBounds(284, 286, 104, 26);
		add(patientAddressTxt);
		patientAddressTxt.setColumns(10);
		
		patientSexTxt = new JTextField();
		patientSexTxt.setBounds(89, 427, 93, 26);
		add(patientSexTxt);
		patientSexTxt.setColumns(10);
		
		JLabel patientSexlb = new JLabel("Sex");
		patientSexlb.setBounds(38, 432, 29, 16);
		add(patientSexlb);
		
		patientZipTxt = new JTextField();
		patientZipTxt.setBounds(284, 334, 104, 26);
		add(patientZipTxt);
		patientZipTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Zipcode");
		lblNewLabel.setBounds(211, 339, 61, 16);
		add(lblNewLabel);
		
		commIdTxt = new JTextField();
		commIdTxt.setBounds(284, 427, 104, 26);
		add(commIdTxt);
		commIdTxt.setColumns(10);
		
		JLabel commIdlb = new JLabel("Comm ID");
		commIdlb.setBounds(211, 432, 61, 16);
		add(commIdlb);
		
		JLabel hospDisplb = new JLabel("Hospitals Near");
		hospDisplb.setBounds(16, 488, 111, 16);
		add(hospDisplb);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(312, 484, 82, 27);
		add(comboBox_1);
		
		JLabel doclb = new JLabel("Doctor List");
		doclb.setBounds(227, 488, 82, 16);
		add(doclb);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hospitalSelected = (String) comboBox.getSelectedItem();
				System.out.println(hospitalSelected);
				ArrayList<String> dNames= new ArrayList<String>();
				dNames=doctorDirectory.showDoctorDetails(hospitalSelected);
				System.out.println(dNames);
System.out.println("action performed");
				int i;	
				for(i=0; i<dNames.size();i++) {
					String dn=dNames.get(i);
					comboBox_1.addItem(dn);
				}
			}
		});
		comboBox.setBounds(112, 484, 93, 27);
		add(comboBox);
		
		
		
		
	
		
		
		
		JButton patientDeletebtn = new JButton("Delete");
		patientDeletebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		patientDeletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(PatientViewPanel,"Please select a row to delete");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//Patient selectedPatientDetails=(Patient)model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedPatientDetails);
				/*Vector selectedPatientDetails=model.getDataVector().elementAt(table.convertRowIndexToModel(table.getSelectedRow()));*/
				int column = 0;
				int row = table.getSelectedRow();
				String PatientIDvalue = table.getModel().getValueAt(row, column).toString();
				String PatientNamevalue= table.getModel().getValueAt(row, 1).toString();
				String PatientAgevalue= table.getModel().getValueAt(row, 2).toString();
				String PatientCityvalue= table.getModel().getValueAt(row, 3).toString();
				String PatientAddressvalue= table.getModel().getValueAt(row, 4).toString();
				//System.out.println(PatientIDvalue);
				//System.out.println(PatientNamevalue);
				//System.out.println(PatientAgevalue);
				//System.out.println(PatientCityvalue);
				//System.out.println(PatientAddressvalue);
				
				int patientID=Integer.parseInt(PatientIDvalue);
				int patientAge=Integer.parseInt(PatientAgevalue);
				//Patient patient = new Patient();
				
				//patientHistory.getPosition(patientID);
				int pos =patientHistory.getPosition(patientID);
				//System.out.println(pos);
				patientHistory.deletePatients(row);
				//patient.getPatientId();
				//patientHistory.deletePatients(patientID);
				
				JOptionPane.showMessageDialog(PatientViewPanel,"Patient details deleted");
				populatePatientDetails();	
					
				
				
			}
		});
		patientDeletebtn.setBounds(296, 224, 117, 29);
		add(patientDeletebtn);
		
		JButton patientViewbtn = new JButton("View");
		patientViewbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		patientViewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(PatientViewPanel,"Please select a row to view");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedEmpdetails);
				
				int column = 0;
				int row = table.getSelectedRow();
				String patientIDvalue = table.getModel().getValueAt(row, column).toString();
				String patientNamevalue= table.getModel().getValueAt(row, 1).toString();
				String patientAgevalue= table.getModel().getValueAt(row, 2).toString();
				String patientSexvalue= table.getModel().getValueAt(row, 3).toString();
				String patientCityvalue= table.getModel().getValueAt(row, 4).toString();
				String patientAddressvalue= table.getModel().getValueAt(row, 5).toString();
				String patientZipvalue=table.getModel().getValueAt(row, 6).toString();
				//System.out.println(PatientIDvalue);
				int patientZipCode=Integer.parseInt(patientZipvalue);
				patientIdTxt.setText(patientIDvalue);
				patientNameTxt.setText(patientNamevalue);
				patientAgeTxt.setText(patientAgevalue);
				patientSexTxt.setText(patientSexvalue);
				patientCityTxt.setText(patientCityvalue);
				patientAddressTxt.setText(patientAddressvalue);
				patientZipTxt.setText(patientZipvalue);
				
	int comID=communityList.FindCommunityIdByZipcd(patientZipCode);
	System.out.println(comID);
	String comIDvalue=String.valueOf(comID);
	commIdTxt.setText(comIDvalue);
	ArrayList<String> hs= new ArrayList<String>();
hs=hospitalDirectory.showHospitalDetails(comID);

int i;	
for(i=0; i<hs.size();i++) {
	String s=hs.get(i);
	comboBox.addItem(s);
}
				
			}
		});
		patientViewbtn.setBounds(38, 224, 117, 29);
		add(patientViewbtn);
		
	
		
		JLabel patientIDlb = new JLabel("PatientId");
		patientIDlb.setBounds(16, 291, 61, 16);
		add(patientIDlb);
		
		JLabel patientNamelb = new JLabel("Name");
		patientNamelb.setBounds(32, 339, 45, 16);
		add(patientNamelb);
		
		JLabel patientAgelb = new JLabel("Age");
		patientAgelb.setBounds(38, 382, 29, 16);
		add(patientAgelb);
		
		JLabel patientCitylb = new JLabel("City");
		patientCitylb.setBounds(211, 382, 38, 16);
		add(patientCitylb);
		
		JLabel patientAddresslb = new JLabel("Address");
		patientAddresslb.setBounds(211, 291, 61, 16);
		add(patientAddresslb);
		
		JButton patientUpdatebtn = new JButton("Update");
		patientUpdatebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		patientUpdatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(PatientViewPanel,"Please select a row to update");
					return;
					
				} else {
					
					//System.out.println(selectedRowindex);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
					//System.out.println(selectedEmpdetails);
					
					int column = 0;
					int row = table.getSelectedRow();
					String patientIDvalue = table.getModel().getValueAt(row, column).toString();
					String patientNamevalue= table.getModel().getValueAt(row, 1).toString();
					String patientAgevalue= table.getModel().getValueAt(row, 2).toString();
					String patientSexvalue= table.getModel().getValueAt(row, 3).toString();
					String patientCityvalue= table.getModel().getValueAt(row, 4).toString();
					String patientAddressvalue= table.getModel().getValueAt(row, 5).toString();
					String patientZipcodevalue=table.getModel().getValueAt(row, 6).toString();
					int patientID=Integer.parseInt(patientIDvalue);
					int patientAge=Integer.parseInt(patientAgevalue);
					int patientZipcodeInt=Integer.parseInt(patientZipcodevalue);
					
				House ch = new House();
				Person cp = new Person(ch);
				Patient currentPatient = new Patient(cp,ch);
				currentPatient.setPatientId(patientID);
				currentPatient.setName(patientNamevalue);
				currentPatient.setAge(patientAge);
				currentPatient.setSex(patientSexvalue);
				
				currentPatient.setPatientCity(patientCityvalue);
				currentPatient.setPatientAddress(patientAddressvalue);
				currentPatient.setZipcode(patientZipcodeInt);
				//System.out.println(row);
				
				
		    String	pID=patientIdTxt.getText().trim();
			String	pName=patientNameTxt.getText().trim();
			String	pAge=patientAgeTxt.getText().trim();
			String  pSex=patientSexTxt.getText().trim();
			String	pCity=patientCityTxt.getText().trim();
			String	pAdd=patientAddressTxt.getText().trim();
			String pZipcd=patientZipTxt.getText().trim();
			int ppID=Integer.parseInt(pID);
			int ppAge=Integer.parseInt(pAge);
			int pZipcdInt=Integer.parseInt(pZipcd);
			
			
			House nh= new House();
			Person np= new Person(nh);
			Patient newPatient= new Patient(np,nh);	
			newPatient.setPatientId(ppID);
			newPatient.setName(pName);
			newPatient.setAge(ppAge);
			newPatient.setSex(pSex);
			newPatient.setPatientCity(pCity);
			newPatient.setPatientAddress(pAdd);
			newPatient.setZipcode(pZipcdInt);
			
			patientHistory.modifyPatients(currentPatient, newPatient,row);
			
			populatePatientDetails();
			
			//patientHistory.printPatientlist();
			
				}
				
				
			}
			
		});
		patientUpdatebtn.setBounds(167, 224, 117, 29);
		add(patientUpdatebtn);
		
		
		
		
		
		populatePatientDetails();
		
	

	}
	
	public void populatePatientDetails() {
		
	
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] column = new Object[7]; // just now added
		column[0]="PatientId";
		column[1]="Name";
		column[2]="Age";
		column[3]="Sex";
		column[4]="City";
		column[5]="Address";
		column[6]="Zipcode";
		
		//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};//just commented.
		//Object[] row= new Object[0];
		//model.addColumn(column);
		
		
		for (Patient p: patientHistory.getHistory()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[7];
			row[0] = p.getPatientId();
			row[1]= p.getName();
			row[2]=p.getAge();
			row[3]=p.getSex();
			row[4]=p.getPatientCity();
			row[5]=p.getPatientAddress();
			row[6]=p.getZipcode();
		
			model.addRow(row);
		}
	}
}
