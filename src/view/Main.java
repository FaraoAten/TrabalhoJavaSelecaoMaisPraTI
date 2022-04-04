package view;

import controller.Menu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1");
        Menu menu = new Menu();

        do {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar pessoa ou aluno;");
            System.out.println("2- Listar todos os cadastrados;");
            System.out.println("3- Atualizar dados de uma pessoa ou aluno;");
            System.out.println("4- Deletar uma pessoa ou aluno;");
            System.out.println("5- Sair.");
            String opcao = entrada.nextLine();

            if (opcao.equals("5")) {
                break;
            } else {
                switch (opcao) {
                    case "1":
                        System.out.println("\nVocê selecionou cadastrar pessoa ou aluno.");
                        if (menu.verificarIntencao(entrada)) {
                            menu.cadastrarPessoaOuAluno(entrada);
                        }
                        break;
                    case "2":
                        System.out.println("\nVocê selecionou listar todos os cadastrados.");
                        if (menu.verificarIntencao(entrada)) {
                            menu.listarTodosCadastrados();
                        }
                        break;
                    case "3":
                        System.out.println("\nVocê selecionou atualizar dados de uma pessoa ou aluno.");
                        if (menu.verificarIntencao(entrada) && menu.listarTodosCadastrados()) {
                            menu.atualizarPessoaOuAluno(entrada);
                        }
                        break;
                    case "4":
                        System.out.println("\nVocê selecionou deletar uma pessoa ou aluno.");
                        if (menu.verificarIntencao(entrada) && menu.listarTodosCadastrados()) {
                            menu.deletarPessoaOuAluno(entrada);
                        }
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor selecione uma função existente.\n");
                        break;
                }
            }
        } while (true);
        entrada.close();
    }
}
