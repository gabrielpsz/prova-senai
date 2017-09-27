package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Reserva.buscarTodos", query="SELECT r FROM Reserva r"),
})
public class Reserva {

	@Id
	@GeneratedValue
	private long idReserva;
	
	@Column(nullable=false)
	private String nomeProfessor;
	
	@Column(nullable=false)
	private String matriculaProfessor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;
	
	@ManyToOne(optional=false)
	private Sala sala;

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getMatriculaProfessor() {
		return matriculaProfessor;
	}

	public void setMatriculaProfessor(String matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Reserva(long idReserva, String nomeProfessor,
			String matriculaProfessor, Date inicio, Date termino, Sala sala) {
		super();
		this.idReserva = idReserva;
		this.nomeProfessor = nomeProfessor;
		this.matriculaProfessor = matriculaProfessor;
		this.inicio = inicio;
		this.termino = termino;
		this.sala = sala;
	}

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idReserva ^ (idReserva >>> 32));
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime
				* result
				+ ((matriculaProfessor == null) ? 0 : matriculaProfessor
						.hashCode());
		result = prime * result
				+ ((nomeProfessor == null) ? 0 : nomeProfessor.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((termino == null) ? 0 : termino.hashCode());
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
		Reserva other = (Reserva) obj;
		if (idReserva != other.idReserva)
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (matriculaProfessor == null) {
			if (other.matriculaProfessor != null)
				return false;
		} else if (!matriculaProfessor.equals(other.matriculaProfessor))
			return false;
		if (nomeProfessor == null) {
			if (other.nomeProfessor != null)
				return false;
		} else if (!nomeProfessor.equals(other.nomeProfessor))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (termino == null) {
			if (other.termino != null)
				return false;
		} else if (!termino.equals(other.termino))
			return false;
		return true;
	}
	
	
}
