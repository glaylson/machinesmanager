package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Fachada.Fachada;
import Model.Maquina;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterMaq {

	private JFrame frame;
	
	private Fachada fachada;
	private Maquina maquina;
	private JTextField txtIdmaquina;
	private JTextField txtNome;
	private JTextField txtDescricao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterMaq window = new AlterMaq();
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
	public AlterMaq() {
		initialize();
		this.fachada = new Fachada();
	}

	
	public void alterar(){
		maquina = new Maquina();
		maquina.setIdMaquina(Integer.parseInt(txtIdmaquina.getText()));
		maquina.setTipo(txtNome.getText());
		maquina.setDescricao(txtDescricao.getText());
		fachada.alterar(maquina);
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 18, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 49, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 82, 67, 14);
		frame.getContentPane().add(lblDescricao);
		
		txtIdmaquina = new JTextField();
		txtIdmaquina.setBounds(81, 15, 46, 20);
		frame.getContentPane().add(txtIdmaquina);
		txtIdmaquina.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(81, 46, 165, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(81, 79, 165, 20);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btnAlterar.setBounds(165, 217, 89, 23);
		frame.getContentPane().add(btnAlterar);
	}
}
