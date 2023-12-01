package com.classes.DTO;

import java.util.Date;

public class Presenca {
    private int id;
    private Aluno aluno;
    private Date data;
    private boolean presente;
    

    public Presenca() {
       
    }
    
    public Presenca(int id, Aluno aluno, Date data, boolean presente) {
    	this.id = id;
        this.aluno = aluno;
        this.data = data;
        this.presente = presente;
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


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public boolean isPresente() {
		return presente;
	}


	public void setPresente(boolean presente) {
		this.presente = presente;
	}


	@Override
    public String toString() {
        return "Presenca [id=" + id + ", aluno=" + aluno + ", data=" + data + ", presente=" + presente + "]";
    }
}