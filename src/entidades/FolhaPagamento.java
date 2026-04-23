package entidades;

import java.time.LocalDate;

public class FolhaPagamento {
    private int codigo;
    private Funcionario funcionario;
    private LocalDate dataPagamento;
    private double descontoInss;
    private double descontoIr;
    private double salarioLiquido;

    public FolhaPagamento(
            int codigo,
            Funcionario funcionario,
            LocalDate dataPagamento,
            double descontoInss,
            double descontoIr,
            double salarioLiquido

    )

    {
        this.codigo = codigo;
        this.funcionario = funcionario;
        this.dataPagamento = dataPagamento;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIr;
        this.salarioLiquido = salarioLiquido;
    }

    public int getCodigo() {
        return codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public double getDescontoInss() {
        return descontoInss;
    }

    public double getDescontoIr() {
        return descontoIr;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public static String formatarSaida(FolhaPagamento f) {
        return String.format("%s;%s;%.2f;%.2f;%.2f",
                f.getFuncionario().getNome(),
                f.getFuncionario().getCpf(),
                f.getDescontoInss(),
                f.getDescontoIr(),
                f.getSalarioLiquido());
    }
}
