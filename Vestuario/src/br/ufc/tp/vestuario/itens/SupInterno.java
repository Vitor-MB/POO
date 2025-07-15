package br.ufc.tp.vestuario.itens;

import java.util.GregorianCalendar;

import br.ufc.tp.vestuario.BancoEmprestados;

public class SupInterno extends Superior implements IEmprestavel {
	protected Boolean emprestado;
	protected GregorianCalendar dataEmprestimo;
	
	public SupInterno(String id, String Loja_Origem, String Cor, ConservacaoEnum Conservacao, GregorianCalendar ult_lavagem, TamanhoEnum tamanho, String Estilo) {
		super(id, Loja_Origem, Cor, Conservacao, ult_lavagem, tamanho, Estilo);
		emprestado = false;
	}
	
	// ------------------------ METODOS EMPRESTIMO ------------------------------
	
	
	public void registrarEmprestimo(BancoEmprestados Emprestados, GregorianCalendar Deadline) {
		if(emprestado) {
			System.out.println("Item já emprestado");
			
		}else {
			emprestado = true;
			dataEmprestimo = Deadline;
			((Item)this).resgistrarEmprestimoItem(Emprestados);
			System.out.println("Item emprestado com sucesso!");
		}
	}
	
	public void registrarEmprestimo(BancoEmprestados Emprestados, int qtdDiad) {
		if(emprestado) {
			System.out.println("Item já emprestado");
		}else {
			emprestado = true;
			dataEmprestimo = new GregorianCalendar();
			dataEmprestimo.add(GregorianCalendar.DATE, qtdDiad);
			((Item)this).resgistrarEmprestimoItem(Emprestados);
			System.out.println("Item emprestado com sucesso!");
		}
	}
	
	public GregorianCalendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public int qtdDiasEmprestado() {
		if(emprestado) {
			long millis1 = dataEmprestimo.getTimeInMillis();
			long millis2 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)((millis1-millis2)/(1000*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public int diasParadevolucao() {
		if(emprestado) {
			long Total = dataEmprestimo.getTimeInMillis();
			long millis1 = new GregorianCalendar().getTimeInMillis();
			
			int Dias = (int)((Total-millis1)/(1000*60*60*24));
			
			return Dias;
		}
		else {
			return 0;
		}
	}
	
	public void registrarDevolucao(BancoEmprestados Emprestados) {
		if(emprestado) {
			emprestado = false;
			Emprestados.remover(this);
		}else {
			System.out.println("Item não está Emprestado");
		}
	}
	
	public Boolean isEmprestado() {
		return emprestado;
	}
	//------------------------------
}
