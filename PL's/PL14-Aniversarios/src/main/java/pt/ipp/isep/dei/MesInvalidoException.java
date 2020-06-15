package pt.ipp.isep.dei;

/**
 * @author Jordão
 */
public class MesInvalidoException extends IllegalArgumentException {

    public MesInvalidoException() {
        super("Mês Inválido !!!");
    }

    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }
}
