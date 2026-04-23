package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entidades.FolhaPagamento;
import entidades.Funcionario;

public class CalculadoraFolhaPagamento {
    
    public List<FolhaPagamento> processar(List<Funcionario> funcionarios) {
        List<FolhaPagamento> folhas = new ArrayList<>();
        int codigo = 1;

        for (Funcionario funcionario : funcionarios) {
            double inss = funcionario.calcularDescontoInss();
            double ir = funcionario.calcularDescontoIr();
            double liquido = funcionario.calcularSalarioLiquido();

            folhas.add(new FolhaPagamento(
                codigo++, 
                funcionario, 
                LocalDate.now(), 
                inss, 
                ir, 
                liquido
            ));
        }
        return folhas;
    }
}
