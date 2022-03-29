package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    Scanner entrada = new Scanner(System.in);
    private boolean repete = true, continua = true;
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
            System.out.println("3- Listar apenas as pessoas csadastradas;");
            System.out.println("4- Listar apenas os alunos cadastrados;");
            System.out.println("5- Atualizar dados de uma pessoa ou aluno;");
            System.out.println("6- Deletar uma pessoa ou aluno;");
            System.out.println("7- Sair.");

            switch (entrada.nextLine()) {
                case "1":
                    System.out.println("\nVocê selecionou cadastrar pessoa ou aluno.");
                    if (verificarIntencao()) {
                        cadastrarPessoaOuAluno();
                    }
                    break;
                case "2":
                    System.out.println("\nVocê selecionou listar todos os cadastrados.");
                    if (verificarIntencao()) {
                        listarTodosCadastrados();
                    }
                    break;
                case "3":
                    System.out.println("\nVocê selecionou listar apenas as pessoas csadastradas.");
                    if (verificarIntencao()) {
                        listarPessoasCadastradas();
                    }
                    break;
                case "4":
                    System.out.println("\nVocê selecionou listar apenas os alunos cadastrados.");
                    if (verificarIntencao()) {
                        listarAlunosCadastrados();
                    }
                    break;
                case "5":
                    System.out.println("\nVocê selecionou atualizar dados de uma pessoa ou aluno.");
                    if (verificarIntencao()) {
                        atualizarPessoaOuAluno();
                    }
                    break;
                case "6":
                    System.out.println("\nVocê selecionou deletar uma pessoa ou aluno.");
                    if (verificarIntencao()) {
                        deletarPessoaOuAluno();
                    }
                    break;
                case "7":
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor selecione uma função existente.\n");
                    break;
            }
        }
    }

    private void cadastrarPessoaOuAluno() {
        System.out.println("\nDigite o nome da pessoa ou aluno a ser cadastrado:");
        String nome = entrada.nextLine();
        while (nome.length() < 3) {
            System.out.println("\nPor favor digite um nome:");
            nome = entrada.nextLine();
        }

        System.out.println("\nDigite o DDD+número telefonico da pessoa ou aluno a ser cadastrado (apenas os números):");
        String telefone = entrada.nextLine();
        while (repete) {
            try {
                while (telefone.length() < 10 || telefone.length() > 12) {
                    System.out.println("\nPor favor digite um número telefonico válido:\n(No formato DDD+número e colocando apenas os números)");
                    telefone = entrada.nextLine();
                }
                Long.parseLong(telefone);
                repete = false;
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor digite um número telefonico válido:\n(No formato DDD+número e colocando apenas os números)");
                telefone = entrada.nextLine();
            }
        }
        repete = true;

        System.out.println("\nDigite a data de nascimento da pessoa ou aluno a ser cadastrado (no padrão dd/mm/aaaa):");
        LocalDate nascimento = LocalDate.now();
        while (repete) {
            try {
                nascimento = LocalDate.parse(entrada.nextLine(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                repete = false;
            } catch (DateTimeParseException e) {
                System.out.println("\nPor favor digite uma data válida:\n(No formato dd/mm/aaaa)");
            }
        }
        repete = true;

        System.out.println("\nCaso queira cadastrar um aluno, digite a nota final do curso:\n(Para cadastrar uma pessoa clique na tecla 'Enter' deixando esse campo em branco)");
        String notaFinal = entrada.nextLine();

        if (notaFinal.isBlank()) {
            listaDeCadastrados.add(new Pessoa(nome, telefone, nascimento));
            System.out.println("Pessoa cadastrada com sucesso.\n");
        } else {
            while (repete) {
                try {
                    while (notaFinal.contains("-")) {
                        System.out.println("\nPor favor digite uma nota válida:");
                        notaFinal = entrada.nextLine();
                    }
                    Double.parseDouble(notaFinal);
                    repete = false;
                } catch (NumberFormatException e) {
                    System.out.println("\nPor favor digite uma nota válida:");
                    notaFinal = entrada.nextLine();
                }
            }
            repete = true;
            listaDeCadastrados.add(new Aluno(nome, telefone, nascimento, Double.parseDouble(notaFinal)));
            System.out.println("\nAluno cadastrado com sucesso.\n");
        }
    }

    private void listarTodosCadastrados() {
        System.out.println();

        if (listaDeCadastrados.size() <= 0) {
            System.out.println("No momento não há niguém cadastrado.");
        } else {
            int i = 1;
            for (Pessoa cadastrado : listaDeCadastrados) {
                System.out.println("#" + i + "- " + cadastrado);
                i++;
            }
        }

        System.out.println();
    }

    private void listarPessoasCadastradas() {
        System.out.println();

        List<Pessoa> listaDePessoas = listaDeCadastrados.stream().filter(cadastrada -> cadastrada.getClass().toString().equals("class model.Pessoa")).collect(Collectors.toList());

        if (listaDePessoas.size() <= 0) {
            System.out.println("No momento não há nenhuma pessoa cadastrada.");
        } else {
            int i = 1;
            for (Pessoa cadastrado : listaDePessoas) {
                System.out.println("#" + i + "- " + cadastrado);
                i++;
            }
        }

        System.out.println();
    }

    private void listarAlunosCadastrados() {
        System.out.println();

        List<Pessoa> listaDeAlunos = listaDeCadastrados.stream().filter(cadastrada -> cadastrada.getClass().toString().equals("class model.Aluno")).collect(Collectors.toList());

        if (listaDeAlunos.size() <= 0) {
            System.out.println("No momento não há nenhum aluno cadastrado.");
        } else {
            int i = 1;
            for (Pessoa cadastrado : listaDeAlunos) {
                System.out.println("#" + i + "- " + cadastrado);
                i++;
            }
        }

        System.out.println();
    }

    private void atualizarPessoaOuAluno() {
        listarTodosCadastrados();
        if (listaDeCadastrados.size() > 0) {
            System.out.println("Digite o número da posição de quem você quer editar os dados:");
            int i = 1;
            while (repete) {
                try {
                    i = Integer.parseInt(entrada.nextLine());
                    listaDeCadastrados.get(i - 1);
                    repete = false;
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido\n\nPor favor digite o número de uma posição:");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Posição inexistente\n\nPor favor digite uma posição válida:");
                }
            }
            repete = true;

            System.out.println("\nCaso não queira atualizar algum dado clique na tecla 'Enter' deixando o campo em branco.");

            System.out.println("\nDigite o novo nome:");
            String nome = entrada.nextLine();
            if (!nome.isBlank()) {
                while (nome.length() < 3) {
                    System.out.println("\nPor favor digite um nome:");
                    nome = entrada.nextLine();
                }
                listaDeCadastrados.get(i - 1).setNome(nome);
            }

            System.out.println("\nDigite o número número telefonico (apenas os números):");
            String telefone = entrada.nextLine();
            if (!telefone.isBlank()) {
                while (repete) {
                    try {
                        while (telefone.length() < 10 || telefone.length() > 12) {
                            System.out.println("\nPor favor digite um número telefonico válido:\n(No formato DDD+número e colocando apenas os números)");
                            telefone = entrada.nextLine();
                        }
                        Long.parseLong(telefone);
                        repete = false;
                    } catch (NumberFormatException e) {
                        System.out.println("\nPor favor digite um número telefonico válido:\n(No formato DDD+número e colocando apenas os números)");
                        telefone = entrada.nextLine();
                    }
                }
                listaDeCadastrados.get(i - 1).setTelefone(telefone);
            }
            repete = true;

            System.out.println("\nDigite a nova data de nascimento (no padrão dd/mm/aaaa):");
            String nascimento = entrada.nextLine();
            if (!nascimento.isBlank()) {
                while (repete) {
                    try {
                        LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                        repete = false;
                    } catch (DateTimeParseException e) {
                        System.out.println("\nPor favor digite uma data válida:\n(No formato dd/mm/aaaa)");
                        nascimento = entrada.nextLine();
                    }
                }
                listaDeCadastrados.get(i - 1).setNascimento(LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu")));
            }
            repete = true;

            if (listaDeCadastrados.get(i - 1).getClass().toString().equals("class model.Aluno")) {
                System.out.println("\nDigite a nova nota final do curso:");
                String notaFinal = entrada.nextLine();
                if (!notaFinal.isBlank()) {
                    while (repete) {
                        try {
                            while (notaFinal.contains("-")) {
                                System.out.println("\nPor favor digite uma nota válida:");
                                notaFinal = entrada.nextLine();
                            }
                            Double.parseDouble(notaFinal);
                            repete = false;
                        } catch (NumberFormatException e) {
                            System.out.println("\nPor favor digite uma nota válida:");
                            notaFinal = entrada.nextLine();
                        }
                    }
                    Aluno.parseAluno(listaDeCadastrados.get(i - 1)).setNotaFinal(Double.parseDouble(notaFinal));
                }
                repete = true;
            }

            listaDeCadastrados.get(i - 1).setUltimaAlteracao(LocalDate.now());

            System.out.println("\nAtualização realizada com sucesso.\n");
        }
    }

    private void deletarPessoaOuAluno() {
        listarTodosCadastrados();
        if (listaDeCadastrados.size() > 0) {
            System.out.println("Digite o número da posição de quem você quer deletar os dados:");
            int i = 1;
            while (repete) {
                try {
                    i = Integer.parseInt(entrada.nextLine());
                    listaDeCadastrados.get(i - 1);
                    repete = false;
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido\n\nPor favor digite o número de uma posição:");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Posição inexistente\n\nPor favor digite uma posição válida:");
                }
            }
            repete = true;

            listaDeCadastrados.remove(i - 1);

            System.out.println("Remoção efetuada com sucesso.\n");
        }
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
