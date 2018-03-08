package sistema.service;

import java.util.ArrayList;

import sistema.modelos.Professor;

public class ProfessorService {
	
	private ArrayList <Professor> professores = new ArrayList<Professor>();
	
	public ProfessorService() {}
	
	public void salvar(Professor prof)
	{
		professores.add(prof);
	}

	
	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	

}
