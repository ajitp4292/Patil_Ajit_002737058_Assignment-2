package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Model.Encounter;
import Model.EncounterHistory;
import Model.House;
import Model.Patient;
import Model.Person;
import Model.VitalSigns;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class EncounterViewJPanel extends JPanel {
	private JTable table;
	private JPanel EncounterViewJPanel;
	EncounterHistory encounterHistory;
	private JTextField EcounterIdTxt;
	private JTextField patientIdTxt;
	private JTextField doctorIdTxt;
	private JTextField tempTxt;
	private JTextField bpTxt;
	private JTextField pulseTxt;
	private JTextField DateTxt;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public EncounterViewJPanel(EncounterHistory encounterHistory) {
		this.encounterHistory=encounterHistory;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel encounterViewlb = new JLabel("View Encounter Details");
		encounterViewlb.setBounds(121, 17, 144, 16);
		add(encounterViewlb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 42, 387, 139);
		add(scrollPane);
		EcounterIdTxt = new JTextField();
		EcounterIdTxt.setBounds(96, 248, 75, 26);
		add(EcounterIdTxt);
		EcounterIdTxt.setColumns(10);
		
		patientIdTxt = new JTextField();
		patientIdTxt.setBounds(96, 286, 75, 26);
		add(patientIdTxt);
		patientIdTxt.setColumns(10);
		
		doctorIdTxt = new JTextField();
		doctorIdTxt.setBounds(96, 324, 72, 26);
		add(doctorIdTxt);
		doctorIdTxt.setColumns(10);
		
		JLabel encounterlb = new JLabel("Encounter Id");
		encounterlb.setBounds(13, 253, 82, 16);
		add(encounterlb);
		
		JLabel patientIdlb = new JLabel("Patient Id");
		patientIdlb.setBounds(13, 291, 61, 16);
		add(patientIdlb);
		
		JLabel doctorIdlb = new JLabel("Doctor Id");
		doctorIdlb.setBounds(23, 329, 61, 16);
		add(doctorIdlb);
		
		JLabel templb = new JLabel("Temperature");
		templb.setBounds(13, 377, 82, 16);
		add(templb);
		
		tempTxt = new JTextField();
		tempTxt.setBounds(96, 372, 75, 26);
		add(tempTxt);
		tempTxt.setColumns(10);
		
		bpTxt = new JTextField();
		bpTxt.setBounds(318, 248, 75, 26);
		add(bpTxt);
		bpTxt.setColumns(10);
		
		pulseTxt = new JTextField();
		pulseTxt.setBounds(318, 286, 71, 26);
		add(pulseTxt);
		pulseTxt.setColumns(10);
		
		JLabel bloodPressurelb = new JLabel("BloodPressure");
		bloodPressurelb.setBounds(214, 253, 92, 16);
		add(bloodPressurelb);
		
		JLabel pulselb = new JLabel("Pulse");
		pulselb.setBounds(265, 291, 41, 16);
		add(pulselb);
		
		DateTxt = new JTextField();
		DateTxt.setBounds(318, 324, 75, 26);
		add(DateTxt);
		DateTxt.setColumns(10);
		
		JLabel Datelb = new JLabel("Date");
		Datelb.setBounds(265, 329, 41, 16);
		add(Datelb);
		
		
		
		model= new DefaultTableModel();
		Object[] column= {"EncounterId","PatientId","DoctorId","Temperature","BloodPressure","Pulse","EncounterDate"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JButton viewbtn = new JButton("View");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(EncounterViewJPanel,"Please select a row to view Encounter");
					return;
					
				}
				
				else {
					
					
					
			
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedEmpdetails);
				
				int column = 0;
				int row = table.getSelectedRow();
				String encounterIdvalue = table.getModel().getValueAt(row, column).toString();
				String patientIdvalue= table.getModel().getValueAt(row, 1).toString();
				String doctorIdvalue= table.getModel().getValueAt(row, 2).toString();
				String patienttemp= table.getModel().getValueAt(row, 3).toString();
				String patientBp= table.getModel().getValueAt(row, 4).toString();
				String patientpulse= table.getModel().getValueAt(row, 5).toString();
				String patientvisitdate=table.getModel().getValueAt(row, 6).toString();
				//System.out.println(PatientIDvalue);
				//int patientZipCode=Integer.parseInt(patientZipvalue);
				
				//patientIdTxt.setText(encounterIdvalue);
				//Date date = new Date();
				

				EcounterIdTxt.setText(encounterIdvalue);
				patientIdTxt.setText(patientIdvalue);
				doctorIdTxt.setText(doctorIdvalue);
				tempTxt.setText(patienttemp);
				bpTxt.setText(patientBp);
				pulseTxt.setText(patientpulse);
				DateTxt.setText(patientvisitdate);
				//dateTxt.setText(date.toString());
				
				}

				
				
			}
			
		});
		viewbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		viewbtn.setBounds(33, 193, 117, 29);
		add(viewbtn);
		
		JButton Updatebtn = new JButton("Update");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(EncounterViewJPanel,"Please select a row to view and update");
					return;
					
				} else {
					
					//System.out.println(selectedRowindex);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
					//System.out.println(selectedEmpdetails);
					
					int column = 0;
					int row = table.getSelectedRow();
					String encounterIdvalue = table.getModel().getValueAt(row, column).toString();
					String patientIdvalue= table.getModel().getValueAt(row, 1).toString();
					String doctorIdvalue= table.getModel().getValueAt(row, 2).toString();
					String patienttemp= table.getModel().getValueAt(row, 3).toString();
					String patientBp= table.getModel().getValueAt(row, 4).toString();
					String patientpulse= table.getModel().getValueAt(row, 5).toString();
					String patientvisitdate=table.getModel().getValueAt(row, 6).toString();
					int encounterIDInt=Integer.parseInt(encounterIdvalue);
					int patientIdInt=Integer.parseInt(patientIdvalue);
					int doctorIdInt=Integer.parseInt(doctorIdvalue);
					double patienttempDouble=Double.parseDouble(patienttemp);
					double patientBPDouble=Double.parseDouble(patientBp);
					int patientpulseInt=Integer.parseInt(patientpulse);
					
				//House ch = new House();
				//Person cp = new Person(ch);
				//Patient currentPatient = new Patient(cp,ch);
					VitalSigns vitalsigns= new VitalSigns();
					
					Encounter currentEncounter=new Encounter(vitalsigns);
					currentEncounter.setEncounterId(encounterIDInt);
					currentEncounter.setPatientID(patientIdInt);
					currentEncounter.setDoctorID(doctorIdInt);
					currentEncounter.setTemeprature(patienttempDouble);
					currentEncounter.setBloodPressure(patientBPDouble);
					currentEncounter.setPulse(patientpulseInt);
					currentEncounter.setDate(patientvisitdate);
			
				//System.out.println(row);
					
					/*EcounterIdTxt.setText(encounterIdvalue);
					patientIdTxt.setText(patientIdvalue);
					doctorIdTxt.setText(doctorIdvalue);
					tempTxt.setText(patienttemp);
					bpTxt.setText(patientBp);
					pulseTxt.setText(patientpulse);
					DateTxt.setText(patientvisitdate);*/
					
				
				
		    String	eID=EcounterIdTxt.getText().trim();
			String	epId=patientIdTxt.getText().trim();
			String	eDocID=doctorIdTxt.getText().trim();
			String  epTemp=tempTxt.getText().trim();
			String	ebp=bpTxt.getText().trim();
			String	ep=pulseTxt.getText().trim();
			String eDt=DateTxt.getText().trim();
			int encounterIDIntNew=Integer.parseInt(eID);
			int patientIdIntNew=Integer.parseInt(epId);
			int doctorIdIntNew=Integer.parseInt(eDocID);
			double patienttempDoubleNew=Double.parseDouble(epTemp);
			double patientBPDoubleNew=Double.parseDouble(ebp);
			int patientpulseIntNew=Integer.parseInt(ep);
			
			
			//House nh= new House();
			//Person np= new Person(nh);
			//Patient newPatient= new Patient(np,nh);	
			VitalSigns vitals= new VitalSigns();
			Encounter newEncounter= new Encounter(vitals);
			Date date = new Date();

		     
			String updatedDate=date.toString();
		
			newEncounter.setEncounterId(encounterIDIntNew);
			newEncounter.setPatientID(patientIdIntNew);
			newEncounter.setDoctorID(doctorIdIntNew);
			newEncounter.setTemeprature(patienttempDoubleNew);
			newEncounter.setBloodPressure(patientBPDoubleNew);
			newEncounter.setPulse(patientpulseIntNew);
			newEncounter.setDate(updatedDate);
			
			//patientHistory.modifyPatients(currentPatient, newPatient,row);
			encounterHistory.modifyEncounter(currentEncounter, newEncounter, row);
			
			populateEncounterDetails();
			
			//patientHistory.printPatientlist();
			
				}
				
			}
		});
		Updatebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		Updatebtn.setBounds(162, 193, 117, 29);
		add(Updatebtn);
		
		JButton deletebtn = new JButton("Delete");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(EncounterViewJPanel,"Please select a row to delete");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//Patient selectedPatientDetails=(Patient)model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedPatientDetails);
				/*Vector selectedPatientDetails=model.getDataVector().elementAt(table.convertRowIndexToModel(table.getSelectedRow()));*/
				int column = 0;
				int row = table.getSelectedRow();
				
				encounterHistory.deleteEncounter(row);
				//patient.getPatientId();
				//patientHistory.deletePatients(patientID);
				
				JOptionPane.showMessageDialog(EncounterViewJPanel,"Encounter details deleted");
				populateEncounterDetails();	
					
				
				
			}
		});
		deletebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		deletebtn.setBounds(291, 193, 117, 29);
		add(deletebtn);
		
		populateEncounterDetails();
		

	}
	public void populateEncounterDetails() {
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] column = new Object[7]; // just now added
		column[0]="EncounterID";
		column[1]="PatientID";
		column[2]="DoctorId";
		column[3]="Temperature";
		column[4]="BloodPressure";
		column[5]="Pulse";
		column[6]="EncounterDate";
		
		//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};//just commented.
		//Object[] row= new Object[0];
		//model.addColumn(column);
		
		
		for (Encounter e: encounterHistory.getEncounter()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[7];
			row[0] = e.getEncounterId();
			row[1]= e.getpatientId();
			row[2]=e.getDoctorID();
			row[3]=e.getTemperature();
			row[4]=e.getbloodPressure();
			row[5]=e.getPulse();
			row[6]=e.getDate();
		
			model.addRow(row);
		}
	}

}
