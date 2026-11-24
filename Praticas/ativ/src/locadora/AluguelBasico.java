package locadora;

import java.util.OptionalInt;

public class AluguelBasico extends Aluguel {
    public AluguelBasico() { super("Básico", OptionalInt.of(100), "sem seguro incluso"); }
}
