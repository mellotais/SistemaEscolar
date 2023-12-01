package com.classes.DTO;

public class Funcionario extends Pessoa {
    private String cargo;

    
   public Funcionario() {
	   
   }
    public Funcionario(int id, String nome, String cargo) {
        super(id, nome);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + getId() + ", nome=" + getNome() + ", cargo=" + cargo + "]";
    }
}
