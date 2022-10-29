package UI;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Model.Community;
import Model.CommunityCollector;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CommunitySearch extends JPanel {
	private JTable table;
	private JTextField searchKey;
	private static ArrayList<String> hosp1;
	private static ArrayList<String> hosp2;
	CommunityCollector communityList;
	private JPanel CommunitySearch;
	DefaultTableModel model;
	private JTextField commIDTxt;
	private static JComboBox<String> hospitalList;
	
	

	/**
	 * Create the panel.
	 */
	public CommunitySearch(CommunityCollector communityList,ArrayList<String> hosp1,ArrayList<String> hosp2) {
		this.communityList=communityList;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 99, 338, 178);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 42, 88, 27);
		add(comboBox);
		comboBox.addItem("Community ID");
		comboBox.addItem("Community Name");
		
		JLabel search = new JLabel("Search By");
		search.setBounds(35, 43, 74, 23);
		add(search);
		
		searchKey = new JTextField();
		searchKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> st = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(st);
				st.setRowFilter(RowFilter.regexFilter(searchKey.getText().trim()));
				
			}
		});
		searchKey.setBounds(205, 41, 130, 26);
		add(searchKey);
		searchKey.setColumns(10);
		
		model= new DefaultTableModel();
		Object[] column= {"CommunityID","City","CommunityName","CommunityZipcode"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		
		commIDTxt = new JTextField();
		commIDTxt.setBounds(151, 349, 109, 26);
		add(commIDTxt);
		commIDTxt.setColumns(10);
		
		JLabel commId = new JLabel("Community ID");
		commId.setBounds(48, 354, 100, 16);
		add(commId);
		
		JLabel hospitalListlb = new JLabel("Hospital List");
		hospitalListlb.setBounds(48, 401, 88, 16);
		add(hospitalListlb);
		
		hospitalList = new JComboBox();
		hospitalList.setBounds(148, 397, 120, 27);
		add(hospitalList);
		
		JButton View = new JButton("View Hospitals");
		View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRowindex=table.getSelectedRow();
				if (selectedRowindex<0) {
					
					JOptionPane.showMessageDialog(CommunitySearch,"Please select a row to view");
					return;
					
				}
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//Patient selectedEmpdetails=(Patient) model.getValueAt(selectedRowindex,0);
				//System.out.println(selectedEmpdetails);
				
				int column = 0;
				int row = table.getSelectedRow();
				String commIdvalue = table.getModel().getValueAt(row, column).toString();
				int commID=Integer.parseInt(commIdvalue);
				
	commIDTxt.setText(commIdvalue);
			//System.out.println("Outside");
			
	if(commID == 1) {
		//hospitalList.ad
		//System.out.println("Inside");
		for(int i = 0; i < hosp1.size(); i++) {
		String s=hosp1.get(i);
			hospitalList.addItem(s);
			
		}
	}
		
		if(commID == 2) {
			for(int i = 0; i < hosp1.size(); i++) {
				String s=hosp1.get(i);
					hospitalList.removeItem(s);
					
				}
			
			for(int j = 0; j < hosp2.size(); j++) {
			String s=hosp2.get(j);
			
		
				hospitalList.addItem(s);
				
			}
		
	}
	
				
			}
		});
		View.setBackground(UIManager.getColor("Button.darkShadow"));
		View.setBounds(151, 289, 117, 29);
		add(View);
		
	
		populateCommunityDetails();

	}
	
public void populateCommunityDetails() {
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
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
