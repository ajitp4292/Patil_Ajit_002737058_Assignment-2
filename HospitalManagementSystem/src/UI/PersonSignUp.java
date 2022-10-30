package UI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.UIManager;

import Model.House;
import Model.Patient;
import Model.Person;
import Model.PersonDirectory;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class PersonSignUp extends JPanel {
	private JTextField NameTxt;
	private JTextField AgeTxt;
	private JTextField genderTxt;
	private JTextField streetTxt;
	private JTextField aptnoTxt;
	private JTextField zipCdTxt;
	private JPanel PersonSignUp;
	PersonDirectory personDirectory;

	/**
	 * Create the panel.
	 */
	public PersonSignUp(PersonDirectory personDirectory) {
		this.personDirectory=personDirectory;
		setBackground(UIManager.getColor("Desktop.background"));
		setLayout(null);
		
		NameTxt = new JTextField();
		NameTxt.setBounds(139, 33, 130, 26);
		add(NameTxt);
		NameTxt.setColumns(10);
		
		AgeTxt = new JTextField();
		AgeTxt.setBounds(139, 83, 130, 26);
		add(AgeTxt);
		AgeTxt.setColumns(10);
		
		genderTxt = new JTextField();
		genderTxt.setBounds(139, 137, 130, 26);
		add(genderTxt);
		genderTxt.setColumns(10);
		
		streetTxt = new JTextField();
		streetTxt.setBounds(139, 189, 130, 26);
		add(streetTxt);
		streetTxt.setColumns(10);
		
		aptnoTxt = new JTextField();
		aptnoTxt.setBounds(139, 247, 130, 26);
		add(aptnoTxt);
		aptnoTxt.setColumns(10);
		
		zipCdTxt = new JTextField();
		zipCdTxt.setBounds(139, 303, 130, 26);
		add(zipCdTxt);
		zipCdTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(78, 36, 44, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setBounds(83, 88, 44, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sex");
		lblNewLabel_2.setBounds(87, 142, 35, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Street");
		lblNewLabel_3.setBounds(78, 194, 44, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apartmnet No");
		lblNewLabel_4.setBounds(37, 252, 90, 16);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Zipcode");
		lblNewLabel_5.setBounds(66, 308, 61, 16);
		add(lblNewLabel_5);
		
		JButton Registerbtn = new JButton("Register");
		Registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( NameTxt.getText().equals("") || AgeTxt.getText().equals("") || genderTxt.getText().equals("") || 
						streetTxt.getText().equals("") || aptnoTxt.getText().equals("") || zipCdTxt.getText().equals(""))
				{
			JOptionPane.showMessageDialog(PersonSignUp, "Please fill the information Completely.");
		}
				else {
					
				
				
				
				String Name=NameTxt.getText().trim();
				String Age= AgeTxt.getText().trim();
				String Gender=genderTxt.getText();
				String street=streetTxt.getText().trim();
				String apt= aptnoTxt.getText().trim();
		String Zipcode=zipCdTxt.getText().trim();
		
	
		int AgeInt=Integer.parseInt(Age);
		int AptInt=Integer.parseInt(apt);
		int ZipInt=Integer.parseInt(Zipcode);;
		//System.out.println(patientID);
		House h= new House();
		//Person p= new Person(h);
		
		
		//Patient patient = patientHistory.addNewPatients(p,h);
		Person person=personDirectory.addNewPerson(h);
		
		
		person.setName(Name);
		person.setAge(AgeInt);
		person.setSex(Gender);
		person.setStreet(street);
		person.setAptNumber(AptInt);
		person.setZipcode(ZipInt);
		
		//p.hashCode();
		
		JOptionPane.showMessageDialog(PersonSignUp, "Person Added successfully.");
		//System.out.println(p.hashCode());
		//p.getName();		
		//System.out.println(p.getName());
		//int p1 = p.hashCode();
		NameTxt.setText(" ");
		AgeTxt.setText(" ");
		genderTxt.setText(" ");
		streetTxt.setText(" ");
		aptnoTxt.setText(" ");
		
		
		
		
				}

				
			}
			
			
		});
		Registerbtn.setBounds(152, 364, 117, 29);
		add(Registerbtn);

	}

}
