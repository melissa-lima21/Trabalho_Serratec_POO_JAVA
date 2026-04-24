package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sql.ConexaoBanco;
import entidades.Dependente;

public class DependenteDAO {
    private Connection conectar;

    public DependenteDAO() {
        conectar = new ConexaoBanco().getConnection();
    }

    public void salvar(Dependente d, int idFuncionario) throws Exception {

        String sql = "INSERT INTO dependente (nome, cpf, data_nasc, parentesco, id_funcionario) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conectar.prepareStatement(sql);
            
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(d.getDataNasc()));
            stmt.setString(4, d.getParentesco().name());
            stmt.setInt(5,idFuncionario);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                throw new Exception("Erro: CPF " + d.getCpf() + " já cadastrado no banco!");
            }
        }
    }
}