package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Disciplina;
import com.classes.DTO.Professor;
import com.classes.Conexao.Conexao;

public class DisciplinaDAO {

    final String NOMEDATABELA = "disciplina";

    public boolean inserir(Disciplina disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (iddisciplina, nome, idprofessor) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, disciplina.getId());
            ps.setString(2, disciplina.getNome());
            ps.setInt(3, disciplina.getProfessorResponsavel().getId());
            ps.executeUpdate();

            

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Disciplina disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ?, idprofessor = ? WHERE iddisciplina = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getProfessorResponsavel().getId());
            ps.setInt(3, disciplina.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean excluir(Disciplina disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE iddisciplina = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, disciplina.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Disciplina procurarPorCodigo(Disciplina disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE iddisciplina = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, disciplina.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Disciplina obj = new Disciplina();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setProfessorResponsavel(new Professor(0, null, null, 0)); 
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

    public boolean existe(Disciplina disciplina) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, disciplina.getNome());
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

    public List<Disciplina> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Disciplina> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Disciplina> montarLista(ResultSet rs) {
        List<Disciplina> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Disciplina obj = new Disciplina();
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
