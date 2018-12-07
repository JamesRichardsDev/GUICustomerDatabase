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

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


					CustomerManagerFrame window = new CustomerManagerFrame();
					window.frame.setVisible(true);

			
					
					
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

		});
		btnAdd.setBounds(290, 366, 117, 29);
		frame.getContentPane().add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener((ActionEvent) -> {

		});
		btnEdit.setBounds(419, 366, 117, 29);
		frame.getContentPane().add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener((ActionEvent) -> {

		});
		btnDelete.setBounds(562, 366, 117, 29);
		frame.getContentPane().add(btnDelete);
		

		
	}

}
