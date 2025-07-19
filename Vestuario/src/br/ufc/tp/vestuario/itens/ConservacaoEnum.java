package br.ufc.tp.vestuario.itens;


public enum ConservacaoEnum {
	RUIM(1),
	REGULAR(2),
	BOA(3),
	EXCELENTE(4);
	
	private int code;
	
	ConservacaoEnum(int code){
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
