public class Item {
    private Produto produto;
    private int qtd, qtdEstoque;
    private double valorTotal, valorItem;

    public Item(){}

    public Item(Produto produto, int qtd, double valorTotal, double valorItem) {
        this.produto = produto;
        this.qtd = qtd;
        this.valorTotal = valorTotal;
        this.valorItem = valorItem;
    }

    public void alterarQuantidade(Item item, int qtd){
        item.qtd = qtd;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
