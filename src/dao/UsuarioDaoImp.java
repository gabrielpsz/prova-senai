package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionManager;
import modelo.Usuario;

public class UsuarioDaoImp extends GenericHibernateDao<Usuario> implements UsuarioDAO {

	private EntityManager manager;
	
	public UsuarioDaoImp() {
		manager = ConnectionManager.getEntityManager();
	}
	
	@Override
	public List<Usuario> buscarTodos() {
		Query query = manager.createNamedQuery("Usuario.buscarTodos");
		return query.getResultList();
	}

	@Override
	public Usuario autenticarUsuario(String login, String senha) {
		Query query = manager.createNamedQuery("Usuario.buscarPorEmailSenha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
	}

}
