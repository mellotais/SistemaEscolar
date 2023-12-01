package com.classes.DTO;

import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private Professor professorResponsavel;
    private List<Aluno> alunosMatriculados;
    

    public Disciplina() {
    	
    }
    
    public Disciplina(int id, String nome, Professor professorResponsavel, List<Aluno> alunosMatriculados) {
    	this.id = id;
        this.nome = nome;
        this.professorResponsavel = professorResponsavel;
        this.alunosMatriculados = alunosMatriculados;
    }

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}



	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}



	public List<Aluno> getAlunosMatriculados() {
		return alunosMatriculados;
	}



	public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}



	@Override
    public String toString() {
        return "Disciplina [id=" + id + ", nome=" + nome + ", professorResponsavel=" + professorResponsavel + ", alunosMatriculados=" + alunosMatriculados + "]";
    }
}