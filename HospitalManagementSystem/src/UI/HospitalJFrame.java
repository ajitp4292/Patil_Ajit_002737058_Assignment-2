package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Community;
import Model.Hospital;
import Model.HospitalDirectory;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospitalJFrame extends JFrame {

	private JPanel contentPane;
	private static HospitalDirectory hospitalDirectory;
	static Hospital hosp;
	static Community comm;
	private static JFrame loginFrame;
	private static HospitalJFrame frame; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new HospitalJFrame(hospitalDirectory, loginFrame,hosp,comm);
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
	public HospitalJFrame(HospitalDirectory hospitalDirectory, JFrame loginframe,Hospital hosp,Community comm) {
		
		HospitalJFrame.loginFrame=loginFrame;
		this.hospitalDirectory=hospitalDirectory;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(6, 6, 537, 533);
		contentPane.add(splitPane);
		
		JPanel controlAreaHospital = new JPanel();
		controlAreaHospital.setBackground(SystemColor.textHighlight);
		splitPane.setLeftComponent(controlAreaHospital);
		
		JButton createHopistalbtn = new JButton("Create Hospital");
		createHopistalbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HospitalJPanel hospitalPanel= new HospitalJPanel(hospitalDirectory,hosp,comm);
				splitPane.setRightComponent(hospitalPanel);
				
			}
			
		});
		createHopistalbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton mangHospitalbtn = new JButton("Hospital Manager");
		mangHospitalbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		mangHospitalbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospitalMangJPanel hospitalmanager = new HospitalMangJPanel(hospitalDirectory,hosp);
				splitPane.setRightComponent(hospitalmanager);
				
			}
		});
		
		JButton logouthospbtn = new JButton("Logout");
		logouthospbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             loginFrame.setVisible(true);
				
				dispose();
				
			}
		});
		logouthospbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		GroupLayout gl_controlAreaHospital = new GroupLayout(controlAreaHospital);
		gl_controlAreaHospital.setHorizontalGroup(
			gl_controlAreaHospital.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaHospital.createSequentialGroup()
					.addGroup(gl_controlAreaHospital.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_controlAreaHospital.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_controlAreaHospital.createParallelGroup(Alignment.LEADING, false)
								.addComponent(mangHospitalbtn, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(createHopistalbtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_controlAreaHospital.createSequentialGroup()
							.addGap(27)
							.addComponent(logouthospbtn)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_controlAreaHospital.setVerticalGroup(
			gl_controlAreaHospital.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaHospital.createSequentialGroup()
					.addGap(86)
					.addComponent(createHopistalbtn)
					.addGap(44)
					.addComponent(mangHospitalbtn)
					.addPreferredGap(ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
					.addComponent(logouthospbtn)
					.addGap(30))
		);
		controlAreaHospital.setLayout(gl_controlAreaHospital);
		
		JPanel workAreaHospital = new JPanel();
		workAreaHospital.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(workAreaHospital);
	}
}
