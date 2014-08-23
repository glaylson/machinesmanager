package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Fachada.Fachada;
import Model.Maquina;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadMaq {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtDescricao;
	
	private Fachada fachada;
	private Maquina maquina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadMaq window = new CadMaq();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadMaq() {
		initialize();
		this.fachada = new Fachada();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void inserir(){
		maquina = new Maquina();
		maquina.setTipo(txtNome.getText());
		maquina.setDescricao(txtDescricao.getText());
		fachada.inserir(maquina);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inserir();
			}
		});
		btnSalvar.setBounds(163, 200, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		txtNome = new JTextField();
		txtNome.setBounds(99, 41, 179, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(99, 83, 179, 20);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(10, 44, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblDescricao = new JLabel("descricao");
		lblDescricao.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblDescricao);
		JButton btnTeste = new JButton("teste");
		
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//teste
			}
		});
		btnTeste.setBounds(30, 200, 89, 23);
		frame.getContentPane().add(btnTeste);
	}
}
