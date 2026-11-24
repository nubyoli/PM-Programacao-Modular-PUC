package academia;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private final List<Atividade> atividades;
    private final List<Plano> planos;

    public Academia(List<Atividade> atividades, List<Plano> planos) {
        this.atividades = new ArrayList<>(atividades);
        this.planos = new ArrayList<>(planos);
    }

    public void executar(Menu menu) {
        String opcoes = """
                ACADEMIA
                1. Associar atividade a um plano
                2. Exibir atividades
                3. Exibir planos
                4. Exibir planos ativos
                5. Emitir certificado
                6. Registrar presença em aula
                7. Remover atividades inativas
                8. Registrar acesso à academia
                9. Desativar atividade
                10. Desativar plano
                0. Sair""";
        while (true) {
            try {
                switch (menu.opcao(opcoes, 10)) {
                    case 0 -> { return; }
                    case 1 -> {
                        Plano plano = menu.escolher("Escolha o plano", planosAtivos());
                        if (plano == null) break;
                        Atividade atividade = menu.escolher("Escolha a atividade", atividadesAtivas());
                        if (atividade != null) {
                            plano.associar(atividade);
                            System.out.println("Atividade associada.");
                        }
                    }
                    case 2 -> menu.listar(atividades);
                    case 3 -> menu.listar(planos);
                    case 4 -> menu.listar(planosAtivos());
                    case 5 -> {
                        Certificavel turma = menu.escolher("Turmas que emitem certificado",
                                atividades.stream().filter(Certificavel.class::isInstance).map(Certificavel.class::cast).toList());
                        if (turma != null) {
                            System.out.println("Nome do participante:");
                            String nome = menu.participante();
                            if (!nome.isEmpty()) turma.emitirCertificado(nome);
                        }
                    }
                    case 6 -> {
                        var turmas = atividadesAtivas().stream().filter(ControladorPresenca.class::isInstance).toList();
                        Atividade turma = menu.escolher("Turmas com chamada", turmas);
                        if (turma != null) registrar(menu, (ControladorPresenca) turma);
                    }
                    case 7 -> {
                        int antes = atividades.size();
                        planos.forEach(Plano::removerInativas);
                        atividades.removeIf(a -> !a.isAtiva());
                        System.out.println("Atividades removidas: " + (antes - atividades.size()));
                    }
                    case 8 -> {
                        Plano plano = menu.escolher("Escolha o plano do participante", planosAtivos());
                        if (plano instanceof ControladorPresenca controle) registrar(menu, controle);
                        else if (plano != null) System.out.println("Acesso liberado pelo plano ilimitado.");
                    }
                    case 9 -> {
                        Atividade turma = menu.escolher("Escolha a turma a desativar", atividadesAtivas());
                        if (turma != null) turma.desativar();
                    }
                    case 10 -> {
                        Plano plano = menu.escolher("Escolha o plano a desativar", planosAtivos());
                        if (plano != null) plano.desativar();
                    }
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Atividade> atividadesAtivas() {
        return atividades.stream().filter(Atividade::isAtiva).toList();
    }

    private List<Plano> planosAtivos() {
        return planos.stream().filter(Plano::isAtivo).toList();
    }

    private void registrar(Menu menu, ControladorPresenca controle) {
        System.out.println("Nome do participante:");
        String nome = menu.participante();
        if (!nome.isEmpty()) controle.registrarPresenca(nome);
    }
}
