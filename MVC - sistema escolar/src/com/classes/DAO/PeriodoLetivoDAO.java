package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.PeriodoLetivo;
import com.classes.Conexao.Conexao;

public class PeriodoLetivoDAO {

    final String NOMEDATABELA = "periodoletivo";

    public boolean inserir(PeriodoLetivo periodoLetivo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idperiodoletivo, datainicio, datatermino) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, periodoLetivo.getId());
            ps.setDate(2, new java.sql.Date(periodoLetivo.getDataInicio().getTime()));
            ps.setDate(3, new java.sql.Date(periodoLetivo.getDataTermino().getTime()));
            ps.executeUpdate();

            

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(PeriodoLetivo periodoLetivo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET idperiodoletivo = ?, datainicio = ?, datatermino = ? WHERE idperiodoletivo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, periodoLetivo.getId());
            ps.setDate(2, new java.sql.Date(periodoLetivo.getDataInicio().getTime()));
            ps.setDate(3, new java.sql.Date(periodoLetivo.getDataTermino().getTime()));
            ps.setInt(4, periodoLetivo.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(PeriodoLetivo periodoLetivo) {
        try {
            Connection conn = Conexao.conectar();

            excluirDisciplinasDaGradeCurricular(conn, periodoLetivo.getId());

            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idperiodoletivo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, periodoLetivo.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void excluirDisciplinasDaGradeCurricular(Connection conn, int idPeriodoLetivo) {
        try {
            String sql = "DELETE FROM gradecurricular WHERE idperiodoletivo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPeriodoLetivo);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public PeriodoLetivo procurarPorCodigo(PeriodoLetivo periodoLetivo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idperiodoletivo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, periodoLetivo.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PeriodoLetivo obj = new PeriodoLetivo();
                obj.setId(rs.getInt(1));
                obj.setDataInicio(rs.getDate(2));
                obj.setDataTermino(rs.getDate(3));
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

    public boolean existe(PeriodoLetivo periodoLetivo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE datainicio = ? AND datatermino = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(periodoLetivo.getDataInicio().getTime()));
            ps.setDate(2, new java.sql.Date(periodoLetivo.getDataTermino().getTime()));
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

    public List<PeriodoLetivo> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<PeriodoLetivo> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<PeriodoLetivo> montarLista(ResultSet rs) {
        List<PeriodoLetivo> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                PeriodoLetivo obj = new PeriodoLetivo();
                obj.setId(rs.getInt(1));
                obj.setDataInicio(rs.getDate(2));
                obj.setDataTermino(rs.getDate(3));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }
}
