package medicamentos.receita;

import medicamentos.Medicamento;

import java.util.HashSet;
import java.util.Set;


public class Prescricao {
		protected Set <Medicamento> receita;
		
		public Prescricao() {
			receita = new HashSet <Medicamento>();
		}
		
		public void adicionar(Medicamento medic) {
			receita.add(medic);
			System.out.println(medic.nome() + " Adicionado à receita");
		}
		
}

