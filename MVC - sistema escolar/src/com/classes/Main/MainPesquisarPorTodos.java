package com.classes.Main;

import java.util.List;

import com.classes.BO.AlunoBO;
import com.classes.BO.AulaBO;
import com.classes.BO.DisciplinaBO;
import com.classes.BO.FuncionarioBO;
import com.classes.BO.GradeCurricularBO;
import com.classes.BO.NotaBO;
import com.classes.BO.PeriodoLetivoBO;
import com.classes.BO.PresencaBO;
import com.classes.BO.ProfessorBO;
import com.classes.BO.TurmaBO;
import com.classes.DTO.Aluno;
import com.classes.DTO.Aula;
import com.classes.DTO.Disciplina;
import com.classes.DTO.Funcionario;
import com.classes.DTO.GradeCurricular;
import com.classes.DTO.Nota;
import com.classes.DTO.PeriodoLetivo;
import com.classes.DTO.Presenca;
import com.classes.DTO.Professor;
import com.classes.DTO.Turma;

public class MainPesquisarPorTodos {

    public static void main(String[] args) {
        
        // **PROCURAR TODOS OS ALUNOS**
        AlunoBO alunoBO = new AlunoBO();
        List<Aluno> listaAlunos = alunoBO.pesquisarTodos();
        System.out.println("Alunos:");
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno.toString());
        }

        // **PROCURAR TODAS AS AULAS**
        AulaBO aulaBO = new AulaBO();
        List<Aula> listaAulas = aulaBO.pesquisarTodos();
        System.out.println("\nAulas:");
        for (Aula aula : listaAulas) {
            System.out.println(aula.toString());
        }

        // **PROCURAR TODAS AS DISCIPLINAS**
        DisciplinaBO disciplinaBO = new DisciplinaBO();
        List<Disciplina> listaDisciplinas = disciplinaBO.pesquisarTodos();
        System.out.println("\nDisciplinas:");
        for (Disciplina disciplina : listaDisciplinas) {
            System.out.println(disciplina.toString());
        }

        // **PROCURAR TODOS OS FUNCIONÁRIOS**
        FuncionarioBO funcionarioBO = new FuncionarioBO();
        List<Funcionario> listaFuncionarios = funcionarioBO.pesquisarTodos();
        System.out.println("\nFuncionários:");
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario.toString());
        }

        // **PROCURAR TODAS AS GRADES CURRICULARES**
        GradeCurricularBO gradeCurricularBO = new GradeCurricularBO();
        List<GradeCurricular> listaGrades = gradeCurricularBO.pesquisarTodos();
        System.out.println("\nGrades Curriculares:");
        for (GradeCurricular gradeCurricular : listaGrades) {
            System.out.println(gradeCurricular.toString());
        }

        // **PROCURAR TODAS AS NOTAS**
        NotaBO notaBO = new NotaBO();
        List<Nota> listaNotas = notaBO.pesquisarTodos();
        System.out.println("\nNotas:");
        for (Nota nota : listaNotas) {
            System.out.println(nota.toString());
        }

        // **PROCURAR TODOS OS PERÍODOS LETIVOS**
        PeriodoLetivoBO periodoLetivoBO = new PeriodoLetivoBO();
        List<PeriodoLetivo> listaPeriodos = periodoLetivoBO.pesquisarTodos();
        System.out.println("\nPeríodos Letivos:");
        for (PeriodoLetivo periodoLetivo : listaPeriodos) {
            System.out.println(periodoLetivo.toString());
        }

        // **PROCURAR TODAS AS PRESENÇAS**
        PresencaBO presencaBO = new PresencaBO();
        List<Presenca> listaPresencas = presencaBO.pesquisarTodos();
        System.out.println("\nPresenças:");
        for (Presenca presenca : listaPresencas) {
            System.out.println(presenca.toString());
        }

        // **PROCURAR TODOS OS PROFESSORES**
        ProfessorBO professorBO = new ProfessorBO();
        List<Professor> listaProfessores = professorBO.pesquisarTodos();
        System.out.println("\nProfessores:");
        for (Professor professor : listaProfessores) {
            System.out.println(professor.toString());
        }

        // **PROCURAR TODAS AS TURMAS**
        TurmaBO turmaBO = new TurmaBO();
        List<Turma> listaTurmas = turmaBO.pesquisarTodos();
        System.out.println("\nTurmas:");
        for (Turma turma : listaTurmas) {
            System.out.println(turma.toString());
        }
    }
}
