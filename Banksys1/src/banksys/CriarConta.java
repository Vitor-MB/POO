package banksys;

public class CriarConta {
	public static void main(String args[]) {
		
		
		Banco banco = new Banco();
		
		
		Conta conta1;
		conta1 = new Conta("123");
		
		Conta conta2 = new Conta("125");
		
		
		banco.cadastrar(conta1);
		banco.cadastrar(conta2);
		
		banco.creditar("124", 100);
		
		/*
		conta1.creditar(5);
		System.out.println("O saldo é: " + conta1.saldo());
		
		Conta conta2;
		conta2 = new Conta("124");
		
		conta2.creditar(50000);
		System.out.println("O saldo é: " + conta2.saldo());
		*/
		
	}
}