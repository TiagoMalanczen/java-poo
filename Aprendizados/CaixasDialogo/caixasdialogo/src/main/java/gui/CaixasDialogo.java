package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CaixasDialogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaixasDialogo frame = new CaixasDialogo();
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
	public CaixasDialogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInformacao = new JButton("Informação");
		btnInformacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Mensagem de informacao", "Informacao", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnInformacao.setBounds(33, 72, 89, 23);
		contentPane.add(btnInformacao);
		
		JButton btnAdvertencia = new JButton("Advertência");
		btnAdvertencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensagem de advertência", "Advertência", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnAdvertencia.setBounds(167, 72, 97, 23);
		contentPane.add(btnAdvertencia);
		
		JButton btnErro = new JButton("Erro");
		btnErro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensagem de Erro", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnErro.setBounds(301, 73, 89, 23);
		contentPane.add(btnErro);
		
		JButton btnQuestionamento = new JButton("Questionamento");
		btnQuestionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensagem de questionamento", "Questionamento", JOptionPane.QUESTION_MESSAGE);
			}
		});
		btnQuestionamento.setBounds(88, 154, 125, 23);
		contentPane.add(btnQuestionamento);
		
		JButton btnMensagem = new JButton("Mensagem");
		btnMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Você tem uma mensagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnMensagem.setBounds(234, 154, 117, 23);
		contentPane.add(btnMensagem);

	}
}
