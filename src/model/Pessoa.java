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
        this.nome = Pessoa.formatarNome(nome);
        this.telefone = Pessoa.formatarTelefone(telefone);
        this.nascimento = nascimento;
        this.cadastro = LocalDate.now();
        this.ultimaAlteracao = LocalDate.now();
    }

    private static String formatarNome(String nome) {
        String nomeFormatado = "";
        for (String parte : nome.split(" ")) {
            nomeFormatado += parte.substring(0, 1).toUpperCase() + parte.substring(1) + " ";
        }
        return nomeFormatado.substring(0, nomeFormatado.length() - 1);
    }

    private static String formatarTelefone(String telefone) {
        if (telefone.length() == 12) {
            return "(" + telefone.substring(0, 3) + ")" + telefone.substring(3, 8) + "-" + telefone.substring(8, 12);
        } else if (telefone.length() == 11 && !telefone.substring(0, 1).equals("0")) {
            return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
        } else if (telefone.length() == 11) {
            return "(" + telefone.substring(0, 3) + ")" + telefone.substring(3, 7) + "-" + telefone.substring(7, 11);
        } else {
            return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 6) + "-" + telefone.substring(6, 10);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = Pessoa.formatarNome(nome);
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
