package Pacote;

public class Main {
	public static void main(String args[]) {
		Pessoa p = new Pessoa("Maria", "123");
		System.out.println("O nome da pessoa é:" + p.getNome() + "O cpf é" + p.getCPF());
	}
}
