package model;

import java.time.LocalDate;

public class Aluno extends Pessoa{
    
    private double notaFinal;

    public Aluno() {
        super();
    }

    public Aluno(String nome, long telefone, LocalDate nascimento, double notaFinal) {
        super(nome, telefone, nascimento);
        this.notaFinal = notaFinal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Aluno{" + "notaFinal=" + notaFinal + '}';
    }
}
