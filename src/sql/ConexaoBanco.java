package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:postgresql://localhost:5432/Trabalho_Serratec_POO_JAVA";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}