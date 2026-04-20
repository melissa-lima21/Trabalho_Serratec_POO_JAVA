package exceptions;

public class DependenteException extends RuntimeException {
    public DependenteException(String message) {
        super(message);
    }
}

// Herda de RuntimeException pra criar uma exceção personalizada,
// permitindo lançar erros específicos das regras de negócio sem
// obrigar tratamento com try/catch ou throws.