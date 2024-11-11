package desafio3.devsuperior.exception;

public class DatabaseIntegrityViolationException extends RuntimeException{
    public DatabaseIntegrityViolationException(String message) {
        super(message);
    }
}
