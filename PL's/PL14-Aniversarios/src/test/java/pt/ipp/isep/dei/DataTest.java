package pt.ipp.isep.dei;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jordão
 */
public class DataTest {

    @Test
    public void testSetComDataValida() {
        System.out.println("setData: data válida");
        int ano = 2018;
        int mes = 12;
        int dia = 1;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

        assertEquals(instance.getAno(), ano);
        assertEquals(instance.getMes(), mes);
        assertEquals(instance.getDia(), dia);

        //Ano Bissexto
        ano = 2004;
        mes = 2;
        dia = 29;
        instance = new Data();

        instance.setData(ano, mes, dia);

        assertEquals(instance.getAno(), ano);
        assertEquals(instance.getMes(), mes);
        assertEquals(instance.getDia(), dia);
    }

    @Test(expected = MesInvalidoException.class)
    public void testSetDataComMesInvalido() {
        System.out.println("setData: data com mês inválido");

        //mês < 1
        int ano = 2018;
        int mes = 0;
        int dia = 1;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

        //mês > 12
        mes = 13;

        instance.setData(ano, mes, dia);
    }

    @Test(expected = DiaInvalidoException.class)
    public void testSetDataComDiaInvalido() {
        System.out.println("setData: data com dia inválido");

        //dia < 1
        int ano = 2018;
        int mes = 12;
        int dia = 0;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

        //dia > 31
        dia = 33;

        instance.setData(ano, mes, dia);
    }
}