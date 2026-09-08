package SelecaoDeBruxos;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Bruxo {
    private String nome, casa, codigoMatricula;
    private double coragem, inteligencia, ambicao, lealdade, estrategia, criatividade;
    private LocalDate dataNascimento;

    public Bruxo(){
    }

    public Bruxo(String nome, LocalDate dataNascimento, double coragem, double inteligencia, double ambicao, double lealdade, double estrategia, double criatividade, String codigoMatricula) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.casa = "";
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.codigoMatricula = "";
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCoragem() {
        return coragem;
    }

    public void setCoragem(double coragem) {
        this.coragem = coragem;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public double getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(double criatividade) {
        this.criatividade = criatividade;
    }

    public double getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(double estrategia) {
        this.estrategia = estrategia;
    }

    public double getLealdade() {
        return lealdade;
    }

    public void setLealdade(double lealdade) {
        this.lealdade = lealdade;
    }

    public double getAmbicao() {
        return ambicao;
    }

    public void setAmbicao(double ambicao) {
        this.ambicao = ambicao;
    }

    public double getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void exibirInformacoes() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n===== INFORMAÇÕES DO ALUNO =====");

        System.out.println("Nome: " + nome);

        System.out.println("Data de nascimento: " +
                dataNascimento.format(formato));

        System.out.println("Idade: " + calcularIdade());

        System.out.println("Coragem: " + coragem);

        System.out.println("Inteligencia: " + inteligencia);

        System.out.println("Ambicao: " + ambicao);

        System.out.println("Lealdade: " + lealdade);

        System.out.println("Estrategia: " + estrategia);

        System.out.println("Criatividade: " + criatividade);

        System.out.println("Casa: " + calcularCasa());

        System.out.println("Casa em maiúsculas: " + formatarCasa());

        System.out.println("Nome de usuário: " +
                gerarNomeUsuario());

        System.out.println("Código de matrícula: " +
                codigoMatricula);

        System.out.println("Maioridade mágica: " +
                (verificarMaioridadeMagica() ? "SIM" : "NÃO"));
    }

    public String calcularCasa(){
        double grifinoria = (2 * this.coragem) + this.lealdade;
        double sonserina = (2 * this.ambicao) + this.estrategia;
        double corvinal = (2 * this.inteligencia) + this.criatividade;
        double lufalufa = ((2 * this.lealdade) + this.coragem) / 3;

        double maior = grifinoria;

        if (grifinoria > maior){
            maior = grifinoria;
            this.casa = "Grifinoria";
        }
        if (sonserina > maior){
            maior = sonserina;
            this.casa = "Sonserina";
        }
        if (corvinal > maior){
            maior = corvinal;
            this.casa = "Corvinal";
        }
        if (lufalufa > maior){
            maior = lufalufa;
            this.casa = "Lufa-Lufa";
        }
        return this.casa;
    }

    public int calcularIdade() {

        if (dataNascimento == null) {
            return 0;
        }

        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    public String formatarCasa() {

        if (casa == null) {
            return "";
        }

        return casa.toUpperCase();
    }

    public String gerarNomeUsuario() {

        if (nome == null || nome.trim().isEmpty()) {
            return "";
        }

        String[] partes = nome.trim().split("\\s+");

        if (partes.length == 1) {
            return partes[0].toLowerCase();
        }

        String primeiraLetra = partes[0].substring(0, 1);

        String sobrenome = partes[partes.length - 1];

        return (primeiraLetra + sobrenome).toLowerCase();
    }

    public String gerarCodigoMatricula(int posicao) {

        if (nome == null || nome.trim().isEmpty()) {
            return "";
        }

        String[] partes = nome.trim().split("\\s+");

        String iniciais = "";

        for (String parte : partes) {
            iniciais += parte.substring(0, 1).toUpperCase();
        }

        int anoAtual = LocalDate.now().getYear();

        codigoMatricula = iniciais + "-" + anoAtual + "-" +
                String.format("%02d", posicao);

        return codigoMatricula;
    }

    public boolean verificarCasa(String casaInformada) {

        if (casaInformada == null || casa == null) {
            return false;
        }

        return casa.equalsIgnoreCase(casaInformada.trim());
    }

    public boolean verificarPresencaPalavra(String palavra) {

        if (nome == null || palavra == null) {
            return false;
        }

        String nomeMinusculo = nome.toLowerCase();
        String palavraMinuscula = palavra.toLowerCase().trim();

        String[] partes = nomeMinusculo.split("\\s+");

        for (int i = 1; i < partes.length; i++) {

            if (partes[i].contains(palavraMinuscula)) {
                return true;
            }
        }

        return false;
    }
}
