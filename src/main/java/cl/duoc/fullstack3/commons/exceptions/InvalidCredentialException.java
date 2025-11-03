package cl.duoc.fullstack3.commons.exceptions;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
        super("Credenciales incorrectas");
    }
}
