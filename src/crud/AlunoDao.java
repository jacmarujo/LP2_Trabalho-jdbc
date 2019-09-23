package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import db.DB;

public class AlunoDao {

	private Connection conexao;

	public void salvarAluno_Bd(Aluno aluno) {
		Connection conexao = null;
		PreparedStatement st = null;
		try {
			conexao = DB.getConnetion();

			st = conexao.prepareStatement("insert into aluno (nome, idade, cpf, sexo, ra)" + "values (?,?,?,?,?)");
			st.setString(1, aluno.getNome());
			st.setInt(2, aluno.getIdade());
			st.setString(3, aluno.getCpf());
			st.setString(4, aluno.getSexo());
			st.setInt(5, aluno.getRa());

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

	public void atualizaAluno(int id, Aluno a) {
		Connection conexao = null;
		Aluno aluno = new Aluno();
		PreparedStatement st = null;
		try {
			conexao = DB.getConnetion();
			st = conexao.prepareStatement(
					"UPDATE aluno SET Nome = ?, Idade = ?, CPF = ?, Sexo = ?, RA = ? WHERE idAluno = ?");

			st.setString(1, aluno.getNome());
			st.setInt(2, aluno.getIdade());
			st.setString(3, aluno.getCpf());
			st.setString(4, aluno.getSexo());
			st.setInt(5, aluno.getRa());
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

	public void deleteAluno(String cpf) {
		conexao = null;
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("DELETE FROM Aluno WHERE CPF = ?");

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

	public void buscaNome(String nome) throws SQLException {
		PreparedStatement st = null;
		st = conexao.prepareStatement("select * from ws_pessoas where Nome = ?");
		st.setString(1, nome);
		ResultSet rs = st.executeQuery();
		String p = "";

		while (rs.next()) {
			int id = rs.getInt("idProfessor");
			nome = rs.getString("Nome");
			String tipo = rs.getString("Tipo");
			String cpf = rs.getString("CPF");
			p = p + "Id: " + id + " " + "Nome: " + nome + " " + "CPF: " + cpf + " " + "Tipo: " + tipo + "\n";

		}
		JOptionPane.showConfirmDialog(null, p);
		rs.close();
		st.close();

	}

}