package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Sala.buscarTodos", query="SELECT s FROM Sala s")
})
public class Sala {

	@Id
	@GeneratedValue
	private long idSala;
	
	@Column(length=15, nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private int capacidade;
	
	@Column(nullable=false)
	private boolean laboratorio;
	
	@OneToMany(mappedBy="sala")
	private List<Reserva> reserva;
	
	public Sala() {
	}

	public Sala(long idSala, String nome, int capacidade, boolean laboratorio) {
		this.idSala = idSala;
		this.nome = nome;
		this.capacidade = capacidade;
		this.laboratorio = laboratorio;
	}

	public long getIdSala() {
		return idSala;
	}

	public void setIdSala(long idSala) {
		this.idSala = idSala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + (int) (idSala ^ (idSala >>> 32));
		result = prime * result + (laboratorio ? 1231 : 1237);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((reserva == null) ? 0 : reserva.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (capacidade != other.capacidade)
			return false;
		if (idSala != other.idSala)
			return false;
		if (laboratorio != other.laboratorio)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (reserva == null) {
			if (other.reserva != null)
				return false;
		} else if (!reserva.equals(other.reserva))
			return false;
		return true;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(boolean laboratorio) {
		this.laboratorio = laboratorio;
	}
	
}
