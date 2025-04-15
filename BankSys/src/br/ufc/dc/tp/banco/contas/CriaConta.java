package br.ufc.dc.tp.banco.contas;

import br.ufc.dc.tp.banco.Banco;

public class CriaConta {
	public static void main(String args[]) {
		
		
		Banco banco = new Banco();
		
		
		Conta conta1;
		conta1 = new Conta("123");
		
		Conta conta2 = new Conta("125");
		
		
		banco.cadastrar(conta1);
		banco.cadastrar(conta2);
		
		banco.creditar(conta1.numero(), 100);
		banco.transferir(conta1.numero(), conta2.numero(), 50);		
		
		banco.debitar(conta1.numero(), 90);
		
		
		
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
