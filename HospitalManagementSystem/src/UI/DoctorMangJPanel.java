package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Model.Community;
import Model.Doctor;
import Model.DoctorDirectory;
import Model.Hospital;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorMangJPanel extends JPanel {
	private JTable table;
	private JPanel DoctorMangJPanel;
	private JTextField docIDTxt;
	private JTextField docNameTxt;
	private JTextField docSpecTxt;
	private JTextField docHospIDTxt;
	private JTextField docHospNMTxt;
	DoctorDirectory doctorDirectory;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public DoctorMangJPanel(DoctorDirectory doctorDirectory) {
		
		this.doctorDirectory=doctorDirectory;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel docviewlb = new JLabel("View Doctor Details");
		docviewlb.setBounds(153, 33, 130, 16);
		add(docviewlb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 63, 417, 155);
		add(scrollPane);
		
		docIDTxt = new JTextField();
		docIDTxt.setBounds(166, 283, 130, 26);
		add(docIDTxt);
		docIDTxt.setColumns(10);
		
		docNameTxt = new JTextField();
		docNameTxt.setBounds(166, 334, 130, 26);
		add(docNameTxt);
		docNameTxt.setColumns(10);
		
		docSpecTxt = new JTextField();
		docSpecTxt.setBounds(166, 383, 130, 26);
		add(docSpecTxt);
		docSpecTxt.setColumns(10);
		
		docHospIDTxt = new JTextField();
		docHospIDTxt.setBounds(166, 431, 130, 26);
		add(docHospIDTxt);
		docHospIDTxt.setColumns(10);
		
		docHospNMTxt = new JTextField();
		docHospNMTxt.setBounds(166, 479, 130, 26);
		add(docHospNMTxt);
		docHospNMTxt.setColumns(10);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton docViewbtn = new JButton("View");
		docViewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex=table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(DoctorMangJPanel,"Please select a row to view");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedEmpdetails);
				
				int column = 0;
				int row = table.getSelectedRow();
				String docIdvalue = table.getModel().getValueAt(row, column).toString();
				String docName= table.getModel().getValueAt(row, 1).toString();
				String docSpec= table.getModel().getValueAt(row, 2).toString();
				String docHospID= table.getModel().getValueAt(row, 3).toString();
				String docHospNm= table.getModel().getValueAt(row, 4).toString();
		
				
				docIDTxt.setText(docIdvalue);
				docNameTxt.setText(docName);
				docSpecTxt.setText(docSpec);
				docHospIDTxt.setText(docHospID);
				docHospNMTxt.setText(docHospNm);
		
				
			}
		});
		docViewbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		docViewbtn.setBounds(37, 230, 117, 29);
		add(docViewbtn);
		
		JButton docUpdatebtn = new JButton("Update");
		docUpdatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(DoctorMangJPanel,"Please select a row to update");
					return;
					
				} else {
					
					//System.out.println(selectedRowindex);
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
					//System.out.println(selectedEmpdetails);
					
					int column = 0;
					int row = table.getSelectedRow();
					
					
					String docIdvalue = table.getModel().getValueAt(row, column).toString();
					String docName= table.getModel().getValueAt(row, 1).toString();
					String docSpec= table.getModel().getValueAt(row, 2).toString();
					String docHospID= table.getModel().getValueAt(row, 3).toString();
					String docHospNm= table.getModel().getValueAt(row, 4).toString();
				
					int docID=Integer.parseInt(docIdvalue);
					int docHospIDvalue=Integer.parseInt(docHospID);
					Community com=new Community();
					Hospital hosp=new Hospital(com);
				//Community currentCommunity = new Community();
					Doctor docCurrent= new Doctor(com,hosp);
				
				docCurrent.setDoctorID(docID);
				docCurrent.setDoctorName(docName);
				docCurrent.setDoctorSpecialization(docSpec);
				docCurrent.setHopsitalName(docHospNm);
				docCurrent.setHospitalId(docHospIDvalue);
			
				docIDTxt.setText(docIdvalue);
				docNameTxt.setText(docName);
				docSpecTxt.setText(docSpec);
				docHospIDTxt.setText(docHospID);
				docHospNMTxt.setText(docHospNm);
				
		    String	dID=docIDTxt.getText().trim();
			String	dNm=docNameTxt.getText().trim();
			String	dS=docSpecTxt.getText().trim();
			String	dhID=docHospIDTxt.getText().trim();
			String	dHNm=docHospNMTxt.getText().trim();
			
			int docIDvalue=Integer.parseInt(dID);
			int docHospIDval=Integer.parseInt(dhID);
			
			/*Community com1=new Community();
			Hospital hosp1=new Hospital(com1);*/
		//Community currentCommunity = new Community();
			Doctor docNew= new Doctor(com,hosp);
			
			//Community newCommunity= new Community();	
			docNew.setDoctorID(docIDvalue);
			docNew.setDoctorName(dNm);
			docNew.setDoctorSpecialization(dS);
			docNew.setHopsitalName(dHNm);
			docNew.setHospitalId(docHospIDval);
		
			
			//communityList.modifyCommunity(currentCommunity, newCommunity,row);
			doctorDirectory.modifyDoctor(docCurrent, docNew, row);
			
			populateDoctorDetails();
			
			docIDTxt.setText(" ");
			docNameTxt.setText(" ");
			docSpecTxt.setText(" ");
			docHospIDTxt.setText(" ");
			docHospNMTxt.setText(" ");
			
			
				}
		
				
				
			}
		});
		docUpdatebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		docUpdatebtn.setBounds(166, 230, 117, 29);
		add(docUpdatebtn);
		
		JButton deleteDocbtn = new JButton("Delete");
		deleteDocbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(DoctorMangJPanel,"Please select a row to delete");
					return;
					
				}
				
				
				int column = 0;
				int row = table.getSelectedRow();
				//String communityId = table.getModel().getValueAt(row, column).toString();
			
				
				
				//int commID=Integer.parseInt(communityId);
				
				//Patient patient = new Patient();
				
			
				//int pos =communityList.getPosition(commID);
				//System.out.println(pos);
				doctorDirectory.deleteDoctor(row);
				
				JOptionPane.showMessageDialog(DoctorMangJPanel,"Doctor details deleted");
				populateDoctorDetails();
				
				
				
			}
		});
		deleteDocbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		deleteDocbtn.setBounds(309, 230, 117, 29);
		add(deleteDocbtn);
		
		
		
		model= new DefaultTableModel();
		Object[] column= {"DoctorID","DoctorName","Speciality","Hospital ID","Hospital Name"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JLabel docIDlb = new JLabel("Doctor ID");
		docIDlb.setBounds(80, 288, 61, 16);
		add(docIDlb);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor Name");
		lblNewLabel_1.setBounds(69, 339, 95, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Specialist");
		lblNewLabel_2.setBounds(93, 388, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hospital ID");
		lblNewLabel_3.setBounds(88, 436, 76, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hospital Name");
		lblNewLabel_4.setBounds(59, 484, 95, 16);
		add(lblNewLabel_4);
		
		populateDoctorDetails();

	}
public void populateDoctorDetails() {
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] column = new Object[5]; // just now added
		column[0]="DoctorID";
		column[1]="DoctorName";
		column[2]="Speciality";
		column[3]="Hospital ID";
		column[4]="Hospital Name";
		
		//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};//just commented.
		//Object[] row= new Object[0];
		//model.addColumn(column);
		
		
		for (Doctor doc: doctorDirectory.getDoctor()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[5];
			row[0]=doc.getDoctorID();
			row[1] =doc.getDoctorName();
			row[2]= doc.getDoctorSpecialization();
			row[3]=doc.getHospitalId();
			row[4]=doc.getHospital();
			
		
			model.addRow(row);
		}
	}
}
