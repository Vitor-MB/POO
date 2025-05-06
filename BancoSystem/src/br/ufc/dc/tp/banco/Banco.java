package br.ufc.dc.tp.banco;

import br.ufc.dc.tp.banco.contas.Conta;
import br.ufc.dc.tp.banco.contas.ContaEspecial;
import br.ufc.dc.tp.banco.contas.ContaPoupanca;
import br.ufc.dc.tp.banco.contas.ContaAbstrata;

public class Banco {
	private ContaAbstrata[] contas;
	private int indice = 0;
	
	public Banco() {
		contas = new ContaAbstrata[100];
	}
	
	public void cadastrar(ContaAbstrata conta) {
		contas[indice] = conta;
		indice = indice + 1 ; 
	}
	
	private ContaAbstrata procurar (String numero) {
		for(int i = 0; i <indice ; i++) {
			if(contas[i].numero().equals(numero)) {
				return contas[i];
			}
		}
		return null;
	}
	
	public void creditar(String numero, double valor) {
		ContaAbstrata conta = procurar(numero);
		
		if(conta != null) {
			conta.creditar(valor);
			System.out.println("Foi creditado R$" + valor);
		}
		else {
			System.out.println("A conta não existe");
		}
	}
	
	public void debitar (String numero, double valor) {
		ContaAbstrata conta = procurar(numero);
		
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
		ContaAbstrata conta = procurar(numero);
		
		if(conta != null) {
			return conta.saldo();
		}
		else {
			return -1;
		}
	}
	
	public void transferir(String origem, String destino, double valor) {
		ContaAbstrata ori = procurar(origem);
		ContaAbstrata dest = procurar(destino);
		
		if(ori != null && dest != null && ori.saldo() >= valor) {
			ori.debitar(valor);
			dest.creditar(valor);
			System.out.println("Transferência realizada no valor de R$" + valor);
		}
		else {
			System.out.println("Erro na transferencia");
		}
	}
	
	public void renderJuros(String numero) {
		ContaAbstrata conta = procurar(numero);
		
		if(conta != null) {
			if(conta instanceof ContaPoupanca) {
				((ContaPoupanca) conta).renderJuros(0.01);
				System.out.println("Sua Conta Poupança rendeu 1%, seu novo saldo é: R$" + conta.saldo());
			}
			else 
				System.out.println("Essa conta não é poupanca");
			
		}
		else 
			System.out.println("Conta inválida");
	}
	public void renderBonus(String numero) {
		ContaAbstrata c = procurar(numero);
		
		if(c != null) {
			if(c instanceof ContaEspecial) {
				((ContaEspecial) c).renderBonus();
			}
			else 
				System.out.println("Essa conta não é especial");
			
		}
		else 
			System.out.println("Conta inválida");
	}
		
}