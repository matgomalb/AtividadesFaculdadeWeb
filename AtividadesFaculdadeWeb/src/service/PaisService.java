package service;

import dao.PaisDAO;
import model.Pais;

public class PaisService {

	PaisDAO dao = new PaisDAO();
	
	public int criar(Pais pais) {
		return dao.insert(pais);
	}
	
	public void atualizar(Pais pais){
		dao.update(pais);
	}
	
	public void excluir(int id){
		dao.delete(id);
	}
	
	public Pais carregar(Pais pais){
		return dao.select(pais);
	}
}
