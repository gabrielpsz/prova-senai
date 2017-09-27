package dao;

import java.util.List;

import modelo.Usuario;

public interface UsuarioDAO extends DAO<Usuario> {

	public List<Usuario> buscarTodos();
	Usuario autenticarUsuario(String login, String senha);
	
}
