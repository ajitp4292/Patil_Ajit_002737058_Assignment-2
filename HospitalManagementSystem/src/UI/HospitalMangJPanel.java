package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Model.Hospital;
import Model.HospitalDirectory;



public class HospitalMangJPanel extends JPanel {
	private JTable table;
	private JTextField hospitalIDTxt;
	private JTextField hospitalNamTxt;
	private JTextField hospCommIDTxt;
	private JTextField hospCommNamTxt;
	private JPanel HospitalMangJPanel;
	HospitalDirectory hospitalDirectory;
	Hospital hosp;
	/**
	 * Create the panel.
	 */
	public HospitalMangJPanel(HospitalDirectory hospitalDirectory,Hospital hosp) {
		this.hospitalDirectory=hospitalDirectory;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel hopsitalDTlb = new JLabel("View Hospital Details");
		hopsitalDTlb.setBounds(149, 29, 141, 27);
		add(hopsitalDTlb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 72, 445, 194);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton viewHospbtn = new JButton("View");
		viewHospbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		viewHospbtn.setBounds(40, 281, 117, 29);
		add(viewHospbtn);
		
		JButton updateHosplb = new JButton("Update");
		updateHosplb.setBackground(UIManager.getColor("Button.darkShadow"));
		updateHosplb.setBounds(195, 281, 117, 29);
		add(updateHosplb);
		
		JButton deleteHosplb = new JButton("Delete");
		deleteHosplb.setBackground(UIManager.getColor("Button.darkShadow"));
		deleteHosplb.setBounds(348, 281, 117, 29);
		add(deleteHosplb);
		
		hospitalIDTxt = new JTextField();
		hospitalIDTxt.setBounds(195, 329, 130, 26);
		add(hospitalIDTxt);
		hospitalIDTxt.setColumns(10);
		
		hospitalNamTxt = new JTextField();
		hospitalNamTxt.setBounds(195, 386, 130, 26);
		add(hospitalNamTxt);
		hospitalNamTxt.setColumns(10);
		
		hospCommIDTxt = new JTextField();
		hospCommIDTxt.setBounds(195, 441, 130, 26);
		add(hospCommIDTxt);
		hospCommIDTxt.setColumns(10);
		
		hospCommNamTxt = new JTextField();
		hospCommNamTxt.setBounds(195, 492, 130, 26);
		add(hospCommNamTxt);
		hospCommNamTxt.setColumns(10);
		
		JLabel hospitalIDlb = new JLabel("Hospital ID");
		hospitalIDlb.setBounds(107, 334, 76, 16);
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

	}
}
