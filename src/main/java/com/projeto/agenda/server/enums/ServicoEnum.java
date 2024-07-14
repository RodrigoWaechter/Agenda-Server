package com.projeto.agenda.server.enums;

public enum ServicoEnum {

	CONSULTA(1, "Consulta Geral"),
	PILATES(2, "Aula de Pilates"),
	BARBEIRO(3, "Horário no Barbeiro");

	Integer cdServico;
	String nmServico;

	public Integer getCdServico() {
		return cdServico;
	}

	public void setCdServico(Integer cdServico) {
		this.cdServico = cdServico;
	}

	public String getNmServico() {
		return nmServico;
	}

	public void setNmServico(String nmServico) {
		this.nmServico = nmServico;
	}

	private ServicoEnum() {
	}

	private ServicoEnum(Integer cdServico, String nmServico) {
		this.cdServico = cdServico;
		this.nmServico = nmServico;
	}

}
