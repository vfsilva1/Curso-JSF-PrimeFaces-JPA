package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import sistema.modelos.Representante;
import org.primefaces.model.SelectableDataModel;
import sistema.service.RepresentanteService;

public class RepresentanteDataModel extends ListDataModel<Representante> implements SelectableDataModel<Representante> 
{
	private static RepresentanteService servico = new RepresentanteService();
	
	public RepresentanteDataModel()
	{
		
	}

	public RepresentanteDataModel(List <Representante> list)
	{
	   super(list);	
	}

	
	@Override
	public Representante getRowData(String rowKey) {
		
		for(Representante r: servico.getRepresentantes())
		   if(Integer.parseInt(rowKey) ==  r.getNumero())
			   return r;
		
		return null;
	}

	@Override
	public Object getRowKey(Representante representante) {
		return representante.getNumero();
	}
	
}