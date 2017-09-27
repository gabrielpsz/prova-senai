package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.buscarTodos", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.buscarPorEmailSenha", query="SELECT u FROM Usuario u WHERE u.email = :login AND u.senha = :senha")
})
public class Usuario {

	@Id
	@GeneratedValue
	private long idUsuario;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 150, nullable = false)
	private String email;

	@Column(length = 10, nullable = false)
	private String senha;

	public Usuario() {
	}

	public Usuario(long idUsuario, String nome, String email, String senha) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
