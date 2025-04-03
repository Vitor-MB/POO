package Pacote;


public class Pessoa {
	private String nome;
	private String cpf;
	endereco end;
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getCPF() {
		return this.cpf;
	}
}
