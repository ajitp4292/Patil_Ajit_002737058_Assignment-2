package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Community;
import Model.CommunityCollector;
import Model.Hospital;
import Model.HospitalDirectory;
import Model.Patient;
import Model.PatientHistory;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.SystemColor;

public class LoginPage implements ActionListener{
	static ArrayList<String> userlist= new ArrayList<String>();
	private static ArrayList<String> hosp1;
	private static ArrayList<String> hosp2;
	private static JLabel usernameLb;
	private static JTextField usernameTxt;
	private static 	JLabel passwordLb;
	private static JPasswordField passwordTxt;
	private static JLabel roleLb;
	private static JComboBox<String> userRole;
	private static JButton loginBtn;
	private static JButton signUp;
	private JPanel loginPanel;
	private static JFrame loginFrame;
	private JFrame PatientJFrame;
	private JFrame CommunityJFrame;
	private JFrame HospitalJFrame;
	//private  ArrayList <Patient> patientHistory;
	private static PatientHistory  patientHistory;
	private static CommunityCollector communityList;
	private static HospitalDirectory hospitalDirectory;
    //Community comm;
	Patient p;
	private static Hospital hosp;
	private static Community comm;
	
	public static void main(String[] args){
		
		//ArrayList <Patient> patientHistory = new ArrayList <Patient>();
		patientHistory = new PatientHistory();
		communityList = new CommunityCollector();
		hospitalDirectory= new HospitalDirectory();
		//comm= new Community();
		//hosp= new Hospital(comm);
		
		
		JPanel loginPanel= new JPanel();
		loginPanel.setBounds(0, 0, 350, 369);
		loginPanel.setBackground(SystemColor.textHighlight);
	    loginFrame= new JFrame();
		loginFrame.setSize(350,397);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.getContentPane().add(loginPanel);
	    loginPanel.setLayout(null);
		
	    
	    usernameLb= new JLabel("Username");
	    usernameLb.setBounds(10, 20, 80, 25);
		loginPanel.add(usernameLb);
		
		 usernameTxt= new JTextField(20);
		 usernameTxt.setBounds(100, 20, 165, 25);
		loginPanel.add(usernameTxt);
		
		passwordLb= new JLabel("Password");
		passwordLb.setBounds(10, 50, 80, 25);
		loginPanel.add(passwordLb);
		
		passwordTxt= new JPasswordField();
		passwordTxt.setBounds(100, 50, 165, 25);
		loginPanel.add(passwordTxt);
		
		roleLb= new JLabel("UserRole");
		roleLb.setBounds(10, 80, 80, 25);
		loginPanel.add(roleLb);
		
		hosp1= new ArrayList<String>();
		hosp2= new ArrayList<String>();
		
		userRole= new JComboBox<String>();
		userRole.setBounds(100, 80, 165, 25);
		userRole.addItem("");
		userRole.addItem("ADMIN");
		userRole.addItem("DOCTOR");
		userRole.addItem("PATIENT");
		userRole.addItem("COMMUNITYADMIN");
		userRole.addItem("HOSPITALADMIN");
		loginPanel.add(userRole);
		
		signUp=new JButton("Signup");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("SignUp clicked");
				String user = usernameTxt.getText();
				String password=passwordTxt.getText();
				String selectedRole = (String) userRole.getSelectedItem();
				System.out.println(password);
				System.out.println(selectedRole);
				
				userlist.add(user);
				userlist.add(password);
				userlist.add(selectedRole);
				System.out.println(userlist);
				
				usernameTxt.setText("");
				passwordTxt.setText("");
				userRole.setSelectedItem("");
				
			}
			
		});
		
		
		
		signUp.setBounds(106, 130, 80, 25);
		loginPanel.add(signUp);
		
		loginBtn= new JButton("Login");
		loginBtn.setBounds(198, 130, 80, 25);
		loginPanel.add(loginBtn);
		loginBtn.addActionListener(new LoginPage());
		loginFrame.setVisible(true);
		
		
		
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userlg = usernameTxt.getText().toLowerCase();
		String passwordlg=passwordTxt.getText().toLowerCase();
		String selectedRolelg = (String) userRole.getSelectedItem();
		
		
		if (selectedRolelg == "") {
			JOptionPane.showMessageDialog(loginPanel,"Please select the Role of the User");
		}
		
		if (selectedRolelg=="PATIENT") {
			
			PatientJFrame pJFrame = new PatientJFrame(patientHistory,loginFrame);
			//patientJFrame.setVisible(true);
			//PatientViewPanel pPanelview = new PatientViewPanel(patientHistory,p);
			pJFrame.setVisible(true);
			loginFrame.dispose();
			
		}
	if(selectedRolelg =="ADMIN") {
		System.out.println("Welcome homepage ADMIN");
		
	}
	
	if(selectedRolelg =="COMMUNITYADMIN") {
		CommunityJFrame communityFrame = new CommunityJFrame(communityList,loginFrame,hosp1,hosp2);
		communityFrame.setVisible(true);
		loginFrame.dispose();
	}
	
	if(selectedRolelg =="HOSPITALADMIN") {
		HospitalJFrame hospitalFrame= new HospitalJFrame(hospitalDirectory,loginFrame,hosp1,hosp2);
		hospitalFrame.setVisible(true);
		loginFrame.dispose();
		
		
	}

		usernameTxt.setText("");
		passwordTxt.setText("");
		userRole.setSelectedItem("");
		//System.out.println("user credentials does not exist");		
}
}


