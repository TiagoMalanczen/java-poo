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
	
	private JButton btnInformacao;
	private JButton btnAdvertencia;
	private JButton btnErro;
	private JButton btnQuestionamento;
	private JButton btnMensagem;
	
	private JButton btnCalcular;
	private JButton btnConfirmacao;


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

	public CaixasDialogo() {
		iniciarComponentes();
	}

	private void exibirMensagem() {
		JOptionPane.showMessageDialog(null, "Você tem uma mensagem", "Mensagem", JOptionPane.PLAIN_MESSAGE);
	}
	private void exibirMensagemInformacao() {
		JOptionPane.showMessageDialog(null, "Mensagem de informacao", "Informacao", JOptionPane.INFORMATION_MESSAGE);
	}

	private void exibirMensagemAdvertencia() {
		JOptionPane.showMessageDialog(null, "Mensagem de advertência", "Advertência", JOptionPane.WARNING_MESSAGE);
	}
	private void exibirMensagemErro() {
		JOptionPane.showMessageDialog(null, "Mensagem de Erro", "Erro", JOptionPane.ERROR_MESSAGE);
	}
	private void exibirMensagemQuestionamentto() {
		JOptionPane.showMessageDialog(null, "Mensagem de questionamento", "Questionamento", JOptionPane.QUESTION_MESSAGE);
	}
	private void excluir() {
		int result = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Excluido com sucesso", "Resultado", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Cancelado com sucesso", "Resultado", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	private void calcular() {
		String valor1 = JOptionPane.showInputDialog(null, "Informe o primeiro valor", "Valor 1", JOptionPane.QUESTION_MESSAGE);
		if(valor1 == null) return;
		String valor2 = JOptionPane.showInputDialog(null, "Informe o segundo valor", "Valor 2", JOptionPane.QUESTION_MESSAGE);
		if(valor2 == null) return;
		Double convertido1 = Double.parseDouble(valor1);
		Double convertido2 = Double.parseDouble(valor2);

		JOptionPane.showMessageDialog(null, convertido1+convertido2, "Soma",  JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, convertido1-convertido2, "Subtração",  JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, convertido1/convertido2, "Divisão",  JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, convertido1*convertido2, "Multiplicação",  JOptionPane.INFORMATION_MESSAGE);

	}
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnInformacao = new JButton("Informação");
		btnInformacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exibirMensagemInformacao();
			}

		});
		btnInformacao.setBounds(18, 84, 89, 23);
		contentPane.add(btnInformacao);
		
		btnAdvertencia = new JButton("Advertência");
		btnAdvertencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirMensagemAdvertencia();
			}

		});
		btnAdvertencia.setBounds(13, 108, 97, 23);
		contentPane.add(btnAdvertencia);
		
		btnErro = new JButton("Erro");
		btnErro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirMensagemErro();
			}

			
		});
		btnErro.setBounds(18, 59, 89, 23);
		contentPane.add(btnErro);
		
		btnQuestionamento = new JButton("Questionamento");
		btnQuestionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirMensagemQuestionamentto();
			}

			
		});
		btnQuestionamento.setBounds(-2, 10, 125, 23);
		contentPane.add(btnQuestionamento);
		
		btnMensagem = new JButton("Mensagem");
		btnMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirMensagem();
			}

			
		});
		btnMensagem.setBounds(4, 34, 117, 23);
		contentPane.add(btnMensagem);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalcular.setBounds(226, 10, 112, 47);
		contentPane.add(btnCalcular);
		
		btnConfirmacao = new JButton("Confirmação");
		btnConfirmacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluir();
			}
		});
		btnConfirmacao.setBounds(226, 108, 160, 79);
		contentPane.add(btnConfirmacao);
	}
}
