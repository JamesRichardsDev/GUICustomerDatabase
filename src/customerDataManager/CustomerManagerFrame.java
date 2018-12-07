package customerDataManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CustomerManagerFrame extends JFrame {

	private JFrame frame;
	private static JTable table;
	static DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManagerFrame window = new CustomerManagerFrame();
					window.frame.setVisible(true);

					model.addColumn("Email");
					model.addColumn("First Name");
					model.addColumn("Last Name");
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerManagerFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 763, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 751, 342);
		frame.getContentPane().add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JButton btnAdd = new JButton("Add");

		// When action button is clicked
		btnAdd.addActionListener((ActionEvent) -> {
			String email = 
					JOptionPane.showInputDialog(null,
							"Enter the Email",
							"New Customer Email",
							JOptionPane.QUESTION_MESSAGE
							);
			String first = 
					JOptionPane.showInputDialog(null,
							"Enter the First Name",
							"New Customer First Name",
							JOptionPane.QUESTION_MESSAGE
							);
			String last = 
					JOptionPane.showInputDialog(null,
							"Enter the Last Name",
							"New Customer Last Name",
							JOptionPane.QUESTION_MESSAGE
							);
			try {
				CustomerDB.AddCustomer(first, last, email);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		btnAdd.setBounds(290, 366, 117, 29);
		frame.getContentPane().add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener((ActionEvent) -> {
			String edit = 
					JOptionPane.showInputDialog(null,
							"What customer would you like to edit?",
							"Edit Customer",
							JOptionPane.QUESTION_MESSAGE
							);

		});
		btnEdit.setBounds(419, 366, 117, 29);
		frame.getContentPane().add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener((ActionEvent) -> {
			String delete = 
					JOptionPane.showInputDialog(null,
							"What customer would you like to delete?",
							"Delete Customer",
							JOptionPane.QUESTION_MESSAGE
							);

		});
		btnDelete.setBounds(562, 366, 117, 29);
		frame.getContentPane().add(btnDelete);
		

		
	}

}
