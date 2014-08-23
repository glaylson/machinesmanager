package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Fachada.Fachada;
import Model.Maquina;
import Util.MaquinaTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroMaquina extends JFrame {

	private JPanel contentPane;
	private JTextField txtTipo;
	private JTextField txtDescricao;
	private JTable tableMaquinas;
	
	private Fachada fachada;
	private Maquina maquina;
	private MaquinaTableModel maquinaTableModel;
	private List<Maquina> maquinas = null;
	private JTextField txtCodigo;
	private JTextField txtPesquisa;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMaquina window = new CadastroMaquina();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public CadastroMaquina() {
		
		inicialize();
		fachada = new Fachada();
		atualizarTabela();
	}
	
	public void atualizarTabela(){
		maquinas = fachada.listar();
		maquinaTableModel = new MaquinaTableModel(maquinas);
		tableMaquinas.setModel(maquinaTableModel);
	}
	public void pesquisaId(){
		maquina = new Maquina();
		try {
			maquina.setIdMaquina(Integer.parseInt(txtPesquisa.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Somente números neste campo.");
		}
	
		maquinas = fachada.pesquisarId(maquina);
		maquinaTableModel = new MaquinaTableModel(maquinas);
		tableMaquinas.setModel(maquinaTableModel);
	}
	public void excluirMaquina(){
		maquina = new Maquina();
		maquina.setIdMaquina(Integer.parseInt(txtCodigo.getText()));
		fachada.excluir(maquina);
	}
	
	public void inserirMaquina(){
		maquina = new Maquina();
		maquina.setDescricao(txtDescricao.getText());
		maquina.setTipo(txtTipo.getText());
		fachada.inserir(maquina);
	}
	public void alterar(){
		maquina = new Maquina();
		maquina.setIdMaquina(Integer.parseInt(txtCodigo.getText()));
		maquina.setDescricao(txtDescricao.getText());
		maquina.setTipo(txtTipo.getText());
		fachada.alterar(maquina);
	}
	
	
	public void inicialize(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da M\u00E1quina", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 513, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(348, 21, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(85, 21, 65, 14);
		panel.add(lblDescricao);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(348, 36, 155, 20);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(85, 36, 251, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inserirMaquina();
				atualizarTabela();
			}
		});
		btnSalvar.setBounds(163, 119, 89, 23);
		panel.add(btnSalvar);
		
		JLabel lblIdmaquina = new JLabel("C\u00F3digo:");
		lblIdmaquina.setBounds(10, 21, 65, 14);
		panel.add(lblIdmaquina);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 36, 54, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			excluirMaquina();
			atualizarTabela();
			}
		});
		btnExcluir.setBounds(357, 119, 89, 23);
		panel.add(btnExcluir);
		
		final JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
				atualizarTabela();
			}
		});
		btnAlterar.setBounds(262, 119, 89, 23);
		panel.add(btnAlterar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigo.setText("");
				txtDescricao.setText("");
				txtTipo.setText("");
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
				txtCodigo.setEditable(false);
			}
		});
		btnNovo.setBounds(61, 119, 89, 23);
		panel.add(btnNovo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 533, 52);
		contentPane.add(panel_1);
		
		JLabel lblCadastroDeMquinas = new JLabel("Cadastro de M\u00E1quinas");
		lblCadastroDeMquinas.setForeground(Color.WHITE);
		lblCadastroDeMquinas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.add(lblCadastroDeMquinas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "M\u00E1quinas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 227, 513, 390);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(10, 62, 493, 292);
		panel_2.add(scrollPaneTable);
		
		tableMaquinas = new JTable();
		tableMaquinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = tableMaquinas.getSelectedRow();
				int colunaSelecionada= tableMaquinas.getSelectedColumn();
				txtCodigo.setText(tableMaquinas.getValueAt(linhaSelecionada, 0).toString());
				txtDescricao.setText(tableMaquinas.getValueAt(linhaSelecionada, 1).toString());
				txtTipo.setText(tableMaquinas.getValueAt(linhaSelecionada, 2).toString());
				btnSalvar.setEnabled(false);
				btnAlterar.setEnabled(true);
				txtCodigo.setEditable(true);
			}

		});
		scrollPaneTable.setViewportView(tableMaquinas);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 31, 379, 20);
		panel_2.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaId();
			}
		});
		btnPesquisar.setBounds(399, 28, 104, 23);
		panel_2.add(btnPesquisar);
		
		JButton btnTodas = new JButton("Todas");
		btnTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarTabela();
			}
		});
		btnTodas.setBounds(203, 356, 89, 23);
		panel_2.add(btnTodas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 628, 89, 23);
		contentPane.add(btnVoltar);
	}
}
