package dao;

import java.util.List;

import modelo.Sala;

public interface SalaDAO extends DAO<Sala> {
	
	public Sala buscarPorId(long idSala);
	public List<Sala> buscarTodos();
	
}
