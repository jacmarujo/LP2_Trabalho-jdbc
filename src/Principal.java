import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws SQLException {

		Principal p = new Principal();
		Dao d = new Dao();

		JOptionPane.showMessageDialog(null, "Bem vindos ao sistema!");
		d.listaPronta();
		int menu;
		do {
			menu = p.menu_1();
			switch (menu) {
			case 1:
				int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Aluno\n2 - Professor"));
				new Leitura_Informacoes().leitura(op, d);
				break;

			case 2:
				d.Exibir();
				break;

			case 3:
				String cpf = JOptionPane.showInputDialog("Digite o CPF que deseja remover");
				d.remover(cpf);
				break;

			case 4:
				JOptionPane.showMessageDialog(null, "Finalizando o Programa");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcao Invalida!");
			}
		} while (menu != 4);
	}

	int menu_1() {

		String menu = "1 - Salvar\n2 - Exibir Todos\n3 - Remover\n4 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(null, menu));
	}
}