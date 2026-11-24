package academia;

public class PlanoBasico extends Plano implements ControladorPresenca {
    private final Frequencia acessos = new Frequencia();

    public PlanoBasico() { super("Básico"); }

    @Override
    protected boolean permite(Atividade atividade) {
        return atividade.getModalidade() == Modalidade.INDIVIDUAL;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (!isAtivo()) throw new IllegalStateException("Plano inativo.");
        acessos.registrar(nomeParticipante, Integer.MAX_VALUE);
    }
}
