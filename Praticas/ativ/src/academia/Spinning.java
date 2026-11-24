package academia;

import java.time.LocalTime;

public class Spinning extends Atividade implements ControladorPresenca {
    private final int bicicletas;
    private final Frequencia frequencia = new Frequencia();

    public Spinning(String nome, LocalTime horario, int duracao, int vagas, int bicicletas) {
        super(nome, horario, duracao, vagas, Modalidade.COLETIVA);
        this.bicicletas = bicicletas;
    }

    @Override
    protected String detalhes() { return bicicletas + " bicicletas"; }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (!isAtiva()) throw new IllegalStateException("Turma inativa.");
        frequencia.registrar(nomeParticipante, getMaxParticipantes());
    }
}
