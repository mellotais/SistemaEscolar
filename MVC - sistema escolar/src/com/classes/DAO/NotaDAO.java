package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.Nota;
import com.classes.DTO.Aluno;
import com.classes.DTO.Disciplina;
import com.classes.Conexao.Conexao;

public class NotaDAO {

    final String NOMEDATABELA = "nota";

   
    public boolean inserir(Nota nota) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idnota, idaluno, iddisciplina, valor) VALUES (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nota.getId());
            ps.setInt(2, nota.getAluno().getId());  
            ps.setInt(3, nota.getDisciplina().getId());
            ps.setDouble(4, nota.getValor());

            ps.executeUpdate();

            

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Nota nota) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET idnota =?, idaluno = ?, iddisciplina = ?, valor = ? WHERE idnota = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nota.getId());
            ps.setInt(2, nota.getAluno().getId());  
            ps.setInt(3, nota.getDisciplina().getId());
            ps.setDouble(4, nota.getValor());
            ps.setInt(5, nota.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean excluir(Nota nota) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idnota = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nota.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Nota procurarPorCodigo(Nota nota) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idnota = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nota.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Nota obj = new Nota();
                obj.setId(rs.getInt(1));
                obj.setAluno(new Aluno(0, null, 0, null)); 
                obj.setDisciplina(new Disciplina(0, null, null, null));
                obj.setValor(rs.getDouble(4));
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

    public boolean existe(Nota nota) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idaluno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nota.getAluno().getId());
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

    public List<Nota> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Nota> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Nota> montarLista(ResultSet rs) {
        List<Nota> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                Nota obj = new Nota();
                obj.setId(rs.getInt(1));
                
                obj.setValor(rs.getDouble(4));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
