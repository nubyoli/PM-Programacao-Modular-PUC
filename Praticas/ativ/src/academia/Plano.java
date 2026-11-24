package academia;

import java.util.ArrayList;
import java.util.List;

public abstract class Plano {
    private final String nome;
    private final List<Atividade> atividades = new ArrayList<>();
    private boolean ativo = true;

    protected Plano(String nome) { this.nome = nome; }
    public boolean isAtivo() { return ativo; }
    public void desativar() { ativo = false; }
    protected abstract boolean permite(Atividade atividade);

    public void associar(Atividade atividade) {
        if (!ativo || !atividade.isAtiva()) throw new IllegalStateException("Plano e atividade precisam estar ativos.");
        if (!permite(atividade)) throw new IllegalArgumentException("Este plano permite apenas atividades individuais.");
        if (atividades.contains(atividade)) throw new IllegalStateException("Atividade já associada.");
        atividades.add(atividade);
    }

    public void removerInativas() { atividades.removeIf(a -> !a.isAtiva()); }

    @Override
    public String toString() {
        return nome + " | " + (ativo ? "ativo" : "inativo") + " | atividades: "
                + atividades.stream().map(Atividade::getNome).toList();
    }
}
