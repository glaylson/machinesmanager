package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoSql;

public class EquipamentoDAO {
	private Connection connection = null;
	private PreparedStatement stmt;
	
	public  void inserir(Equipamento equipamento){
		String sql = "INSERT INTO EQUIPAMENTO (IDMAQUINA, DESCRICAO) VALUES (?,?,?)";
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setInt(1, equipamento.getIdMaquina());
			this.stmt.setString(2, equipamento.getDescricaoEquip());
			
			this.stmt.execute();
			this.stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public  void excluir(Tecnico tecnico){
		String sql = "DELETE FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?";
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setInt(1, tecnico.getIdFuncionario());
			
			this.stmt.execute();
			this.stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public  void alterar(Tecnico tecnico){
		String sql = "UPDATE FUNCIONARIO SET NOME = ?, TELEFONE = ?, CPF = ? WHERE IDFUNCIONARIO = ?";
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setString(1, tecnico.getNome());
			this.stmt.setString(2, tecnico.getTelefone());
			this.stmt.setString(3, tecnico.getCpf());
			
			this.stmt.execute();
			this.stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public List<Equipamento> listar(){
		String sql = "SELECT * FROM EQUIPAMENTO";
		ResultSet rs = null;
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		Equipamento equipamento = null;
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			
			rs = this.stmt.executeQuery();
			
			while(rs.next()){
				equipamento = new Equipamento();
				equipamento.setIdEquipamento(rs.getInt("idequipamento"));
				equipamento.setDescricaoEquip(rs.getString("descricaoequip"));
				
				equipamentos.add(equipamento);
			}
			this.stmt.close();
			rs.close();
			
			return equipamentos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public List<Equipamento> listarEquipComMaquina(){
		String sql = "select equipamento.idequipamento, equipamento.descricaoequip, maquina.idmaquina, maquina.descricaomaq from maquina, equipamento where equipamento.idmaquina = 2 and equipamento.idmaquina = maquina.idmaquina";
		ResultSet rs = null;
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		Equipamento equipamento = null;
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			
			rs = this.stmt.executeQuery();
			
			//set os valors para os atributos do objeto equipamento pegando os da tabela que é a consulta do sql acima.
			while(rs.next()){
				equipamento = new Equipamento();
				equipamento.setIdEquipamento(rs.getInt("idequipamento"));
				equipamento.setDescricaoEquip(rs.getString("descricaoequip"));
				equipamento.setIdMaquina(rs.getInt("idmaquina"));
				equipamento.setDescricaoMaq(rs.getString("descricaomaq"));
				equipamentos.add(equipamento);
			}
			this.stmt.close();
			rs.close();
			
			return equipamentos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	//falta ajeitar esse método.
	public List<Maquina> pesquisarId(Maquina maquina){
		String sql = "SELECT * FROM MAQUINA WHERE IDMAQUINA = "+ maquina.getIdMaquina()+"";
		ResultSet rs = null;
		List<Maquina> maquinas = new ArrayList<Maquina>();
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			
			rs = this.stmt.executeQuery();
			
			while(rs.next()){
				maquina = new Maquina();
				maquina.setIdMaquina(rs.getInt("idmaquina"));
				maquina.setDescricao(rs.getString("descricao"));
				maquina.setTipo(rs.getString("tipo"));
				maquinas.add(maquina);
			}
			this.stmt.close();
			rs.close();
			
			return maquinas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
  