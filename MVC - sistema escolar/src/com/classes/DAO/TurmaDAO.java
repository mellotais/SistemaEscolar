package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Turma;
import com.classes.DTO.Aluno;
import com.classes.DTO.Professor;
import com.classes.Conexao.Conexao;

public class TurmaDAO {

    final String NOMEDATABELA = "turma";

    
    public boolean inserir(Turma turma) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idturma, horario) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ps.setString(2, turma.getHorario());
            ps.executeUpdate();

            

            // Inserir alunos na turma
            inserirAlunosNaTurma(conn, turma);

            // Inserir professores na turma
            inserirProfessoresNaTurma(conn, turma);

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void inserirAlunosNaTurma(Connection conn, Turma turma) {
        try {
            String sql = "INSERT INTO turma_aluno (idturma, idaluno) VALUES(?, ?);";
            for (Aluno aluno : turma.getAluno()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, turma.getId());
                ps.setInt(2, aluno.getId());
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inserirProfessoresNaTurma(Connection conn, Turma turma) {
        try {
            String sql = "INSERT INTO turma_professor (idturma, idprofessor) VALUES (?, ?);";
            for (Professor professor : turma.getProfessores()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, turma.getId());
                ps.setInt(2, professor.getId());
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean alterar(Turma turma) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET horario = ? WHERE idturma = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, turma.getHorario());
            ps.setInt(2, turma.getId());
            ps.executeUpdate();

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void excluirAlunosDaTurma(Connection conn, Turma turma) {
        try {
            String sql = "DELETE FROM turma_aluno WHERE idturma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirProfessoresDaTurma(Connection conn, Turma turma) {
        try {
            String sql = "DELETE FROM turma_professor WHERE idturma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean excluir(Turma turma) {
        try {
            Connection conn = Conexao.conectar();

            // Excluir alunos da turma
            excluirAlunosDaTurma(conn, turma);

            // Excluir professores da turma
            excluirProfessoresDaTurma(conn, turma);

            // Excluir a turma
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idturma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ps.executeUpdate();

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Turma procurarPorCodigo(Turma turma) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idturma = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Turma obj = new Turma();
                obj.setId(rs.getInt(1));
                obj.setHorario(rs.getString(2));
                obj.setAluno(buscarAlunosDaTurma(conn, obj));
                obj.setProfessores(buscarProfessoresDaTurma(conn, obj));
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

    private List<Aluno> buscarAlunosDaTurma(Connection conn, Turma turma) {
        try {
            List<Aluno> alunos = new ArrayList<>();
            String sql = "SELECT idaluno FROM turma_aluno WHERE idturma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt(1));
                alunos.add(aluno);
            }
            ps.close();
            rs.close();
            return alunos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Professor> buscarProfessoresDaTurma(Connection conn, Turma turma) {
        try {
            List<Professor> professores = new ArrayList<>();
            String sql = "SELECT idprofessor FROM turma_professor WHERE idturma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, turma.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getInt(1));
                professores.add(professor);
            }
            ps.close();
            rs.close();
            return professores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existe(Turma turma) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE horario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, turma.getHorario());
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

    public List<Turma> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Turma> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Turma> montarLista(ResultSet rs) {
        List<Turma> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Turma obj = new Turma();
                obj.setId(rs.getInt(1));
                obj.setHorario(rs.getString(2));
                obj.setAluno(buscarAlunosDaTurma(Conexao.conectar(), obj));
                obj.setProfessores(buscarProfessoresDaTurma(Conexao.conectar(), obj));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
