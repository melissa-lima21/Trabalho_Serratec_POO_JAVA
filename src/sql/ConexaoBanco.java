package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:postgresql://localhost:5432/Trabalho_Serratec_POO_JAVA";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    private Connection connection;

    public Connection getConnection() {
        System.out.println("Testando conexão...");
        try {
            connection = (Connection) DriverManager.getConnection(URL, USER, PASS);
            if (connection != null) {
                System.out.println("Conectado com sucesso!");
            } else {
                System.out.println("Erro nos dados da conexão! Verifique, porfavor e tente novamente.");
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco.\n" + e.getMessage());
        }
        return connection;
    }

}