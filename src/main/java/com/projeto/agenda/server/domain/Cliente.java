package ziparProKelvin;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;
	
	@Column(length = 255, nullable = false)
	private String nomeCliente;
	
	@Column(nullable = false)
	private Date nascimentoCliente;
	
	@Column(length = 20, nullable = false, unique = true)
	private String cpfCliente;
	
	@Column(length = 20)
	private String telefoneCliente;

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nomeCliente, Date nascimentoCliente, String cpfCliente,
			String telefoneCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.nascimentoCliente = nascimentoCliente;
		this.cpfCliente = cpfCliente;
		this.telefoneCliente = telefoneCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}

	public void setNascimentoCliente(Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
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
	
}
