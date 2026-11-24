package locadora;

import java.util.IntSummaryStatistics;

class Avaliacoes {
    private final IntSummaryStatistics notas = new IntSummaryStatistics();

    void adicionar(int nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("Informe uma nota de 1 a 5.");
        notas.accept(nota);
        System.out.println("Avaliação registrada.");
    }

    @Override
    public String toString() {
        return notas.getCount() == 0 ? "sem avaliações" : String.format("média %.1f", notas.getAverage());
    }
}
