package Model;

public class Equipamento {
	private String descricaoEquep;
	private int idEquipamento;
	private int idMaquina;
	private String descricaoMaq;

	public String getDescricaoMaq() {
		return descricaoMaq;
	}

	public void setDescricaoMaq(String descricaoMaq) {
		this.descricaoMaq = descricaoMaq;
	}

	public int getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getDescricaoEquip() {
		return descricaoEquep;
	}

	public void setDescricaoEquip(String descricao) {
		this.descricaoEquep = descricao;
	}
	
}
