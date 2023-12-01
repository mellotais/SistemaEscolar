package com.classes.BO;

import java.util.List;
import com.classes.DAO.PresencaDAO;
import com.classes.DTO.Presenca;

public class PresencaBO {
    public boolean inserir(Presenca presenca) {
        if (!existe(presenca)) {
            PresencaDAO presencaDAO = new PresencaDAO();
            return presencaDAO.inserir(presenca);
        }
        return false;
    }

    public boolean alterar(Presenca presenca) {
        PresencaDAO presencaDAO = new PresencaDAO();
        return presencaDAO.alterar(presenca);
    }

    public boolean excluir(Presenca presenca) {
        PresencaDAO presencaDAO = new PresencaDAO();
        return presencaDAO.excluir(presenca);
    }

    public boolean existe(Presenca presenca) {
        PresencaDAO presencaDAO = new PresencaDAO();
        return presencaDAO.existe(presenca);
    }

    public List<Presenca> pesquisarTodos() {
        PresencaDAO presencaDAO = new PresencaDAO();
        return presencaDAO.pesquisarTodos();
    }

    public Presenca procurarPorCodigo(Presenca presenca) {
        PresencaDAO presencaDAO = new PresencaDAO();
        return presencaDAO.procurarPorCodigo(presenca);
    }
}
