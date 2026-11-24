package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public abstract class Aluguel {
    private final String tipo;
    private final OptionalInt limiteKmPorDia;
    private final String servicos;
    private final List<Veiculo> veiculos = new ArrayList<>();

    protected Aluguel(String tipo, OptionalInt limiteKmPorDia, String servicos) {
        this.tipo = tipo;
        this.limiteKmPorDia = limiteKmPorDia;
        this.servicos = servicos;
    }

    public boolean permiteDistanciaDiaria(int km) {
        return km >= 0 && (limiteKmPorDia.isEmpty() || km <= limiteKmPorDia.getAsInt());
    }

    public void associar(Veiculo veiculo) {
        veiculo.alugar();
        veiculos.add(veiculo);
    }

    @Override
    public String toString() {
        String distancia = limiteKmPorDia.isPresent() ? limiteKmPorDia.getAsInt() + " km/dia" : "km ilimitados";
        return tipo + " | " + distancia + " | " + servicos + " | veículos: "
                + veiculos.stream().map(Veiculo::getPlaca).toList();
    }
}
