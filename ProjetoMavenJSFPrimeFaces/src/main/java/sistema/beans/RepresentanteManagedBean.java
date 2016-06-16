package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;
import sistema.beans.datamodel.*;
import sistema.service.FornecedorService;
import sistema.service.RepresentanteService;
import sistema.modelos.Fornecedor;
import sistema.modelos.Representante;

@ManagedBean
@SessionScoped
public class RepresentanteManagedBean {

	  private Representante representante = new Representante();
	  private Representante representanteSelecionado = new Representante();
	  private RepresentanteService servicoRepre = new RepresentanteService();
	  private FornecedorService    servidoForne = new FornecedorService(); 
	  private DualListModel<Fornecedor> dualList = new DualListModel<Fornecedor>();
	  
	  
	  public void salvar()
	  {
		  servicoRepre.salvar(representante);
		  representante = new Representante();
		  
	  }
	  
	  public void addFornecedorToRepresentante(Representante representante)
	  {
		representanteSelecionado = representante;  
		  
	  }
	  
	  public DualListModel<Fornecedor> getFornecedores()
	  {
		   
		   List <Fornecedor> source  = new ArrayList<Fornecedor>();
		   List <Fornecedor> target  =  new ArrayList<Fornecedor>();
		   
		   source.addAll(servidoForne.getFornecedores());
		
		   if(representanteSelecionado != null)
		   {
			   target.addAll(representanteSelecionado.getFornecedores());
			   source.removeAll(representanteSelecionado.getFornecedores());
		   }
		   
		   dualList.setSource(source);
		   dualList.setTarget(target);
		   
		   return dualList;
		   
	  }
	  
	  public void setFornecedores(DualListModel<Fornecedor> fornecedores)
	  {
		  this.dualList = fornecedores;
		  
	  }


	  
	  public void remove(Representante representante)
	  {
		  servicoRepre.remover(representante);
		  
	  }


	/**
	 * @return the representanteSelecionado
	 */
	public Representante getRepresentanteSelecionado() {
		return representanteSelecionado;
	}

   public void associar()
   {
	   
	   
	   for(Fornecedor f : dualList.getSource())
	   {   
          f.getRepresentantes().remove(representanteSelecionado);
	   }
	   
	   for(Fornecedor f : dualList.getTarget())
	   {   
          f.getRepresentantes().add(representanteSelecionado);
	   }
	   
	   representanteSelecionado.getFornecedores().clear();
	   representanteSelecionado.getFornecedores().addAll(dualList.getTarget());

	   servicoRepre.alterar(representanteSelecionado);
	   
	   representanteSelecionado.getFornecedores().clear();
	   representanteSelecionado.getFornecedores().clear();
	   
	   
	   
   }


	/**
	 * @param representanteSelecionado the representanteSelecionado to set
	 */
	public void setRepresentanteSelecionado(Representante representanteSelecionado) {
		this.representanteSelecionado = representanteSelecionado;
	}




	/**
	 * @return the representante
	 */
	public Representante getRepresentante() {
		return representante;
	}


	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	
	  
	public RepresentanteDataModel getRepresentantes()
	{
		return new RepresentanteDataModel(servicoRepre.getRepresentantes());
	}
	  
	
}
