package banksys;

public class Banco {
	private Conta[] contas;
	private int indice = 0;
	
	public Banco() {
		contas = new Conta[100];
	}
	
	public void cadastrar(Conta conta) {
		contas[indice] = conta;
		indice = indice + 1 ; 
	}
	
	private Conta procurar (String numero) {
		for(int i = 0; i <indice ; i++) {
			if(contas[i].numero().equals(numero)) {
				return contas[i];
			}
		}
		return null;
	}
	
	public void creditar(String numero, double valor) {
		Conta conta = procurar(numero);
		
		if(conta != null) {
			conta.creditar(valor);
			System.out.println("Foi creditado R$" + valor);
		}
		else {
			System.out.println("A conta não existe");
		}
	}
	
	public void debitar (String numero, double valor) {
		Conta conta = procurar(numero);
		
		if(conta != null) {
			conta.debitar(valor);
			System.out.println("Foi creditado R$" + valor);
		}
		else {
			System.out.println("A conta não existe");
		}
		
	}
	
}
