package locadora;

import java.util.OptionalInt;

public class AluguelPremium extends Aluguel {
    public AluguelPremium() { super("Premium", OptionalInt.empty(), "seguro incluso"); }
}
