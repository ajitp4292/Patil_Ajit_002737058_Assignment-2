package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Model.Community;
import Model.Doctor;
import Model.DoctorDirectory;

public class DoctorMangJPanel extends JPanel {
	private JTable table;
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
		scrollPane.setBounds(27, 63, 417, 192);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton docViewbtn = new JButton("View");
		docViewbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		docViewbtn.setBounds(36, 266, 117, 29);
		add(docViewbtn);
		
		JButton docUpdatebtn = new JButton("Update");
		docUpdatebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		docUpdatebtn.setBounds(178, 266, 117, 29);
		add(docUpdatebtn);
		
		JButton deleteDocbtn = new JButton("Delete");
		deleteDocbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		deleteDocbtn.setBounds(313, 266, 117, 29);
		add(deleteDocbtn);
		
		docIDTxt = new JTextField();
		docIDTxt.setBounds(166, 319, 130, 26);
		add(docIDTxt);
		docIDTxt.setColumns(10);
		
		docNameTxt = new JTextField();
		docNameTxt.setBounds(166, 365, 130, 26);
		add(docNameTxt);
		docNameTxt.setColumns(10);
		
		docSpecTxt = new JTextField();
		docSpecTxt.setBounds(166, 417, 130, 26);
		add(docSpecTxt);
		docSpecTxt.setColumns(10);
		
		docHospIDTxt = new JTextField();
		docHospIDTxt.setBounds(166, 466, 130, 26);
		add(docHospIDTxt);
		docHospIDTxt.setColumns(10);
		
		docHospNMTxt = new JTextField();
		docHospNMTxt.setBounds(166, 520, 130, 26);
		add(docHospNMTxt);
		docHospNMTxt.setColumns(10);
		
		model= new DefaultTableModel();
		Object[] column= {"DoctorID","DoctorName","Speciality","Hospital ID","Hospital Name"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JLabel docIDlb = new JLabel("Doctor ID");
		docIDlb.setBounds(80, 324, 61, 16);
		add(docIDlb);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor Name");
		lblNewLabel_1.setBounds(58, 370, 95, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Specialist");
		lblNewLabel_2.setBounds(80, 422, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hospital ID");
		lblNewLabel_3.setBounds(80, 471, 76, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hospital Name");
		lblNewLabel_4.setBounds(58, 525, 95, 16);
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
