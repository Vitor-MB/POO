package br.ufc.tp.vestuario;

import java.util.Map;

import br.ufc.tp.vestuario.itens.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.util.GregorianCalendar;

public class Look {

	private Map<Class<? extends Item>, Item> roupas;
	private List<Acessorio> acessorios;
	private ArrayList<EventoLook> historicoUsos;
	
	private int qtdUsos;

	
	
	private String ID;
	
	public Look(String ID, Item ... Itens) {
		this.ID = ID;
		
		this.roupas = new HashMap<Class<? extends Item>, Item>();
		this.acessorios = new ArrayList<Acessorio>();
		this.historicoUsos = new ArrayList<EventoLook>();
		
		qtdUsos = 0;
		
		//Partes do roupas que vai ser obrigatorio
		this.roupas.put(SupInterno.class, null);
		this.roupas.put(Inferior.class, null);
		this.roupas.put(Calcado.class, null);
		
		for(Item i : Itens) {
			if(i instanceof Acessorio) {
				Acessorio a = ((Acessorio) i);
				this.acessorios.add(a);
			}
			else
				this.roupas.put(i.getClass(), i);
		}
	}
	
	public String getID() {
		return this.ID;
	}
	
	public boolean isLookValido() {
		return !this.roupas.containsValue(null);
	}
	
	public boolean temAcessorio() {
		return !this.acessorios.isEmpty();
	}
	
	public void adicionar(Item...itens) {
		for(Item i: itens) {
			if(i instanceof Acessorio) {
				Acessorio a = ((Acessorio) i);
				this.acessorios.add(a);
			}
			else
				this.roupas.put(i.getClass(), i);
		}
	}
	
	public boolean remover(Item i) {
		if(this.roupas.containsValue(i)) { 
			this.roupas.put(i.getClass(), null);
			return true;
		}
		else {
			System.out.println(i.getID()+ " não está nesse roupas");
			return false;
		}
		
	}
	
	public boolean editar(Class<? extends Item> key, Item i) {
		if(this.roupas.get(key) != null) {
			this.roupas.put(key, i);
			return true;
		}
		else {
			System.out.println("Essa parte não está ");
			return false;
		}
	}
	
	public boolean salvar(BancoLooks Looks) {
		return Looks.salvar(this);
	}
	
	public void registrarUso(String Evento) {
		this.qtdUsos += 1;
		this.historicoUsos.add(new EventoLook(Evento, new GregorianCalendar()));
		
		//Registra o uso individual de cada item
		for(Item i : this.roupas.values()) {
			i.registrarUso();
		}
		for(Acessorio a : this.acessorios) {
			Item i = ((Item) a);
			i.registrarUso();
		}
	}
	
	public void registrarUso(String Evento, GregorianCalendar ultimoUso) {
		this.qtdUsos += 1;
		this.historicoUsos.add(new EventoLook(Evento, ultimoUso));
		for(Item i : this.roupas.values()) {
			i.registrarUso();
		}
		for(Acessorio a : this.acessorios) {
			Item i = ((Item) a);
			i.registrarUso();
		}
	}
	
	public int getQtdUsos() {
		return this.qtdUsos;
	}
	
	public ArrayList<EventoLook> getHistoricoEventos(){
		return historicoUsos;
	}
	
	public void ListarHistorico() {
		for(EventoLook e : this.historicoUsos) {
			System.out.println(e.getEvento() + " em " + e.getData().getTime());
		}
	}
	
	public EventoLook getUltimoUso() {
		if(this.historicoUsos.isEmpty())
			return null;
		else {
			EventoLook ultimoUso = this.historicoUsos.get(0);
			
			for(EventoLook l : this.historicoUsos) {
				if(l.getData().after(ultimoUso.getData())) {
					ultimoUso = l; 
				}
			}
			return ultimoUso;
		}
	}
	
	public void MostrarLook() {
		 for (Map.Entry<Class<? extends Item>, Item> key : this.roupas.entrySet()) {
		        Class<? extends Item> classe = key.getKey();
		        Item i = key.getValue();
		        
		        if (i != null)
		            System.out.print(classe.getSimpleName() + ": " + i.getID() + " | ");
		        else
		            System.out.print( classe.getSimpleName() + ": " + " | ");
		    }
		 
		 System.out.print("Acessorios: ");
		 for(Acessorio a : this.acessorios) {
			 System.out.print(a.getID()+", ");
		 }
		 System.out.println();
	}

}
