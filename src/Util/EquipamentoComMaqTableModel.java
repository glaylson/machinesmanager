package Util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Equipamento;
import Model.Maquina;
import Model.Tecnico;

public class EquipamentoComMaqTableModel extends AbstractTableModel{
	
	private List<Equipamento> equipamentos;
	
	public EquipamentoComMaqTableModel(List<Equipamento> equipamentos){
		this.equipamentos = equipamentos;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.equipamentos.size();
	}
	
	public String getColumnName(final int column){
		switch (column) {
		case 0:
			return "CÓDIGO EQUIP";
		case 1:
			return "DESCRIÇÃO EQUIP";	
		case 2:
			return "CÓDIGO MAQUINA";
		case 3:
			return "DESCRIÇÃO MAQUINA";
		default:
			return "?";
		}
		
	}

	//Populando a tabela
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Equipamento equipamento = equipamentos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return equipamento.getIdEquipamento();
		case 1:
			return equipamento.getDescricaoEquip();
		case 2:
			return equipamento.getIdMaquina();
		case 3:
			return equipamento.getDescricaoMaq();
		default:
			return null;
		}
	}
	
	public Equipamento getEquipamento(int rowIndex){
		Equipamento equipamento = equipamentos.get(rowIndex);
		return equipamento;
	}

}
