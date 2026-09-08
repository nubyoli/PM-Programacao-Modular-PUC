package hogwarts;

import java.util.Scanner;

public class Bruxo {
    private String nome;
    private int idade;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;

    public Bruxo(){
        this.nome = "";
        this.idade = 0;
        this.coragem = 0;
        this.inteligencia = 0;
        this.ambicao = 0;
        this.lealdade = 0;
        this.casa = "";
        this.estrategia = 0;
        this.criatividade = 0;
    }

    public Bruxo(String nome, int idade, double coragem, double inteligencia, double ambicao, double lealdade, double estrategia, double criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.casa = "";
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public void exibirInformacoes(){
        System.out.println("\n===== INFORMAÇÕES DO ALUNO =====");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Coragem: " + getCoragem());
        System.out.println("Inteligencia: " + getInteligencia());
        System.out.println("Ambicao: " + getAmbicao());
        System.out.println("Lealdade: " + getLealdade());
        System.out.println("Estratégia: " + getEstrategia());
        System.out.println("Criatividade: " + getCriatividade());
        System.out.println("Casa: " + calcularCasa());
    }

    public String calcularCasa(){
        double grifinoria = (2 * this.coragem) + this.lealdade;
        double sonserina = (2 * this.ambicao) + this.estrategia;
        double corvinal = (2 * this.inteligencia) + this.criatividade;
        double lufalufa = ((2 * this.lealdade) + this.coragem) / 3;

        double maior = 0;

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

    public void main(String[] args){
        Scanner input = new Scanner(System.in);
        Bruxo bruxo = new Bruxo();
        String continuar = "s";

        while (continuar.equals("s")) {
            System.out.println("Informe seu primeiro nome: ");
            bruxo.setNome(input.nextLine());
            System.out.println("Informe sua idade: ");
            bruxo.setIdade(input.nextInt());
            System.out.println("Pontos de Coragem: ");
            bruxo.setCoragem(input.nextDouble());
            System.out.println("Pontos de Inteligencia: ");
            bruxo.setInteligencia(input.nextDouble());
            System.out.println("Pontos de Ambição: ");
            bruxo.setAmbicao(input.nextDouble());
            System.out.println("Pontos de Lealdade: ");
            bruxo.setLealdade(input.nextDouble());
            System.out.println("Pontos de Estrategia: ");
            bruxo.setEstrategia(input.nextDouble());
            System.out.println("Pontos de Criatividade: ");
            bruxo.setCriatividade(input.nextDouble());

            bruxo.exibirInformacoes();

            System.out.println("Deseja continuar? (s/n): ");
            continuar = input.nextLine();
        }

        System.out.println("Seleção de bruxos finalizada!");
    }
}
