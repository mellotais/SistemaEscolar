package com.classes.Main;

import java.sql.Date;
import java.util.ArrayList;
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

public class MainExcluirAlteração {

    public static void main(String[] args) {

        // **EXCLUI UM ALUNO**
        AlunoBO alunoBO = new AlunoBO();
        Aluno aluno = new Aluno(1, "João Silva", 21, "Engenharia");

        if (alunoBO.excluir(aluno))
            System.out.println("Aluno Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Aluno");

        Aluno aluno1 = new Aluno(2, "Maria Souza", 23, "Ciência da Computação");
        if (alunoBO.excluir(aluno1))
            System.out.println("Aluno Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Aluno");

        Aluno aluno2 = new Aluno(3, "Pedro Oliveira", 25, "Matemática");
        if (alunoBO.excluir(aluno2))
            System.out.println("Aluno Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Aluno");

        Aluno aluno3 = new Aluno(4, "Gilberto Santos", 26, "Matemática");
        if (alunoBO.excluir(aluno3))
            System.out.println("Aluno Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Aluno");

        Aluno aluno4 = new Aluno(5, "Vanessa Lima", 22, "Biologia");
        if (alunoBO.excluir(aluno4))
            System.out.println("Aluno Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Aluno");

        // Criar uma lista de alunos

        List<Aluno> alunosDaTurma = new ArrayList<>();
        alunosDaTurma.add(aluno);

        List<Aluno> alunosDaTurma1 = new ArrayList<>();
        alunosDaTurma1.add(aluno1);

        List<Aluno> alunosDaTurma2 = new ArrayList<>();
        alunosDaTurma2.add(aluno2);

        // **EXCLUI UM FUNCIONÁRIO**
        FuncionarioBO funcionarioBO = new FuncionarioBO();
        Funcionario funcionario = new Funcionario(1, "Lucas Oliveira", "Secretário");

        if (funcionarioBO.excluir(funcionario))
            System.out.println("Funcionário Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Funcionário");

        Funcionario funcionario1 = new Funcionario(2, "Ana Silva", "Contador");
        if (funcionarioBO.excluir(funcionario1))
            System.out.println("Funcionário Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Funcionário");

        // **EXCLUI UM PROFESSOR**
        ProfessorBO professorBO = new ProfessorBO();
        Professor professor = new Professor(1, "Carlos Rocha", "Matemática", 41);

        if (professorBO.excluir(professor))
            System.out.println("Professor Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Professor");

        Professor professor1 = new Professor(2, "Isabel Lima", "Física", 36);
        if (professorBO.excluir(professor1))
            System.out.println("Professor Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Professor");

        Professor professor2 = new Professor(3, "Robson Santos", "Cálculo", 21);
        if (professorBO.excluir(professor2))
            System.out.println("Professor Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Professor");

        // **EXCLUI UMA DISCIPLINA**
        DisciplinaBO disciplinaBO = new DisciplinaBO();
        Disciplina disciplina = new Disciplina(1, "Matemática", professor, alunosDaTurma);

        if (disciplinaBO.excluir(disciplina))
            System.out.println("Disciplina Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Disciplina");

        Disciplina disciplina1 = new Disciplina(2, "Física", professor1, alunosDaTurma1);

        if (disciplinaBO.excluir(disciplina1))
            System.out.println("Disciplina Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Disciplina");

        Disciplina disciplina2 = new Disciplina(3, "Programação", professor2, alunosDaTurma2);

        if (disciplinaBO.excluir(disciplina2))
            System.out.println("Disciplina Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Disciplina");

        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(disciplina);
        disciplinas.add(disciplina1);

        // **EXCLUI UMA TURMA**
        TurmaBO turmaBO = new TurmaBO();

        // Criar uma lista de professores
        List<Professor> professoresDaTurma = new ArrayList<>();
        professoresDaTurma.add(professor);
        professoresDaTurma.add(professor1);

        // Criar uma instância de Turma
        Turma turma = new Turma(1, alunosDaTurma, professoresDaTurma, "Segunda-feira, 14:00");

        if (turmaBO.excluir(turma))
            System.out.println("Turma Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Turma");

        // **EXCLUI UM PERÍODO LETIVO**

        PeriodoLetivoBO periodoLetivoBO = new PeriodoLetivoBO();
        Date dataInicio = Date.valueOf("2023-07-24");
        Date dataTermino = Date.valueOf("2023-12-24");
        PeriodoLetivo periodoLetivo = new PeriodoLetivo(1, dataInicio, dataTermino);

        if (periodoLetivoBO.excluir(periodoLetivo))
            System.out.println("Período Letivo Excluido com Sucesso");
        else
            System.out.println("Erro ao excluir Período Letivo");

        // **EXCLUI UMA NOTA**
        NotaBO notaBO = new NotaBO();
        Nota nota = new Nota(1, aluno1, disciplina2, 8.5);

        if (notaBO.excluir(nota))
            System.out.println("Nota Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Nota");

        // **EXCLUI UMA GRADE CURRICULAR**
        GradeCurricularBO gradeCurricularBO = new GradeCurricularBO();
        GradeCurricular gradeCurricular = new GradeCurricular(1, disciplinas, periodoLetivo);

        if (gradeCurricularBO.excluir(gradeCurricular))
            System.out.println("Grade Curricular Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Grade Curricular");

        // **EXCLUI UMA PRESENÇA**
        PresencaBO presencaBO = new PresencaBO();
        Date dataPresenca = Date.valueOf("2023-01-12");
        Presenca presenca = new Presenca(1, aluno3, dataPresenca, true);

        if (presencaBO.excluir(presenca))
            System.out.println("Presença Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Presença");

        // **EXCLUI UMA AULA**
        AulaBO aulaBO = new AulaBO();
        Aula aula = new Aula(1, disciplina, "Segunda-feira, 10:00", "Sala 101");

        if (aulaBO.excluir(aula))
            System.out.println("Aula Excluida com Sucesso");
        else
            System.out.println("Erro ao excluir Aula");

    }
}

