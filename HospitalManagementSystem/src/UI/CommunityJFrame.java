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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CommunityJFrame extends JFrame {

	private JPanel contentPane;
	private static CommunityCollector communityList;
	//Community com;
	//static Community comm;
	private static JFrame loginFrame;
	private static CommunityJFrame frame;
	private static ArrayList<String> hosp1;
	private static ArrayList<String> hosp2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new CommunityJFrame(communityList,loginFrame,hosp1,hosp2);
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
	public CommunityJFrame(CommunityCollector communityList,JFrame loginFrame, ArrayList<String> hosp1,ArrayList<String> hosp2)  {
		//communityList = new CommunityCollector();
		CommunityJFrame.loginFrame=loginFrame;
		this.communityList=communityList;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		communityManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommunityMangJPanel communitymanager = new CommunityMangJPanel(communityList);
				splitPane.setRightComponent(communitymanager);
				
			}
		});
		communityManage.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton commlogoutbtn = new JButton("Logout");
		commlogoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(true);
				
				dispose();
				
			}
		});
		commlogoutbtn.setForeground(UIManager.getColor("Button.darkShadow"));
		
		JButton searchcommbtn = new JButton("Search");
		searchcommbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommunitySearch communitysearch = new CommunitySearch(communityList,hosp1,hosp2);
				splitPane.setRightComponent(communitysearch);
				
			}
		});
		searchcommbtn.setBackground(UIManager.getColor("Button.darkShadow"));
		GroupLayout gl_controlAreacommunity = new GroupLayout(controlAreacommunity);
		gl_controlAreacommunity.setHorizontalGroup(
			gl_controlAreacommunity.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addContainerGap()
					.addComponent(createCommunity)
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(communityManage)
					.addContainerGap())
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addGap(41)
					.addComponent(commlogoutbtn)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addGap(32)
					.addComponent(searchcommbtn)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_controlAreacommunity.setVerticalGroup(
			gl_controlAreacommunity.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlAreacommunity.createSequentialGroup()
					.addGap(110)
					.addComponent(createCommunity)
					.addGap(43)
					.addComponent(communityManage)
					.addGap(35)
					.addComponent(searchcommbtn)
					.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
					.addComponent(commlogoutbtn)
					.addGap(47))
		);
		controlAreacommunity.setLayout(gl_controlAreacommunity);
		
		JPanel workAreacommunity = new JPanel();
		workAreacommunity.setBackground(UIManager.getColor("Desktop.background"));
		splitPane.setRightComponent(workAreacommunity);
	}
}
