package com.classes.DTO;


public class Nota {
    private int id;
    private Aluno aluno;
    private Disciplina disciplina;
    private double valor;
    

    public Nota() {
    }
    
    public Nota(int id, Aluno aluno, Disciplina disciplina, double valor) {
    	this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.valor = valor;
    }

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public Disciplina getDisciplina() {
		return disciplina;
	}



	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	@Override
    public String toString() {
        return "Nota [id=" + id + ", aluno=" + aluno + ", disciplina=" + disciplina + ", valor=" + valor + "]";
    }
}
