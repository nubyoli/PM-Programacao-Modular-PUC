package locadora;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner entrada = new Scanner(System.in);

    public int opcao(String titulo, int maximo) {
        while (true) {
            System.out.println(titulo);
            if (!entrada.hasNextLine()) return 0;
            try {
                int numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0 && numero <= maximo) return numero;
            } catch (NumberFormatException ignorada) {
                // A mesma orientação atende números fora da faixa e texto inválido.
            }
            System.out.println("Digite um número entre 0 e " + maximo + ".");
        }
    }

    public <T> T escolher(String titulo, List<T> itens) {
        System.out.println(titulo);
        listar(itens);
        if (itens.isEmpty()) return null;
        int indice = opcao("Número do item (0 para voltar):", itens.size());
        return indice == 0 ? null : itens.get(indice - 1);
    }

    public void listar(List<?> itens) {
        if (itens.isEmpty()) System.out.println("Nenhum item encontrado.");
        for (int i = 0; i < itens.size(); i++)
            System.out.println((i + 1) + ". " + itens.get(i));
    }
}
