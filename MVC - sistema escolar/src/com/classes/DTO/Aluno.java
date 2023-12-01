package com.classes.DTO;

public class Aluno extends Pessoa {
    private int idade;
    private String turma;

    
    public Aluno() {
    	
    }

    
    
    public Aluno(int id, String nome, int idade, String turma) {
        super(id, nome);
        this.idade = idade;
        this.turma = turma;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + getId() + ", nome=" + getNome() + ", idade=" + idade + ", turma=" + turma + "]";
    }
}
