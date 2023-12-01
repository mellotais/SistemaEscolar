package com.classes.BO;

import java.util.List;
import com.classes.DAO.NotaDAO;
import com.classes.DTO.Nota;

public class NotaBO {
    public boolean inserir(Nota nota) {
        if (!existe(nota)) {
            NotaDAO notaDAO = new NotaDAO();
            return notaDAO.inserir(nota);
        }
        return false;
    }

    public boolean alterar(Nota nota) {
        NotaDAO notaDAO = new NotaDAO();
        return notaDAO.alterar(nota);
    }

    public boolean excluir(Nota nota) {
        NotaDAO notaDAO = new NotaDAO();
        return notaDAO.excluir(nota);
    }

    public boolean existe(Nota nota) {
        NotaDAO notaDAO = new NotaDAO();
        return notaDAO.existe(nota);
    }

    public List<Nota> pesquisarTodos() {
        NotaDAO notaDAO = new NotaDAO();
        return notaDAO.pesquisarTodos();
    }

    public Nota procurarPorCodigo(Nota nota) {
        NotaDAO notaDAO = new NotaDAO();
        return notaDAO.procurarPorCodigo(nota);
    }
}
