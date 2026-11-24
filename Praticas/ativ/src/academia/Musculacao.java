package academia;

import java.time.LocalTime;

public class Musculacao extends Atividade {
    private final int aparelhos;

    public Musculacao(String nome, LocalTime horario, int duracao, int vagas, int aparelhos) {
        super(nome, horario, duracao, vagas, Modalidade.INDIVIDUAL);
        this.aparelhos = aparelhos;
    }

    @Override
    protected String detalhes() { return aparelhos + " aparelhos"; }
}
