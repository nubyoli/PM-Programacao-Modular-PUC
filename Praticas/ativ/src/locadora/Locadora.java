package locadora;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Locadora {
    private final List<Veiculo> veiculos;
    private final List<Aluguel> alugueis;

    public Locadora(List<Veiculo> veiculos, List<Aluguel> alugueis) {
        this.veiculos = new ArrayList<>(veiculos);
        this.alugueis = new ArrayList<>(alugueis);
    }

    public void executar(Menu menu) {
        String opcoes = """
                LOCADORA
                1. Associar veículo a um aluguel
                2. Exibir veículos
                3. Exibir aluguéis
                4. Exibir veículos disponíveis
                5. Avaliar veículo ou aluguel
                6. Realizar inspeção
                7. Remover veículos em manutenção
                8. Enviar veículo para manutenção
                9. Criar aluguel
                0. Sair""";
        while (true) {
            switch (menu.opcao(opcoes, 9)) {
                case 0 -> { return; }
                case 1 -> {
                    Aluguel aluguel = menu.escolher("Escolha o aluguel", alugueis);
                    if (aluguel == null) break;
                    Veiculo veiculo = menu.escolher("Escolha o veículo", disponiveis());
                    if (veiculo != null) {
                        aluguel.associar(veiculo);
                        System.out.println("Veículo associado.");
                    }
                }
                case 2 -> menu.listar(veiculos);
                case 3 -> menu.listar(alugueis);
                case 4 -> menu.listar(disponiveis());
                case 5 -> {
                    var avaliaveis = Stream.concat(veiculos.stream(), alugueis.stream())
                            .filter(Avaliavel.class::isInstance).map(Avaliavel.class::cast).toList();
                    Avaliavel item = menu.escolher("Escolha o que deseja avaliar", avaliaveis);
                    if (item != null) {
                        int nota = menu.opcao("Nota de 1 a 5 (0 para voltar):", 5);
                        if (nota != 0) item.avaliar(nota);
                    }
                }
                case 6 -> {
                    var inspecionaveis = veiculos.stream().filter(Inspecionavel.class::isInstance)
                            .map(Inspecionavel.class::cast).toList();
                    Inspecionavel item = menu.escolher("Escolha o veículo para inspeção", inspecionaveis);
                    if (item != null) item.realizarInspecao();
                }
                case 7 -> {
                    int antes = veiculos.size();
                    veiculos.removeIf(v -> v.getStatus() == StatusVeiculo.MANUTENCAO);
                    System.out.println("Veículos removidos: " + (antes - veiculos.size()));
                }
                case 8 -> {
                    Veiculo veiculo = menu.escolher("Enviar para manutenção", disponiveis());
                    if (veiculo != null) veiculo.enviarParaManutencao();
                }
                case 9 -> {
                    int tipo = menu.opcao("1. Básico  2. Premium  3. Executivo  0. Voltar", 3);
                    switch (tipo) {
                        case 1 -> alugueis.add(new AluguelBasico());
                        case 2 -> alugueis.add(new AluguelPremium());
                        case 3 -> alugueis.add(new AluguelExecutivo());
                    }
                }
            }
        }
    }

    private List<Veiculo> disponiveis() {
        return veiculos.stream().filter(v -> v.getStatus() == StatusVeiculo.DISPONIVEL).toList();
    }
}
