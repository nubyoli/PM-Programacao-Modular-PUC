import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public void adicionarItem(Produto produto, int qtd) {
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                item.adicionarQuantidade(qtd);
                atualizarValorTotal();
                return;
            }
        }
        itens.add(new Item(produto, qtd));
        atualizarValorTotal();
    }

    public boolean removerItem(int posicao) {
        if (!posicaoValida(posicao)) {
            return false;
        }
        itens.remove(posicao - 1);
        atualizarValorTotal();
        return true;
    }

    public boolean alterarQuantidade(int posicao, int novaQtd) {
        if (!posicaoValida(posicao) || novaQtd <= 0) {
            return false;
        }
        itens.get(posicao - 1).alterarQuantidade(novaQtd);
        atualizarValorTotal();
        return true;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 1 && posicao <= itens.size();
    }

    private void atualizarValorTotal() {
        valorTotal = 0;
        for (int i = 0; i < itens.size(); i++) {
            valorTotal += itens.get(i).getValorTotal();
        }
    }

    public boolean estaVazia() {
        return itens.isEmpty();
    }

    public void exibirFatura() {
        System.out.println("--- Sua fatura atualizada ---");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item na fatura.");
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + itens.get(i));
        }
        exibirValorFinal();
    }

    public void exibirValorFinal() {
        System.out.println("-----------------------------------");
        System.out.printf("Valor final da sua fatura: R$ %.2f%n", valorTotal);
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}

