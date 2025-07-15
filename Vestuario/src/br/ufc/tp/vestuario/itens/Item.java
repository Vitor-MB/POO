package br.ufc.tp.vestuario.itens;

import br.ufc.tp.vestuario.*;

public abstract class Item {

	protected String id; //Nome
	protected String Loja_Origem;
	protected String Cor;
	protected ConservacaoEnum Conservacao;
	
	protected int qtdUsos;
	
	public Item(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao) {
		this.id = id;
		this.Loja_Origem = Loja_Origem;
		this.Cor = Cor;
		this.Conservacao = Conservacao;
		qtdUsos = 0;
	}
	
	/*
	//Opção do usuário de cadastrar
	public abstract boolean cadastrar();
	//Opção de editar
	public abstract boolean editar();
	//Opção de deletar
	public abstract boolean deletar();
	*/
	
	//Gets
	public String getID() {
		return id;
	}
	public int getQtdUsos() {
		return qtdUsos;
	}
	public String getCor() {
		return Cor;
	}
	public String getLoja() {
		return Loja_Origem;
	}
	public ConservacaoEnum get_conservacao() {
		return Conservacao;
	}
	public Boolean isEmprestavel() {
		return this instanceof IEmprestavel;
	}
	
	public void resgistrarEmprestimoItem(BancoEmprestados Emprestados) {
		if(isEmprestavel())
			Emprestados.adicionar(this);
		else {
			System.out.println("Esse item não é emprestavel");
		}
	}
	
	public void deletarEmprestimoItem(BancoEmprestados Emprestados) {
		if(isEmprestavel())
			Emprestados.remover(this);
		else {
			System.out.println("Esse item não é emprestavel");
		}
	}
	
	
}
