package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome, telefone;
    protected LocalDate nascimento, cadastro, ultimaAlteracao;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, LocalDate nascimento) {
        this.nome = nome;
        this.telefone = Pessoa.formatarTelefone(telefone);
        this.nascimento = nascimento;
        this.cadastro = LocalDate.now();
        this.ultimaAlteracao = LocalDate.now();
    }

    private static String formatarTelefone(String telefone) {
        if (telefone.length() > 11) {
            return "(" + telefone.substring(0, 3) + ")" + telefone.substring(3, 8) + "-" + telefone.substring(8, 12);
        } else {
            return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = Pessoa.formatarTelefone(telefone);
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
