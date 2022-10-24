package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class LoginPage implements ActionListener{
	static ArrayList<String> userlist= new ArrayList<String>();
	private static JLabel usernameLb;
	private static JTextField usernameTxt;
	private static 	JLabel passwordLb;
	private static JPasswordField passwordTxt;
	private static JLabel roleLb;
	private static JComboBox<String> userRole;
	private static JButton loginBtn;
	private static JButton signUp;
	private static JLabel successLb;
	
	
	
	public static void main(String[] args){
		
		JPanel loginPanel= new JPanel();
		JFrame loginFrame= new JFrame();
		loginFrame.setSize(350,200);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		userRole= new JComboBox<String>();
		userRole.setBounds(100, 80, 165, 25);
		userRole.addItem("");
		userRole.addItem("ADMIN");
		userRole.addItem("DOCTOR");
		userRole.addItem("PATIENT");
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
		
		successLb= new JLabel("success");
		successLb.setBounds(158, 170, 80, 25);
		loginPanel.add(successLb);
		loginFrame.setVisible(true);
		
		
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userlg = usernameTxt.getText().toLowerCase();
		String passwordlg=passwordTxt.getText().toLowerCase();
		String selectedRolelg = (String) userRole.getSelectedItem();
		
	if(selectedRolelg =="ADMIN") {
		System.out.println("Welcome homepage ADMIN");
		
	}

		usernameTxt.setText("");
		passwordTxt.setText("");
		userRole.setSelectedItem("");
		//System.out.println("user credentials does not exist");		
}
}


