package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButtonMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Principal() {
		inicialize();
	}
	
	
	public void inicialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 438);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnMenu.add(mnCadastro);
		
		JMenuItem mntmCadastroDeMquinas = new JMenuItem("Cadastrar M\u00E1quina");
		mnCadastro.add(mntmCadastroDeMquinas);
		
		JMenuItem mntmCadastroDeTecnico = new JMenuItem("Cadastrar T\u00E9cnico");
		mntmCadastroDeTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		
		JMenuItem mntmCadastroDeEquipamento = new JMenuItem("Cadastrar Equipamento");
		mntmCadastroDeEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEquipamento cadEq = new CadastroEquipamento();
				cadEq.setLocationRelativeTo(null);
				cadEq.setVisible(true);
				dispose();
			}
		});
		mnCadastro.add(mntmCadastroDeEquipamento);
		mnCadastro.add(mntmCadastroDeTecnico);
		mntmCadastroDeMquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro telaCadastro= new Cadastro();
				telaCadastro.setLocationRelativeTo(null);
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		
		JMenu mnReltorio = new JMenu("Rel\u00E1torio");
		mnMenu.add(mnReltorio);
		
		JMenuItem mntmMaquina = new JMenuItem("M\u00E1quina");
		mnReltorio.add(mntmMaquina);
		
		JMenuItem mntmTcnico = new JMenuItem("T\u00E9cnico");
		mnReltorio.add(mntmTcnico);
		mnMenu.add(mntmSair);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblManagerpc = new JLabel("MACHINES MANAGER");
		lblManagerpc.setForeground(Color.WHITE);
		lblManagerpc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(72)
					.addComponent(lblManagerpc, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addComponent(lblManagerpc, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(264))
		);
		panel.setLayout(gl_panel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
