package controle;

import java.util.List;

import modelo.Reserva;
import modelo.Sala;
import dao.DAOFactory;
import dao.ReservaDAO;
import dao.SalaDAO;

public class ReservaControle {
	private ReservaDAO reservaDao = DAOFactory.getReservaDao();
	
	public void salvar(Reserva reserva) throws Exception {
		if (reserva.getNomeProfessor() == null || reserva.getNomeProfessor().trim().isEmpty()) {
			throw new Exception("O nome do professor é obrigatório");
		}
		if (reserva.getMatriculaProfessor() == null || reserva.getMatriculaProfessor().trim().isEmpty()) {
			throw new Exception("A matrícula do professor é obrigatória");
		}
		if (reserva.getIdReserva() == 0) {
			reservaDao.salvar(reserva);
		} else {
			reservaDao.update();
		}
	}
	
	public void excluir(Reserva reserva) throws Exception {
		if (reserva == null) {
			throw new Exception("É obrigatório selecionar uma reserva para exclusão");
		}
		reservaDao.excluir(reserva);
	}
	
	public List<Reserva> buscarTodos() {
		return reservaDao.buscarTodos();
	}
	
	public Sala buscarSalaPorId(long idSala) {
		SalaDAO salaDao = DAOFactory.getSalaDao();
		return salaDao.buscarPorId(idSala);
	}
	
	public List<Sala> buscarTodasSalas() {
		SalaDAO salaDao = DAOFactory.getSalaDao();
		return salaDao.buscarTodos();
	}
	
}
