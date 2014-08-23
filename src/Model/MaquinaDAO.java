package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoSql;

public class MaquinaDAO {
	private Connection connection = null;
	private PreparedStatement stmt;
	
	public  void inserir(Maquina maquina){
		String sql = "INSERT INTO MAQUINA (DESCRICAO, TIPO) VALUES (?,?)";
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setString(1, maquina.getDescricao());
			this.stmt.setString(2, maquina.getTipo());
			
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
	
	public  void excluir(Maquina maquina){
		String sql = "DELETE FROM MAQUINA WHERE IDMAQUINA = ?";
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setInt(1, maquina.getIdMaquina());
			
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
	
	public  void alterar(Maquina maquina){
		String sql = "UPDATE MAQUINA SET TIPO = ?, DESCRICAO = ? WHERE IDMAQUINA = ?";
		try {
			this.connection = new ConexaoSql().getConnection();
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setString(1, maquina.getTipo());
			this.stmt.setString(2, maquina.getDescricao());
			this.stmt.setInt(3, maquina.getIdMaquina());
			
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
	
	public List<Maquina> listar(){
		String sql = "SELECT * FROM MAQUINA";
		ResultSet rs = null;
		List<Maquina> maquinas = new ArrayList<Maquina>();
		Maquina maquina = null;
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
  