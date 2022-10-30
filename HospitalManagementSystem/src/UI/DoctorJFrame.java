package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.DoctorDirectory;
import Model.HospitalDirectory;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DoctorJFrame extends JFrame {

	private JPanel contentPane;
	private static DoctorDirectory doctorDirectory;
	private static JFrame loginFrame;
	private static DoctorJFrame frame;
	//private static ArrayList<String> doctorNames;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new DoctorJFrame(doctorDirectory,loginFrame);
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
	public DoctorJFrame(DoctorDirectory doctorDirectory,JFrame loginFrame) {
DoctorJFrame.loginFrame=loginFrame;
		
		this.doctorDirectory=doctorDirectory;
		//DoctorJFrame.doctorNames=doctorNames;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(6, 6, 651, 510);
		contentPane.add(splitPane);
		
		JPanel controlAreaDoc = new JPanel();
		controlAreaDoc.setBackground(SystemColor.textHighlight);
		splitPane.setLeftComponent(controlAreaDoc);
		
		JButton createDocbtn = new JButton("Create Doctor");
		createDocbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorJPanel docJPanel= new DoctorJPanel(doctorDirectory);
				splitPane.setRightComponent(docJPanel);
				
			}
		});
		createDocbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton docMangbtn = new JButton("Doctor Manager");
		docMangbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorMangJPanel docmangJpanel = new DoctorMangJPanel(doctorDirectory);
				splitPane.setRightComponent(docmangJpanel);
				
			}
		});
		docMangbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton logoutDoc = new JButton("Logout");
		logoutDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              loginFrame.setVisible(true);
				
				dispose();
			}
			
		});
		logoutDoc.setBackground(UIManager.getColor("Button.darkShadow"));
		GroupLayout gl_controlAreaDoc = new GroupLayout(controlAreaDoc);
		gl_controlAreaDoc.setHorizontalGroup(
			gl_controlAreaDoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaDoc.createSequentialGroup()
					.addGroup(gl_controlAreaDoc.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_controlAreaDoc.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_controlAreaDoc.createParallelGroup(Alignment.LEADING)
								.addComponent(docMangbtn)
								.addComponent(createDocbtn)))
						.addGroup(gl_controlAreaDoc.createSequentialGroup()
							.addGap(29)
							.addComponent(logoutDoc)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_controlAreaDoc.setVerticalGroup(
			gl_controlAreaDoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaDoc.createSequentialGroup()
					.addGap(75)
					.addComponent(createDocbtn)
					.addGap(28)
					.addComponent(docMangbtn)
					.addPreferredGap(ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
					.addComponent(logoutDoc)
					.addGap(31))
		);
		controlAreaDoc.setLayout(gl_controlAreaDoc);
		
		JPanel workAreaDoc = new JPanel();
		workAreaDoc.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(workAreaDoc);
	}

}
