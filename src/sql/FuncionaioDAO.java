package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.ConexaoBanco;
import entidades.Funcionario;

public class FuncionaioDAO {
    private Connection conectar;

    public FuncionaioDAO() {
        conectar = new ConexaoBanco().getConnection();
    }

    public int salvar(Funcionario f) throws Exception {
        String sql = "INSERT INTO funcionario (nome, cpf, data_nasc, salario_bruto) VALUES (?, ?, ?, ?)";
        try {

            PreparedStatement stmt = conectar.prepareStatement(sql);

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(f.getDataNasc()));
            stmt.setDouble(4, f.getSalarioBruto());
            ;

            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                if (e.getSQLState().equals("23505")) {
                    throw new Exception("Erro: CPF " + f.getCpf() + " já cadastrado no banco!");
                }
                e.printStackTrace();
            }
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return 0;
    }

    public int buscarIdPorCpf(String cpf) {
        String sql = "SELECT id_funcionario FROM funcionario WHERE cpf = ?";
        try {

            PreparedStatement stmt = conectar.prepareStatement(sql);

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