package Util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Maquina;

public class MaquinaTableModel extends AbstractTableModel{
	
	private List<Maquina> maquinas;
	
	public MaquinaTableModel(List<Maquina> maquinas){
		this.maquinas = maquinas;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.maquinas.size();
	}
	
	public String getColumnName(final int column){
		switch (column) {
		case 0:
			return "CÓDIGO";
		case 1:
			return "DESCIÇÃO";	
		case 2:
			return "TIPO";
		default:
			return "?";
		}
		
	}

	//Populando a tabela
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Maquina maquina = maquinas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return maquina.getIdMaquina();
		case 1:
			return maquina.getDescricao();	
		case 2:
			return maquina.getTipo();
		default:
			return null;
		}
	}
	
	public Maquina getMaquina(int rowIndex){
		Maquina maquina = maquinas.get(rowIndex);
		return maquina;
	}

}
