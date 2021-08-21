package br.com.tarefas.enums;

public enum EnumPrioridade {
	
	ALTA("Alta"),
	MEDIA("Média"),
	BAIXA("Baixa");
	
	private final String situacao;
	
	private EnumPrioridade(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}
	
}
