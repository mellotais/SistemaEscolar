package com.classes.DTO;

public class Professor extends Pessoa {
    private String disciplina;
    private int cargaHoraria;

    public Professor() {
    }
    
    public Professor(int id, String nome, String disciplina, int cargaHoraria) {
        super(id, nome);
        this.disciplina = disciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Professor [id=" + getId() + ", nome=" + getNome() + ", disciplina=" + disciplina + ", cargaHoraria=" + cargaHoraria + "]";
    }
}
