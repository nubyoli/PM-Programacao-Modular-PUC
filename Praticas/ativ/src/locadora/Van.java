package locadora;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {
    private final int passageiros;
    private final Avaliacoes avaliacoes = new Avaliacoes();
    private LocalDate ultimaInspecao;

    public Van(String placa, String modelo, int ano, BigDecimal diaria, int km, int passageiros) {
        super(placa, modelo, ano, diaria, km);
        this.passageiros = passageiros;
    }

    @Override
    protected String detalhes() {
        return passageiros + " passageiros" + " | " + avaliacoes
                + " | inspeção: " + (ultimaInspecao == null ? "pendente" : ultimaInspecao);
    }

    @Override
    public void avaliar(int nota) { avaliacoes.adicionar(nota); }

    @Override
    public void realizarInspecao() {
        ultimaInspecao = LocalDate.now();
        System.out.println("Inspeção registrada em " + ultimaInspecao + ".");
    }
}
