package controle;

import java.util.List;

import modelo.Sala;
import dao.DAOFactory;
import dao.SalaDAO;

public class SalaControle {

	public void salvar(Sala sala) throws Exception {
		if (sala.getCapacidade() <= 0) {
			throw new Exception("A capacidade da sala deve ser maior que 0!");
		}
		if (sala.getNome() == null || sala.getNome().trim().isEmpty()) {
			throw new Exception("O nome � obrigat�rio!");
		}
		
		SalaDAO salaDao = DAOFactory.getSalaDao();
		if (sala.getIdSala() == 0) {
			salaDao.salvar(sala);
		} else {
			salaDao.update();
		}
	}
	
	public void excluir(Sala sala) throws Exception {
		if (sala == null) {
			throw new Exception("� obrigat�rio selecionar uma sala para exclus�o");
		}
		SalaDAO salaDao = DAOFactory.getSalaDao();
		salaDao.excluir(sala);
	}
	
	public List<Sala> buscarTodos() {
		SalaDAO salaDao = DAOFactory.getSalaDao();
		return salaDao.buscarTodos();
	}
	
}
