package academia;

import java.time.LocalDate;
import java.util.*;

class Frequencia {
    private final Map<LocalDate, Set<String>> porDia = new HashMap<>();

    void registrar(String nome, int capacidade) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Informe o nome.");
        Set<String> presentes = porDia.computeIfAbsent(LocalDate.now(),
                data -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER));
        if (presentes.contains(nome.trim())) throw new IllegalStateException("Presença já registrada hoje.");
        if (presentes.size() >= capacidade) throw new IllegalStateException("Turma lotada.");
        presentes.add(nome.trim());
        System.out.println("Presença registrada para " + nome.trim() + ".");
    }
}
