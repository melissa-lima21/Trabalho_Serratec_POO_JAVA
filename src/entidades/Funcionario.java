package entidades;
import interfaces.Tributavel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Funcionario extends Pessoa implements Tributavel {
    private Double salarioBruto;
    private Double descontoInss;
    private Double descontoIr;
    private Double salarioLiquido;
    private List<Dependente> dependentes = new ArrayList<>();
    private static final Set<String> CPF_Funcionarios = new HashSet<>();

    public Funcionario(
            String nome,
            String cpf,
            LocalDate dataNasc,
            Double salarioBruto){

        super(nome, cpf, dataNasc);
        validarCPF(cpf);
        this.salarioBruto = salarioBruto;
        CPF_Funcionarios.add(cpf);
    }

    private void validarCPF (String cpf){
        if (CPF_Funcionarios.contains(cpf)) {
            throw new IllegalArgumentException("Funcionario invalido, CPF ja cadastrado.");
        }
    }

    @Override
    public double calcularDescontoInss() {
        double aliquota;
        double deducao;

        if (salarioBruto <= 1412.00) {
            aliquota = 0.075; deducao = 0.00;
        } else if (salarioBruto <= 2666.68) {
            aliquota = 0.09;  deducao = 21.18;
        } else if (salarioBruto <= 4000.03) {
            aliquota = 0.12;  deducao = 101.18;
        } else {
            aliquota = 0.14;  deducao = 181.19;
        }

        return (salarioBruto * aliquota) - deducao;
    }

    @Override
    public double calcularDescontoIr() {
        double baseCalculo = salarioBruto - descontoInss - (dependentes.size() * 189.59);
        double aliquota;
        double deducao;

        if (baseCalculo <= 2259.20) {
            return 0.0; // isento
        } else if (baseCalculo <= 2826.65) {
            aliquota = 0.075; deducao = 169.44;
        } else if (baseCalculo <= 3751.05) {
            aliquota = 0.15;  deducao = 381.44;
        } else if (baseCalculo <= 4664.68) {
            aliquota = 0.225; deducao = 662.77;
        } else {
            aliquota = 0.275; deducao = 896.00;
        }

        return (baseCalculo * aliquota) - deducao;
    }

    @Override
    public double calcularSalarioLiquido(){
        return salarioLiquido = salarioBruto - calcularDescontoIr() - calcularDescontoInss();
    }



    public void adicionarDependente (Dependente dependente) {
        dependentes.add(dependente);
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getDescontoInss() {
        return descontoInss;
    }

    public void setDescontoInss(Double descontoInss) {
        this.descontoInss = descontoInss;
    }

    public Double getDescontoIr() {
        return descontoIr;
    }

    public void setDescontoIr(Double descontoIr) {
        this.descontoIr = descontoIr;
    }
}