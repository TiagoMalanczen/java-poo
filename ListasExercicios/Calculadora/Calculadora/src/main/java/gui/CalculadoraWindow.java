package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculadoraWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtVisor;
	
	private JButton btnMS;
	private JButton btnMR;
	private JButton btnMC;
	private JButton btnC;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnDividir;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnMultiplicar;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnSubtrair;
	private JButton btn0;
	private JButton btnVirgula;
	private JButton btnIgual;
	private JButton btnSomar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraWindow frame = new CalculadoraWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalculadoraWindow() {
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Linha 1: MS, MR, MC, C
		btnMS = new JButton("MS");
		btnMS.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMS.setBounds(10, 90, 66, 48);
		contentPane.add(btnMS);
		
		btnMR = new JButton("MR");
		btnMR.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMR.setBounds(86, 90, 66, 48);
		contentPane.add(btnMR);
		
		btnMC = new JButton("MC");
		btnMC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMC.setBounds(162, 90, 66, 48);
		contentPane.add(btnMC);
		
		btnC = new JButton("C");
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnC.setBounds(238, 90, 66, 48);
		contentPane.add(btnC);
		
		// Linha 2: 7, 8, 9, /
		btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn7.setBounds(10, 149, 66, 48);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn8.setBounds(86, 149, 66, 48);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn9.setBounds(162, 149, 66, 48);
		contentPane.add(btn9);
		
		btnDividir = new JButton("/");
		btnDividir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDividir.setBounds(238, 149, 66, 48);
		contentPane.add(btnDividir);
		
		// Linha 3: 4, 5, 6, *
		btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn4.setBounds(10, 209, 66, 48);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn5.setBounds(86, 209, 66, 48);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn6.setBounds(162, 209, 66, 48);
		contentPane.add(btn6);
		
		btnMultiplicar = new JButton("*");
		btnMultiplicar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMultiplicar.setBounds(238, 209, 66, 48);
		contentPane.add(btnMultiplicar);
		
		// Linha 4: 1, 2, 3, -
		btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn1.setBounds(10, 268, 66, 48);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn2.setBounds(86, 268, 66, 48);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn3.setBounds(162, 268, 66, 48);
		contentPane.add(btn3);
		
		btnSubtrair = new JButton("-");
		btnSubtrair.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSubtrair.setBounds(238, 268, 66, 48);
		contentPane.add(btnSubtrair);
		
		// Linha 5: 0, ,, =, +
		btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn0.setBounds(10, 327, 66, 48);
		contentPane.add(btn0);
		
		btnVirgula = new JButton(",");
		btnVirgula.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVirgula.setBounds(86, 327, 66, 48);
		contentPane.add(btnVirgula);
		
		btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnIgual.setBounds(162, 327, 66, 48);
		contentPane.add(btnIgual);
		
		btnSomar = new JButton("+");
		btnSomar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSomar.setBounds(238, 327, 66, 48);
		contentPane.add(btnSomar);
		
		// Visor
		txtVisor = new JTextField();
		txtVisor.setBounds(10, 11, 294, 68);
		contentPane.add(txtVisor);
		txtVisor.setColumns(10);
	}
}