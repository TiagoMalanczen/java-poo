package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
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

import dto.AlunoDTO;
import dto.CursoDTO;
import service.AlunoService;
import service.CursoService;

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
	private JComboBox<CursoDTO> cbCurso;
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
	
	private CursoService cursoService;
	private AlunoService alunoService;
	
	public AlunoWindow() {
		this.criarMascara();
		this.iniciarComponentes();
		
		this.cursoService = new CursoService();
		this.alunoService = new AlunoService();
		
		this.buscarAlunos();
		this.BuscarCurso();
		this.limparComponentes();
	}

	private void limparComponentes() {
		this.txtRegistroAcademico.setText("");
		this.txtNome.setText("");
		this.rbNaoInformar.setSelected(true);
		this.cbCurso.setSelectedIndex(0);
		this.txtDataIngresso.setText("");
		this.spPeriodo.setValue(1);
		this.txtCoeficiente.setText("");
	}
	
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

	private void buscarAlunos() {
		List<AlunoDTO> listaAlunos = this.alunoService.buscarTodos();
		
		DefaultTableModel modelo = (DefaultTableModel) tblAlunos.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);
		
		for (AlunoDTO alunoDTO : listaAlunos) {
			modelo.addRow(new Object[] {
				alunoDTO.getRegistroAcademico(),
				alunoDTO.getNome(),
				alunoDTO.getSexo(),
				alunoDTO.getCursoDTO().getNome(),
				alunoDTO.getDataIngresso(),
				alunoDTO.getPeriodo(),
				alunoDTO.getCoeficiente()
			});
		}
	}
	
	private void BuscarCurso() {
		List<CursoDTO> listaCurso = this.cursoService.buscarTodos();
		
		for(CursoDTO cursoDTO : listaCurso) {
			this.cbCurso.addItem(cursoDTO);
		}
	}
	
	public void criarMascara() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void cadastrarAluno() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			AlunoDTO alunoDTO = new AlunoDTO();
			
			alunoDTO.setNome(this.txtNome.getText().trim());
			alunoDTO.setSexo(this.verificarSexo());
			alunoDTO.setRegistroAcademico(Integer.parseInt(txtRegistroAcademico.getText()));
			alunoDTO.setCursoDTO((CursoDTO) this.cbCurso.getSelectedItem());
			alunoDTO.setDataIngresso(new java.sql.Date(sdf.parse(this.txtDataIngresso.getText()).getTime()));
			alunoDTO.setCoeficiente(Integer.parseInt(txtCoeficiente.getText().trim()));
			alunoDTO.setPeriodo(Integer.parseInt(spPeriodo.getValue().toString()));
			
			int resultado = alunoService.cadastrar(alunoDTO);
			
			if(resultado > 0) {
				System.out.println("Aluno cadastrado com sucesso");
			}
			else {
				System.out.println("Não foi possível cadastrar um novo aluno");
			}
			
		} 
		catch (ParseException | NumberFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			buscarAlunos();
		}
	}
	private String verificarSexo() {
		if(rbMasculino.isSelected()) {
			return rbMasculino.getText().trim();
		} 
		else if (rbFeminino.isSelected()) {
			return rbFeminino.getText().trim();
		}
		else {
			return rbNaoInformar.getText().trim();
		}
	}
	
	private void atualizarAluno() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			AlunoDTO alunoDTO = new AlunoDTO();
			
			alunoDTO.setRegistroAcademico(Integer.parseInt(txtRegistroAcademico.getText().trim()));
			alunoDTO.setNome(this.txtNome.getText().trim());
			alunoDTO.setSexo(this.verificarSexo());
			alunoDTO.setCursoDTO((CursoDTO) this.cbCurso.getSelectedItem()); // Ajuste para setCurso se necessário
			alunoDTO.setDataIngresso(new java.sql.Date(sdf.parse(this.txtDataIngresso.getText()).getTime()));
			alunoDTO.setPeriodo(Integer.parseInt(this.spPeriodo.getValue().toString()));
			alunoDTO.setCoeficiente(Double.parseDouble(this.txtCoeficiente.getText().trim().replace(',', '.')));

			int resultado = alunoService.atualizar(alunoDTO);

			if (resultado > 0) {
				System.out.println("Cadastro Atualizado com Sucesso.");
			} else {
				System.out.println("Não foi possível atualizar o registro do aluno.");
			}
		} catch (ParseException | NumberFormatException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			this.buscarAlunos();
		}
	}
	
	private void excluirAluno() {
		try {
			int ra = Integer.parseInt(this.txtRegistroAcademico.getText().trim());
			int resultado = this.alunoService.excluir(ra);

			if (resultado > 0) {
				System.out.println("Aluno excluído com sucesso.");
			} else {
				System.out.println("Não foi possível excluir um aluno.");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			this.buscarAlunos();
		}
	}
	
	private void finalizarAplicacao() {
		System.exit(0);
	}
	
	private void abrirJanelaSobre() {
		SobreWindow janelaSobre = new SobreWindow(this);
		janelaSobre.setVisible(true);
		this.setVisible(false);
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
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalizarAplicacao();
			}
		});
		menuArquivo.add(itemSair);
		
		menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		itemSobre = new JMenuItem("Sobre");
		itemSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				abrirJanelaSobre();
			}
		});
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
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarAluno();
			}
		});
		btnCadastrar.setBounds(10, 186, 95, 23);
		contentPane.add(btnCadastrar);
		
		btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparComponentes();
			}
		});
		btnLimparCampos.setBounds(130, 186, 125, 23);
		contentPane.add(btnLimparCampos);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarAluno();
			}
		});
		btnAtualizar.setBounds(261, 186, 85, 23);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirAluno();
			}
		});
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