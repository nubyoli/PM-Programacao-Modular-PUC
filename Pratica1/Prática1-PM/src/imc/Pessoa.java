/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imc;

/**
 *
 * @author 1638220
 */
public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(){
        this.nome = "";
        this.sobrenome = "";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
        this.imc = 0;
    }
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso, double imc){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the imc
     */
    public double getImc() {
        return imc;
    }

    /**
     * @param imc the imc to set
     */
    public void setImc(double imc) {
        this.imc = imc;
    }
    
    public double CalculaIMC(double peso, double altura){
        return this.imc = peso / (Math.pow(altura, 2));
    }
    
    public String InformaObesidade(double imc){
        String result = "";
        if (this.imc < 18.5){
             result = "Abaixo do peso";
        } else if (this.imc >= 18.8 && this.imc <= 24.9){
            result = "Peso normal";
        } else if (this.imc >= 25 && this.imc <= 29.9){
            result = "Sobrepeso";
        } else if (this.imc >= 30 && this.imc <= 34.9){
            result = "Obesidade grau 1";
        } else if (this.imc >= 35 && this.imc <= 39.9){
            result = "Obesidade grau 2";
        } else if (this.imc >= 40){
            result = "Obesidade grau 3";
        }
        return result;
    }
}
