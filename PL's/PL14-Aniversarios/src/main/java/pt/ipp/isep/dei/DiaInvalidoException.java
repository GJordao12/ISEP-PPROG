package pt.ipp.isep.dei;

/**
 * @author Jordão
 */
public class DiaInvalidoException extends IllegalArgumentException {

    public DiaInvalidoException() {
        super("Dia Inválido !!!");
    }

    public DiaInvalidoException(String mensagem) {
        super(mensagem);
    }
}
