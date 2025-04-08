package banksys;

public class CriaConta {
	public static void main(String args[]) {
		
		java.util.ArrayList<Conta> lcs;
		lcs = new java.util.ArrayList<Conta>();
		
		Conta conta1;
		conta1 = new Conta("123", lcs);
		
		lcs.add(conta1);
		
		conta1.creditar(5);
		System.out.println("O saldo é: " + conta1.saldo());
		
		Conta conta2;
		conta2 = new Conta("123", lcs);
		
		
	}
}
