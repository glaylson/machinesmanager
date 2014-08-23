package Util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Maquina;
import Model.Tecnico;

public class TecnicosTableModel extends AbstractTableModel{
	
	private List<Tecnico> tecnicos;
	
	public TecnicosTableModel(List<Tecnico> tecnicos){
		this.tecnicos = tecnicos;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.tecnicos.size();
	}
	
	public String getColumnName(final int column){
		switch (column) {
		case 0:
			return "CÓDIGO";
		case 1:
			return "NOME";	
		case 2:
			return "CPF";
		case 3:
			return "TELEFONE";
		default:
			return "?";
		}
		
	}

	//Populando a tabela
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tecnico tecnico = tecnicos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tecnico.getIdFuncionario();
		case 1:
			return tecnico.getNome();
		case 2:
			return tecnico.getCpf();
		case 3:
			return tecnico.getTelefone();
		default:
			return null;
		}
	}
	
	public Tecnico getTecnico(int rowIndex){
		Tecnico tecnico = tecnicos.get(rowIndex);
		return tecnico;
	}

}
