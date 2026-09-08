package SelecaoDeBruxos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Selecao {

    static Bruxo[] alunos = new Bruxo[10];
    static int quantidadeAlunos = 0;
    static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {

            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar todos os alunos");
            System.out.println("3 - Exibir alunos de uma casa");
            System.out.println("4 - Exibir alunos por casa");
            System.out.println("5 - Exibir alunos maiores de idade");
            System.out.println("6 - Exibir alunos menores de idade");
            System.out.println("7 - Buscar alunos por sobrenome");
            System.out.println("8 - Encerrar");

            System.out.print("\nEscolha uma opção: ");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarAluno();
                    break;

                case 2:
                    listarAlunos();
                    break;

                case 3:
                    exibirPorCasa();
                    break;

                case 4:
                    exibirAlunosPorCasa();
                    break;

                case 5:
                    exibirMaioresDeIdade();
                    break;

                case 6:
                    exibirMenoresDeIdade();
                    break;

                case 7:
                    buscarPorSobrenome();
                    break;

                case 8:
                    System.out.println(
                            "\nSeleção de bruxos finalizada!");
                    break;

                default:
                    System.out.println(
                            "\nOpção inválida!");
            }
        }

        input.close();
    }

    public static void cadastrarAluno() {

        Scanner input = new Scanner(System.in);
        if (quantidadeAlunos >= 10) {

            System.out.println("\nLimite de 10 alunos atingido!");
            return;
        }

        Bruxo bruxo = new Bruxo();

        System.out.println("\n===== CADASTRO DE ALUNO =====");

        System.out.print("Nome: ");
        bruxo.setNome(input.nextLine());

        LocalDate dataNascimento = null;

        while (dataNascimento == null) {

            System.out.print("Data de nascimento (dd/MM/yyyy): ");
            String data = input.nextLine();

            try {
                dataNascimento = LocalDate.parse(data, formato);
                bruxo.setDataNascimento(dataNascimento);

            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Tente novamente.");
            }
        }

        System.out.print("Pontos de Coragem: ");
        bruxo.setCoragem(input.nextDouble());

        System.out.print("Pontos de Inteligencia: ");
        bruxo.setInteligencia(input.nextDouble());

        System.out.print("Pontos de Ambicao: ");
        bruxo.setAmbicao(input.nextDouble());

        System.out.print("Pontos de Lealdade: ");
        bruxo.setLealdade(input.nextDouble());

        System.out.print("Pontos de Estrategia: ");
        bruxo.setEstrategia(input.nextDouble());

        System.out.print("Pontos de Criatividade: ");
        bruxo.setCriatividade(input.nextDouble());

        input.nextLine();

        bruxo.calcularCasa();

        int posicao = quantidadeAlunos + 1;

        bruxo.gerarCodigoMatricula(posicao);

        alunos[quantidadeAlunos] = bruxo;

        quantidadeAlunos++;

        System.out.println("\nAluno cadastrado com sucesso!");

        System.out.println("Casa: " + bruxo.getCasa());

        System.out.println("Matrícula: " + bruxo.getCodigoMatricula());

        System.out.println("Usuário: " + bruxo.gerarNomeUsuario());
    }

    public static void listarAlunos() {

        if (quantidadeAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n===== TODOS OS ALUNOS =====");

        for (int i = 0; i < quantidadeAlunos; i++) {
            alunos[i].exibirInformacoes();
        }
    }

    public static void exibirPorCasa() {
        Scanner input = new Scanner(System.in);
        if (quantidadeAlunos == 0) {

            System.out.println(
                    "\nNenhum aluno cadastrado.");

            return;
        }

        System.out.print("\nInforme a casa: ");
        String casa = input.nextLine();
        int total = 0;

        System.out.println("\n===== ALUNOS DA CASA =====");

        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].verificarCasa(casa)) {
                alunos[i].exibirInformacoes();
                total++;
            }
        }
        System.out.println("\nTotal de alunos da casa: " + total);
    }

    public static void exibirAlunosPorCasa() {

        if (quantidadeAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado.");
            return;
        }

        String[] casas = {
                "Grifinoria",
                "Sonserina",
                "Corvinal",
                "Lufa-Lufa"
        };

        for (String casa : casas) {

            System.out.println("\n===== " + casa.toUpperCase() + " =====");
            boolean encontrou = false;

            for (int i = 0; i < quantidadeAlunos; i++) {
                if (alunos[i].verificarCasa(casa)) {
                    System.out.println(alunos[i].getNome());
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum aluno.");
            }
        }
    }

    public static void exibirMaioresDeIdade() {

        System.out.println("\n===== MAIORES DE IDADE =====");

        boolean encontrou = false;

        for (int i = 0; i < quantidadeAlunos; i++) {

            if (alunos[i].verificarMaioridadeMagica()) {
                System.out.println(alunos[i].getNome() + " - " + alunos[i].calcularIdade() + " anos");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno maior de idade.");
        }
    }

    public static void exibirMenoresDeIdade() {

        System.out.println("\n===== MENORES DE IDADE =====");

        boolean encontrou = false;

        for (int i = 0; i < quantidadeAlunos; i++) {
            if (!alunos[i].verificarMaioridadeMagica()) {
                System.out.println(alunos[i].getNome() + " - " + alunos[i].calcularIdade() + " anos");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno menor de idade.");
        }
    }

    public static void buscarPorSobrenome() {
        Scanner input = new Scanner(System.in);
        if (quantidadeAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado.");
            return;
        }

        System.out.print("\nDigite o sobrenome ou parte dele: ");
        String sobrenome = input.nextLine();
        boolean encontrou = false;
        System.out.println("\n===== RESULTADO DA BUSCA =====");

        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].verificarPresencaPalavra(sobrenome)) {
                alunos[i].exibirInformacoes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado.");
        }
    }
}
