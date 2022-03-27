package model;

import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);
    private boolean continua = true;

    public static void chamarMenu() {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }

    private void mostrarMenu() {
        while (continua) {
            System.out.println("Menu:\n");
            System.out.println("1- Cadastrar pessoa ou aluno;");
            System.out.println("2- Listar cadastrados;");
            System.out.println("3- Atualizar dados de uma pessoa ou aluno;");
            System.out.println("4- Deletar uma pessoa ou aluno;");
            System.out.println("5- Sair.");

            switch (entrada.next()) {
                case "1":
                    cadastrarPessoaOuAluno();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
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
        System.out.println("Você selecionou cadastrar pessoa ou aluno.");
        if(verificarIntencao()){
            
        }        
    }

    private void listarCadastrados() {

    }

    private void atualizarPessoaOuAluno() {

    }

    private void deletarPessoaOuAluno() {

    }
    
    private boolean verificarIntencao(){
        while (true) {
            System.out.println("Deseja proseguir com essa ação?\n1- Sim 2- Não:");
            switch (entrada.next()) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Opção inválida. Por favor selecione uma opção existente.\n");
                    break;
            }
        }
    }
}
