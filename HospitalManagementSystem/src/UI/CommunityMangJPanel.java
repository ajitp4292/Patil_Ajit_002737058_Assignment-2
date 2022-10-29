package UI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Community;
import Model.CommunityCollector;
import Model.Patient;
import Model.PatientHistory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	//static Community com;
	//private JPanel CommunityMangJPanel;
	DefaultTableModel model;
	private JTextField commCityTxt;
	private JTextField commNameTxt;
	private JTextField commZipcodeTxt;
	private JTable commTable;
	private JTextField commIDTxt;
	/**
	 * Create the panel.
	 */
	public CommunityMangJPanel(CommunityCollector communityList) {
		setBackground(UIManager.getColor("Desktop.background"));
		this.communityList=communityList;
		setLayout(null);
		
		JLabel commTxtlb = new JLabel("Community Details");
		commTxtlb.setBounds(160, 21, 127, 16);
		add(commTxtlb);
		
		JLabel citylb = new JLabel("City");
		citylb.setBounds(103, 353, 32, 16);
		add(citylb);
		

		JLabel commNamelb = new JLabel("Community Name");
		commNamelb.setBounds(34, 408, 117, 16);
		add(commNamelb);
		
		JLabel commZiplb = new JLabel("Zipcode");
		commZiplb.setBounds(90, 459, 61, 16);
		add(commZiplb);
		
		JLabel commIDlb = new JLabel("Community ID");
		commIDlb.setBounds(48, 308, 100, 16);
		add(commIDlb);
		
		commIDTxt = new JTextField();
		commIDTxt.setBounds(157, 303, 130, 26);
		add(commIDTxt);
		commIDTxt.setColumns(10);
		
		
		commCityTxt = new JTextField();
		commCityTxt.setBounds(157, 348, 130, 26);
		add(commCityTxt);
		commCityTxt.setColumns(10);
		
		commNameTxt = new JTextField();
		commNameTxt.setBounds(160, 403, 127, 26);
		add(commNameTxt);
		commNameTxt.setColumns(10);
		
		commZipcodeTxt = new JTextField();
		commZipcodeTxt.setBounds(157, 454, 130, 26);
		add(commZipcodeTxt);
		commZipcodeTxt.setColumns(10);
		
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
		
		JButton commViewbtn = new JButton("View");
		commViewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex=commTable.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(CommunityMangJPanel,"Please select a row to view");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel) commTable.getModel();
				//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedEmpdetails);
				
				int column = 0;
				int row = commTable.getSelectedRow();
				String commIdvalue = commTable.getModel().getValueAt(row, column).toString();
				String commCityValue= commTable.getModel().getValueAt(row, 1).toString();
				String commNamevalue= commTable.getModel().getValueAt(row, 2).toString();
				String commZipvalue= commTable.getModel().getValueAt(row, 3).toString();
				
		
				
				commIDTxt.setText(commIdvalue);
				commCityTxt.setText(commCityValue);
				commNameTxt.setText(commNamevalue);
				commZipcodeTxt.setText(commZipvalue);
				
				
				
			}
		});
		
		commViewbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		commViewbtn.setBounds(20, 248, 117, 29);
		add(commViewbtn);
		
		JButton commUpdatebtn = new JButton("Update");
		commUpdatebtn.setBackground(UIManager.getColor("Button.darkShadow"));
		commUpdatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= commTable.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(CommunityMangJPanel,"Please select a row to update");
					return;
					
				} else {
					
					//System.out.println(selectedRowindex);
					DefaultTableModel model = (DefaultTableModel)commTable.getModel();
					//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
					//System.out.println(selectedEmpdetails);
					
					int column = 0;
					int row = commTable.getSelectedRow();
					String communityIDvalue = commTable.getModel().getValueAt(row, column).toString();
					String communityCityvalue= commTable.getModel().getValueAt(row, 1).toString();
					String communityNamvalue= commTable.getModel().getValueAt(row, 2).toString();
					String communityZipvalue= commTable.getModel().getValueAt(row, 3).toString();
				
					int commID=Integer.parseInt(communityIDvalue);
					int commZip=Integer.parseInt(communityZipvalue);
				Community currentCommunity = new Community();
				currentCommunity.setCommunityId(commID);
				currentCommunity.setCity(communityCityvalue);
				currentCommunity.setCommunityName(communityNamvalue);
				currentCommunity.setcommunityZipcd(commZip);
			
				
				
		    String	cID=commIDTxt.getText().trim();
			String	cCity=commCityTxt.getText().trim();
			String	cName=commNameTxt.getText().trim();
			String	cZip=commZipcodeTxt.getText().trim();
			
			int comID=Integer.parseInt(cID);
			int comZip=Integer.parseInt(cZip);
			
			
			Community newCommunity= new Community();	
			newCommunity.setCommunityId(comID);
			newCommunity.setCity(cCity);
			newCommunity.setCommunityName(cName);
			newCommunity.setcommunityZipcd(comZip);
		
			
			communityList.modifyCommunity(currentCommunity, newCommunity,row);
			
			populateCommunityDetails();
			
			commIDTxt.setText("");
			commCityTxt.setText("");
			commNameTxt.setText("");
			commZipcodeTxt.setText("");
			
			
			
				}
			
				
			}
		});
		commUpdatebtn.setBounds(150, 248, 117, 29);
		add(commUpdatebtn);
		
		JButton commDelbtn = new JButton("Delete");
		commDelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex= commTable.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(CommunityMangJPanel,"Please select a row to delete");
					return;
					
				}
				
				/*DefaultTableModel model = (DefaultTableModel) commTable.getModel();
				int column = 0;
				int row = commTable.getSelectedRow();
				int commID = commTable.getModel().getValueAt(row, column).toInteger();
				
				Community selectedCommunityDetails=(Community)model.getValueAt(selectedRowindex,0);
				System.out.println(selectedCommunityDetails);*/
			
				
				//com.getCommunityId();
				//System.out.println(com.getCommunityId());
				/*Vector selectedPatientDetails=model.getDataVector().elementAt(table.convertRowIndexToModel(table.getSelectedRow()));*/
				int column = 0;
				int row = commTable.getSelectedRow();
				String communityId = commTable.getModel().getValueAt(row, column).toString();
				/*String PatientNamevalue= table.getModel().getValueAt(row, 1).toString();
				String PatientAgevalue= table.getModel().getValueAt(row, 2).toString();
				String PatientCityvalue= table.getModel().getValueAt(row, 3).toString();
				String PatientAddressvalue= table.getModel().getValueAt(row, 4).toString();*/
				
				
				int commID=Integer.parseInt(communityId);
				
				//Patient patient = new Patient();
				
			
				int pos =communityList.getPosition(commID);
				//System.out.println(pos);
				communityList.deleteCommunity(row);
				
				JOptionPane.showMessageDialog(CommunityMangJPanel,"Community details deleted");
				populateCommunityDetails();
				
				
					
				
			}
		});
		commDelbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		commDelbtn.setBounds(279, 248, 117, 29);
		add(commDelbtn);
		
		
	
		
		
		
		
		
		
		
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
