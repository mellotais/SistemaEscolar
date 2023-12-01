package com.classes.DTO;

public class Aula {
    private int id;
    private Disciplina disciplina;
    private String horario;
    private String local;
  
    public Aula() {
    	
    }

    public Aula(int id, Disciplina disciplina, String horario, String local) {
    	this.id = id;
        this.disciplina = disciplina;
        this.horario = horario;
        this.local = local;
    }
    

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Disciplina getDisciplina() {
		return disciplina;
	}



	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}



	@Override
    public String toString() {
        return "Aula [id=" + id + ", disciplina=" + disciplina + ", horario=" + horario + ", local=" + local + "]";
    }
}

