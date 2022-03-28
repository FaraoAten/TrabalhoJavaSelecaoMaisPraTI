package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome;
    protected long telefone;
    protected LocalDate nascimento, cadastro, ultimaAlteracao;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa() {
    }

    public Pessoa(String nome, long telefone, LocalDate nascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.cadastro = LocalDate.now();
        this.ultimaAlteracao = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public LocalDate getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(LocalDate ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Data de nascimento: " + getNascimento().format(format) + ", Data de cadastro: " + getCadastro().format(format) + ", Última alteração cadastral feita em: " + getUltimaAlteracao().format(format);
    }
}
