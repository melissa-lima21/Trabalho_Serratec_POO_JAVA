package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Funcionario;

public class FuncionarioDAO {
    private Connection conectar;

    public FuncionarioDAO() {
        conectar = new ConexaoBanco().getConnection();
    }

    public int salvar(Funcionario f) throws Exception {
        String sql = "INSERT INTO funcionario (nome, cpf, data_nasc, salario_bruto) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(f.getDataNasc()));
            stmt.setDouble(4, f.getSalarioBruto());
            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                throw new Exception("Erro: CPF " + f.getCpf() + " já cadastrado no banco!");
            }
            throw e;
        }

        return 0;
    }

    public int buscarIdPorCpf(String cpf) {
        String sql = "SELECT id_funcionario FROM funcionario WHERE cpf = ?";
        try {

            PreparedStatement stmt = conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_funcionario");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}