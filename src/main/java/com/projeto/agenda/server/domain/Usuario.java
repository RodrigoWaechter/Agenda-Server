package ziparProKelvin;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	
	@Column(length = 50, nullable = false)
	private String nomeUsuario;
	
	@Column(length = 50, nullable = false)
	private String senhaUsuario;
	
	@Column(nullable = false)
	private Date data;

	public Usuario() {
		super();
	}

	public Usuario(Integer idUsuario, String nomeUsuario, String senhaUsuario, Date data) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.data = data;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String[] caracteres = new String[getSenhaUsuario().length()];
		caracteres[0] = getSenhaUsuario();
		
		for(int i = 0; i < getSenhaUsuario().length(); i++) {
			caracteres[0].replace(caracteres[0].charAt(i), '*');
		}
		
		builder.append("ID:" + getIdUsuario().toString());
		builder.append("NOME:" + getNomeUsuario());
		builder.append("SENHA:" + caracteres.toString());
		builder.append("DATA:" + getData().toString());
		
		return builder.toString();
	}
}
