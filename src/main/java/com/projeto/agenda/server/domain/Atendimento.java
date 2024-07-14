package com.projeto.agenda.server.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.projeto.agenda.server.enums.ServicoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAtendimento;

	@Column(nullable = false)
	@Enumerated
	private ServicoEnum servico;

	@ManyToOne()
	@JoinColumn(nullable = false)
	private Cliente cliente;

	@Column(nullable = false)
	private LocalTime horarioInicio;

	@Column(nullable = false)
	private LocalTime horarioFim;

	@Column(nullable = false)
	private LocalDate data;
 
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: " + getIdAtendimento().toString());
		builder.append("CLIENTE: " + getCliente().getNomeCliente());
		builder.append("SERVIÇO: " + getServico().getNmServico());
		builder.append("HR INÍCIO: " + getHorarioInicio().toString());
		builder.append("HR FINAL: " + getHorarioFim().toString());
		builder.append("DATA: " + getData().toString());
		return builder.toString();
	}

	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Integer idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public ServicoEnum getServico() {
		return servico;
	}

	public void setServico(ServicoEnum servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
/*
private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

public void addPropertyChangeListener(PropertyChangeListener l) {
	changeSupport.addPropertyChangeListener(l);
}

public void removePropertyChangeListener(PropertyChangeListener l) {
	changeSupport.removePropertyChangeListener(l);
}

public Atendimento() {
	super();
}

public Atendimento(Integer idAtendimento, ServicoEnum servico, Cliente cliente, LocalTime horarioInicio,LocalTime horarioFim, LocalDate data) {
	super();
	this.idAtendimento = idAtendimento;
	this.servico = servico;
	this.cliente = cliente;
	this.horarioInicio = horarioInicio;
	this.horarioFim = horarioFim;
	this.data = data;
}

public Integer getIdAtendimento() {
	return idAtendimento;
}

public void setIdAtendimento(Integer idAtendimento) {
	Object oldValue = this.idAtendimento;
	this.idAtendimento = idAtendimento;
	changeSupport.firePropertyChange("idAtendimento", oldValue, idAtendimento);
}

public ServicoEnum getServico() {
	return servico;
}

public void setServico(ServicoEnum servico) {
	Object oldValue = this.servico;
	this.servico = servico;
	changeSupport.firePropertyChange("servico", oldValue, servico);
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	Object oldValue = this.cliente;
	this.cliente = cliente;
	changeSupport.firePropertyChange("cliente", oldValue, cliente);
}

public LocalTime getHorarioInicio() {
	return horarioInicio;
}

public void setHorarioInicio(LocalTime horarioInicio) {
	Object oldValue = this.horarioInicio;
	this.horarioInicio = horarioInicio;
	changeSupport.firePropertyChange("horarioInicio", oldValue, horarioInicio);
}

public LocalTime getHorarioFim() {
	return horarioFim;
}

public void setHorarioFim(LocalTime horarioFim) {
	Object oldValue = this.horarioFim;
	this.horarioFim = horarioFim;
	changeSupport.firePropertyChange("horarioFim", oldValue, horarioFim);
}

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	Object oldValue = this.data;
	this.data = data;
	changeSupport.firePropertyChange("data", oldValue, data);
}
*/
