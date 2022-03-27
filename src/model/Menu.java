package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);
    private boolean continua = true;
    private List<Pessoa> listaDeCadastrados = new ArrayList();

    public static void chamarMenu() {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }

    private void mostrarMenu() {
        while (continua) {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar pessoa ou aluno;");
            System.out.println("2- Listar todos os cadastrados;");
            System.out.println("3- Atualizar dados de uma pessoa ou aluno;");
            System.out.println("4- Deletar uma pessoa ou aluno;");
            System.out.println("5- Sair.");

            switch (entrada.nextLine()) {
                case "1":
                    cadastrarPessoaOuAluno();
                    break;
                case "2":
                    listarCadastrados();
                    break;
                case "3":
                    atualizarPessoaOuAluno();
                    break;
                case "4":
                    deletarPessoaOuAluno();
                    break;
                case "5":
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor selecione uma função existente.\n");
                    break;
            }
        }
    }

    private void cadastrarPessoaOuAluno() {
        System.out.println("\nVocê selecionou cadastrar pessoa ou aluno.");
        if (verificarIntencao()) {
            System.out.println("\nDigite o nome da pessoa ou aluno a ser cadastrado:");
            String nome = entrada.nextLine();

            System.out.println("\nDigite o número telefonico da pessoa ou aluno a ser cadastrado (apenas os números):");
            long telefone = Long.parseLong(entrada.nextLine());

            System.out.println("\nDigite a data de nascimento da pessoa ou aluno a ser cadastrado (no padrão dd/mm/aaaa):");
            String nascimento = entrada.nextLine();

            System.out.println("\nCaso queira cadastrar um aluno, digite a nota final do curso:\n(Para cadastrar uma pessoa basta clicar a tecla 'Enter' deixando esse campo em branco)");
            String notaFinal = entrada.nextLine();

            if (notaFinal.isBlank()) {
                listaDeCadastrados.add(new Pessoa(nome, telefone, LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu"))));
                System.out.println("Pessoa cadastrada com sucesso.\n");
            } else {
                listaDeCadastrados.add(new Aluno(nome, telefone, LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu")), Double.parseDouble(notaFinal)));
                System.out.println("\nAluno cadastrado com sucesso.\n");
            }
        }
    }

    private void listarCadastrados() {
        System.out.println("\nVocê selecionou listar todos os cadastrados.");
        if (verificarIntencao()) {
            System.out.println();
            int i = 1;
            for (Pessoa cadastrado : listaDeCadastrados) {
                System.out.println("#" + i + "- " + cadastrado);
                i++;
            }
        }
        System.out.println();
    }

    private void atualizarPessoaOuAluno() {

    }

    private void deletarPessoaOuAluno() {

    }

    private boolean verificarIntencao() {
        while (true) {
            System.out.println("Deseja proseguir com essa ação?\n1- Sim 2- Não:");
            switch (entrada.nextLine()) {
                case "1":
                    return true;
                case "2":
                    System.out.println();
                    return false;
                default:
                    System.out.println("\nOpção inválida. Por favor selecione uma opção existente.\n");
                    break;
            }
        }
    }
}
