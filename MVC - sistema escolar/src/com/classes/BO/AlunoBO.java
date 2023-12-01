package com.classes.BO;

import java.util.List;
import com.classes.DAO.AlunoDAO;
import com.classes.DTO.Aluno;

public class AlunoBO {
	public boolean inserir(Aluno aluno){
        if (existe(aluno) != true) {
        	AlunoDAO alunoDAO = new AlunoDAO();
            return alunoDAO.inserir(aluno);
        }
        return false;
    }
	
    public boolean alterar(Aluno aluno){
    	AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.alterar(aluno);
    }
    
    public boolean excluir(Aluno aluno){
    	AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.excluir(aluno);
    }

   
    public boolean existe(Aluno aluno){
    	AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.existe(aluno);
    }
    
    public List<Aluno> pesquisarTodos(){
    	AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.pesquisarTodos();
    }
    public Aluno procurarPorCodigo(Aluno aluno){
    	AlunoDAO alunoDAO = new AlunoDAO();
    	return alunoDAO.procurarPorCodigo(aluno);
    }
}