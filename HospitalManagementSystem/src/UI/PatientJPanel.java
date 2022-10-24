package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PatientJPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PatientJPanel() {
		setLayout(null);
		
		JLabel patientIdlb = new JLabel("PatientId");
		patientIdlb.setBounds(129, 65, 61, 16);
		add(patientIdlb);
		
		textField = new JTextField();
		textField.setBounds(225, 60, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel patientNamelb = new JLabel("Name");
		patientNamelb.setBounds(129, 117, 61, 16);
		add(patientNamelb);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 112, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel patientAgelb = new JLabel("Age");
		patientAgelb.setBounds(129, 172, 61, 16);
		add(patientAgelb);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 167, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel patientCitylb = new JLabel("City");
		patientCitylb.setBounds(129, 226, 61, 16);
		add(patientCitylb);
		
		textField_3 = new JTextField();
		textField_3.setBounds(225, 221, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel patientAddrlb = new JLabel("Address");
		patientAddrlb.setBounds(129, 288, 61, 16);
		add(patientAddrlb);
		
		textField_4 = new JTextField();
		textField_4.setBounds(225, 283, 130, 26);
		add(textField_4);
		textField_4.setColumns(10);

	}
}
