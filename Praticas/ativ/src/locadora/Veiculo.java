package locadora;

import java.math.BigDecimal;

public abstract class Veiculo {
    private final String placa;
    private final String modelo;
    private final int ano;
    private final BigDecimal diaria;
    private final int quilometragem;
    private StatusVeiculo status = StatusVeiculo.DISPONIVEL;

    protected Veiculo(String placa, String modelo, int ano, BigDecimal diaria, int quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.diaria = diaria;
        this.quilometragem = quilometragem;
    }

    public StatusVeiculo getStatus() { return status; }
    public String getPlaca() { return placa; }

    void alugar() {
        exigirDisponivel();
        status = StatusVeiculo.ALUGADO;
    }

    public void enviarParaManutencao() {
        exigirDisponivel();
        status = StatusVeiculo.MANUTENCAO;
    }

    private void exigirDisponivel() {
        if (status != StatusVeiculo.DISPONIVEL) throw new IllegalStateException("Veículo indisponível.");
    }

    protected abstract String detalhes();

    @Override
    public String toString() {
        return placa + " | " + modelo + " " + ano + " | R$ " + diaria + "/dia | "
                + quilometragem + " km | " + status + " | " + detalhes();
    }
}
