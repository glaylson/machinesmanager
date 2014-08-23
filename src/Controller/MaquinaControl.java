package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Model.EquipamentoDAO;
import Model.Maquina;
import Model.MaquinaDAO;

public class MaquinaControl {

	private MaquinaDAO maquinaDAO;
	
	public MaquinaControl(){
		this.maquinaDAO = new MaquinaDAO();
	}
	
	public void inserir(Maquina maquina){
		if(maquina != null){
			maquinaDAO.inserir(maquina);
			JOptionPane.showMessageDialog(null, "M�quina cadastrada com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Campo referencia n�o pode ficar vazio");
		}
	}
	
	public List<Maquina> listar(){
		return maquinaDAO.listar();
	}
	
	public List<Maquina> pesquisarId(Maquina maquina){
		return maquinaDAO.pesquisarId(maquina);
	}
	
	public void alterar(Maquina maquina){
		maquinaDAO.alterar(maquina);
		JOptionPane.showMessageDialog(null, "M�quina alterada com sucesso");
	}
	
	public void exluir(Maquina maquina){
		maquinaDAO.excluir(maquina);
		JOptionPane.showMessageDialog(null, "M�quina excluida com sucesso!");
	}
	
	
	
}
