package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Funcionario;
import sql.ConexaoBanco;
import entidades.Dependente;

public class DependenteDAO {
    private Connection conectar;

    private FuncionarioDAO funcionaioDAO;

    public DependenteDAO() {
        this.funcionaioDAO = new FuncionarioDAO();
        conectar = new ConexaoBanco().getConnection();
    }

    public void salvar(Dependente d, String cpfFuncionario) throws Exception {

        Integer funcionario = funcionaioDAO.buscarIdPorCpf(cpfFuncionario);

        String sql = "INSERT INTO dependente (nome, cpf, data_nascimento, parentesco, id_funcionario) " +
                "VALUES (?, ?, ?, ?::parentesco_dependente, ?)";

        try (PreparedStatement stmt = conectar.prepareStatement(sql)) {

            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(d.getDataNasc()));
            stmt.setString(4, d.getParentesco().name());
            stmt.setInt(5, funcionario);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}