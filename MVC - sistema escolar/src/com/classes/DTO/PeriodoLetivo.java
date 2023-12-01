package com.classes.DTO;

import java.sql.Date;

public class PeriodoLetivo {
    private int id;
    private Date dataInicio;
    private Date dataTermino;
    

    public PeriodoLetivo() {
    }
    
    public PeriodoLetivo(int id,Date dataInicio, Date dataTermino) {
    	this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}



	public Date getDataTermino() {
		return dataTermino;
	}



	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}



	@Override
    public String toString() {
        return "PeriodoLetivo [id=" + id + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + "]";
    }
}

