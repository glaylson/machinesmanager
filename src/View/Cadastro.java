package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import Fachada.Fachada;
import Model.Equipamento;
import Model.Maquina;
import Model.Tecnico;
import Util.EquipamentoComMaqTableModel;
import Util.MaquinaTableModel;
import Util.TecnicosTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.DebugGraphics;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTable;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTipoMaq;
	private JTextField txtDescricaoMaq;
	private JTextField txtCodigoMaq;
	private JTextField txtPesquisaMaq;
	private JTable tableMaquinas;
	
	private Fachada fachada;
	private Maquina maquina;
	private Tecnico tecnico;
	private Equipamento equipamento;
	private List<Equipamento> equipamentos = null;
	private List<Maquina> maquinas = null;
	private List<Tecnico> tecnicos = null;
	
	private MaquinaTableModel maquinaTableModel;
	private TecnicosTableModel tecnicoTableModel;
	private EquipamentoComMaqTableModel equipamentoTableModel;
	
	private JTextField txtCpfTec;
	private JTextField txtNomeTec;
	private JTextField txtCodigoTec;
	private JTextField txtFoneTec;
	private JTextField txtPesquisaTec;
	private JTable tableTec;
	private JTextField textField;
	private JTextField txtDescricaoEquip;
	private JTextField txtCodigoEquip;
	private JTextField textField_3;
	private JTable tableEquipamento;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicialize();
		fachada = new Fachada();
		atualizarTabelaMaquina();
		atualizarTabelaTecnicos();
		atualizarTabelaEquipamento();
		
	}
	
	//Funções Maquinas
	public void atualizarTabelaMaquina(){
		maquinas = fachada.listar(); // maquinas recebe uma lista de maquinas que vem referencido lá da maquinaDAO.
		maquinaTableModel = new MaquinaTableModel(maquinas);
		tableMaquinas.setModel(maquinaTableModel);
	}
	public void pesquisaIdMaquina(){
		maquina = new Maquina();
		try {
			maquina.setIdMaquina(Integer.parseInt(txtPesquisaMaq.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Somente números neste campo.");
		}
	
		maquinas = fachada.pesquisarId(maquina);
		maquinaTableModel = new MaquinaTableModel(maquinas);
		tableMaquinas.setModel(maquinaTableModel);
	}
	public void excluirMaquina(){
		maquina = new Maquina();
		maquina.setIdMaquina(Integer.parseInt(txtCodigoMaq.getText()));
		fachada.excluir(maquina);
	}
	
	public void inserirMaquina(){
		maquina = new Maquina();
		maquina.setDescricao(txtDescricaoMaq.getText());
		maquina.setTipo(txtTipoMaq.getText());
		fachada.inserir(maquina);
	}
	public void alterarMaquina(){
		maquina = new Maquina();
		maquina.setIdMaquina(Integer.parseInt(txtCodigoMaq.getText()));
		maquina.setDescricao(txtDescricaoMaq.getText());
		maquina.setTipo(txtTipoMaq.getText());
		fachada.alterar(maquina);
	}
	
	
	
	//Funções Tecnicos
	/*public void pesquisaIdTecnicos(){
		maquina = new Maquina();
		try {
			maquina.setIdMaquina(Integer.parseInt(txtPesquisaMaq.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Somente números neste campo.");
		}
	
		maquinas = fachada.pesquisarId(maquina);
		maquinaTableModel = new MaquinaTableModel(maquinas);
		tableMaquinas.setModel(maquinaTableModel);
	}*/
	public void excluirTecnicos(){
		tecnico = new Tecnico();
		tecnico.setIdFuncionario(Integer.parseInt(txtCodigoTec.getText()));
		fachada.excluir(tecnico);
	}
	
	public void inserirTecnicos(){
		tecnico = new Tecnico();
		tecnico.setNome(txtNomeTec.getText());
		tecnico.setTelefone(txtFoneTec.getText());
		tecnico.setCpf(txtCpfTec.getText());
		fachada.inserir(tecnico);
	}
	public void alterarTecnicos(){
		tecnico = new Tecnico();
		tecnico.setIdFuncionario(Integer.parseInt(txtCodigoTec.getText()));
		tecnico.setNome(txtNomeTec.getText());
		tecnico.setTelefone(txtFoneTec.getText());
		tecnico.setCpf(txtCpfTec.getText());
		fachada.alterar(tecnico);
	}
	public void atualizarTabelaTecnicos(){
		tecnicos = fachada.listarTec();
		tecnicoTableModel = new TecnicosTableModel(tecnicos);
		tableTec.setModel(tecnicoTableModel);
	}
	
	//Funções Equipamentos
	public void atualizarTabelaEquipamento(){
		equipamentos = fachada.listarEquipComMaquina();
		equipamentoTableModel = new EquipamentoComMaqTableModel(equipamentos);
		tableEquipamento.setModel(equipamentoTableModel);
	}

	
	/**
	 * Create the frame.
	 */
	
	public void inicialize(){
		setBounds(100, 100, 608, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 67, 563, 668);
		contentPane.add(tabbedPane);
		
		JPanel panelMaquina = new JPanel();
		tabbedPane.addTab("M\u00E1quina", null, panelMaquina, null);
		panelMaquina.setLayout(null);
		
		JPanel panelDadosMaquinas = new JPanel();
		panelDadosMaquinas.setLayout(null);
		panelDadosMaquinas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da M\u00E1quina", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDadosMaquinas.setBounds(22, 11, 513, 153);
		panelMaquina.add(panelDadosMaquinas);
		
		JLabel label = new JLabel("Tipo:");
		label.setBounds(348, 21, 46, 14);
		panelDadosMaquinas.add(label);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setBounds(85, 21, 65, 14);
		panelDadosMaquinas.add(label_1);
		
		txtTipoMaq = new JTextField();
		txtTipoMaq.setColumns(10);
		txtTipoMaq.setBounds(348, 36, 155, 20);
		panelDadosMaquinas.add(txtTipoMaq);
		
		txtDescricaoMaq = new JTextField();
		txtDescricaoMaq.setColumns(10);
		txtDescricaoMaq.setBounds(85, 36, 251, 20);
		panelDadosMaquinas.add(txtDescricaoMaq);
		
		final JButton btnSalvarMaq = new JButton("Salvar");
		btnSalvarMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirMaquina();
				atualizarTabelaMaquina();
			}
		});
		btnSalvarMaq.setEnabled(false);
		btnSalvarMaq.setBounds(163, 119, 89, 23);
		panelDadosMaquinas.add(btnSalvarMaq);
		
		JLabel label_2 = new JLabel("C\u00F3digo:");
		label_2.setBounds(10, 21, 65, 14);
		panelDadosMaquinas.add(label_2);
		
		txtCodigoMaq = new JTextField();
		txtCodigoMaq.setColumns(10);
		txtCodigoMaq.setBounds(10, 36, 54, 20);
		panelDadosMaquinas.add(txtCodigoMaq);
		
		JButton btnExcluirMaq = new JButton("Excluir");
		btnExcluirMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirMaquina();
				atualizarTabelaMaquina();
			}
		});
		btnExcluirMaq.setBounds(357, 119, 89, 23);
		panelDadosMaquinas.add(btnExcluirMaq);
		
		final JButton btnAlterarMaq = new JButton("Alterar");
		btnAlterarMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarMaquina();
				atualizarTabelaMaquina();
			}
		});
		btnAlterarMaq.setBounds(262, 119, 89, 23);
		panelDadosMaquinas.add(btnAlterarMaq);
		
		JButton btnNovoMaq = new JButton("Novo");
		btnNovoMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigoMaq.setText("");
				txtDescricaoMaq.setText("");
				txtTipoMaq.setText("");
				btnSalvarMaq.setEnabled(true);
				btnAlterarMaq.setEnabled(false);
				txtCodigoMaq.setEditable(false);
			}
		});
		btnNovoMaq.setBounds(61, 119, 89, 23);
		panelDadosMaquinas.add(btnNovoMaq);
		
		JPanel panelMaquinas = new JPanel();
		panelMaquinas.setLayout(null);
		panelMaquinas.setBorder(new TitledBorder(null, "M\u00E1quinas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMaquinas.setBounds(22, 175, 513, 403);
		panelMaquina.add(panelMaquinas);
		
		JScrollPane scrollPaneMaq = new JScrollPane();
		scrollPaneMaq.setBounds(10, 62, 493, 302);
		panelMaquinas.add(scrollPaneMaq);
		
		tableMaquinas = new JTable();
		tableMaquinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = tableMaquinas.getSelectedRow();
				int colunaSelecionada= tableMaquinas.getSelectedColumn();
				txtCodigoMaq.setText(tableMaquinas.getValueAt(linhaSelecionada, 0).toString());
				txtDescricaoMaq.setText(tableMaquinas.getValueAt(linhaSelecionada, 1).toString());
				txtTipoMaq.setText(tableMaquinas.getValueAt(linhaSelecionada, 2).toString());
				btnSalvarMaq.setEnabled(false);
				btnAlterarMaq.setEnabled(true);
				txtCodigoMaq.setEditable(true);
			}
		});
		scrollPaneMaq.setViewportView(tableMaquinas);
		
		txtPesquisaMaq = new JTextField();
		txtPesquisaMaq.setColumns(10);
		txtPesquisaMaq.setBounds(10, 31, 379, 20);
		panelMaquinas.add(txtPesquisaMaq);
		
		JButton btnPesquisarMaq = new JButton("Pesquisar");
		btnPesquisarMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaIdMaquina();
			}
		});
		btnPesquisarMaq.setBounds(399, 28, 104, 23);
		panelMaquinas.add(btnPesquisarMaq);
		
		JButton btnTodasMaq = new JButton("Todas");
		btnTodasMaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaMaquina();
			}
		});
		btnTodasMaq.setBounds(203, 369, 89, 23);
		panelMaquinas.add(btnTodasMaq);
		
		JPanel panelEquipamento = new JPanel();
		tabbedPane.addTab("Equipamento", null, panelEquipamento, null);
		panelEquipamento.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Equipamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(23, 11, 513, 153);
		panelEquipamento.add(panel_1);
		
		JLabel label_3 = new JLabel("Tipo:");
		label_3.setBounds(348, 21, 46, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Descri\u00E7\u00E3o:");
		label_4.setBounds(85, 21, 65, 14);
		panel_1.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(348, 36, 155, 20);
		panel_1.add(textField);
		
		txtDescricaoEquip = new JTextField();
		txtDescricaoEquip.setColumns(10);
		txtDescricaoEquip.setBounds(85, 36, 251, 20);
		panel_1.add(txtDescricaoEquip);
		
		JButton button = new JButton("Salvar");
		button.setEnabled(false);
		button.setBounds(163, 119, 89, 23);
		panel_1.add(button);
		
		JLabel label_5 = new JLabel("C\u00F3digo:");
		label_5.setBounds(10, 21, 65, 14);
		panel_1.add(label_5);
		
		txtCodigoEquip = new JTextField();
		txtCodigoEquip.setColumns(10);
		txtCodigoEquip.setBounds(10, 36, 54, 20);
		panel_1.add(txtCodigoEquip);
		
		JButton button_1 = new JButton("Excluir");
		button_1.setBounds(357, 119, 89, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Alterar");
		button_2.setBounds(262, 119, 89, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Novo");
		button_3.setBounds(61, 119, 89, 23);
		panel_1.add(button_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(348, 67, 28, 20);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "M\u00E1quinas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(23, 175, 513, 403);
		panelEquipamento.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 493, 302);
		panel_2.add(scrollPane);
		
		tableEquipamento = new JTable();
		scrollPane.setViewportView(tableEquipamento);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 31, 379, 20);
		panel_2.add(textField_3);
		
		JButton button_4 = new JButton("Pesquisar");
		button_4.setBounds(399, 28, 104, 23);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Todas");
		button_5.setBounds(203, 369, 89, 23);
		panel_2.add(button_5);
		
		JPanel panelTecnico = new JPanel();
		tabbedPane.addTab("Tecnico", null, panelTecnico, null);
		panelTecnico.setLayout(null);
		
		JPanel panelDadosTecnico = new JPanel();
		panelDadosTecnico.setLayout(null);
		panelDadosTecnico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDadosTecnico.setBounds(24, 11, 513, 153);
		panelTecnico.add(panelDadosTecnico);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(348, 21, 46, 14);
		panelDadosTecnico.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(85, 21, 65, 14);
		panelDadosTecnico.add(lblNome);
		
		txtCpfTec = new JTextField();
		txtCpfTec.setColumns(10);
		txtCpfTec.setBounds(348, 36, 155, 20);
		panelDadosTecnico.add(txtCpfTec);
		
		txtNomeTec = new JTextField();
		txtNomeTec.setColumns(10);
		txtNomeTec.setBounds(85, 36, 251, 20);
		panelDadosTecnico.add(txtNomeTec);
		
		final JButton btnSalvarTec = new JButton("Salvar");
		btnSalvarTec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inserirTecnicos();
				atualizarTabelaTecnicos();
			}
		});
		btnSalvarTec.setEnabled(false);
		btnSalvarTec.setBounds(163, 119, 89, 23);
		panelDadosTecnico.add(btnSalvarTec);
		
		JLabel label_6 = new JLabel("C\u00F3digo:");
		label_6.setBounds(10, 21, 65, 14);
		panelDadosTecnico.add(label_6);
		
		txtCodigoTec = new JTextField();
		txtCodigoTec.setColumns(10);
		txtCodigoTec.setBounds(10, 36, 54, 20);
		panelDadosTecnico.add(txtCodigoTec);
		
		JButton btnExcluirTec = new JButton("Excluir");
		btnExcluirTec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirTecnicos();
				atualizarTabelaTecnicos();
			}
		});
		btnExcluirTec.setBounds(357, 119, 89, 23);
		panelDadosTecnico.add(btnExcluirTec);
		
		final JButton btnAlterarTec = new JButton("Alterar");
		btnAlterarTec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarTecnicos();
				atualizarTabelaTecnicos();
			}
		});
		btnAlterarTec.setBounds(262, 119, 89, 23);
		panelDadosTecnico.add(btnAlterarTec);
		
		JButton btnNovoTec = new JButton("Novo");
		btnNovoTec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigoTec.setText("");
				txtNomeTec.setText("");
				txtCpfTec.setText("");
				txtFoneTec.setText("");
				btnSalvarTec.setEnabled(true);
				btnAlterarTec.setEnabled(false);
				txtCodigoTec.setEditable(false);
			}
		});
		btnNovoTec.setBounds(61, 119, 89, 23);
		panelDadosTecnico.add(btnNovoTec);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 67, 80, 14);
		panelDadosTecnico.add(lblTelefone);
		
		txtFoneTec = new JTextField();
		txtFoneTec.setColumns(10);
		txtFoneTec.setBounds(10, 82, 114, 20);
		panelDadosTecnico.add(txtFoneTec);
		
		JPanel panelTecnicos = new JPanel();
		panelTecnicos.setLayout(null);
		panelTecnicos.setBorder(new TitledBorder(null, "M\u00E1quinas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTecnicos.setBounds(24, 175, 513, 403);
		panelTecnico.add(panelTecnicos);
		
		JScrollPane scrollPaneTec = new JScrollPane();
		scrollPaneTec.setBounds(10, 62, 493, 302);
		panelTecnicos.add(scrollPaneTec);
		
		tableTec = new JTable();
		tableTec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = tableTec.getSelectedRow();
				int colunaSelecionada= tableTec.getSelectedColumn();
				txtCodigoTec.setText(tableTec.getValueAt(linhaSelecionada, 0).toString());
				txtNomeTec.setText(tableTec.getValueAt(linhaSelecionada, 1).toString());
				txtCpfTec.setText(tableTec.getValueAt(linhaSelecionada, 2).toString());
				txtFoneTec.setText(tableTec.getValueAt(linhaSelecionada, 3).toString());
				btnSalvarTec.setEnabled(false);
				btnAlterarTec.setEnabled(true);
				txtCodigoTec.setEditable(true);
			}
		});
		scrollPaneTec.setViewportView(tableTec);
		
		txtPesquisaTec = new JTextField();
		txtPesquisaTec.setColumns(10);
		txtPesquisaTec.setBounds(10, 31, 379, 20);
		panelTecnicos.add(txtPesquisaTec);
		
		JButton btnPesquisaTec = new JButton("Pesquisar");
		btnPesquisaTec.setBounds(399, 28, 104, 23);
		panelTecnicos.add(btnPesquisaTec);
		
		JButton btnTodosTec = new JButton("Todas");
		btnTodosTec.setBounds(203, 369, 89, 23);
		panelTecnicos.add(btnTodosTec);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 592, 52);
		contentPane.add(panel);
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setForeground(Color.WHITE);
		lblCadastros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblCadastros);
		
		JButton button_6 = new JButton("Voltar");
		button_6.setBounds(10, 737, 89, 23);
		contentPane.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				dispose();
			}
		});
	}
}
