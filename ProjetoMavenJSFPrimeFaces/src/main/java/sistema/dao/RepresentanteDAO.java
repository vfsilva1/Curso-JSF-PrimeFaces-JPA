package sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;

import sistema.dao.generic.DAOImpl;
import sistema.modelos.Fornecedor;
import sistema.modelos.Representante;

public class RepresentanteDAO extends DAOImpl<Representante, Integer>{

	public List<Fornecedor> getFornecedoresRepresentantes(Representante representanteSelecionado) {
		
		List<Fornecedor> fornecedores = null;
		EntityManager em = getEntityManager();
		Representante r = em.find(Representante.class, representanteSelecionado.getNumero());
		em.refresh(r);
		fornecedores = r.getFornecedores();
		em.close();

		return fornecedores;
	}

}
