package locadora;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Moto extends Veiculo implements Inspecionavel {
    private final int cilindrada;
    private LocalDate ultimaInspecao;

    public Moto(String placa, String modelo, int ano, BigDecimal diaria, int km, int cilindrada) {
        super(placa, modelo, ano, diaria, km);
        this.cilindrada = cilindrada;
    }

    @Override
    protected String detalhes() {
        return cilindrada + " cc"
                + " | inspeção: " + (ultimaInspecao == null ? "pendente" : ultimaInspecao);
    }

    @Override
    public void realizarInspecao() {
        ultimaInspecao = LocalDate.now();
        System.out.println("Inspeção registrada em " + ultimaInspecao + ".");
    }
}
