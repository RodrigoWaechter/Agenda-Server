package com.projeto.agenda.server.enums;

public enum FormaPagamentoEnum {

	DINHEIRO(1, "Dinheiro"),
	PIX(2, "PIX"),
	CARTAO_CREDITO(3, "Cartão de Crédito"),
	CARTAO_DEBITO(4, "Cartão de Débito");

	Integer cdFormaPagamento;
	String nmFormaPagamento;

	public Integer geCdFormaPagamento() {
		return cdFormaPagamento;
	}

	public void setCdFormaPagamento(Integer cdServico) {
		this.cdFormaPagamento = cdServico;
	}

	public String getNmFormaPagamento() {
		return nmFormaPagamento;
	}

	public void setNmFormaPagamento(String noFormaPagamento) {
		this.nmFormaPagamento = noFormaPagamento;
	}

	private FormaPagamentoEnum() {
	}

	private FormaPagamentoEnum(Integer cdFormaPagamento, String nmFormaPagamento) {
		this.cdFormaPagamento = cdFormaPagamento;
		this.nmFormaPagamento = nmFormaPagamento;
	}

}
