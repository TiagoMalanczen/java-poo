package all;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class ContactWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblContacts;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JLabel lblName;
	private JButton btnSave;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactWindow frame = new ContactWindow();
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
	public ContactWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoontactInformation = new JLabel("Contact Information");
		lblCoontactInformation.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblCoontactInformation.setBounds(21, 0, 280, 32);
		contentPane.add(lblCoontactInformation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 35, 497, 12);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(21, 58, 260, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		panel.add(lblName);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 47, 46, 14);
		panel.add(lblAddress);
		
		lblNewLabel = new JLabel("Phone");
		lblNewLabel.setBounds(10, 83, 46, 14);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(67, 8, 180, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(67, 44, 180, 20);
		panel.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(67, 80, 180, 20);
		panel.add(txtPhone);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(31, 182, 227, 50);
		contentPane.add(btnSave);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 58, 210, 213);
		contentPane.add(scrollPane);
		
		tblContacts = new JTable();
		scrollPane.setViewportView(tblContacts);
		tblContacts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Address", "Phone"
			}
		));

	}
}
