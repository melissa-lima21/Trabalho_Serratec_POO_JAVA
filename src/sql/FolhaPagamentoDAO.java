package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import sql.ConexaoBanco;
import entidades.FolhaPagamento;

public class FolhaPagamentoDAO {
    public void salvar(FolhaPagamento p, int idFuncionario) throws Exception {
        String sql = "INSERT INTO folha_pagamento (data_pagamento, desconto_inss, desconto_ir, salario_liquido, id_funcionario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDate(1, java.sql.Date.valueOf(p.getDataPagamento()));
            stmt.setDouble(2, p.getDescontoInss());
            stmt.setDouble(3, p.getDescontoIr());
            stmt.setDouble(4, p.getSalarioLiquido());
            stmt.setInt(5, idFuncionario);
            
            stmt.executeUpdate();
        }
    }
}