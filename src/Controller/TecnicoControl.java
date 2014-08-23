package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Model.Maquina;
import Model.MaquinaDAO;
import Model.Tecnico;
import Model.TecnicoDAO;

public class TecnicoControl {

	private TecnicoDAO tecnicoDAO;
	
	public TecnicoControl(){
		this.tecnicoDAO = new TecnicoDAO();
	}
	
	public void inserir(Tecnico tecnico){
		if(tecnico != null){
			tecnicoDAO.inserir(tecnico);
			JOptionPane.showMessageDialog(null, "T�cnico cadastrada com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Campo referencia n�o pode ficar vazio");
		}
	}
	
	public List<Tecnico> listar(){
		return tecnicoDAO.listar();
	}
	
	public List<Maquina> pesquisarId(Maquina maquina){
		return tecnicoDAO.pesquisarId(maquina);
	}
	
	public void alterar(Tecnico tecnico){
		tecnicoDAO.alterar(tecnico);
		JOptionPane.showMessageDialog(null, "T�cnico alterada com sucesso");
	}
	
	public void exluir(Tecnico tecnico){
		tecnicoDAO.excluir(tecnico);
		JOptionPane.showMessageDialog(null, "T�cnico excluida com sucesso!");
	}
	
	
	
}
