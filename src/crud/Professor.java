package crud;

public class Professor extends Pessoa{
	private int siape;
	
	public Professor(String nome, int idade, String cpf, String sexo, int siape) {
		super(nome, idade, cpf, sexo);
		this.siape = siape;
	}

	public Professor() {
		super();
	}

	public int getSiape() {
		return siape;
	}

	public void setSiape(int siape) {
		this.siape = siape;
	}
	
	public String toString() {
		
		String saida = "CPF: " +getCpf() +" - Idade: " +getIdade()
		+" - Sexo: " +getSexo() +" - Siape: " +getSiape() +"- Professor: " +getNome() +"\n";
		return saida;
	}
	
	
}
