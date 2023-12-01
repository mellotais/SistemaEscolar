package com.classes.BO;

import java.util.List;
import com.classes.DAO.PeriodoLetivoDAO;
import com.classes.DTO.PeriodoLetivo;

public class PeriodoLetivoBO {
    public boolean inserir(PeriodoLetivo periodoLetivo) {
        if (!existe(periodoLetivo)) {
            PeriodoLetivoDAO periodoLetivoDAO = new PeriodoLetivoDAO();
            return periodoLetivoDAO.inserir(periodoLetivo);
        }
        return false;
    }

    public boolean alterar(PeriodoLetivo periodoLetivo) {
        PeriodoLetivoDAO periodoLetivoDAO = new PeriodoLetivoDAO();
        return periodoLetivoDAO.alterar(periodoLetivo);
    }

    public boolean excluir(PeriodoLetivo periodoLetivo) {
        PeriodoLetivoDAO periodoLetivoDAO = new PeriodoLetivoDAO();
        return periodoLetivoDAO.excluir(periodoLetivo);
    }

    public boolean existe(PeriodoLetivo periodoLetivo) {
        PeriodoLetivoDAO periodoLetivoDAO = new PeriodoLetivoDAO();
        return periodoLetivoDAO.existe(periodoLetivo);
    }

    public List<PeriodoLetivo> pesquisarTodos() {
        PeriodoLetivoDAO periodoLetivoDAO = new PeriodoLetivoDAO();
        return periodoLetivoDAO.pesquisarTodos();
    }

    public PeriodoLetivo procurarPorCodigo(PeriodoLetivo periodoLetivo) {
        PeriodoLetivoDAO periodoLetivoDAO = new PeriodoLetivoDAO();
        return periodoLetivoDAO.procurarPorCodigo(periodoLetivo);
    }
}
