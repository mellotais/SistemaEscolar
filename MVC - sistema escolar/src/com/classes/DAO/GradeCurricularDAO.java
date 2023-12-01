package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.DTO.GradeCurricular;
import com.classes.DTO.Disciplina;
import com.classes.DTO.PeriodoLetivo;
import com.classes.Conexao.Conexao;

public class GradeCurricularDAO {

    final String NOMEDATABELA = "gradecurricular";

    public boolean inserir(GradeCurricular gradeCurricular) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (idgradecurricular, idperiodoletivo) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gradeCurricular.getId());
            ps.setInt(2, gradeCurricular.getPeriodoLetivoAssociado().getId());
            ps.executeUpdate();

            inserirDisciplinas(gradeCurricular);

            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(GradeCurricular gradeCurricular) {
        try {
            Connection conn = Conexao.conectar();

            removerDisciplinas(gradeCurricular.getId());

            if (gradeCurricular.getPeriodoLetivoAssociado() == null || gradeCurricular.getPeriodoLetivoAssociado().getId() <= 0) {
                System.out.println("ID de período letivo inválido.");
                return false;
            }

            String sqlUpdate = "UPDATE " + NOMEDATABELA + " SET idperiodoletivo = ? WHERE idgradecurricular = ?;";
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, gradeCurricular.getPeriodoLetivoAssociado().getId());
            psUpdate.setInt(2, gradeCurricular.getId());
            psUpdate.executeUpdate();
            psUpdate.close();

            inserirDisciplinas(gradeCurricular);

            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(GradeCurricular gradeCurricular) {
        try {
            Connection conn = Conexao.conectar();

            removerDisciplinas(gradeCurricular.getId());

            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idgradecurricular = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gradeCurricular.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public GradeCurricular procurarPorCodigo(GradeCurricular gradeCurricular) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idgradecurricular = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gradeCurricular.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                GradeCurricular obj = new GradeCurricular();
                obj.setId(rs.getInt(1));
                obj.setPeriodoLetivoAssociado(new PeriodoLetivo(0, null, null));
                obj.setDisciplinas(carregarDisciplinas(obj.getId()));
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

    public boolean existe(GradeCurricular gradeCurricular) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idgradecurricular = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,gradeCurricular.getId());
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

    public List<GradeCurricular> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<GradeCurricular> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    public List<GradeCurricular> montarLista(ResultSet rs) {
        List<GradeCurricular> listObj = new ArrayList<>();
        try {
            while (rs.next()) {
                GradeCurricular obj = new GradeCurricular();
                obj.setId(rs.getInt(1));
                
                obj.setDisciplinas(carregarDisciplinas(obj.getId()));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            return null;
        }
    }

    private void inserirDisciplinas(GradeCurricular gradeCurricular) {
        try {
            Connection conn = Conexao.conectar();
            
            if (!existe(gradeCurricular)) {
                conn.close();
                return;
            }

            String sql = "INSERT INTO gradecurricular_disciplina (idgradecurricular, iddisciplina) VALUES (?, ?);";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                conn.setAutoCommit(false);

                for (Disciplina disciplina : gradeCurricular.getDisciplinas()) {
                    ps.setInt(1, gradeCurricular.getId());
                    ps.setInt(2, disciplina.getId());
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            } finally {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removerDisciplinas(int gradeCurricularId) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM gradecurricular_disciplina WHERE idgradecurricular = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gradeCurricularId);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Disciplina> carregarDisciplinas(int gradeCurricularId) {
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT iddisciplina FROM gradecurricular_disciplina WHERE idgradecurricular = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, gradeCurricularId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt(1));
                disciplinas.add(disciplina);
            }
            ps.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinas;
    }
}
