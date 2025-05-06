package br.ufc.dc.tp.banco.contas;

public class ContaImposto extends ContaAbstrata{
	public ContaImposto(String numero) {
		super(numero);
	}
	
	public void debitar(double valor) {
		valor = valor + valor * 0.001;
		
		saldo = saldo - valor;
	}
}
