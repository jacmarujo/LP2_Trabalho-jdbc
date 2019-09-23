package crud;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Principal p = new Principal();
		Aluno a = new Aluno();
		AlunoDao AluD = new AlunoDao();
		ProfessorDao PrfD = new ProfessorDao();

		JOptionPane.showMessageDialog(null, "Bem vindos ao sistema!");
		
		int menu;
		do {
			menu = p.menu_1();

			switch (menu) {
			case 1:
				int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Aluno\n2 - Professor"));
					switch (op) {
					case 1:
						new LeituraInformacoes().leitura(op);							
						break;
					case 2:
						new LeituraInformacoes().leitura(op);							
						break;
					default:
						break;
					}
				break;
			case 2:
				op = Integer.parseInt(JOptionPane.showInputDialog("1 - Aluno\n2 - Professor"));
				switch (op) {
				case 1:
					String nome = JOptionPane.showInputDialog("Digite o nome do Aluno?");
					AluD.buscaNome(nome);									
					break;
				case 2:
					nome = JOptionPane.showInputDialog("Digite o nome do Professor?");
					AluD.buscaNome(nome);								
					break;
				default:
					break;
				}
				break;

			case 3:
				String cpf = JOptionPane.showInputDialog("Digite o CPF que deseja remover");
				AluD.deleteAluno(cpf);
				break;

			case 4:
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id para atualizar"));
				AluD.atualizaAluno(id);
				JOptionPane.showMessageDialog(null, "Finalizando o Programa");
				break;
	
			case 5:
				JOptionPane.showMessageDialog(null, "Finalizando o Programa");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcao Invalida!");
			}
		} while (menu != 5);
	}

	int menu_1() {

		String menu = "1 - Salvar\n2 - Buscar\n3 - Deletar\n4 - Alterar\n5 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(null, menu));
	}
}
