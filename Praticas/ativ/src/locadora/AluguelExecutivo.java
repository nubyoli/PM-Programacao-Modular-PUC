package locadora;

import java.util.OptionalInt;

public class AluguelExecutivo extends Aluguel implements Avaliavel {
    private final Avaliacoes avaliacoes = new Avaliacoes();

    public AluguelExecutivo() { super("Executivo", OptionalInt.empty(), "motorista particular"); }

    @Override
    public void avaliar(int nota) { avaliacoes.adicionar(nota); }

    @Override
    public String toString() { return super.toString() + " | " + avaliacoes; }
}
