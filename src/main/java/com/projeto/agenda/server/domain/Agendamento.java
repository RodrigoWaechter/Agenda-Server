package com.projeto.agenda.server.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Agendamento {
	private int id;
	private Cliente cliente;
	private Servico servico;
	private float valor;
	private Date hora;
	private String observacao;

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	public Agendamento(int id, Cliente cliente, Servico servico, float valor, Date hora, String observacao) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.valor = valor;
		this.hora = hora;
		this.observacao = observacao;
	}

	public Agendamento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Object oldValue = this.id;
		this.id = id;
		changeSupport.firePropertyChange("id", oldValue, id);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		Object oldValue = this.cliente;
		this.cliente = cliente;
		changeSupport.firePropertyChange("cliente", oldValue, cliente);
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		Object oldValue = this.servico;
		this.servico = servico;
		changeSupport.firePropertyChange("servico", oldValue, servico);
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		Object oldValue = this.valor;
		this.valor = valor;
		changeSupport.firePropertyChange("valor", oldValue, valor);
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		Object oldValue = this.hora;
		this.hora = hora;
		changeSupport.firePropertyChange("hora", oldValue, hora);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		Object oldValue = this.observacao;
		this.observacao = observacao;
		changeSupport.firePropertyChange("observacao", oldValue, observacao);
	}

}
