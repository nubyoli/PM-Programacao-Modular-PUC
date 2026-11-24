package academia;

import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Academia academia = criarAcademia();
        academia.executar(new Menu());
    }

    private static Academia criarAcademia() {
        return new Academia(List.of(
                new Musculacao("Musculação", LocalTime.of(7, 0), 60, 20, 15),
                new Natacao("Natação", LocalTime.of(9, 0), 45, 12, 1.8),
                new Spinning("Spinning", LocalTime.of(18, 0), 50, 16, 16)),
                List.of(new PlanoBasico(), new PlanoPremium()));
    }
}
