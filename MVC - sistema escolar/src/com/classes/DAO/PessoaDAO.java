package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Pessoa;
import com.classes.Conexao.Conexao;

public class PessoaDAO {

    final String NOMEDATABELA = "pessoa";

    public boolean inserir(Pessoa pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            }

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Pessoa pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE idpessoa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Pessoa pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idpessoa = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pessoa procurarPorCodigo(Pessoa pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idpessoa = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pessoa obj = new Pessoa();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
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

    public boolean existe(Pessoa pessoa) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
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

    public List<Pessoa> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Pessoa> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Pessoa> montarLista(ResultSet rs) {
        List<Pessoa> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Pessoa obj = new Pessoa();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
