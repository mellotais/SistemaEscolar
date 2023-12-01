package com.classes.BO;


import com.classes.DTO.Professor;
import com.classes.DAO.ProfessorDAO;

import java.util.List;

public class ProfessorBO {
		
		
	public boolean inserir(Professor professor){
        if (existe(professor) != true) {
        	ProfessorDAO professorDAO = new ProfessorDAO();
            return professorDAO.inserir(professor);
        }
        return false;
    }
	
	public boolean alterar(Professor professor){
		ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.alterar(professor);
    }
	
	public boolean excluir(Professor professor){
		ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.excluir(professor);
    }
	
    
	public boolean existe(Professor professor){
		ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.existe(professor);
    }
    
    public List<Professor> pesquisarTodos(){
    	ProfessorDAO professorDAO = new ProfessorDAO();
        return professorDAO.pesquisarTodos();
    }
    
    
    public Professor procurarPorCodigo(Professor professor){
    	ProfessorDAO professorDAO = new ProfessorDAO();
    	return professorDAO.procurarPorCodigo(professor);
    }
	}