package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionManager;
import modelo.Reserva;
import modelo.Sala;

public class ReservaDaoImp extends GenericHibernateDao<Reserva> implements ReservaDAO {

	private EntityManager manager;
	
	public ReservaDaoImp() {
		manager = ConnectionManager.getEntityManager();
	}
	
	@Override
	public List<Reserva> buscarTodos() {
		Query query = manager.createNamedQuery("Reserva.buscarTodos");
		return query.getResultList();
	}

	@Override
	public Reserva buscarPorId(long idReserva) {
		return manager.find(Reserva.class, idReserva);
	}


}
