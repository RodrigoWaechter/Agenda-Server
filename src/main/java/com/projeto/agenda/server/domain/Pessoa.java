package com.projeto.agenda.server.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Pessoa {
	private int id;
	private String nome;
	private Date dataNascimento;
	private String telefone;
	private String email;
	private String cpf;

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	public Pessoa(int id, String nome, Date dataNascimento, String telefone, String email, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}

	public Pessoa() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Object oldValue = this.nome;
		this.nome = nome;
		changeSupport.firePropertyChange("nome", oldValue, nome);
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		Object oldValue = this.dataNascimento;
		this.dataNascimento = dataNascimento;
		changeSupport.firePropertyChange("dataNascimento", oldValue, dataNascimento);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		Object oldValue = this.telefone;
		this.telefone = telefone;
		changeSupport.firePropertyChange("telefone", oldValue, telefone);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Object oldValue = this.email;
		this.email = email;
		changeSupport.firePropertyChange("email", oldValue, email);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		Object oldValue = this.cpf;
		this.cpf = cpf;
		changeSupport.firePropertyChange("cpf", oldValue, cpf);
	}

}
