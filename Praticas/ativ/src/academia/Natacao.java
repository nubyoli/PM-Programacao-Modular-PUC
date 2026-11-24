package academia;

import java.time.LocalTime;

public class Natacao extends Atividade implements ControladorPresenca, Certificavel {
    private final double profundidade;
    private final Frequencia frequencia = new Frequencia();

    public Natacao(String nome, LocalTime horario, int duracao, int vagas, double profundidade) {
        super(nome, horario, duracao, vagas, Modalidade.COLETIVA);
        this.profundidade = profundidade;
    }

    @Override
    protected String detalhes() { return profundidade + " m de profundidade"; }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (!isAtiva()) throw new IllegalStateException("Turma inativa.");
        frequencia.registrar(nomeParticipante, getMaxParticipantes());
    }

    @Override
    public void emitirCertificado(String nomeParticipante) {
        System.out.println("Certificamos a participação de " + nomeParticipante + " na turma " + getNome() + ".");
    }
}
