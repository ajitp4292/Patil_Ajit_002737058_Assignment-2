package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientJFrame frame = new PatientJFrame();
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
	public PatientJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JPanel workAreaPatient = new JPanel();
		splitPane.setRightComponent(workAreaPatient);
		workAreaPatient.setLayout(null);
		
		JPanel controlAreaPatient = new JPanel();
		splitPane.setLeftComponent(controlAreaPatient);
		
		JButton btnNewPatient = new JButton("New Patient");
		btnNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientJPanel patientPanel= new PatientJPanel();
				splitPane.setRightComponent(patientPanel);
				
			}
		});
		
		JButton btnViewPatient = new JButton("View Patient");
		GroupLayout gl_controlAreaPatient = new GroupLayout(controlAreaPatient);
		gl_controlAreaPatient.setHorizontalGroup(
			gl_controlAreaPatient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaPatient.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnViewPatient)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_controlAreaPatient.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewPatient)
					.addContainerGap())
		);
		gl_controlAreaPatient.setVerticalGroup(
			gl_controlAreaPatient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreaPatient.createSequentialGroup()
					.addGap(123)
					.addComponent(btnNewPatient)
					.addGap(26)
					.addComponent(btnViewPatient)
					.addContainerGap(367, Short.MAX_VALUE))
		);
		controlAreaPatient.setLayout(gl_controlAreaPatient);
		contentPane.setLayout(gl_contentPane);
	}
}
