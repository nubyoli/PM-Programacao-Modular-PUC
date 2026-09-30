import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Monitor", 500));
        produtos.add(new Produto(2, "Mouse", 120));
        produtos.add(new Produto(3, "Teclado", 280));

        Fatura fatura = new Fatura();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n===== LOJA DE SUPRIMENTOS =====");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Finalizar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> menuComprar(produtos, fatura);
                case 2 -> fatura.exibirFatura();
                case 3 -> menuExcluir(fatura);
                case 4 -> menuAlterar(fatura);
                case 5 -> {
                    System.out.println("\n--- Compra finalizada ---");
                    fatura.exibirFatura();
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuComprar(ArrayList<Produto> produtos, Fatura fatura) {
        System.out.println("\n--- Produtos disponíveis ---");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }
        System.out.print("Código do produto (0 para voltar): ");
        int codigo = sc.nextInt();
        if (codigo == 0) return;

        Produto escolhido = buscarProduto(produtos, codigo);
        if (escolhido == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Quantidade (0 para voltar): ");
        int qtd = sc.nextInt();
        if (qtd == 0) return;
        if (qtd < 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        fatura.adicionarItem(escolhido, qtd);
        System.out.println("Item adicionado à fatura!");
    }

    private static void menuExcluir(Fatura fatura) {
        if (fatura.estaVazia()) {
            System.out.println("A fatura está vazia.");
            return;
        }
        fatura.exibirFatura();
        System.out.print("Número do item a excluir (0 para voltar): ");
        int pos = sc.nextInt();
        if (pos == 0) return;

        if (fatura.removerItem(pos)) {
            System.out.println("Item removido!");
        } else {
            System.out.println("Item inválido.");
        }
    }

    private static void menuAlterar(Fatura fatura) {
        if (fatura.estaVazia()) {
            System.out.println("A fatura está vazia.");
            return;
        }
        fatura.exibirFatura();
        System.out.print("Número do item a alterar (0 para voltar): ");
        int pos = sc.nextInt();
        if (pos == 0) return;

        System.out.print("Nova quantidade (0 para voltar): ");
        int novaQtd = sc.nextInt();
        if (novaQtd == 0) return;

        if (fatura.alterarQuantidade(pos, novaQtd)) {
            System.out.println("Quantidade alterada!");
        } else {
            System.out.println("Item ou quantidade inválidos.");
        }
    }

    private static Produto buscarProduto(ArrayList<Produto> produtos, int codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                return produtos.get(i);
            }
        }
        return null;
    }
}