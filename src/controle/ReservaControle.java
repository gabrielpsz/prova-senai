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
			throw new Exception("O nome do professor � obrigat�rio");
		}
		if (reserva.getMatriculaProfessor() == null || reserva.getMatriculaProfessor().trim().isEmpty()) {
			throw new Exception("A matr�cula do professor � obrigat�ria");
		}
		if (reserva.getIdReserva() == 0) {
			reservaDao.salvar(reserva);
		} else {
			reservaDao.update();
		}
	}
	
	public void excluir(Reserva reserva) throws Exception {
		if (reserva == null) {
			throw new Exception("� obrigat�rio selecionar uma reserva para exclus�o");
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
