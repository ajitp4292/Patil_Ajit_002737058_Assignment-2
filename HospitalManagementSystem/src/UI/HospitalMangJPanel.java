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
import Model.Hospital;
import Model.HospitalDirectory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class HospitalMangJPanel extends JPanel {
	private JTable table;
	private JTextField hospitalIDTxt;
	private JTextField hospitalNamTxt;
	private JTextField hospCommIDTxt;
	private JTextField hospCommNamTxt;
	private JPanel HospitalMangJPanel;
	HospitalDirectory hospitalDirectory;
	Hospital hosp;
	DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public HospitalMangJPanel(HospitalDirectory hospitalDirectory) {
		this.hospitalDirectory=hospitalDirectory;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel hopsitalDTlb = new JLabel("View Hospital Details");
		hopsitalDTlb.setBounds(148, 30, 141, 27);
		add(hopsitalDTlb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 75, 387, 194);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton viewHospbtn = new JButton("View");
		viewHospbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(hospitalDirectory);
				 hospitalDirectory.showHopsitalList();
				
		           
			}
		});
		viewHospbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		viewHospbtn.setBounds(32, 281, 117, 29);
		add(viewHospbtn);
		
		JButton updateHosplb = new JButton("Update");
		updateHosplb.setBackground(UIManager.getColor("Button.darkShadow"));
		updateHosplb.setBounds(161, 281, 117, 29);
		add(updateHosplb);
		
		JButton deleteHosplb = new JButton("Delete");
		deleteHosplb.setBackground(UIManager.getColor("Button.darkShadow"));
		deleteHosplb.setBounds(290, 281, 117, 29);
		add(deleteHosplb);
		
		hospitalIDTxt = new JTextField();
		hospitalIDTxt.setBounds(182, 329, 130, 26);
		add(hospitalIDTxt);
		hospitalIDTxt.setColumns(10);
		
		hospitalNamTxt = new JTextField();
		hospitalNamTxt.setBounds(182, 386, 130, 26);
		add(hospitalNamTxt);
		hospitalNamTxt.setColumns(10);
		
		hospCommIDTxt = new JTextField();
		hospCommIDTxt.setBounds(182, 441, 130, 26);
		add(hospCommIDTxt);
		hospCommIDTxt.setColumns(10);
		
		hospCommNamTxt = new JTextField();
		hospCommNamTxt.setBounds(182, 492, 130, 26);
		add(hospCommNamTxt);
		hospCommNamTxt.setColumns(10);
		
		JLabel hospitalIDlb = new JLabel("Hospital ID");
		hospitalIDlb.setBounds(104, 334, 76, 16);
		add(hospitalIDlb);
		
		JLabel hospitalNamlb = new JLabel("Hospital Name");
		hospitalNamlb.setBounds(88, 391, 95, 16);
		add(hospitalNamlb);
		
		JLabel commIDlb = new JLabel("Community ID");
		commIDlb.setBounds(88, 446, 95, 16);
		add(commIDlb);
		
		JLabel commNamlb = new JLabel("Community Name");
		commNamlb.setBounds(67, 497, 117, 16);
		add(commNamlb);
		

		model= new DefaultTableModel();
		Object[] column= {"Hospital ID","Hospital Name","Community ID","Community Name"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		populateHospitalDetails();

	}
public void populateHospitalDetails() {
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] column = new Object[4]; // just now added
		column[0]="Hospital ID";
		column[1]="Hospital Name";
		column[2]="Community ID";
		column[3]="Community Name";
		
		
		
		
		
		for (Hospital hosp: hospitalDirectory.getHospital()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[4];
			row[0]=hosp.getHospitalID();
			row[1] = hosp.getHospitalName();
			row[2]= hosp.getCommunityId();
			row[3]=hosp.getCommunityName();
			
		
			model.addRow(row);
		}
	}
}
