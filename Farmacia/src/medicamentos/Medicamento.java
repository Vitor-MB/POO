package medicamentos;

public abstract class Medicamento {
	protected String nome;
	
	
	public Medicamento(String nome) {
		this.nome = nome;	
		System.out.println("Novo medicamento cadastrado : " + nome);
	}
	
	public String nome() {
		return nome;
	}
}