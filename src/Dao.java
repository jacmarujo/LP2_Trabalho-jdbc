import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class Dao {

	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

	public void listaPronta() {
		lista.add(new Aluno("JAC", 20, "112", "M", 7500));
		lista.add(new Aluno("JOANA", 25, "113", "F", 7501));
		lista.add(new Professor("JOSE", 40, "114", "M", 101010));
		lista.add(new Professor("MARIA", 35, "115", "F", 202020));
	}

	public void salvar(Pessoa p) {
		lista.add(p);
		JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
		JOptionPane.showMessageDialog(null, "Tamanho da lista: " + lista.size());
	}

	void Exibir() {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) instanceof Aluno) {
			}
			if (lista.get(i) instanceof Professor) {
			}
		}
		JOptionPane.showMessageDialog(null, lista + "\n");
	}

	public void remover(String cpf) {
		boolean removido = false;
		for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getCpf().equals(cpf)) {
			lista.remove(i);
			JOptionPane.showMessageDialog(null, "CPF Excluido com Sucesso!");
			removido = true;
                    } 
		}if (!removido) {
			JOptionPane.showMessageDialog(null, "CPF n�o encontrado!");
		}
	}
	
	public void salvarNoBd(Pessoa pessoa) throws SQLException{
		Connection conexao = null;
            try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/lp2", "root", "1311");
            String sql = "insert into aluno (idpessoa, nome, idade, cpf)" + "values (2, ?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setString(3, pessoa.getCpf());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
            	JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
            }
            } catch (SQLException ex) {
            	JOptionPane.showMessageDialog(null, ex.getMessage());
			}
	}
}
