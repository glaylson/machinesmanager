package Fachada;

import java.util.List;

import Controller.EquipamentoControl;
import Controller.MaquinaControl;
import Controller.TecnicoControl;
import Model.Equipamento;
import Model.Maquina;
import Model.Tecnico;

public class Fachada {
	private MaquinaControl maquinaControl;
	private TecnicoControl tecnicoControl;
	private EquipamentoControl equipamentoControl;
	
	public Fachada(){
		this.maquinaControl = new MaquinaControl();
		this.tecnicoControl = new TecnicoControl();
		this.equipamentoControl = new EquipamentoControl();
	}
	
	//metodos para maquinas
	public void inserir(Maquina maquina){
		this.maquinaControl.inserir(maquina);
	}
	public List<Maquina> listar(){
		return this.maquinaControl.listar();
	}
	public List<Maquina> pesquisarId(Maquina maquina){
		return this.maquinaControl.pesquisarId(maquina);
	}
	public void alterar(Maquina maquina){
		this.maquinaControl.alterar(maquina);
	}
	public void excluir(Maquina maquina){
		maquinaControl.exluir(maquina);
	}
	
	//metodos para tecnicos
	public void inserir(Tecnico tecnico){
		this.tecnicoControl.inserir(tecnico);
	}
	public List<Tecnico> listarTec(){
		return this.tecnicoControl.listar();
	}
	/*public List<Tecnico> pesquisarId(Tecnico tecnico){
		return this.tecnicoControl.pesquisarId(tecnico);
	}*/
	public void alterar(Tecnico tecnico){
		this.tecnicoControl.alterar(tecnico);
	}
	public void excluir(Tecnico tecnico){
		tecnicoControl.exluir(tecnico);
	}
	
	//metodos para equipamento
	public void inserir(Equipamento equipamento){
		this.equipamentoControl.inserir(equipamento);
	}
	public List<Equipamento> listarEquip(){
		return this.equipamentoControl.listar();
	}
	public List<Equipamento> listarEquipComMaquina(){
		return this.equipamentoControl.listaEquipamentos();
	}
	/*public List<Tecnico> pesquisarId(Tecnico tecnico){
		return this.tecnicoControl.pesquisarId(tecnico);
	}*/
	/*
	public void alterar(Tecnico tecnico){
		this.tecnicoControl.alterar(tecnico);
	}
	public void excluir(Tecnico tecnico){
		tecnicoControl.exluir(tecnico);
	}
	*/
}
