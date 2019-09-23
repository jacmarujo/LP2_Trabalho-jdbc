package crud;

import javax.swing.JOptionPane;

public class LeituraInformacoes {

void leitura(int op) {
	
	if (op == 1) {
		Aluno a = new Aluno();
		AlunoDao aluD = new AlunoDao();
		
		a.setNome("JOAO");// JOptionPane.showInputDialog("nome"));
		a.setIdade(15);//Integer.parseInt(JOptionPane.showInputDialog("idade")));
		a.setCpf("112982");//JOptionPane.showInputDialog("cpf"));
		a.setSexo("M");//JOptionPane.showInputDialog("sexo"));
		a.setRa(111);//Integer.parseInt(JOptionPane.showInputDialog("ra")));
		
		aluD.salvarAluno_Bd(a);
		
	} else {
		Professor p = new Professor();
		ProfessorDao profD = new ProfessorDao();
		
		p.setNome(JOptionPane.showInputDialog("nome"));
		p.setIdade(Integer.parseInt(JOptionPane.showInputDialog("idade")));
		p.setCpf(JOptionPane.showInputDialog("cpf"));
		p.setSexo(JOptionPane.showInputDialog("sexo"));
		p.setSiape(Integer.parseInt(JOptionPane.showInputDialog("siape")));
		
		profD.salvarProfessor_Bd(p);
	}
}
}
