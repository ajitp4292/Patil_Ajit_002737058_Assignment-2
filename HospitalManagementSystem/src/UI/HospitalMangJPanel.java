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
import Model.Hospital;
import Model.HospitalDirectory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



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
		hospitalIDTxt = new JTextField();
		hospitalIDTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || Character.isISOControl(c)) {
					hospitalIDTxt.setEditable(false);
				}
				else {
					JOptionPane.showMessageDialog(HospitalMangJPanel, "Hospital Id must be a Integer value");
					hospitalIDTxt.setEditable(false);
				}
				
			}
		});
		hospitalIDTxt.setBounds(182, 329, 130, 26);
		add(hospitalIDTxt);
		hospitalIDTxt.setColumns(10);
		
		hospitalNamTxt = new JTextField();
		hospitalNamTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//allow only letter,space and Iso control char
				
					hospitalNamTxt.setEditable(true);
				}
					else {
						JOptionPane.showMessageDialog(HospitalMangJPanel, "Hospital Name must be a String value");
						hospitalNamTxt.setEditable(false);
						
					}
			}
		});
		hospitalNamTxt.setBounds(182, 386, 130, 26);
		add(hospitalNamTxt);
		hospitalNamTxt.setColumns(10);
		
		hospCommIDTxt = new JTextField();
		hospCommIDTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || Character.isISOControl(c)) {
					hospCommIDTxt.setEditable(true);
				}
				else {
					JOptionPane.showMessageDialog(HospitalMangJPanel, "Community ID must be a Integer value");
					hospCommIDTxt.setEditable(false);
				}
				
			}
		});
		hospCommIDTxt.setBounds(182, 441, 130, 26);
		add(hospCommIDTxt);
		hospCommIDTxt.setColumns(10);
		
		hospCommNamTxt = new JTextField();
		hospCommNamTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//allow only letter,space and Iso control char
				
					hospCommNamTxt.setEditable(true);
				}
					else {
						JOptionPane.showMessageDialog(HospitalMangJPanel, "Community Name must be a String value");
						hospCommNamTxt.setEditable(false);
						
					}
				
			}
		});
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model= new DefaultTableModel();
		Object[] column= {"Hospital ID","Hospital Name","Community ID","Community Name"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		JButton viewHospbtn = new JButton("View");
		viewHospbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex=table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(HospitalMangJPanel,"Please select a row to view");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedEmpdetails);
				
				int column = 0;
				int row = table.getSelectedRow();
				String hospIdvalue = table.getModel().getValueAt(row, column).toString();
				String hospNmValue= table.getModel().getValueAt(row, 1).toString();
				String hospCommIDvalue= table.getModel().getValueAt(row, 2).toString();
				String hospcommNmvalue= table.getModel().getValueAt(row, 3).toString();
				
		
				
				hospitalIDTxt.setText(hospIdvalue);
				hospitalNamTxt.setText(hospNmValue);
				hospCommIDTxt.setText(hospCommIDvalue);
				hospCommNamTxt.setText(hospcommNmvalue);
				
		           
			}
		});
		viewHospbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		viewHospbtn.setBounds(32, 281, 117, 29);
		add(viewHospbtn);
		
		JButton updateHosplb = new JButton("Update");
		updateHosplb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(HospitalMangJPanel,"Please select a row to update");
					return;
					
				} else {
					
					//System.out.println(selectedRowindex);
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
					//System.out.println(selectedEmpdetails);
					
					int column = 0;
					int row = table.getSelectedRow();
					
					String hospIdvalue = table.getModel().getValueAt(row, column).toString();
					String hospNmValue= table.getModel().getValueAt(row, 1).toString();
					String hospCommIDvalue= table.getModel().getValueAt(row, 2).toString();
					String hospcommNmvalue= table.getModel().getValueAt(row, 3).toString();
				
					int hospID=Integer.parseInt(hospIdvalue);
					int hospCommID=Integer.parseInt(hospCommIDvalue);
				//Community currentCommunity = new Community();
					Community com =new Community();
					Hospital currentHosp= new Hospital(com);
			
				currentHosp.setHospitalID(hospID);
				currentHosp.setHospitalName(hospNmValue);
				currentHosp.setCommunityId(hospCommID);
				currentHosp.setCommunityName(hospcommNmvalue);
				
				
				
		    String	hID=hospitalIDTxt.getText().trim();
			String	hNm=hospitalNamTxt.getText().trim();
			String	hCID=hospCommIDTxt.getText().trim();
			String	hCNm=hospCommNamTxt.getText().trim();
			
			int hIDval=Integer.parseInt(hID);
			int hcommID=Integer.parseInt(hCID);
			
			
			
			
			Community com1 =new Community();
			Hospital newHosp= new Hospital(com1);
	
			newHosp.setHospitalID(hIDval);
			newHosp.setHospitalName(hNm);
			newHosp.setCommunityId(hcommID);
			newHosp.setCommunityName(hCNm);
		
			
			//communityList.modifyCommunity(currentCommunity, newCommunity,row);
			hospitalDirectory.modifyHospital(currentHosp, newHosp, row);
			JOptionPane.showMessageDialog(HospitalMangJPanel,"Update Successful");
			populateHospitalDetails();
			
			hospitalIDTxt.setText("");
			hospitalNamTxt.setText("");
			hospCommIDTxt.setText("");
			hospCommNamTxt.setText("");
			
			
			
				}
		
				
			}
			
		});
		updateHosplb.setBackground(UIManager.getColor("Button.darkShadow"));
		updateHosplb.setBounds(161, 281, 117, 29);
		add(updateHosplb);
		
		JButton deleteHosplb = new JButton("Delete");
		deleteHosplb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex= table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(HospitalMangJPanel,"Please select a row to delete");
					return;
					
				}
				
			
				int column = 0;
				int row = table.getSelectedRow();
				String communityId = table.getModel().getValueAt(row, column).toString();
			
				
				
				//int commID=Integer.parseInt(communityId);
				
				//Patient patient = new Patient();
				
			
				//int pos =communityList.getPosition(commID);
				//System.out.println(pos);
				//communityList.deleteCommunity(row);
				hospitalDirectory.deleteHospital(row);
				
				JOptionPane.showMessageDialog(HospitalMangJPanel,"Hospital details deleted");
				populateHospitalDetails();
				
			}
		});
		deleteHosplb.setBackground(UIManager.getColor("Button.darkShadow"));
		deleteHosplb.setBounds(290, 281, 117, 29);
		add(deleteHosplb);
		
		
		

		
		
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
