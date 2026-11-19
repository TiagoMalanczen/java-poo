package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class SobreWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AlunoWindow alunoWindow;

	public SobreWindow(AlunoWindow alunoWindow) {
		this.alunoWindow = alunoWindow;
		this.iniciarComponentes();
	}

	private void iniciarComponentes() {
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Exemplo GUI");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 25, 304, 25);
		contentPane.add(lblTitulo);

		JLabel lblAutor = new JLabel("Prof. Vinícius Camargo Andrade");
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setBounds(10, 65, 304, 14);
		contentPane.add(lblAutor);

		JLabel lblInstituicao = new JLabel("Universidade Tecnológica Federal do Paraná");
		lblInstituicao.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstituicao.setBounds(10, 85, 304, 14);
		contentPane.add(lblInstituicao);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(e -> fecharJanela());
		btnOk.setBounds(117, 135, 89, 23);
		contentPane.add(btnOk);
	}

	private void fecharJanela() {
		this.dispose();
		this.alunoWindow.setVisible(true);
	}
}