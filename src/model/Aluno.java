package model;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private double notaFinal;

    public Aluno() {
        super();
    }

    public Aluno(String nome, long telefone, LocalDate nascimento, double notaFinal) {
        super(nome, telefone, nascimento);
        this.notaFinal = notaFinal;
    }
    
    public static Aluno parseAluno(Pessoa pessoa){
        return (Aluno) pessoa;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Data de nascimento: " + getNascimento().format(format) + ", Nota final do curso: " + getNotaFinal() + ", Data de cadastro: " + getCadastro().format(format) + ", Última alteração cadastral feita em: " + getUltimaAlteracao().format(format);
    }
}
