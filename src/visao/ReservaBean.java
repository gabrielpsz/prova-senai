package visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Reserva;
import modelo.Sala;
import controle.ReservaControle;

@ManagedBean(name = "reservaBean")
@SessionScoped
public class ReservaBean {

	private Reserva reserva = new Reserva();
	private ReservaControle reservaControle = new ReservaControle();
	private Reserva reservaSelecionada;
	private List<Reserva> listReserva = new ArrayList<Reserva>();
	private List<Sala> listSala;

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public ReservaControle getReservaControle() {
		return reservaControle;
	}

	public void setReservaControle(ReservaControle reservaControle) {
		this.reservaControle = reservaControle;
	}

	public Reserva getReservaSelecionada() {
		return reservaSelecionada;
	}

	public void setReservaSelecionada(Reserva reservaSelecionada) {
		this.reservaSelecionada = reservaSelecionada;
	}

	public List<Reserva> getListReserva() {
		return listReserva;
	}

	public void setListReserva(List<Reserva> listReserva) {
		this.listReserva = listReserva;
	}

	public List<Sala> getListSala() {
		listSala = reservaControle.buscarTodasSalas();
		return listSala;
	}

	public void setListSala(List<Sala> listSala) {
		this.listSala = listSala;
	}

	public String novo() {
		reserva = new Reserva();
		return "/adm/cadastroReserva";
	}
	
	public String voltar() {
		reserva = new Reserva();
		listReserva = reservaControle.buscarTodos();
		return "/adm/listarReserva";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			reservaControle.salvar(reserva);
			reserva = new Reserva();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva cadastrada com sucesso!", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "/adm/cadastroReserva";
	}
	
	public String excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			reservaControle.excluir(reservaSelecionada);
			listReserva.remove(reservaSelecionada);
			reservaSelecionada = null;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva removida com sucesso!", ""));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "/adm/listarReserva";
	}
	
	public String alterar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (reservaSelecionada == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "É obrigatório selecionar uma reserva para alteração", ""));
			return "";
		} else {
			reserva = reservaSelecionada;
			return "/adm/cadastroReserva";
		}
	}
	
	public String buscarTodos() {
		listReserva = reservaControle.buscarTodos();
		return "/adm/listarReserva";
	}

}
