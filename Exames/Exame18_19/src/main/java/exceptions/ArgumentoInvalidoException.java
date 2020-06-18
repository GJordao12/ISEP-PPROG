package exceptions;

/**
 * O Argumento inválido exception.
 */
public class ArgumentoInvalidoException extends IllegalArgumentException {

    /**
     * Cria uma instância para o Argumento Inválido Exception.
     */
    public ArgumentoInvalidoException() {
        super("O número de telefone tem de conter 9 números!");
    }
}
