import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Leitura_Informacoes {

	void leitura(int op, Dao d) throws SQLException {
		
		if (op == 1) {
			Aluno a = new Aluno();
			
			a.setNome("JOAO");// JOptionPane.showInputDialog("nome"));
			a.setIdade(15);//Integer.parseInt(JOptionPane.showInputDialog("idade")));
			a.setCpf("112982");//JOptionPane.showInputDialog("cpf"));
			a.setSexo("M");//JOptionPane.showInputDialog("sexo"));
			a.setRa(111);//Integer.parseInt(JOptionPane.showInputDialog("ra")));
			
			d.salvar(a);	
			d.salvarNoBd(a);
			
		} else {
			Professor p = new Professor();
			p.setNome(JOptionPane.showInputDialog("nome"));
			p.setIdade(Integer.parseInt(JOptionPane.showInputDialog("idade")));
			p.setCpf(JOptionPane.showInputDialog("cpf"));
			p.setSexo(JOptionPane.showInputDialog("sexo"));
			p.setSiape(Integer.parseInt(JOptionPane.showInputDialog("siape")));
			
			d.salvar(p);
			d.salvarNoBd(p);			
		}
	}
}