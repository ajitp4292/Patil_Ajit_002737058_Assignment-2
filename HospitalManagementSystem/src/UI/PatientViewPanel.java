package UI;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Patient;
import Model.PatientHistory;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class PatientViewPanel extends JPanel {
	private JTable table;
private JPanel PatientViewPanel;
	PatientHistory patientHistory;
	Patient p ;
	DefaultTableModel model;
	private JTextField patientIdTxt;
	private JTextField patientNameTxt;
	private JTextField patientAgeTxt;
	private JTextField patientCityTxt;
	private JTextField patientAddressTxt;
	/**
	 * Create the panel.
	 */
	public PatientViewPanel(PatientHistory patientHistory , Patient p) {
		this.patientHistory=patientHistory;
		//p.getAge();
		//System.out.println(p.getAge());
		/*Patient p = new Patient();
		System.out.println(p.getName());*/
		//System.out.println(p.size());
		
		model= new DefaultTableModel();
		Object[] column= {"PatientId","Name","Age","City","Address"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		setLayout(null);
		
		JLabel patientViewlb = new JLabel("View Patient Details");
		patientViewlb.setBounds(185, 29, 173, 43);
		add(patientViewlb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 93, 469, 205);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JButton patientDeletebtn = new JButton("Delete");
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
		patientDeletebtn.setBounds(389, 320, 117, 29);
		add(patientDeletebtn);
		
		JButton patientViewbtn = new JButton("View");
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
				String patientCityvalue= table.getModel().getValueAt(row, 3).toString();
				String patientAddressvalue= table.getModel().getValueAt(row, 4).toString();
				//System.out.println(PatientIDvalue);
				
				patientIdTxt.setText(patientIDvalue);
				patientNameTxt.setText(patientNamevalue);
				patientAgeTxt.setText(patientAgevalue);
				patientCityTxt.setText(patientCityvalue);
				patientAddressTxt.setText(patientAddressvalue);
				
			}
		});
		patientViewbtn.setBounds(48, 320, 117, 29);
		add(patientViewbtn);
		
		patientIdTxt = new JTextField();
		patientIdTxt.setBounds(89, 377, 130, 26);
		add(patientIdTxt);
		patientIdTxt.setColumns(10);
		
		patientNameTxt = new JTextField();
		patientNameTxt.setBounds(89, 415, 130, 26);
		add(patientNameTxt);
		patientNameTxt.setColumns(10);
		
		patientAgeTxt = new JTextField();
		patientAgeTxt.setBounds(89, 453, 130, 26);
		add(patientAgeTxt);
		patientAgeTxt.setColumns(10);
		
		patientCityTxt = new JTextField();
		patientCityTxt.setBounds(89, 491, 130, 26);
		add(patientCityTxt);
		patientCityTxt.setColumns(10);
		
		patientAddressTxt = new JTextField();
		patientAddressTxt.setBounds(89, 531, 130, 26);
		add(patientAddressTxt);
		patientAddressTxt.setColumns(10);
		
		JLabel patientIDlb = new JLabel("PatientId");
		patientIDlb.setBounds(16, 382, 61, 16);
		add(patientIDlb);
		
		JLabel patientNamelb = new JLabel("Name");
		patientNamelb.setBounds(26, 420, 45, 16);
		add(patientNamelb);
		
		JLabel patientAgelb = new JLabel("Age");
		patientAgelb.setBounds(38, 458, 29, 16);
		add(patientAgelb);
		
		JLabel patientCitylb = new JLabel("City");
		patientCitylb.setBounds(33, 496, 38, 16);
		add(patientCitylb);
		
		JLabel patientAddresslb = new JLabel("Address");
		patientAddresslb.setBounds(16, 536, 61, 16);
		add(patientAddresslb);
		
		JButton patientUpdatebtn = new JButton("Update");
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
					String patientCityvalue= table.getModel().getValueAt(row, 3).toString();
					String patientAddressvalue= table.getModel().getValueAt(row, 4).toString();
					int patientID=Integer.parseInt(patientIDvalue);
					int patientAge=Integer.parseInt(patientAgevalue);
				Patient currentPatient = new Patient();
				currentPatient.setPatientId(patientID);
				currentPatient.setAge(patientAge);
				currentPatient.setName(patientNamevalue);
				currentPatient.setPatientCity(patientCityvalue);
				currentPatient.setPatientAddress(patientAddressvalue);
				System.out.println(row);
				
				
		    String	pID=patientIdTxt.getText().trim();
			String	pName=patientNameTxt.getText().trim();
			String	pAge=patientAgeTxt.getText().trim();
			String	pCity=patientCityTxt.getText().trim();
			String	pAdd=patientAddressTxt.getText().trim();
			int ppID=Integer.parseInt(pID);
			int ppAge=Integer.parseInt(pAge);
			
			System.out.println(ppID);
			System.out.println(pName);
			System.out.println(ppAge);
			System.out.println(pCity);
			System.out.println(pAdd);
			Patient newPatient= new Patient();	
			newPatient.setPatientId(ppID);
			newPatient.setName(pName);
			newPatient.setAge(ppAge);
			newPatient.setPatientCity(pCity);
			newPatient.setPatientAddress(pAdd);
			
			patientHistory.modifyPatients(currentPatient, newPatient,row);
			
			populatePatientDetails();
			
			patientHistory.printPatientlist();
			
				}
				
				
			}
			
		});
		patientUpdatebtn.setBounds(218, 320, 117, 29);
		add(patientUpdatebtn);
		
		populatePatientDetails();
		
	

	}
	
	public void populatePatientDetails() {
		
	
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] column = new Object[5]; // just now added
		column[0]="PatientId";
		column[1]="Name";
		column[2]="Age";
		column[3]="City";
		column[4]="Address";
		
		
		//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};//just commented.
		//Object[] row= new Object[0];
		//model.addColumn(column);
		
		
		for (Patient p: patientHistory.getHistory()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[5];
			row[0] = p.getPatientId();
			row[1]= p.getName();
			row[2]=p.getAge();
			row[3]=p.getPatientCity();
			row[4]=p.getPatientAddress();
		
			model.addRow(row);
		}
	}
}
