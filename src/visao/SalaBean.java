package visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Sala;
import controle.SalaControle;

@ManagedBean(name = "salaBean")
@SessionScoped
public class SalaBean {

	private Sala sala = new Sala();
	private SalaControle controle = new SalaControle();
	private Sala salaSelecionada;
	private List<Sala> salas = new ArrayList<Sala>();

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Sala getSalaSelecionada() {
		return salaSelecionada;
	}

	public void setSalaSelecionada(Sala salaSelecionada) {
		this.salaSelecionada = salaSelecionada;
	}

	public List<Sala> getSalas() {
		return salas;
	}
	
	public String novo() {
		sala = new Sala();
		return "/adm/cadastroSala";
	}
	
	public String voltar() {
		sala = new Sala();
		salas = controle.buscarTodos();
		return "/adm/listaSalas";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			controle.salvar(sala);
			sala = new Sala();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala de Aula cadastrada com sucesso!", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "/adm/cadastroSala";
	}
	
	public String excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			controle.excluir(salaSelecionada);
			salas.remove(salaSelecionada);
			salaSelecionada = null;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala de Aula removida com sucesso!", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "/adm/listaSalas";
	}
	
	public String alterar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (salaSelecionada == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "É obrigatório selecionar uma sala de aula para alteração", ""));
			return "";
		} else {
			sala = salaSelecionada;
			return "/adm/cadastroSala";
		}
	}
	
	public String listarTodos() {
		salas = controle.buscarTodos();
		return "/adm/listaSalas";
	}

}
