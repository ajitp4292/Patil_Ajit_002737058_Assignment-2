package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Community;
import Model.CommunityCollector;
import Model.Patient;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CommunityJPanel extends JPanel {
	private  JTextField commCityTxt;
	private  JTextField commNameTxt;
	private  JTextField commZipTxt;
CommunityCollector communityList;
private  JPanel CommunityJPanel;
private JTextField commIDTxt;
//private static Community comm;
	/**
	 * Create the panel.
	 */
	public CommunityJPanel(CommunityCollector communityList) {
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		JLabel cityLb = new JLabel("City");
		cityLb.setBounds(151, 138, 25, 16);
		add(cityLb);
		
		JLabel commNamelb = new JLabel("Community Name");
		commNamelb.setBounds(63, 193, 113, 16);
		add(commNamelb);
		
		JLabel commZiplb = new JLabel("Zipcode");
		commZiplb.setBounds(106, 253, 61, 16);
		add(commZiplb);
		
		JLabel commIdlb = new JLabel("CommunityId");
		commIdlb.setBounds(85, 84, 91, 16);
		add(commIdlb);
		
		
		commIDTxt = new JTextField();
		commIDTxt.setBounds(183, 79, 130, 26);
		add(commIDTxt);
		commIDTxt.setColumns(10);
		
		
		
		int size=communityList.getSize();
		int id = (size+1);
		String pid=String.valueOf(id);
		
		if (size==0) {
			commIDTxt.setText("1");
		}
		else {
			commIDTxt.setText(pid);
		}
		
		commCityTxt = new JTextField();
		commCityTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//allow only letter,space and Iso control char
				
					commCityTxt.setEditable(true);
				}
					else {
						JOptionPane.showMessageDialog(CommunityJPanel, "City must be a String value");
						commCityTxt.setEditable(false);
						
					}
			}
		});
		commCityTxt.setBounds(183, 133, 130, 26);
		add(commCityTxt);
		commCityTxt.setColumns(10);
		
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
						JOptionPane.showMessageDialog(CommunityJPanel, "Community Name must be a String value");
						commNameTxt.setEditable(false);
						
					}
				
			}
		});
		commNameTxt.setBounds(183, 188, 130, 26);
		add(commNameTxt);
		commNameTxt.setColumns(10);
		
		commZipTxt = new JTextField();
		commZipTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c) || Character.isISOControl(c)) {
					commZipTxt.setEditable(true);
				}
				else {
					JOptionPane.showMessageDialog(CommunityJPanel, "Community Zipcode must be a Integer value");
					commZipTxt.setEditable(false);
				}
				
			}
		});
		commZipTxt.setBounds(183, 248, 130, 26);
		add(commZipTxt);
		commZipTxt.setColumns(10);
		
		JButton saveCommbtn = new JButton("Save");
		saveCommbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ( commCityTxt.getText().equals("") || commNameTxt.getText().equals("") || commZipTxt.getText().equals(""))
						{
					JOptionPane.showMessageDialog(CommunityJPanel, "Please fill the information Completely.");
				}
				
				else {	
				String commId=commIDTxt.getText().trim();
				String city=commCityTxt.getText().trim();
				String commName=commNameTxt.getText().trim();
				String commZipcd= commZipTxt.getText().trim();
				
		int communityId=Integer.parseInt(commId);
		int commZIPcd=Integer.parseInt(commZipcd);
		
Community comm=communityList.addNewCommunity();
		comm.setCommunityId(communityId);
		comm.setCity(city);
		comm.setCommunityName(commName);
		comm.setcommunityZipcd(commZIPcd);
		
		
		//p.hashCode();
		
		JOptionPane.showMessageDialog(CommunityJPanel, "Community Added successfully.");
		//System.out.println(p.hashCode());
		//p.getName();		
		//System.out.println(p.getName());
		//int p1 = p.hashCode();
		commCityTxt.setText(" ");
		commNameTxt.setText(" ");
		commZipTxt.setText(" ");
		
		int size=communityList.getSize();
		int id = (size+1);
		String pid=String.valueOf(id);
		
		if (size==0) {
			commIDTxt.setText("1");
		}
		else {
			commIDTxt.setText(pid);
		}
		
		
				
			}
				
			}
		});
		saveCommbtn.setBounds(183, 299, 117, 29);
		add(saveCommbtn);
		
		

	}
}
	


