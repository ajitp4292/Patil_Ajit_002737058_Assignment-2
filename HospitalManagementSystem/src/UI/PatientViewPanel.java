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

public class PatientViewPanel extends JPanel {
	private JTable table;
private JPanel PatientViewPanel;
	PatientHistory patientHistory;
	ArrayList<Patient> p;
	DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public PatientViewPanel(PatientHistory patientHistory) {
		this.patientHistory=patientHistory;
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
				Vector selectedPatientDetails=model.getDataVector().elementAt(table.convertRowIndexToModel(table.getSelectedRow()));
				int column = 0;
				int row = table.getSelectedRow();
				String PatientIDvalue = table.getModel().getValueAt(row, column).toString();
				String PatientNamevalue= table.getModel().getValueAt(row, 1).toString();
				String PatientAgevalue= table.getModel().getValueAt(row, 2).toString();
				String PatientCityvalue= table.getModel().getValueAt(row, 3).toString();
				String PatientAddressvalue= table.getModel().getValueAt(row, 4).toString();
				System.out.println(PatientIDvalue);
				System.out.println(PatientNamevalue);
				System.out.println(PatientAgevalue);
				System.out.println(PatientCityvalue);
				System.out.println(PatientAddressvalue);
				//System.out.println(selectedPatientDetails);
				//patientHistory.deletePatients(selectedPatientDetails);
				//JOptionPane.showMessageDialog(PatientViewPanel,"Patient details deleted");
				//populatePatientDetails();	
					
				
				
			}
		});
		patientDeletebtn.setBounds(389, 320, 117, 29);
		add(patientDeletebtn);
		
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
