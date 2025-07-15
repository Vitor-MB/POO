package br.ufc.tp.vestuario.itens.main;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import br.ufc.tp.vestuario.*;

import br.ufc.tp.vestuario.itens.*;

public class Vestuario {

	public static void main(String[] args) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
		BancoItens Itens = new BancoItens();
		BancoEmprestados Emprestados = new BancoEmprestados();
		
		
		Item item = new SupInterno("Camisa Ceará", "Riachuello", "Azul", ConservacaoEnum.NOVA, new GregorianCalendar(2025, GregorianCalendar.JULY, 01), TamanhoEnum.M, "Esportivo");
		item.resgistrarEmprestimoItem(Emprestados);
		Itens.AdicionarItem(item);		
		
		
		
		Itens.AdicionarItem(new SupExterno("Casaco Adidas", "Adidas", "Preto", ConservacaoEnum.RUIM, new GregorianCalendar(2025, GregorianCalendar.JUNE, 25), TamanhoEnum.M, "Casual"));
		
		
		
		Item A = Itens.getItem("Casaco Adidas");
		
		IEmprestavel e = (IEmprestavel) item;
		
		System.out.println(item.getID());
		
		
		

	}

}
