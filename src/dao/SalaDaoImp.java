package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Sala;
import conexao.ConnectionManager;

public class SalaDaoImp extends GenericHibernateDao<Sala> implements SalaDAO {

	private EntityManager manager;
	
	public SalaDaoImp() {
		manager = ConnectionManager.getEntityManager();
	}
	
	@Override
	public List<Sala> buscarTodos() {
		Query query = manager.createNamedQuery("Sala.buscarTodos");
		return query.getResultList();
	}

	@Override
	public Sala buscarPorId(long idSala) {
		return manager.find(Sala.class, idSala);
	}

}
