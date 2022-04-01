package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Aluno;
import model.Pessoa;

public class Menu {

    Scanner entrada = new Scanner(System.in, "ISO-8859-1");
    private List<Pessoa> listaDeCadastrados = new ArrayList();

    public void cadastrarPessoaOuAluno() {
        System.out.println("\nDigite o nome da pessoa ou aluno a ser cadastrado:");
        String nome = validarNome(entrada.nextLine());

        System.out.println("\nDigite o DDD+número telefonico da pessoa ou aluno a ser cadastrado (apenas os números):");
        String telefone = validarTelefone(entrada.nextLine());

        System.out.println("\nDigite a data de nascimento da pessoa ou aluno a ser cadastrado (no padrão dd/mm/aaaa):");
        String nascimento = validarNascimento(entrada.nextLine());

        System.out.println("\nCaso queira cadastrar um aluno, digite a nota final do curso:\n(Para cadastrar uma pessoa clique na tecla 'Enter' deixando esse campo em branco)");
        String notaFinal = entrada.nextLine();
        if (notaFinal.isBlank()) {
            listaDeCadastrados.add(new Pessoa(nome, telefone, LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu"))));
            System.out.println("\n====================================");
            System.out.println("Pessoa cadastrada com sucesso.");
            System.out.println("====================================\n");
        } else {
            notaFinal = validarNotaFinal(notaFinal);
            listaDeCadastrados.add(new Aluno(nome, telefone, LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu")), Double.parseDouble(notaFinal)));
            System.out.println("\n====================================");
            System.out.println("Aluno cadastrado com sucesso.");
            System.out.println("====================================\n");
        }
    }

    public boolean listarTodosCadastrados() {
        if (listaDeCadastrados.size() <= 0) {
            System.out.println("\n====================================");
            System.out.println("No momento não há niguém cadastrado.");
            System.out.println("====================================\n");
            return false;
        } else {
            System.out.println();
            for (int i = 0; i < listaDeCadastrados.size(); i++) {
                System.out.println("#" + (i + 1) + "- " + listaDeCadastrados.get(i));
            }
            System.out.println();
            return true;
        }
    }

    public void atualizarPessoaOuAluno() {
        System.out.println("Digite o número da posição de quem você quer editar os dados:");
        int i = validarPosicao(entrada.nextLine());
        
        System.out.println("\n==========================================================================================");
        System.out.println("Caso não queira atualizar algum dado clique na tecla 'Enter' deixando o campo em branco.");
        System.out.println("==========================================================================================\n");
        System.out.println("Digite o novo nome:");
        String nome = entrada.nextLine();
        if (!nome.isBlank()) {
            nome = validarNome(nome);
            listaDeCadastrados.get(i - 1).setNome(nome);
        }

        System.out.println("\nDigite o número número telefonico (apenas os números):");
        String telefone = entrada.nextLine();
        if (!telefone.isBlank()) {
            telefone = validarTelefone(telefone);
            listaDeCadastrados.get(i - 1).setTelefone(telefone);
        }

        System.out.println("\nDigite a nova data de nascimento (no padrão dd/mm/aaaa):");
        String nascimento = entrada.nextLine();
        if (!nascimento.isBlank()) {
            nascimento = validarNascimento(nascimento);
            listaDeCadastrados.get(i - 1).setNascimento(LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu")));
        }

        if (listaDeCadastrados.get(i - 1).getClass().toString().equals("class model.Aluno")) {
            System.out.println("\nDigite a nova nota final do curso:");
            String notaFinal = entrada.nextLine();
            if (!notaFinal.isBlank()) {
                notaFinal = validarNotaFinal(notaFinal);
                Aluno.parseAluno(listaDeCadastrados.get(i - 1)).setNotaFinal(Double.parseDouble(notaFinal));
            }
        }

        listaDeCadastrados.get(i - 1).setUltimaAlteracao(LocalDate.now());
        System.out.println("\n====================================");
        System.out.println("Atualização realizada com sucesso.");
        System.out.println("====================================\n");
    }

    public void deletarPessoaOuAluno() {
        System.out.println("Digite o número da posição de quem você quer deletar os dados:");
        int i = validarPosicao(entrada.nextLine());
        listaDeCadastrados.remove(i - 1);
        System.out.println("\n====================================");
        System.out.println("Remoção efetuada com sucesso.");
        System.out.println("====================================\n");
    }

    //---- Validações de Inputs ----
    public boolean verificarIntencao() {
        while (true) {
            System.out.println("Deseja proseguir com essa ação?\n1- Sim 2- Não:");
            switch (entrada.nextLine()) {
                case "1":
                    return true;
                case "2":
                    System.out.println();
                    return false;
                default:
                    System.out.println("Opção inválida. Por favor selecione uma opção existente.\n");
                    break;
            }
        }
    }

    private String validarNome(String nome) {
        String regexNome = "[a-zA-Zà-üÀ-Ü' ]{3,}";
        while (!nome.matches(regexNome)) {
            System.out.println("\nPor favor digite um nome:");
            nome = entrada.nextLine();
        }
        return nome;
    }

    private String validarTelefone(String telefone) {
        String regexTelefone = "[0-9]{10,12}";
        while (!telefone.matches(regexTelefone)) {
            System.out.println("\nPor favor digite um número telefonico válido:\n(No formato DDD+número e colocando apenas os números)");
            telefone = entrada.nextLine();
        }
        return telefone;
    }

    private String validarNascimento(String nascimento) {
        while (true) {
            try {
                LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("\nPor favor digite uma data válida:\n(No formato dd/mm/aaaa)");
                nascimento = entrada.nextLine();
            }
        }
        return nascimento;
    }

    private String validarNotaFinal(String notaFinal) {
        String regexNotaFinal = "[0-9]{1,}[\\.][0-9]{1,}|[0-9]{1,}";
        while (!notaFinal.matches(regexNotaFinal)) {
            System.out.println("\nPor favor digite uma nota válida:\n(Para números não-inteiros utilize ponto ao invés de vírgula)");
            notaFinal = entrada.nextLine();
        }
        return notaFinal;
    }

    private Integer validarPosicao(String posicao) {
        int i = 1;
        while (true) {
            try {
                i = Integer.parseInt(posicao);
                listaDeCadastrados.get(i - 1);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido\nPor favor digite o número de uma posição:");
                posicao = entrada.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Posição inexistente\nPor favor digite uma posição válida:");
                posicao = entrada.nextLine();
            }
        }
        return i;
    }
}
