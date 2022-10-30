package UI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import Model.Patient;
import Model.Person;
import Model.PersonDirectory;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;

public class PersonSignUpViewJPanel extends JPanel {
	private JTable table;
PersonDirectory personDirectory;
DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public PersonSignUpViewJPanel(PersonDirectory personDirectory) {
		setBackground(UIManager.getColor("Desktop.background"));
		this.personDirectory=personDirectory;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 44, 362, 171);
		add(scrollPane);
		
		model= new DefaultTableModel();
		Object[] column= {"Name","Age","Sex","Street","Aptno","Zipcode"};
		Object[] row= new Object[0];
		model.setColumnIdentifiers(column);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setBounds(25, 233, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(134, 233, 117, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(263, 233, 117, 29);
		add(btnNewButton_2);
		populatePersonDetails() ;

	}
	public void populatePersonDetails() {
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] column = new Object[6]; // just now added
		column[0]="Name";
		column[1]="Age";
		column[2]="Gender";
		column[3]="Street";
		column[4]="Aptno";
		column[5]="Zipcode";
		
		
		//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};//just commented.
		//Object[] row= new Object[0];
		//model.addColumn(column);
		
		
		for (Person prs: personDirectory.getPerson()) {
			//Object[] column= {"Name","EmplID","Gender","Position","TeamInfo"};
			
			Object[] row = new Object[7];
			row[0] = prs.getName();
			row[1]= prs.getAge();
			row[2]=prs.getSex();
			row[3]=prs.getStreet();
			row[4]=prs.getAptNumber();
			row[5]=prs.getZipcode();
			
		
			model.addRow(row);
		}
	}

}
