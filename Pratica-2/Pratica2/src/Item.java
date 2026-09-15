public class Item {
    private Produto produto;
    private int qtd;
    private double valorTotal, valorItem;

    public Item(){}

    public Item(Produto produto, int qtd, double valorTotal, double valorItem) {
        this.produto = produto;
        this.qtd = qtd;
        this.valorTotal = valorTotal;
        this.valorItem = valorItem;
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
}
