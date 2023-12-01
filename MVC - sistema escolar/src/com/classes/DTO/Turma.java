package com.classes.DTO;

import java.util.List;

public class Turma {
    private int id;
    private List<Aluno> aluno;
    private List<Professor> professores;
    private String horario;
    

    public Turma() {
    }
    
    public Turma(int id, List<Aluno> aluno, List<Professor> professores, String horario) {
        this.id = id;
        this.aluno= aluno;
        this.professores = professores;
        this.horario = horario;
    }

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<Aluno> getAluno() {
		return aluno;
	}



	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}



	public List<Professor> getProfessores() {
		return professores;
	}



	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	@Override
    public String toString() {
        return "Turma [id=" + id + ", aluno=" + aluno + ", professores=" + professores + ", horario=" + horario + "]";
    }
}