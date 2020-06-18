package exceptions;

/**
 * The type Argumento invalido exception.
 */
public class ArgumentoInvalidoException extends IllegalArgumentException{

    /**
     * Instantiates a new Argumento invalido exception.
     */
    public ArgumentoInvalidoException() {
        super("O número de telefone tem de conter 9 números!");
    }
}
