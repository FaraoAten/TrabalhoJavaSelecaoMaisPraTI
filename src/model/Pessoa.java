package model;

import java.time.LocalDate;

public class Pessoa {
    
    private String nome;
    private long telefone;
    private LocalDate nascimento, cadastro, ultimaAlteracao;

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
        return "Pessoa{" + "nome=" + nome + ", telefone=" + telefone + ", nascimento=" + nascimento + ", cadastro=" + cadastro + ", ultimaAlteracao=" + ultimaAlteracao + '}';
    }
}
