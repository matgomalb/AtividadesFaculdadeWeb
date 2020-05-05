package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {

	private Connection conexao;
	
	//public PaisDAO() {}
	
	/*public PaisDAO (Connection conexao) {
		this.conexao = conexao;
	}*/
	
	public PaisDAO () {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public int insert (Pais pais) {
		System.out.println("Pais: " + pais.toString());
		PaisDAO dao = new PaisDAO();
		String inserir = "INSERT INTO Pais (id, nome, populacao, area_total)" + "VALUES(?,?,?,?)";
	
		try (PreparedStatement pst = conexao.prepareStatement(inserir)){
			System.out.println("Entrou inserir");
			pst.setInt(1, pais.getId());
			pst.setString(2, pais.getNome());
			pst.setLong(3, pais.getPopulacao());
			pst.setDouble(4, pais.getArea());
			pst.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conexao.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Pais Cadastrado!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao cadastrar o Pais");
		}	
		return pais.getId();
	}
	
	//SELECT
	public Pais select (Pais p) {
		Pais pais = null;
		String consulta = "SELECT id, nome, populacao, area_total FROM pais WHERE id = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(consulta)){
			System.out.println("ID DO PAIS: " + p.getId());
			pst.setInt(1, p.getId());
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				pais = new Pais();
				
				int idPais = resultado.getInt("id");
				String nome = resultado.getString("nome");
				long populacao = resultado.getLong("populacao");
				double area = resultado.getDouble("area_total");
				
				pais.setId(idPais);
				pais.setNome(nome);
				pais.setPopulacao(populacao);
				pais.setArea(area);
				System.out.println("Esse é o pais: " + pais.toString());
			}else {
				pais = new Pais();
				pais.setId(-1);
				pais.setNome(null);
				pais.setPopulacao(0);
				pais.setArea(0);
			}
			System.out.println("Consulta feita com sucesso");
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println("Falha na consulta");
		}
		System.out.println("PAIS  DO LADO DE FOR: " +pais);
		return pais;
	}
	
	//DELETE
	public void delete (int id) {
		String deleta = "DELETE pais FROM pais WHERE id = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(deleta)){
			pst.setInt(1, id);
			pst.execute();
			
			System.out.println("Pais excluido");
			
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Falha ao excluir o Pais");
		}
	}
	
	public void upDateNomePais (String pais, int id) {		
		String update = "UPDATE pais SET nome = ? WHERE id = ?";
			
		try (PreparedStatement pst = conexao.prepareStatement(update)){
			pst.setString(1, pais);
			pst.setInt(2, id);
			pst.execute();
				
			System.out.println("Atualizado com sucesso!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao atualizar");
		}
	}	
	
	public void update(Pais pais) {
		String sqlUpdate = "UPDATE cliente SET nome=?, SET populacao=?, SET area=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
