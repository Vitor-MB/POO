package br.ufc.dc.tp.banco;

import br.ufc.dc.tp.banco.contas.Conta;

public class Banco {
	private Conta[] contas;
	private int indice = 0;
	
	public Banco() {
		contas = new Conta[100];
	}
	
	public void cadastrar(Conta conta) {
		contas[indice] = conta;
		indice = indice + 1 ; 
	}
	
	private Conta procurar (String numero) {
		for(int i = 0; i <indice ; i++) {
			if(contas[i].numero().equals(numero)) {
				return contas[i];
			}
		}
		return null;
	}
	
	public void creditar(String numero, double valor) {
		Conta conta = procurar(numero);
		
		if(conta != null) {
			conta.creditar(valor);
			System.out.println("Foi creditado R$" + valor);
		}
		else {
			System.out.println("A conta não existe");
		}
	}
	
	public void debitar (String numero, double valor) {
		Conta conta = procurar(numero);
		
		if(conta != null) {
			if(conta.saldo() < valor) 
				System.out.println("Saldo insuficiente ");
			else {
			conta.debitar(valor);
			System.out.println("Foi debitado R$" + valor);
			}
		}
		else {
			System.out.println("A conta não existe");
		}
		
	}
	
	public double saldo(String numero) {
		Conta conta = procurar(numero);
		
		if(conta != null) {
			return conta.saldo();
		}
		else {
			return -1;
		}
	}
	
	public void transferir(String origem, String destino, double valor) {
		Conta ori = procurar(origem);
		Conta dest = procurar(destino);
		
		if(ori != null && dest != null && ori.saldo() >= valor) {
			ori.debitar(valor);
			dest.creditar(valor);
			System.out.println("Transferência realizada no valor de R$" + valor);
		}
		else {
			System.out.println("Erro na transferencia");
		}
	}
}
