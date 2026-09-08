/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imc;

import java.util.Scanner;

/**
 *
 * @author 1638220
 */
public class Imc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        
        System.out.println("Informe seu primeiro nome: ");
        pessoa.setNome(entrada.nextLine());
        
        System.out.println("Informe seu sobrenome: ");
        pessoa.setSobrenome(entrada.nextLine());
        
        System.out.println("Informe seu peso: ");
        pessoa.setPeso(entrada.nextDouble());
        
        System.out.println("Informe sua altura: ");
        pessoa.setAltura(entrada.nextDouble());
        
        System.out.println("Informe sua idade: ");
        pessoa.setIdade(entrada.nextInt());
        
        System.out.printf("Seu IMC eh: %.2f \n", pessoa.CalculaIMC(pessoa.getPeso(), pessoa.getAltura()));
        System.out.println("Sua classificacao: " + pessoa.InformaObesidade(pessoa.getImc()));
    }
    
}
