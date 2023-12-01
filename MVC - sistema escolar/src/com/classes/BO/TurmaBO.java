package com.classes.BO;

import java.util.List;

import com.classes.DAO.TurmaDAO;
import com.classes.DTO.Turma;

public class TurmaBO {
    public boolean inserir(Turma turma) {
        if (!existe(turma)) {
            TurmaDAO turmaDAO = new TurmaDAO();
            return turmaDAO.inserir(turma);
        }
        return false;
    }

    public boolean alterar(Turma turma) {
    	TurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.alterar(turma); 
    }
    
   

    public boolean excluir(Turma turma) {
        TurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.excluir(turma);
    }

    public boolean existe(Turma turma) {
        TurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.existe(turma);
    }

    public List<Turma> pesquisarTodos() {
        TurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.pesquisarTodos();
    }

    public Turma procurarPorCodigo(Turma turma) {
        TurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.procurarPorCodigo(turma);
    }
}
