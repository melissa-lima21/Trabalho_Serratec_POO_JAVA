package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entidades.FolhaPagamento;
import entidades.Funcionario;
import sql.FolhaPagamentoDAO;
import sql.FuncionarioDAO;

public class CalculadoraFolhaPagamento {

    public List<FolhaPagamento> processar(List<Funcionario> funcionarios) throws Exception {
        List<FolhaPagamento> folhas = new ArrayList<>();
        int codigo = 1;
        FolhaPagamentoDAO folhaPagamentoDAO = new FolhaPagamentoDAO();
        FuncionarioDAO funcionaioDAO = new FuncionarioDAO();
        for (Funcionario funcionario : funcionarios) {
            double inss = funcionario.calcularDescontoInss();
            double ir = funcionario.calcularDescontoIr();
            double liquido = funcionario.calcularSalarioLiquido();

            int func = funcionaioDAO.buscarIdPorCpf(funcionario.getCpf());
            FolhaPagamento folhaPagamento = new FolhaPagamento(
                    codigo++,
                    funcionario,
                    LocalDate.now(),
                    inss,
                    ir,
                    liquido
            );
            folhas.add(folhaPagamento);
            folhaPagamentoDAO.salvar(folhaPagamento,func);
        }
        return folhas;
    }
}