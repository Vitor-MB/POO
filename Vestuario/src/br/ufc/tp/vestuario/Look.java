package br.ufc.tp.vestuario;

import java.util.Map;

import br.ufc.tp.vestuario.itens.*;

import java.util.HashMap;

public class Look {

	private Map<Class<? extends Item>, Item> Look;
	
	public Look(Item ... Itens) {
		this.Look = new HashMap<Class<? extends Item>, Item>();
		
		//Partes do Look que vai ser obrigatorio
		this.Look.put(SupInterno.class, null);
		this.Look.put(Inferior.class, null);
		this.Look.put(Calcado.class, null);
		
		for(Item i : Itens) {
			Look.put(i.getClass(), i);
		}
	}
	
	public boolean isLookValido() {
		return this.Look.containsValue(null);
	}
	
	public void adicionar(Item...itens) {
		for(Item i: itens) {
			this.Look.put(i.getClass(), i);
		}
	}
	
	public boolean remover(Item i) {
		if(this.Look.containsValue(i)) { 
			this.Look.put(i.getClass(), null);
			return true;
		}
		else {
			System.out.println(i.getID()+ " não está nesse look");
			return false;
		}
		
	}
	
	public boolean editar(Class<? extends Item> key, Item i) {
		if(this.Look.get(key) != null) {
			this.Look.put(key, i);
			return true;
		}
		else {
			System.out.println("Essa parte não está ");
			return false;
		}
	}
	
	public boolean salvar(BancoLooks Looks) {
		
	}

}
