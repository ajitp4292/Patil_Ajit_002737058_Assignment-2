package UI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Community;
import Model.CommunityCollector;
import Model.Patient;
import Model.PatientHistory;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommunityMangJPanel extends JPanel {
	private JTable table;
private JPanel CommunityMangJPanel;
	CommunityCollector communityList;
	Community com;
	
	DefaultTableModel model;
	private JTextField commCity;
	private JTextField commName;
	private JTextField commZipcode;
	private JTable commTable;
	/**
	 * Create the panel.
	 */
	public CommunityMangJPanel(CommunityCollector communityList,Community com) {
		setBackground(UIManager.getColor("Desktop.background"));
		this.communityList=communityList;
		setLayout(null);
		
		JLabel commTxtlb = new JLabel("Community Details");
		commTxtlb.setBounds(160, 21, 127, 16);
		add(commTxtlb);
		
		JButton commViewbtn = new JButton("View");
		commViewbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		commViewbtn.setBounds(20, 248, 117, 29);
		add(commViewbtn);
		
		JButton commUpdatebtn = new JButton("Update");
		commUpdatebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		commUpdatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		commUpdatebtn.setBounds(150, 248, 117, 29);
		add(commUpdatebtn);
		
		JButton commDelbtn = new JButton("Delete");
		commDelbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		commDelbtn.setBounds(279, 248, 117, 29);
		add(commDelbtn);
		
		JLabel citylb = new JLabel("City");
		citylb.setBounds(107, 310, 32, 16);
		add(citylb);
		
		JLabel commNamelb = new JLabel("Community Name");
		commNamelb.setBounds(34, 353, 117, 16);
		add(commNamelb);
		
		JLabel commZiplb = new JLabel("Zipcode");
		commZiplb.setBounds(88, 392, 61, 16);
		add(commZiplb);
		
		commCity = new JTextField();
		commCity.setBounds(160, 305, 130, 26);
		add(commCity);
		commCity.setColumns(10);
		
		commName = new JTextField();
		commName.setBounds(160, 348, 127, 26);
		add(commName);
		commName.setColumns(10);
		
		commZipcode = new JTextField();
		commZipcode.setBounds(160, 387, 130, 26);
		add(commZipcode);
		commZipcode.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 49, 359, 187);
		add(scrollPane);
		
		commTable = new JTable();
		scrollPane.setViewportView(commTable);
		model= new DefaultTableModel();
		Object[] column= {"CommunityID","City","CommunityName","CommunityZipcode"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		commTable.setModel(model);
		
		populateCommunityDetails();

	}
	public void populateCommunityDetails() {
		
		
		DefaultTableModel model = (DefaultTableModel) commTable.getModel();
		model.setRowCount(0);
		Object[] column = new Object[4]; // just now added
		column[0]="CommunityID";
		column[1]="City";
		column[2]="CommunityName";
		column[3]="CommunityZipcode";
		
		
		//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};//just commented.
		//Object[] row= new Object[0];
		//model.addColumn(column);
		
		
		for (Community com: communityList.getCommunity()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[4];
			row[0]=com.getCommunityId();
			row[1] = com.getCity();
			row[2]= com.getCommunityName();
			row[3]=com.getcommunityZipcd();
			
		
			model.addRow(row);
		}
	}
}
