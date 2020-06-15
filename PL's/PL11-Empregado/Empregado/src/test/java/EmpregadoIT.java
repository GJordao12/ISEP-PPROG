
import org.junit.Test;
import static org.junit.Assert.*;

public class EmpregadoIT {

    /**
     * Test of determinarHorasTrabalho method, of class Empregado.
     */
    @Test
    public void testDeterminarHorasTrabalho() {
        System.out.println("determinarHorasTrabalho");
        Empregado instance = new Empregado("Gonçalo", "Jordão", new Data(Data.dataAtual()), new Tempo(8, 30, 0), new Tempo(17, 15, 0));
        int expResult = 43;
        int result = instance.determinarHorasTrabalho();
        assertEquals(expResult, result);
    }

    /**
     * Test of determinarTempoEmpregado method, of class Empregado.
     */
    @Test
    public void testDeterminarTempoEmpregado() {
        System.out.println("determinarTempoEmpregado");
        Empregado instance = new Empregado("Gonçalo", "Jordão", new Data(2020, 03, 28), new Tempo(8, 30, 0), new Tempo(17, 15, 0));
        int expResult = 4;
        int result = instance.determinarTempoEmpregado();
        assertEquals(expResult, result);
    }
}
