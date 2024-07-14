package ziparProKelvin;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private ServicoEnum servico;

	@ManyToOne()
	@JoinColumn(nullable = false)
	private Cliente cliente;

	@Column(nullable = false)
	private LocalDateTime horarioInicio;

	@Column(nullable = false)
	private LocalDateTime horarioFim;

	public Atendimento() {
		super();
	}

	public Atendimento(Integer idAtendimento, ServicoEnum servico, Cliente cliente, LocalDateTime horarioInicio,
			LocalDateTime horarioFim) {
		super();
		this.idAtendimento = idAtendimento;
		this.servico = servico;
		this.cliente = cliente;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
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

	public LocalDateTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalDateTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalDateTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalDateTime horarioFim) {
		this.horarioFim = horarioFim;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("ID:" + getIdAtendimento().toString());
		builder.append("CLIENTE:" + getCliente().getNomeCliente());
		builder.append("SERVIÇO:" + getServico().getNmServico());
		builder.append("HR INÍCIO:" + getHorarioInicio().toString());
		builder.append("HR FINAL:" + getHorarioFim().toString());
		
		return builder.toString();
	}
}
