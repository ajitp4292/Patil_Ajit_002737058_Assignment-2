package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Patient;
import Model.PatientHistory;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class PatientJFrame extends JFrame {
//private PatientJFrame frame;
private static JPanel contentPane;
private static PatientHistory patientHistory;
Patient p;
private static JFrame loginFrame;
//private static JFrame PatientJFrame;
private static PatientJFrame frame;
private static JPanel workAreaPatient;
private static JPanel controlAreaPatient;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PatientJFrame(patientHistory,loginFrame);
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
	public PatientJFrame(PatientHistory patientHistory,JFrame loginFrame) {
		PatientJFrame.loginFrame=loginFrame;
		//patientHistory = new PatientHistory();//just removed oct 27 3pm
		this.patientHistory=patientHistory;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
	     workAreaPatient = new JPanel();
		workAreaPatient.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(workAreaPatient);
		workAreaPatient.setLayout(null);
		
		 controlAreaPatient = new JPanel();
		controlAreaPatient.setBackground(SystemColor.textHighlight);
		splitPane.setLeftComponent(controlAreaPatient);
		
		JButton btnNewPatient = new JButton("New Patient");
		btnNewPatient.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientJPanel patientPanel= new PatientJPanel(patientHistory);
				splitPane.setRightComponent(patientPanel);
				
			}
		});
		
		JButton btnViewPatient = new JButton("View Patient");
		btnViewPatient.setBackground(UIManager.getColor("Button.darkShadow"));
		btnViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientViewPanel patientview= new PatientViewPanel(patientHistory,p);
				splitPane.setRightComponent(patientview);
				
			}
		});
		
		JButton logoutbtn = new JButton("Logout");
		logoutbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PatientJFrame pframe = new PatientJFrame();
				//PatientViewPanel patientreview = new PatientViewPanel(patientHistory,p);
				loginFrame.setVisible(true);
			
				dispose();
				
			}
		});
		GroupLayout gl_controlAreaPatient = new GroupLayout(controlAreaPatient);
		gl_controlAreaPatient.setHorizontalGroup(
			gl_controlAreaPatient.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_controlAreaPatient.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnViewPatient)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_controlAreaPatient.createSequentialGroup()
					.addContainerGap(8, Short.MAX_VALUE)
					.addComponent(btnNewPatient)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_controlAreaPatient.createSequentialGroup()
					.addGap(20)
					.addComponent(logoutbtn)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_controlAreaPatient.setVerticalGroup(
			gl_controlAreaPatient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaPatient.createSequentialGroup()
					.addGap(123)
					.addComponent(btnNewPatient)
					.addGap(26)
					.addComponent(btnViewPatient)
					.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
					.addComponent(logoutbtn)
					.addGap(53))
		);
		controlAreaPatient.setLayout(gl_controlAreaPatient);
		contentPane.setLayout(gl_contentPane);
	}
	
}
