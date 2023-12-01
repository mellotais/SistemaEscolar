package com.classes.DTO;

import java.util.List;

public class GradeCurricular {
    private int id;
    private List<Disciplina> disciplinas;
    private PeriodoLetivo periodoLetivoAssociado;
 

    public GradeCurricular() {
    }
    
    public GradeCurricular(int id,List<Disciplina> disciplinas, PeriodoLetivo periodoLetivoAssociado) {
    	this.id = id;
        this.disciplinas = disciplinas;
        this.periodoLetivoAssociado = periodoLetivoAssociado;
    }

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}



	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}



	public PeriodoLetivo getPeriodoLetivoAssociado() {
		return periodoLetivoAssociado;
	}



	public void setPeriodoLetivoAssociado(PeriodoLetivo periodoLetivoAssociado) {
		this.periodoLetivoAssociado = periodoLetivoAssociado;
	}



	@Override
    public String toString() {
        return "GradeCurricular [id=" + id + ", disciplinas=" + disciplinas + ", periodoLetivoAssociado=" + periodoLetivoAssociado + "]";
    }
}