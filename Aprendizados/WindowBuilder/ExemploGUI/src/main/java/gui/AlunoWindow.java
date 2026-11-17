package gui;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class AlunoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenuItem itemSair;
	private JMenu menuAjuda;
	private JMenuItem itemSobre;
	
	private JLabel lblRegistroAcademico;
	private JTextField txtRegistroAcademico;
	private JLabel lblNome;
	private JTextField txtNome;
	
	private JPanel painelSexo;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JRadioButton rbNaoInformar;
	private ButtonGroup bgSexo;
	
	private JLabel lblCurso;
	private JComboBox<String> cbCurso;
	private JLabel lblDataIngresso;
	private JFormattedTextField txtDataIngresso;
	private JLabel lblPeriodo;
	private JSpinner spPeriodo;
	private JLabel lblCoeficiente;
	private JTextField txtCoeficiente;
	
	private JSeparator separator;
	private JButton btnCadastrar;
	private JButton btnLimparCampos;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	
	private JScrollPane scrollPane;
	private JTable tblAlunos;
	
	private MaskFormatter mascaraData;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				AlunoWindow frame = new AlunoWindow();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public void criarMascara() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public AlunoWindow() {
		this.criarMascara();
		this.iniciarComponentes();
	}

	private void iniciarComponentes() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 435);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		itemSair = new JMenuItem("Sair");
		menuArquivo.add(itemSair);
		
		menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		itemSobre = new JMenuItem("Sobre");
		menuAjuda.add(itemSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblRegistroAcademico = new JLabel("Registro Acadêmico");
		lblRegistroAcademico.setBounds(10, 11, 120, 14);
		contentPane.add(lblRegistroAcademico);
		
		txtRegistroAcademico = new JTextField();
		txtRegistroAcademico.setBounds(135, 8, 111, 20);
		contentPane.add(txtRegistroAcademico);
		txtRegistroAcademico.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 40, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 37, 368, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		painelSexo = new JPanel();
		painelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelSexo.setBounds(10, 68, 120, 92);
		painelSexo.setLayout(null);
		contentPane.add(painelSexo);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setSelected(true);
		rbMasculino.setBounds(6, 18, 100, 20);
		painelSexo.add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(6, 41, 100, 20);
		painelSexo.add(rbFeminino);
		
		rbNaoInformar = new JRadioButton("Não Informar");
		rbNaoInformar.setBounds(6, 64, 108, 20);
		painelSexo.add(rbNaoInformar);
		
		this.bgSexo = new ButtonGroup();
		this.bgSexo.add(rbMasculino);
		this.bgSexo.add(rbFeminino);
		this.bgSexo.add(rbNaoInformar);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(145, 72, 46, 14);
		contentPane.add(lblCurso);
		
		cbCurso = new JComboBox<>();
		cbCurso.setModel(new DefaultComboBoxModel<>(new String[] {
			"Análise e Desenvolvimento de Sistemas", 
			"Engenharia de Software", 
			"Ciência da Computação"
		}));
		cbCurso.setBounds(235, 68, 199, 22);
		contentPane.add(cbCurso);
		
		lblDataIngresso = new JLabel("Data de Ingresso");
		lblDataIngresso.setBounds(145, 108, 95, 14);
		contentPane.add(lblDataIngresso);
		
		txtDataIngresso = new JFormattedTextField(mascaraData);
		txtDataIngresso.setBounds(245, 105, 80, 20);
		contentPane.add(txtDataIngresso);
		
		lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(335, 108, 46, 14);
		contentPane.add(lblPeriodo);
		
		spPeriodo = new JSpinner();
		spPeriodo.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spPeriodo.setBounds(385, 105, 49, 20);
		contentPane.add(spPeriodo);
		
		lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setBounds(145, 143, 75, 14);
		contentPane.add(lblCoeficiente);
		
		txtCoeficiente = new JTextField();
		txtCoeficiente.setBounds(245, 140, 80, 20);
		contentPane.add(txtCoeficiente);
		txtCoeficiente.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 173, 424, 2);
		contentPane.add(separator);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 186, 95, 23);
		contentPane.add(btnCadastrar);
		
		btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.setBounds(130, 186, 125, 23);
		contentPane.add(btnLimparCampos);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(261, 186, 85, 23);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(352, 186, 82, 23);
		contentPane.add(btnExcluir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 424, 165);
		contentPane.add(scrollPane);
		
		tblAlunos = new JTable();
		tblAlunos.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"RA", "Nome", "Sexo", "Curso", "Data Início", "Período", "Coeficiente"
			}
		));
		scrollPane.setViewportView(tblAlunos);
	}
}