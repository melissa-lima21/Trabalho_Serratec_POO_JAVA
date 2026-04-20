package entidades;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Funcionario extends Pessoa {
    private Double salarioBruto;
    private Double descontoInss;
    private Double descontoIr;
    private List<Dependente> dependentes = new ArrayList<>();
    private static final Set<String> CPF_Funcionarios = new HashSet<>();

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
        CPF_Funcionarios.add(cpf);
    }

    private void validarCPF (String cpf){
        if (CPF_Funcionarios.contains(cpf)) {
            throw new IllegalArgumentException("Funcionario invalido, CPF ja cadastrado.");
        }
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

    /// add metodo pra calcular o inss e o ir


}

