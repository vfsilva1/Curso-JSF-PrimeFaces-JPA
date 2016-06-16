package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Representante;
import sistema.dao.RepresentanteDAO;
import sistema.modelos.Fornecedor;


public class RepresentanteService  {

	private RepresentanteDAO dao = new RepresentanteDAO();
	
	public List<Fornecedor> getFornecedoresRepresentante(Representante representanteSelecionado) {
		List <Fornecedor> list = dao.getFornecedoresRepresentantes(representanteSelecionado);
		dao.closeEntityManager();
		return list;
	}

	public List<Representante> getRepresentantes() {		
		List <Representante> list = dao.getAll(Representante.class);
		dao.closeEntityManager();
		return list;
	}

	public void salvar(Representante representante) {
		dao.save(representante);
		dao.closeEntityManager();
	}

	public void remover(Representante representante) {
		dao.remove(representante);
		dao.closeEntityManager();
	}


	public void alterar(Representante representante) {
		dao.save(representante);
		dao.closeEntityManager();
	}

}
