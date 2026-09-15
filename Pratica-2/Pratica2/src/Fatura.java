public class Fatura {
    private Item[] itens;
    private double valorTotal;

    public Fatura(){}

    public Fatura(Item[] itens, double valorTotal) {
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
