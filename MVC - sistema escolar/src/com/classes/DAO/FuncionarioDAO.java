package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Funcionario;
import com.classes.Conexao.Conexao;

public class FuncionarioDAO {

    final String NOMEDATABELA = "funcionario";

    public boolean inserir(Funcionario funcionario) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idfuncionario, nome, cargo) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCargo());
            ps.executeUpdate();

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Funcionario funcionario) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET idfuncionario = ?, nome = ?, cargo = ? WHERE idfuncionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCargo());
            ps.setInt(4, funcionario.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Funcionario funcionario) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idfuncionario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Funcionario procurarPorCodigo(Funcionario funcionario) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idfuncionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionario.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setCargo(rs.getString(3));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existe(Funcionario funcionario) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<Funcionario> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Funcionario> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Funcionario> montarLista(ResultSet rs) {
        List<Funcionario> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setCargo(rs.getString(3));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
