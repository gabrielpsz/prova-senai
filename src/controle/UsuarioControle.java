package controle;

import java.util.List;

import modelo.Usuario;
import dao.DAOFactory;
import dao.UsuarioDAO;

public class UsuarioControle {

	public void salvar(Usuario usuario) throws Exception {
		if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
			throw new Exception("O nome � obrigat�rio!");
		}
		if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
			throw new Exception("O e-mail � obrigat�rio!");
		}
		if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
			throw new Exception("A senha � obrigat�ria!");
		}
		
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDao();
		if (usuario.getIdUsuario() == 0) {
			usuarioDao.salvar(usuario);
		} else {
			usuarioDao.update();
		}
	}
	
	public void excluir(Usuario usuario) throws Exception {
		if (usuario == null) {
			throw new Exception("� obrigat�rio selecionar um usu�rio para exclus�o!");
		}
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDao();
		usuarioDao.excluir(usuario);
	}
	
	public List<Usuario> buscarTodos() {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDao();
		return usuarioDao.buscarTodos();
	}
	
	public Usuario autenticarUsuario(String login, String senha) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDao();
		return usuarioDao.autenticarUsuario(login, senha);
	}
	
}
