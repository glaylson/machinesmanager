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
import javax.swing.JTabbedPane;
import java.awt.Checkbox;
import javax.swing.JTextArea;

public class CadastroEquipamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataCompra;
	private JTextField txtDescricao;
	private JTable tableMaquinas;
	
	private Fachada fachada;
	private Maquina maquina;
	private MaquinaTableModel maquinaTableModel;
	private List<Maquina> maquinas = null;
	private JTextField txtIdmaquina;
	private JTextField txtPesquisa;
	private JTextField txtGarantia;
	private JTextField txtNumnf;

	
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
	public CadastroEquipamento() {
		
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
		maquina.setIdMaquina(Integer.parseInt(txtIdmaquina.getText()));
		fachada.excluir(maquina);
	}
	
	public void inserirMaquina(){
		maquina = new Maquina();
		maquina.setDescricao(txtDescricao.getText());
		maquina.setTipo(txtDataCompra.getText());
		fachada.inserir(maquina);
	}
	public void alterar(){
		maquina = new Maquina();
		maquina.setIdMaquina(Integer.parseInt(txtIdmaquina.getText()));
		maquina.setDescricao(txtDescricao.getText());
		maquina.setTipo(txtDataCompra.getText());
		fachada.alterar(maquina);
	}
	
	
	public void inicialize(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 883);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Equipamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 513, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDataCompra = new JLabel("Data da Compra:");
		lblDataCompra.setBounds(10, 65, 102, 14);
		panel.add(lblDataCompra);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(74, 21, 65, 14);
		panel.add(lblDescricao);
		
		txtDataCompra = new JTextField();
		txtDataCompra.setBounds(10, 83, 86, 20);
		panel.add(txtDataCompra);
		txtDataCompra.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(74, 38, 251, 20);
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
		btnSalvar.setBounds(159, 302, 89, 23);
		panel.add(btnSalvar);
		
		JLabel lblIdEquipamento = new JLabel("C\u00F3gido:");
		lblIdEquipamento.setBounds(10, 21, 65, 14);
		panel.add(lblIdEquipamento);
		
		txtIdmaquina = new JTextField();
		txtIdmaquina.setBounds(10, 38, 54, 20);
		panel.add(txtIdmaquina);
		txtIdmaquina.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			excluirMaquina();
			atualizarTabela();
			}
		});
		btnExcluir.setBounds(353, 302, 89, 23);
		panel.add(btnExcluir);
		
		final JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
				atualizarTabela();
			}
		});
		btnAlterar.setBounds(258, 302, 89, 23);
		panel.add(btnAlterar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdmaquina.setText("");
				txtDescricao.setText("");
				txtDataCompra.setText("");
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
				txtIdmaquina.setEditable(false);
			}
		});
		btnNovo.setBounds(57, 302, 89, 23);
		panel.add(btnNovo);
		
		JLabel lblDataDaGarantia = new JLabel("Data da Garantia:");
		lblDataDaGarantia.setBounds(139, 65, 109, 14);
		panel.add(lblDataDaGarantia);
		
		txtGarantia = new JTextField();
		txtGarantia.setBounds(139, 83, 86, 20);
		panel.add(txtGarantia);
		txtGarantia.setColumns(10);
		
		JLabel lblNmNotaFscal = new JLabel("N\u00FAm Nota F\u00EDscal:");
		lblNmNotaFscal.setBounds(258, 65, 109, 14);
		panel.add(lblNmNotaFscal);
		
		txtNumnf = new JTextField();
		txtNumnf.setBounds(258, 84, 86, 20);
		panel.add(txtNumnf);
		txtNumnf.setColumns(10);
		
		Checkbox checkboxDefeito = new Checkbox("Defeito");
		checkboxDefeito.setBounds(353, 38, 95, 22);
		panel.add(checkboxDefeito);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o:");
		lblObservao.setBounds(10, 108, 102, 14);
		panel.add(lblObservao);
		
		JTextArea txtrObs = new JTextArea();
		txtrObs.setBounds(10, 124, 493, 61);
		panel.add(txtrObs);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 533, 52);
		contentPane.add(panel_1);
		
		JLabel lblCadastroDeMquinas = new JLabel("Cadastro de Equipamentos");
		lblCadastroDeMquinas.setForeground(Color.WHITE);
		lblCadastroDeMquinas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.add(lblCadastroDeMquinas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "M\u00E1quinas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 410, 513, 390);
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
				txtIdmaquina.setText(tableMaquinas.getValueAt(linhaSelecionada, 0).toString());
				txtDescricao.setText(tableMaquinas.getValueAt(linhaSelecionada, 1).toString());
				txtDataCompra.setText(tableMaquinas.getValueAt(linhaSelecionada, 2).toString());
				btnSalvar.setEnabled(false);
				btnAlterar.setEnabled(true);
				txtIdmaquina.setEditable(true);
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
		btnVoltar.setBounds(10, 811, 89, 23);
		contentPane.add(btnVoltar);
	}
}
