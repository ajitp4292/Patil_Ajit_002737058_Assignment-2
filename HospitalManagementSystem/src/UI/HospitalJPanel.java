package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import Model.Community;
import Model.Hospital;
import Model.HospitalDirectory;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HospitalJPanel extends JPanel {
	private JTextField hospitalIDTxt;
	private JTextField hospitalNameTxt;
	private JTextField hospCommIDTxt;
	private JTextField commNameTxt;
	HospitalDirectory hospitalDirectory;
	private  JPanel HospitalJPanel;
	private static ArrayList<String> hosp1;
	private static ArrayList<String> hosp2;
	//private static Hospital hosp;
//private static Community comm;
	/**
	 * Create the panel.
	 */
	public HospitalJPanel(HospitalDirectory hospitalDirectory, ArrayList<String> hosp1,ArrayList<String> hosp2) {
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel hospitalIdlb = new JLabel("Hospital ID");
		hospitalIdlb.setBounds(86, 51, 90, 16);
		add(hospitalIdlb);
		
		JLabel hospitalNamlb = new JLabel("Hospital Name");
		hospitalNamlb.setBounds(60, 105, 104, 16);
		add(hospitalNamlb);
		
		JLabel commIdlb = new JLabel("Community Id");
		commIdlb.setBounds(71, 169, 93, 16);
		add(commIdlb);
		
		JLabel hospCommNameTxt = new JLabel("Community Name");
		hospCommNameTxt.setBounds(49, 237, 120, 16);
		add(hospCommNameTxt);
		
		hospitalIDTxt = new JTextField();
		hospitalIDTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || Character.isISOControl(c)) {
					hospitalIDTxt.setEditable(false);
				}
				else {
					JOptionPane.showMessageDialog(HospitalJPanel, "Hospital Id must be a Integer value");
					hospitalIDTxt.setEditable(false);
				}
			}
		});
		hospitalIDTxt.setBounds(181, 46, 130, 26);
		add(hospitalIDTxt);
		hospitalIDTxt.setColumns(10);
		
		//int size=hospitalDirectory.getSize();
		//int id = (size+1);
		//String pid=String.valueOf(id);
		
	
		int size=hospitalDirectory.getSize();
		int id = (size+1);
		String pid=String.valueOf(id);

		if (size==0) {
			hospitalIDTxt.setText("1");
		}
		else {
			hospitalIDTxt.setText(pid);
		}

		
		
		hospitalNameTxt = new JTextField();
		hospitalNameTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//allow only letter,space and Iso control char
				
					hospitalNameTxt.setEditable(true);
				}
					else {
						JOptionPane.showMessageDialog(HospitalJPanel, "Hospital Name must be a String value");
						hospitalNameTxt.setEditable(false);
						
					}
				
			}
		});
		hospitalNameTxt.setBounds(181, 100, 130, 26);
		add(hospitalNameTxt);
		hospitalNameTxt.setColumns(10);
		
		hospCommIDTxt = new JTextField();
		hospCommIDTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || Character.isISOControl(c)) {
					hospCommIDTxt.setEditable(true);
				}
				else {
					JOptionPane.showMessageDialog(HospitalJPanel, "Community ID must be a Integer value");
					hospCommIDTxt.setEditable(false);
				}
				
			}
		});
		hospCommIDTxt.setBounds(181, 164, 130, 26);
		add(hospCommIDTxt);
		hospCommIDTxt.setColumns(10);
		
		commNameTxt = new JTextField();
		commNameTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//allow only letter,space and Iso control char
				
					commNameTxt.setEditable(true);
				}
					else {
						JOptionPane.showMessageDialog(HospitalJPanel, "Community Name must be a String value");
						commNameTxt.setEditable(false);
						
					}
				
			}
		});
		commNameTxt.setBounds(181, 232, 130, 26);
		add(commNameTxt);
		commNameTxt.setColumns(10);
		
		JButton saveHospbtn = new JButton("Save");
		saveHospbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( hospitalIDTxt.getText().equals(" ") || hospitalNameTxt.getText().equals(" ") || hospCommIDTxt.getText().equals(" ") || commNameTxt.getText().equals(" "))
				{
			JOptionPane.showMessageDialog(HospitalJPanel, "Please fill the information Completely.");
		}
		
		else {	
		String hospId=hospitalIDTxt.getText().trim();
		String hospName=hospitalNameTxt.getText().trim();
		String hospCommID=hospCommIDTxt.getText().trim();
		String hospCommName= commNameTxt.getText().trim();
		
int hospitalId=Integer.parseInt(hospId);
int hospitalCommID=Integer.parseInt(hospCommID);
Community comm= new Community();
Hospital hosp=hospitalDirectory.addNewHospital(comm);

//hospitalDirectory.addNewHospital(hosp);
hosp.setHospitalID(hospitalId);
hosp.setHospitalName(hospName);
hosp.setCommunityId(hospitalCommID);
hosp.setCommunityName(hospCommName);


if (hospitalCommID == 1) {
	hosp1.add(hospName);

	}

if(hospitalCommID == 2) {
	hosp2.add(hospName);
}

//p.hashCode();
//System.out.println(hosp1);

JOptionPane.showMessageDialog(HospitalJPanel, "Hospital Added successfully.");
//System.out.println(p.hashCode());
//p.getName();		
//System.out.println(p.getName());
//int p1 = p.hashCode();
hospitalNameTxt.setText(" ");
hospCommIDTxt.setText(" ");
commNameTxt.setText(" ");

int size=hospitalDirectory.getSize();
int id = (size+1);
String pid=String.valueOf(id);

if (size==0) {
	hospitalIDTxt.setText("1");
}
else {
	hospitalIDTxt.setText(pid);
}


		
	}
				
			}
		});
		saveHospbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		saveHospbtn.setBounds(183, 311, 117, 29);
		add(saveHospbtn);

	}

}
