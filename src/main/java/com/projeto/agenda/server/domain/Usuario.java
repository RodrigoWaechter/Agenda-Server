package com.projeto.agenda.server.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends Pessoa {
	private String senha;
	private Servico servico;
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, Date dataNascimento, String telefone, String email, String cpf, String senha) {
		super(id, nome, dataNascimento, telefone, email, cpf);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		Object oldValue = this.senha;
		this.senha = senha;
		changeSupport.firePropertyChange("senha", oldValue, senha);
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		Object oldValue = this.servico;
		this.servico = servico;
		changeSupport.firePropertyChange("servico", oldValue, servico);
	}

}
