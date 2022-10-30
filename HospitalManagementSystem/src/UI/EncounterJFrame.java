package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.EncounterHistory;
import Model.HospitalDirectory;
import Model.PatientHistory;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EncounterJFrame extends JFrame {

	private JPanel contentPane;
	private static PatientHistory patientHistory;
	private static EncounterHistory encounterHistory;
	private static EncounterJFrame frame;
	private static JFrame loginFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EncounterJFrame(patientHistory,loginFrame,encounterHistory);
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
	public EncounterJFrame(PatientHistory patientHistory,JFrame loginFrame,EncounterHistory encounterHistory) {
		EncounterJFrame.loginFrame=loginFrame;
		
		this.patientHistory=patientHistory;
		this.encounterHistory=encounterHistory;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(6, 6, 645, 497);
		contentPane.add(splitPane);
		
		JPanel controlAreaEncounter = new JPanel();
		controlAreaEncounter.setBackground(SystemColor.textHighlight);
		splitPane.setLeftComponent(controlAreaEncounter);
		
		JButton encounterbtn = new JButton("Record Vital Signs");
		encounterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncounterJPanel encounterPanel= new EncounterJPanel(patientHistory,encounterHistory);
				splitPane.setRightComponent(encounterPanel);
				
			}
		});
		encounterbtn.setBackground(UIManager.getColor("Button.shadow"));
		
		JButton btnNewButton_1 = new JButton("Encounter History");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncounterViewJPanel encounterViewPanel= new EncounterViewJPanel(encounterHistory);
				splitPane.setRightComponent(encounterViewPanel);
			
			
			}
				
		});
		btnNewButton_1.setBackground(UIManager.getColor("Button.shadow"));
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  loginFrame.setVisible(true);
				
				 dispose();
				
			}
		});
		logoutBtn.setBackground(UIManager.getColor("Button.shadow"));
		GroupLayout gl_controlAreaEncounter = new GroupLayout(controlAreaEncounter);
		gl_controlAreaEncounter.setHorizontalGroup(
			gl_controlAreaEncounter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaEncounter.createSequentialGroup()
					.addContainerGap()
					.addComponent(encounterbtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_controlAreaEncounter.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
				.addGroup(gl_controlAreaEncounter.createSequentialGroup()
					.addGap(32)
					.addComponent(logoutBtn)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_controlAreaEncounter.setVerticalGroup(
			gl_controlAreaEncounter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaEncounter.createSequentialGroup()
					.addGap(93)
					.addComponent(encounterbtn)
					.addGap(44)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
					.addComponent(logoutBtn)
					.addGap(29))
		);
		controlAreaEncounter.setLayout(gl_controlAreaEncounter);
		
		JPanel workAreaEncounter = new JPanel();
		workAreaEncounter.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(workAreaEncounter);
		workAreaEncounter.setLayout(null);
	}

}
