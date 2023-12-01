package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Aluno;
import com.classes.Conexao.Conexao;

public class AlunoDAO {

    final String NOMEDATABELA = "aluno";

    public boolean inserir(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idaluno, nome, idade, turma) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ps.setString(2, aluno.getNome());
            ps.setInt(3, aluno.getIdade());
            ps.setString(4, aluno.getTurma());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ?, idade = ?, turma = ? WHERE idaluno = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setString(3, aluno.getTurma());
            ps.setInt(4, aluno.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    

    public boolean excluir(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();

            excluirNotasDoAluno(conn, aluno.getId());
            excluirPresencasDoAluno(conn, aluno.getId());
            excluirAlunosDaTurma(conn, aluno.getId());

            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE (idaluno, nome, idade, turma) = (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ps.setString(2, aluno.getNome());
            ps.setInt(3, aluno.getIdade());
            ps.setString(4, aluno.getTurma());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void excluirNotasDoAluno(Connection conn, int idAluno) {
        try {
            String sql = "DELETE FROM nota WHERE idaluno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAluno);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirAlunosDaTurma(Connection conn, int idAluno) {
        try {
            String sql = "DELETE FROM turma_aluno WHERE idaluno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAluno);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean excluirPresencasDoAluno(Connection conn, int idAluno) {
        try {
            String sql = "DELETE FROM  presenca WHERE idaluno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAluno);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public Aluno procurarPorCodigo(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idaluno = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aluno obj = new Aluno();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setIdade(rs.getInt(3));
                obj.setTurma(rs.getString(4));
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

    public boolean existe(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + "  WHERE (idaluno, nome, idade, turma) = (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getId());
            ps.setString(2, aluno.getNome());
            ps.setInt(3, aluno.getIdade());
            ps.setString(4, aluno.getTurma());
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

    public List<Aluno> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Aluno> montarLista(ResultSet rs) {
        List<Aluno> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Aluno obj = new Aluno();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setIdade(rs.getInt(3));
                obj.setTurma(rs.getString(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
