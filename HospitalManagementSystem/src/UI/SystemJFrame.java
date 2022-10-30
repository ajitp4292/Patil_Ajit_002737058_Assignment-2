package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.CommunityCollector;
import Model.DoctorDirectory;
import Model.EncounterHistory;
import Model.HospitalDirectory;
import Model.Patient;
import Model.PatientHistory;
import Model.PersonDirectory;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SystemJFrame extends JFrame {
	Patient p;
	private JPanel contentPane;
	private static SystemJFrame frame; 
	private static JFrame loginFrame;
	private static PatientHistory patientHistory;
	private static CommunityCollector communityList;
	private static HospitalDirectory hospitalDirectory;
	private static DoctorDirectory doctorDirectory;
	private static EncounterHistory encounterHistory;
	private static PersonDirectory personDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SystemJFrame(loginFrame,patientHistory,communityList,hospitalDirectory,doctorDirectory,encounterHistory,personDirectory);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SystemJFrame(JFrame loginFrame,PatientHistory patientHistory,CommunityCollector communityList,HospitalDirectory hospitalDirectory,DoctorDirectory doctorDirectory, EncounterHistory encounterHistory,PersonDirectory personDirectory) {
		
		SystemJFrame.loginFrame=loginFrame;
	
		this.patientHistory=patientHistory;
		this.communityList=communityList;
		this.hospitalDirectory=hospitalDirectory;
		this.doctorDirectory=doctorDirectory;
		this.encounterHistory=encounterHistory;
		this.personDirectory=personDirectory;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(6, 6, 652, 532);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		splitPane.setLeftComponent(panel);
		
		JButton btnNewButton = new JButton("Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientJPanel patientPanel= new PatientJPanel(patientHistory);
				splitPane.setRightComponent(patientPanel);
				
			}
			
		});
		btnNewButton.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_2 = new JButton("Patient Manager");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientViewPanel patientview= new PatientViewPanel(patientHistory,p,communityList,hospitalDirectory,doctorDirectory);
				splitPane.setRightComponent(patientview);
			}
		});
		btnNewButton_2.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_3 = new JButton("Community");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommunityJPanel communityPanel= new CommunityJPanel(communityList);
				splitPane.setRightComponent(communityPanel);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Community Manager");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommunityMangJPanel communitymanager = new CommunityMangJPanel(communityList);
				splitPane.setRightComponent(communitymanager);
				
			}
		});
		btnNewButton_4.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_5 = new JButton("Hospital");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_5.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_6 = new JButton("Hospital Manager");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospitalMangJPanel hospitalmanager = new HospitalMangJPanel(hospitalDirectory);
				splitPane.setRightComponent(hospitalmanager);
			}
		});
		btnNewButton_6.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_7 = new JButton("Doctor");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorJPanel docJPanel= new DoctorJPanel(doctorDirectory);
				splitPane.setRightComponent(docJPanel);
			}
		});
		btnNewButton_7.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_8 = new JButton("Doctor Manager");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorMangJPanel docmangJpanel = new DoctorMangJPanel(doctorDirectory);
				splitPane.setRightComponent(docmangJpanel);
			}
		});
		
		JButton btnNewButton_9 = new JButton("Record Vital");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncounterJPanel encounterPanel= new EncounterJPanel(patientHistory,encounterHistory);
				splitPane.setRightComponent(encounterPanel);
				
			}
		});
		btnNewButton_9.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_10 = new JButton("Encounter Manager");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncounterViewJPanel encounterViewPanel= new EncounterViewJPanel(encounterHistory);
				splitPane.setRightComponent(encounterViewPanel);
			}
		});
		
		JButton btnNewButton_11 = new JButton("Register");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonSignUp reg = new PersonSignUp(personDirectory);
				splitPane.setRightComponent(reg);
			}
		});
		
		JButton btnNewButton_12 = new JButton("Register Manager");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonSignUpViewJPanel regm = new PersonSignUpViewJPanel(personDirectory);
				splitPane.setRightComponent(regm);
			}
		});
		btnNewButton_12.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnNewButton_13 = new JButton("Logout");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             loginFrame.setVisible(true);
				
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_4)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_6)
								.addComponent(btnNewButton_5)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(6)
											.addComponent(btnNewButton_9))
										.addComponent(btnNewButton_8))))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(btnNewButton_13)
					.addGap(58))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(btnNewButton)
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_2)
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_12)
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(btnNewButton_7)
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_10)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addComponent(btnNewButton_11)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addGap(5)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_6)
					.addGap(18)
					.addComponent(btnNewButton_7)
					.addGap(12)
					.addComponent(btnNewButton_8)
					.addGap(12)
					.addComponent(btnNewButton_9)
					.addGap(12)
					.addComponent(btnNewButton_10)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_11)
					.addGap(12)
					.addComponent(btnNewButton_12)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_13)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(panel_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 629, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 528, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 0, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
