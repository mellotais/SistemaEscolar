package com.classes.BO;

import java.util.List;
import com.classes.DAO.AulaDAO;
import com.classes.DTO.Aula;

public class AulaBO {
    public boolean inserir(Aula aula) {
        if (!existe(aula)) {
            AulaDAO aulaDAO = new AulaDAO();
            return aulaDAO.inserir(aula);
        }
        return false;
    }

    public boolean alterar(Aula aula) {
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.alterar(aula);
    }

    public boolean excluir(Aula aula) {
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.excluir(aula);
    }

    public boolean existe(Aula aula) {
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.existe(aula);
    }

    public List<Aula> pesquisarTodos() {
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.pesquisarTodos();
    }

    public Aula procurarPorCodigo(Aula aula) {
        AulaDAO aulaDAO = new AulaDAO();
        return aulaDAO.procurarPorCodigo(aula);
    }
}
