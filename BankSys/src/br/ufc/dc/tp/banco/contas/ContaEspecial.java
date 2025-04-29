package br.ufc.dc.tp.banco.contas;

public class ContaEspecial extends Conta {
	private double bonus;
	
	public ContaEspecial(String numero) {
		super(numero);
		bonus = 0;
	}
	
	public void renderBonus() {
		super.creditar(bonus);
		bonus = 0;
	}
	
	public void creditar(double valor) {
		bonus = bonus + (valor*0.01);
		System.out.printf("Você ganhou um bônus de R$" + "%.2f\n", bonus);
		super.creditar(valor);
	}
}
