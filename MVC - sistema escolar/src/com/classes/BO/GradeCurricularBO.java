package com.classes.BO;

import java.util.List;
import com.classes.DAO.GradeCurricularDAO;
import com.classes.DTO.GradeCurricular;

public class GradeCurricularBO {
    public boolean inserir(GradeCurricular gradeCurricular) {
        if (!existe(gradeCurricular)) {
            GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
            return gradeCurricularDAO.inserir(gradeCurricular);
        }
        return false;
    }

    public boolean alterar(GradeCurricular gradeCurricular) {
        GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
        return gradeCurricularDAO.alterar(gradeCurricular);
    }

    public boolean excluir(GradeCurricular gradeCurricular) {
        GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
        return gradeCurricularDAO.excluir(gradeCurricular);
    }

    public boolean existe(GradeCurricular gradeCurricular) {
        GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
        return gradeCurricularDAO.existe(gradeCurricular);
    }

    public List<GradeCurricular> pesquisarTodos() {
        GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
        return gradeCurricularDAO.pesquisarTodos();
    }

    public GradeCurricular procurarPorCodigo(GradeCurricular gradeCurricular) {
        GradeCurricularDAO gradeCurricularDAO = new GradeCurricularDAO();
        return gradeCurricularDAO.procurarPorCodigo(gradeCurricular);
    }
}
