package com.projeto.agenda.server.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCliente;

	@Column(length = 255, nullable = false)
	private String nomeCliente;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Date nascimentoCliente;

	@Column(length = 14, nullable = false, unique = true)
	private String cpfCliente;

	@Column(length = 20)
	private String telefoneCliente;

	@Transient
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

	public Cliente(Integer idCliente, String nomeCliente, Date nascimentoCliente, String cpfCliente,String telefoneCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.nascimentoCliente = nascimentoCliente;
		this.cpfCliente = cpfCliente;
		this.telefoneCliente = telefoneCliente;
	}

	public Cliente(String nomeCliente) {
		super();
		this.nomeCliente = nomeCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		Object oldValue = this.idCliente;
		this.idCliente = idCliente;
		changeSupport.firePropertyChange("idCliente", oldValue, idCliente);
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		Object oldValue = this.nomeCliente;
		this.nomeCliente = nomeCliente;
		changeSupport.firePropertyChange("nomeCliente", oldValue, nomeCliente);
	}

	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}

	public void setNascimentoCliente(Date nascimentoCliente) {
		Object oldValue = this.nascimentoCliente;
		this.nascimentoCliente = nascimentoCliente;
		changeSupport.firePropertyChange("nascimentoCliente", oldValue, nascimentoCliente);
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		Object oldValue = this.cpfCliente;
		this.cpfCliente = cpfCliente;
		changeSupport.firePropertyChange("cpfCliente", oldValue, cpfCliente);
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		Object oldValue = this.telefoneCliente;
		this.telefoneCliente = telefoneCliente;
		changeSupport.firePropertyChange("telefoneCliente", oldValue, telefoneCliente);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("ID:" + getIdCliente().toString());
		builder.append("NOME:" + getNomeCliente());
		builder.append("NASCIMENTO:" + getNascimentoCliente().toString());
		builder.append("CPF:" + getCpfCliente());
		builder.append("TELEFONE:" + getTelefoneCliente());

		return builder.toString();
	}
	public String getFormmatedDate() {
		Date data = this.nascimentoCliente;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}
}
