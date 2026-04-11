import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private Double salarioBruto;
    private Double descontoInss;
    private Double descontoIr;

    public Funcionario(
            String nome,
            String cpf,
            LocalDate dataNasc,
            Double salarioBruto,
            Double descontoInss,
            Double descontoIr){

        super(nome, cpf, dataNasc);
        this.salarioBruto = salarioBruto;
        this.descontoInss = descontoInss;
        this.descontoIr = descontoIr;
    }

}

