package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoSql;

public class TecnicoDAO {
	private Connection connection = null;
	private PreparedStatement stmt;
	
	public  void inserir(Tecnico tecnico){
		String sql = "INSERT INTO FUNCIONARIO (NOME, TELEFONE, CPF) VALUES (?,?,?)";
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
	
	public List<Tecnico> listar(){
		String sql = "SELECT * FROM FUNCIONARIO";
		ResultSet rs = null;
		List<Tecnico> tecnicos = new ArrayList<Tecnico>();
		Tecnico tecnico = null;
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			
			rs = this.stmt.executeQuery();
			
			while(rs.next()){
				tecnico = new Tecnico();
				tecnico.setIdFuncionario(rs.getInt("idfuncionario"));
				tecnico.setNome(rs.getString("nome"));
				tecnico.setCpf(rs.getString("cpf"));
				tecnico.setTelefone(rs.getString("telefone"));
				tecnicos.add(tecnico);
			}
			this.stmt.close();
			rs.close();
			
			return tecnicos;
			
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
	
	//falta ajeitar esse m�todo.
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
  