package model;

import java.time.LocalDate;

public class Aluno extends Pessoa{
    
    private int notaFinal;

    public Aluno() {
        super();
    }

    public Aluno(String nome, long telefone, LocalDate nascimento, int notaFinal) {
        super(nome, telefone, nascimento);
        this.notaFinal = notaFinal;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Aluno{" + "notaFinal=" + notaFinal + '}';
    }
}
