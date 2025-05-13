package medicamentos.receita;

import medicamentos.Comprimido;
import medicamentos.Xarope;
import medicamentos.Medicamento;

public class Main {

	public static void main(String[] args) {
		Medicamento m1 = new Comprimido("Paracetamol");
		Medicamento m2 = new Xarope("Loratadina");
		
		Prescricao receita = new Prescricao();
		
		receita.adicionar(m1);
		receita.adicionar(m2);
		

	}

}
