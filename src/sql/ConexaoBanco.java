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

            connection = DriverManager.getConnection(URL, USER, PASS);

            System.out.println("Conectado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }

        return connection;
    }
}