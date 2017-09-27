package dao;

/**
 * @author Felipe Demarchi
 */
public interface DAO<E> {

	void salvar(E e);
	void update();
	void excluir(E e);
	
}
