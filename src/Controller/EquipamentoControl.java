package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Model.Equipamento;
import Model.EquipamentoDAO;
import Model.Maquina;
import Model.MaquinaDAO;
import Model.Tecnico;
import Model.TecnicoDAO;

public class EquipamentoControl {

	private TecnicoDAO tecnicoDAO;
	private EquipamentoDAO equipamentoDAO;
	
	public EquipamentoControl(){
		this.equipamentoDAO = new EquipamentoDAO();
	}
	
	public void inserir(Equipamento equipamento){
		if(equipamento != null){
			equipamentoDAO.inserir(equipamento);
			JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Campo referencia não pode ficar vazio");
		}
	}
	
	public List<Equipamento> listar(){
		return equipamentoDAO.listar();
	}
	public List<Equipamento> listaEquipamentos(){
		return equipamentoDAO.listarEquipComMaquina();
	}
	
	public List<Maquina> pesquisarId(Maquina maquina){
		return tecnicoDAO.pesquisarId(maquina);
	}
	
	public void alterar(Tecnico tecnico){
		tecnicoDAO.alterar(tecnico);
		JOptionPane.showMessageDialog(null, "Técnico alterada com sucesso");
	}
	
	public void exluir(Tecnico tecnico){
		tecnicoDAO.excluir(tecnico);
		JOptionPane.showMessageDialog(null, "Técnico excluida com sucesso!");
	}
	
	
	
}
