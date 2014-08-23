package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Fachada.Fachada;
import Model.Maquina;
import Util.MaquinaTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarMaq {

	private JFrame frame;
	private JTable table;
	
	private Fachada fachada;
	private MaquinaTableModel maquinaTableModel;
	private List<Maquina> maquinas = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarMaq window = new ListarMaq();
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
	public ListarMaq() {
		initialize();
		fachada = new Fachada();
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maquinas = fachada.listar();
				maquinaTableModel = new MaquinaTableModel(maquinas);
				table.setModel(maquinaTableModel);
			}
		});
		btnListar.setBounds(234, 430, 89, 23);
		frame.getContentPane().add(btnListar);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 525, 364);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
