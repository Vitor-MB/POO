package br.ufc.tp.vestuario;

import br.ufc.tp.vestuario.itens.IEmprestavel;
import br.ufc.tp.vestuario.itens.Item;

import java.util.List;
import java.util.ArrayList;

public class BancoEmprestados {
	
	private List<IEmprestavel> Emprestados;


	public BancoEmprestados() {
		Emprestados = new ArrayList<IEmprestavel>();
	}
	
	public Boolean adicionar(Item i) {
		IEmprestavel e = (IEmprestavel) i;
		
		if(Emprestados.contains(e)) {
			System.out.println("Item já está registrado no Banco de emprestimos");
			return false;
		}
		else {
			Emprestados.add(e);
			System.out.println("Resgistrado no Banco de Emprestimos com sucesso");
			return true;
		}
	}
	
	public Boolean remover(Item i) {
		IEmprestavel e = (IEmprestavel) i;
		if(Emprestados.contains(e)) {
			System.out.println("Item removido do Banco de Emprestimos!");
			Emprestados.remove(e);
			return true;
		}else {
			System.out.println("Item não está no Banco de emprestimo");
			return false;
		}
	}	
	
	
	
	public void ListarEmprestados() {
		
		for(IEmprestavel e : Emprestados) {
			Item i = (Item) e;
				System.out.println(i.getID() + "Emprestado em: " + e.getDataEmprestimo().getTime());
			}
		}
	
}

