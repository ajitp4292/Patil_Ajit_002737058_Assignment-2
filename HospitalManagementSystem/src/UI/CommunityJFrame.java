package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Community;
import Model.CommunityCollector;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommunityJFrame extends JFrame {

	private JPanel contentPane;
	CommunityCollector communityList;
	Community com;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommunityJFrame frame = new CommunityJFrame();
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
	public CommunityJFrame() {
		communityList = new CommunityCollector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(6, 0, 602, 523);
		contentPane.add(splitPane);
		
		JPanel controlAreacommunity = new JPanel();
		controlAreacommunity.setBackground(SystemColor.textHighlight);
		splitPane.setLeftComponent(controlAreacommunity);
		
		JButton createCommunity = new JButton(" Create Community");
		createCommunity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommunityJPanel communityPanel= new CommunityJPanel(communityList);
				splitPane.setRightComponent(communityPanel);
			
			}
		});
		createCommunity.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton communityManage = new JButton("Community Manager");
		communityManage.setBackground(UIManager.getColor("Button.darkShadow"));
		GroupLayout gl_controlAreacommunity = new GroupLayout(controlAreacommunity);
		gl_controlAreacommunity.setHorizontalGroup(
			gl_controlAreacommunity.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addContainerGap()
					.addComponent(createCommunity)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_controlAreacommunity.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(communityManage)
					.addContainerGap())
		);
		gl_controlAreacommunity.setVerticalGroup(
			gl_controlAreacommunity.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addGap(110)
					.addComponent(createCommunity)
					.addGap(43)
					.addComponent(communityManage)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		controlAreacommunity.setLayout(gl_controlAreacommunity);
		
		JPanel workAreacommunity = new JPanel();
		workAreacommunity.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(workAreacommunity);
	}
}
