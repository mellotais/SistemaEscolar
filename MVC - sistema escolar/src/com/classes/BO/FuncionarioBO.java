package com.classes.BO;

import java.util.List;
import com.classes.DAO.FuncionarioDAO;
import com.classes.DTO.Funcionario;

public class FuncionarioBO {
    public boolean inserir(Funcionario funcionario) {
        if (!existe(funcionario)) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            return funcionarioDAO.inserir(funcionario);
        }
        return false;
    }

    public boolean alterar(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.alterar(funcionario);
    }

    public boolean excluir(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.excluir(funcionario);
    }

    public boolean existe(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.existe(funcionario);
    }

    public List<Funcionario> pesquisarTodos() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.pesquisarTodos();
    }

    public Funcionario procurarPorCodigo(Funcionario funcionario) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.procurarPorCodigo(funcionario);
    }
}
