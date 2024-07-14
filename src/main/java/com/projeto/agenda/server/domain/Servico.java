package com.projeto.agenda.server.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Servico {
	private int id;
	private String descricao;
	private float valor;

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	public Servico() {
		super();
	}

	public Servico(int id, String descricao, float valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Object oldValue = this.id;
		this.id = id;
		changeSupport.firePropertyChange("id", oldValue, id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		Object oldValue = this.descricao;
		this.descricao = descricao;
		changeSupport.firePropertyChange("descricao", oldValue, descricao);
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		Object oldValue = this.valor;
		this.valor = valor;
		changeSupport.firePropertyChange("valor", oldValue, valor);
	}

}
