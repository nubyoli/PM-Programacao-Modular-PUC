package locadora;

import java.math.BigDecimal;

public class Carro extends Veiculo implements Avaliavel {
    private final int portas;
    private final Avaliacoes avaliacoes = new Avaliacoes();

    public Carro(String placa, String modelo, int ano, BigDecimal diaria, int km, int portas) {
        super(placa, modelo, ano, diaria, km);
        this.portas = portas;
    }

    @Override
    protected String detalhes() {
        return portas + " portas" + " | " + avaliacoes;
    }

    @Override
    public void avaliar(int nota) { avaliacoes.adicionar(nota); }
}
