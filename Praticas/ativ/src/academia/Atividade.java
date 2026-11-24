package academia;

import java.time.LocalTime;

public abstract class Atividade {
    private final String nome;
    private final LocalTime horario;
    private final int duracaoMinutos;
    private final int maxParticipantes;
    private final Modalidade modalidade;
    private boolean ativa = true;

    protected Atividade(String nome, LocalTime horario, int duracaoMinutos,
                        int maxParticipantes, Modalidade modalidade) {
        this.nome = nome;
        this.horario = horario;
        this.duracaoMinutos = duracaoMinutos;
        this.maxParticipantes = maxParticipantes;
        this.modalidade = modalidade;
    }

    public boolean isAtiva() { return ativa; }
    public void desativar() { ativa = false; }
    public Modalidade getModalidade() { return modalidade; }
    public int getMaxParticipantes() { return maxParticipantes; }
    public String getNome() { return nome; }

    protected abstract String detalhes();

    @Override
    public String toString() {
        return nome + " | " + horario + " | " + duracaoMinutos + " min | " + maxParticipantes
                + " vagas | " + modalidade + " | " + (ativa ? "ativa" : "inativa") + " | " + detalhes();
    }
}
