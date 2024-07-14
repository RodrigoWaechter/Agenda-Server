package com.projeto.agenda.server.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	private String endereco;
	private String cep;
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	public Cliente() {
		super();
	}

	public Cliente(int id, String nome, Date dataNascimento, String telefone, String email, String cpf, String endereco,String cep) {
		super(id, nome, dataNascimento, telefone, email, cpf);
		this.endereco = endereco;
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		Object oldValue = this.cep;
		this.cep = cep;
		changeSupport.firePropertyChange("cep", oldValue, cep);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		Object oldValue = this.endereco;
		this.endereco = endereco;
		changeSupport.firePropertyChange("endereco", oldValue, endereco);
	}

}
