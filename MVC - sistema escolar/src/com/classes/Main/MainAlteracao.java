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

public class MainAlteracao {

    public static void main(String[] args) {

        // **ALTERA UM ALUNO**
        AlunoBO alunoBO = new AlunoBO();
        Aluno aluno = new Aluno(1, "João Silva", 21, "Engenharia");

        if (alunoBO.alterar(aluno))
            System.out.println("Aluno Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Aluno");

        Aluno aluno1 = new Aluno(2, "Maria Souza", 23, "Ciência da Computação");
        if (alunoBO.alterar(aluno1))
            System.out.println("Aluno Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Aluno");

        Aluno aluno2 = new Aluno(3, "Pedro Oliveira", 25, "Matemática");
        if (alunoBO.alterar(aluno2))
            System.out.println("Aluno Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Aluno");

        Aluno aluno3 = new Aluno(4, "Gilberto Santos", 26, "Matemática");
        if (alunoBO.alterar(aluno3))
            System.out.println("Aluno Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Aluno");

        Aluno aluno4 = new Aluno(5, "Vanessa Lima", 22, "Biologia");
        if (alunoBO.alterar(aluno4))
            System.out.println("Aluno Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Aluno");

        // Criar uma lista de alunos

        List<Aluno> alunosDaTurma = new ArrayList<>();
        alunosDaTurma.add(aluno);

        List<Aluno> alunosDaTurma1 = new ArrayList<>();
        alunosDaTurma1.add(aluno1);

        List<Aluno> alunosDaTurma2 = new ArrayList<>();
        alunosDaTurma2.add(aluno2);

        // **ALTERA UM FUNCIONÁRIO**
        FuncionarioBO funcionarioBO = new FuncionarioBO();
        Funcionario funcionario = new Funcionario(1, "Lucas Oliveira", "Secretário");

        if (funcionarioBO.alterar(funcionario))
            System.out.println("Funcionário Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Funcionário");

        Funcionario funcionario1 = new Funcionario(2, "Ana Silva", "Contador");
        if (funcionarioBO.alterar(funcionario1))
            System.out.println("Funcionário Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Funcionário");

        // **ALTERA UM PROFESSOR**
        ProfessorBO professorBO = new ProfessorBO();
        Professor professor = new Professor(1, "Carlos Rocha", "Matemática", 41);

        if (professorBO.alterar(professor))
            System.out.println("Professor Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Professor");

        Professor professor1 = new Professor(2, "Isabel Lima", "Física", 36);
        if (professorBO.alterar(professor1))
            System.out.println("Professor Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Professor");

        Professor professor2 = new Professor(3, "Robson Santos", "Cálculo", 21);
        if (professorBO.alterar(professor2))
            System.out.println("Professor Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Professor");

        // **ALTERA UMA DISCIPLINA**
        DisciplinaBO disciplinaBO = new DisciplinaBO();
        Disciplina disciplina = new Disciplina(1, "Matemática", professor, alunosDaTurma);

        if (disciplinaBO.alterar(disciplina))
            System.out.println("Disciplina Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Disciplina");

        Disciplina disciplina1 = new Disciplina(2, "Física", professor1, alunosDaTurma1);

        if (disciplinaBO.alterar(disciplina1))
            System.out.println("Disciplina Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Disciplina");

        Disciplina disciplina2 = new Disciplina(3, "Programação", professor2, alunosDaTurma2);

        if (disciplinaBO.alterar(disciplina2))
            System.out.println("Disciplina Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Disciplina");

        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(disciplina);
        disciplinas.add(disciplina1);

        // **ALTERA UMA TURMA**
        TurmaBO turmaBO = new TurmaBO();

        // Criar uma lista de professores
        List<Professor> professoresDaTurma = new ArrayList<>();
        professoresDaTurma.add(professor);
        professoresDaTurma.add(professor1);

        // Criar uma instância de Turma
        Turma turma = new Turma(1, alunosDaTurma, professoresDaTurma, "Segunda-feira, 14:00");

        if (turmaBO.alterar(turma))
            System.out.println("Turma Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Turma");

        // **ALTERA UM PERÍODO LETIVO**

        PeriodoLetivoBO periodoLetivoBO = new PeriodoLetivoBO();
        Date dataInicio = Date.valueOf("2023-07-24");
        Date dataTermino = Date.valueOf("2023-12-24");
        PeriodoLetivo periodoLetivo = new PeriodoLetivo(1, dataInicio, dataTermino);

        if (periodoLetivoBO.alterar(periodoLetivo))
            System.out.println("Período Letivo Alterado com Sucesso");
        else
            System.out.println("Erro ao Alterar Período Letivo");

        // **ALTERA UMA NOTA**
        NotaBO notaBO = new NotaBO();
        Nota nota = new Nota(1, aluno1, disciplina2, 8.5);

        if (notaBO.alterar(nota))
            System.out.println("Nota Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Nota");

        // **ALTERA UMA GRADE CURRICULAR**
        GradeCurricularBO gradeCurricularBO = new GradeCurricularBO();
        GradeCurricular gradeCurricular = new GradeCurricular(1, disciplinas, periodoLetivo);

        if (gradeCurricularBO.alterar(gradeCurricular))
            System.out.println("Grade Curricular Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Grade Curricular");

        // **ALTERA UMA PRESENÇA**
        PresencaBO presencaBO = new PresencaBO();
        Date dataPresenca = Date.valueOf("2023-01-12");
        Presenca presenca = new Presenca(1, aluno3, dataPresenca, true);

        if (presencaBO.alterar(presenca))
            System.out.println("Presença Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Presença");

        // **ALTERA UMA AULA**
        AulaBO aulaBO = new AulaBO();
        Aula aula = new Aula(1, disciplina, "Segunda-feira, 10:00", "Sala 101");

        if (aulaBO.alterar(aula))
            System.out.println("Aula Alterada com Sucesso");
        else
            System.out.println("Erro ao Alterar Aula");

    }
}
