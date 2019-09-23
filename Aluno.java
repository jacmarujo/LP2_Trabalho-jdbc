
public class Aluno extends Pessoa {
	
	private int ra;
	
	public Aluno() {
		super();
	}

	public Aluno(String nome, int idade, String cpf, String sexo, int ra) {
		super(nome, idade, cpf, sexo);
		this.ra = ra;
	}
	
	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}
	
	@Override
	public String toString() {
		String saida = "CPF: " +getCpf() +" - Idade: " +getIdade()
		+" - Sexo: " +getSexo() +" - RA: " +getRa() +" - Aluno: " +getNome() +"\n";
	
		return saida; 
	}

}
