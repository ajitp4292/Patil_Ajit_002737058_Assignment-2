package UI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Model.Encounter;
import Model.EncounterHistory;
import Model.House;
import Model.Patient;
import Model.PatientHistory;
import Model.Person;
import Model.VitalSigns;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class EncounterJPanel extends JPanel {
	private JTable table;
	private JPanel EncounterJPanel;
	PatientHistory patientHistory;
	EncounterHistory encounterHistory;
	private JTextField patientIDTxt;
	private JTextField doctorIDTxt;
	private JTextField tempTxt;
	private JTextField bpTxt;
	private JTextField pulseTxt;
	private JTextField dateTxt;
	DefaultTableModel model;
	private JTextField encounterIDTxt;

	/**
	 * Create the panel.
	 */
	public EncounterJPanel(PatientHistory patientHistory,EncounterHistory encounterHistory) {
		this.patientHistory=patientHistory;
		this.encounterHistory=encounterHistory;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel encounterDtbtn = new JLabel("Record Encounter Details for Patients");
		encounterDtbtn.setBounds(81, 20, 241, 16);
		add(encounterDtbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 55, 415, 135);
		add(scrollPane);
		JLabel patientIdlb = new JLabel("Patient ID");
		patientIdlb.setBounds(32, 254, 61, 16);
		add(patientIdlb);
		
		patientIDTxt = new JTextField();
		patientIDTxt.setBounds(105, 249, 93, 26);
		add(patientIDTxt);
		patientIDTxt.setColumns(10);
		
		doctorIDTxt = new JTextField();
		doctorIDTxt.setBounds(105, 287, 93, 26);
		add(doctorIDTxt);
		doctorIDTxt.setColumns(10);
		
		tempTxt = new JTextField();
		tempTxt.setBounds(105, 325, 93, 26);
		add(tempTxt);
		tempTxt.setColumns(10);
		
		bpTxt = new JTextField();
		bpTxt.setBounds(315, 249, 98, 26);
		add(bpTxt);
		bpTxt.setColumns(10);
		
		pulseTxt = new JTextField();
		pulseTxt.setBounds(315, 287, 98, 26);
		add(pulseTxt);
		pulseTxt.setColumns(10);
		
		dateTxt = new JTextField();
		dateTxt.setBounds(315, 325, 98, 26);
		add(dateTxt);
		dateTxt.setColumns(10);
		
		encounterIDTxt = new JTextField();
		encounterIDTxt.setBounds(105, 371, 93, 26);
		add(encounterIDTxt);
		encounterIDTxt.setColumns(10);
		
		JLabel encounterlb = new JLabel("Encounter Id");
		encounterlb.setBounds(17, 376, 84, 16);
		add(encounterlb);
		
		
		JLabel doctorIDlb = new JLabel("Doctor ID");
		doctorIDlb.setBounds(32, 292, 61, 16);
		add(doctorIDlb);
		
		JLabel templb = new JLabel("Temperature");
		templb.setBounds(17, 330, 84, 16);
		add(templb);
		
		JLabel bplb = new JLabel("BloodPressure");
		bplb.setBounds(210, 254, 93, 16);
		add(bplb);
		
		JLabel pulselb = new JLabel("Pulse");
		pulselb.setBounds(266, 292, 37, 16);
		add(pulselb);
		
		JLabel datelb = new JLabel("Date");
		datelb.setBounds(266, 330, 37, 16);
		add(datelb);

		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model= new DefaultTableModel();
		Object[] column= {"PatientId","Name","Age","Sex","City","Address","Zipcode"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JButton selectBtn = new JButton("Select Patient to record Vital Signs");
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(EncounterJPanel,"Please select a row to record Vital Signs");
					return;
					
				}
				
				else {
					int size=encounterHistory.getSize();
					int id = (size+1);
					String pid=String.valueOf(id);
					
					if (size==0) {
						encounterIDTxt.setText("1");
					}
					else {
						encounterIDTxt.setText(pid);
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
				//int patientZipCode=Integer.parseInt(patientZipvalue);
				patientIDTxt.setText(patientIDvalue);
				Date date = new Date();

			     
				dateTxt.setText(date.toString());
				
				}

			}
		});
		selectBtn.setBackground(UIManager.getColor("Button.darkShadow"));
		selectBtn.setBounds(124, 202, 241, 29);
		add(selectBtn);
		
				
		JButton saveVsbtn = new JButton("Save VitalSigns");
		saveVsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String patientId=patientIDTxt.getText().trim();
				
				
				String docIdString= doctorIDTxt.getText().trim();
				String patientTemp=tempTxt.getText().trim();
			
				String patientBP=bpTxt.getText().trim();
		String patientPulse=pulseTxt.getText().trim();
		String patientDateString=dateTxt.getText().trim();
		String encounterIdString=encounterIDTxt.getText().trim();
	
		int patientID=Integer.parseInt(patientId);
		int docID=Integer.parseInt(docIdString);
		int encounterIDInt=Integer.parseInt(encounterIdString);
		double patienttempDouble=Double.parseDouble(patientTemp);
		double patientBPDouble=Double.parseDouble(patientBP);
		int patientpulseInt=Integer.parseInt(patientPulse);
		
		VitalSigns vs= new VitalSigns();
		Encounter encounter=encounterHistory.addNewEncounter(vs);
		
		encounter.setPatientID(patientID);
		encounter.setDoctorID(docID);
		encounter.setTemeprature(patienttempDouble);
		encounter.setBloodPressure(patientBPDouble);
		encounter.setPulse(patientpulseInt);
		encounter.setDate(patientDateString);
		encounter.setEncounterId(encounterIDInt);
		
		//p.hashCode();
		
		JOptionPane.showMessageDialog(EncounterJPanel, "Vital Signs Added for Patient successfully.");
		//System.out.println(p.hashCode());
		//p.getName();		
		//System.out.println(p.getName());
		//int p1 = p.hashCode();
		patientIDTxt.setText(" ");
		doctorIDTxt.setText(" ");
		tempTxt.setText(" ");
		bpTxt.setText(" ");
		pulseTxt.setText(" ");
		dateTxt.setText(" ");
		encounterIDTxt.setText(" ");
		//System.out.println(patientHistory.getSize());
	
		
	
		
		
		
				
			}
			
		});
		saveVsbtn.setBounds(177, 420, 138, 29);
		add(saveVsbtn);
		
		
		
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
