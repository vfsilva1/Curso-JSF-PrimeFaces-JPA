package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@SessionScoped
public class ProfessorManagedBean {
	
	private Professor prof = new Professor();
	private ProfessorService service = new ProfessorService();
	
	public void salvar()
	{
		service.salvar(prof);
		prof = new Professor();
	}
	
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	public List<Professor> getProfessores(){
		return service.getProfessores();
	}
}
