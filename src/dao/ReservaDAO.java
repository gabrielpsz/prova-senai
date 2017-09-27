package dao;

import java.util.List;

import modelo.Reserva;
import modelo.Sala;

public interface ReservaDAO extends DAO<Reserva>{
	
	Reserva buscarPorId(long idReserva);
	List<Reserva> buscarTodos();

}
