package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Presenca;
import com.classes.DTO.Aluno;
import com.classes.Conexao.Conexao;

public class PresencaDAO {

    final String NOMEDATABELA = "presenca";

    public boolean inserir(Presenca presenca) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idpresenca, idaluno, data, presente) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, presenca.getId());
            ps.setInt(2, presenca.getAluno().getId());
            ps.setDate(3, new java.sql.Date(presenca.getData().getTime()));
            ps.setBoolean(4, presenca.isPresente());
            ps.executeUpdate();

            

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Presenca presenca) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET idpresenca = ?, idaluno = ?, data = ?, presente = ? WHERE idpresenca = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, presenca.getId());
            ps.setInt(2, presenca.getAluno().getId());
            ps.setDate(3, new java.sql.Date(presenca.getData().getTime()));
            ps.setBoolean(4, presenca.isPresente());
            ps.setInt(5, presenca.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Presenca presenca) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idpresenca = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, presenca.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Presenca procurarPorCodigo(Presenca presenca) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idpresenca = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, presenca.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Presenca obj = new Presenca();
                obj.setId(rs.getInt(1));
                obj.setAluno(new Aluno(0, null, 0, null)); 
                obj.setData(rs.getDate(3));
                obj.setPresente(rs.getBoolean(4));
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

    public boolean existe(Presenca presenca) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idpresenca = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, presenca.getId());
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

    public List<Presenca> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Presenca> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Presenca> montarLista(ResultSet rs) {
        List<Presenca> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Presenca obj = new Presenca();
                obj.setId(rs.getInt(1));
                obj.setData(rs.getDate(3));
                obj.setPresente(rs.getBoolean(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
