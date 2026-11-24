package locadora;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Locadora locadora = criarLocadora();
        locadora.executar(new Menu());
    }

    private static Locadora criarLocadora() {
        return new Locadora(List.of(
                new Carro("ABC1D23", "Onix", 2024, new BigDecimal("140.00"), 25000, 4),
                new Moto("DEF4G56", "Factor", 2023, new BigDecimal("70.00"), 12000, 150),
                new Van("GHI7J89", "Sprinter", 2025, new BigDecimal("320.00"), 18000, 15)),
                List.of(new AluguelBasico(), new AluguelExecutivo()));
    }
}
