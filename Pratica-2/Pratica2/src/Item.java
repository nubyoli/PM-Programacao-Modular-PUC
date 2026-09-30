public class Item {
    private Produto produto;
    private int qtd;

    public Item() {}

    public Item(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public double getValorTotal() {
        return produto.getPreco() * qtd;
    }

    public void alterarQuantidade(int novaQtd) {
        this.qtd = novaQtd;
    }

    public void adicionarQuantidade(int qtdExtra) {
        this.qtd += qtdExtra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}