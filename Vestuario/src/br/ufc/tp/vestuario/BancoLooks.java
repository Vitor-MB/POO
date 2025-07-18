package br.ufc.tp.vestuario;

import java.util.List;
import java.util.ArrayList;

public class BancoLooks {
	
	private List<Look> Looks;
	
	public BancoLooks() {
		Looks = new ArrayList<Look>();
	}
	
	public boolean salvar(Look l) {
		Looks.add(l);
	}

}
