package visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import controle.UsuarioControle;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private UsuarioControle controle = new UsuarioControle();
	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void irAdm() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = ((HttpServletRequest) context.getELContext()).getSession();
		LoginBean loginBean = (LoginBean) session.getAttribute("LoginBean");
	}
	
	public String novo() {
		usuario = new Usuario();
		return "/adm/cadastroUsuario";
	}
	
	public String voltar() {
		usuario = new Usuario();
		usuarios = controle.buscarTodos();
		return "/adm/listaUsuarios";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			controle.salvar(usuario);
			usuario = new Usuario();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "/adm/cadastroUsuario";
	}
	
	public String excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			controle.excluir(usuarioSelecionado);
			usuarios.remove(usuarioSelecionado);
			usuarioSelecionado = null;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário removido com sucesso!", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "/adm/listaUsuarios";
	}
	
	public String alterar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (usuarioSelecionado == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "É obrigatório selecionar um usuário para alteração", ""));
			return "";
		} else {
			usuario = usuarioSelecionado;
			return "/adm/cadastroUsuario";
		}
	}
	
	public String listarTodos() {
		usuarios = controle.buscarTodos();
		return "/adm/listaUsuarios";
		}
	}

