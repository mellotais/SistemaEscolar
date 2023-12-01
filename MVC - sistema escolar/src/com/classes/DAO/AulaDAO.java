package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.classes.DTO.Aula;
import com.classes.DTO.Disciplina;
import com.classes.Conexao.Conexao;

public class AulaDAO {

    final String NOMEDATABELA = "aula";

    public boolean inserir(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idaula, iddisciplina, horario, local) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aula.getId());
            ps.setInt(2, aula.getDisciplina().getId());
            ps.setString(3, aula.getHorario());
            ps.setString(4, aula.getLocal());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET idaula = ?, iddisciplina = ?, horario = ?, local = ? WHERE idaula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aula.getId());
            ps.setInt(2, aula.getDisciplina().getId());
            ps.setString(3, aula.getHorario());
            ps.setString(4, aula.getLocal());
            ps.setInt(5, aula.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idaula = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aula.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Aula procurarPorCodigo(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idaula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aula.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aula obj = new Aula();
                obj.setId(rs.getInt(1));
                obj.setDisciplina(new Disciplina(0, null, null, null)); 
                obj.setHorario(rs.getString(3));
                obj.setLocal(rs.getString(4));
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

    public boolean existe(Aula aula) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + "  WHERE (iddisciplina, horario, local) = (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aula.getDisciplina().getId());
            ps.setString(2, aula.getHorario());
            ps.setString(3, aula.getLocal());
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

    public List<Aula> pesquisarTodos() {
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + NOMEDATABELA);
             ResultSet rs = ps.executeQuery()) {

            return montarLista(rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao pesquisar aulas", e);
        }
    }


    public List<Aula> montarLista(ResultSet rs) {
        List<Aula> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("idaula");
                String horario = rs.getString("horario");
                String local = rs.getString("local");

                int disciplinaId = rs.getInt("iddisciplina");
                String disciplinaNome = recuperarNomeDisciplina(disciplinaId);
                Disciplina disciplina = new Disciplina(disciplinaId, disciplinaNome, null, null);

                Aula obj = new Aula(id, disciplina, horario, local);
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public String recuperarNomeDisciplina(int disciplinaId) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT nome FROM disciplina WHERE iddisciplina = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, disciplinaId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nome");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
    }
    }
}
