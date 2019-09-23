package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import db.DB;

public class ProfessorDao {

	private Connection conexao;

	public void salvarProfessor_Bd(Professor p) {
		conexao = null;
		PreparedStatement st = null;

		try {
			st = conexao.prepareStatement(
					"INSERT INTO Professor " + "(Nome, Idade, CPF, Sexo, SIAPE) " + "VALUES " + "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, p.getNome());
			st.setInt(2, p.getIdade());
			st.setString(3, p.getCpf());
			st.setString(4, p.getSexo());
			st.setInt(5, p.getSiape());

			int linhaAlterada = st.executeUpdate();
			JOptionPane.showMessageDialog(null, "LInhas Alteradas: " + linhaAlterada);

			if (linhaAlterada > 0) {
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	public void atualizaProfessor(int id, Professor professor) {
		conexao = null;
		PreparedStatement st = null;

		try {
			st = conexao.prepareStatement(
					"UPDATE Professor SET Nome = ?, Idade = ?, CPF = ?, Sexo = ?, SIAPE = ? WHERE idProfessor = ?");

			st.setString(1, professor.getNome());
			st.setInt(2, professor.getIdade());
			st.setString(3, professor.getCpf());
			st.setString(4, professor.getSexo());
			st.setInt(5, professor.getSiape());
			st.setInt(6, id);

			int linhaAlterada = st.executeUpdate();
			JOptionPane.showMessageDialog(null, "LInhas Alteradas: " + linhaAlterada);

			if (linhaAlterada > 0) {
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	public void deleteProfessorByCpf(String cpf) {
		conexao = null;
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("DELETE FROM Professor WHERE CPF = ?");

			st.setString(1, cpf);

			int linhaAlterada = st.executeUpdate();
			JOptionPane.showMessageDialog(null, "LInhas Alteradas: " + linhaAlterada);

			if (linhaAlterada > 0) {
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	public void deletarByIdProfessor(Integer id) {
		conexao = null;
		PreparedStatement st = null;

		try {
			st = conexao.prepareStatement("DELETE FROM Professor WHERE Id = ?");

			st.setInt(1, id);

			int linhaAlterada = st.executeUpdate();
			JOptionPane.showMessageDialog(null, "LInhas Alteradas: " + linhaAlterada);

			if (linhaAlterada > 0) {
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	public void buscarTodos() throws SQLException {
		conexao = null;
		PreparedStatement st = null;
		
		st = conexao.prepareStatement("select * from ws_pessoas");

		ResultSet rs = st.executeQuery();
		String p = "";

		while (rs.next()) {
			int id = rs.getInt("IdProfessor");
			String nome = rs.getString("Nome");
			String tipo = rs.getString("Tipo");
			String cpf = rs.getString("CPF");
			p = p + "Id: " + id + " " + "Nome: " + nome + " " + "CPF: " + cpf + " " + "Tipo: " + tipo + "\n";

		}
		JOptionPane.showConfirmDialog(null, p);
		rs.close();
		st.close();
	}
}
