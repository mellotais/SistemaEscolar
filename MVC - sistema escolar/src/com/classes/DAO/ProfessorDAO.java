package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Professor;
import com.classes.Conexao.Conexao;

public class ProfessorDAO {

    final String NOMEDATABELA = "professor";

    public boolean inserir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idprofessor, nome, disciplina, cargahoraria) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor.getId());
            ps.setString(2, professor.getNome());
            ps.setString(3, professor.getDisciplina());
            ps.setInt(4, professor.getCargaHoraria());
            ps.executeUpdate();

            

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET idprofessor = ?, nome = ?, disciplina = ?, cargahoraria = ? WHERE idprofessor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor.getId());
            ps.setString(2, professor.getNome());
            ps.setString(3, professor.getDisciplina());
            ps.setInt(4, professor.getCargaHoraria());
            ps.setInt(5, professor.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Professor professor) {
        try {
            Connection conn = Conexao.conectar();

            excluirTurmasDoProfessor(conn, professor.getId());

            excluirDisciplinasDoProfessor(conn, professor.getId());

            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idprofessor = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void excluirTurmasDoProfessor(Connection conn, int idProfessor) {
        try {
            String sql = "DELETE FROM turma_professor WHERE idprofessor = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProfessor);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void excluirDisciplinasDoProfessor(Connection conn, int idProfessor) {
        try {

            excluirDisciplinasDaGradeCurricular(conn, idProfessor);

            String sql = "DELETE FROM disciplina WHERE idprofessor = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProfessor);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirDisciplinasDaGradeCurricular(Connection conn, int idProfessor) {
        try {

            excluirAulas(conn, idProfessor);

            String sql = "DELETE FROM gradecurricular_disciplina WHERE iddisciplina IN (SELECT iddisciplina FROM disciplina WHERE idprofessor = ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProfessor);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirAulas(Connection conn, int idProfessor) {
        try {
            String sql = "DELETE FROM aula WHERE iddisciplina IN (SELECT iddisciplina FROM disciplina WHERE idprofessor = ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProfessor);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Professor procurarPorCodigo(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idprofessor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Professor obj = new Professor();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDisciplina(rs.getString(3));
                obj.setCargaHoraria(rs.getInt(4));
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

    public boolean existe(Professor professor) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ? AND disciplina = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getDisciplina());
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

    public List<Professor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Professor> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Professor> montarLista(ResultSet rs) {
        List<Professor> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Professor obj = new Professor();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setDisciplina(rs.getString(3));
                obj.setCargaHoraria(rs.getInt(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
