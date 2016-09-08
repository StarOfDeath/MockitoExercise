package mx.iteso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
public class TacitKnowledgePrinterTest {

    //Test printNumbers with a limit of 10 // done
    //Verify calculate being called 10 times //done
    //Verify expected result //done

    //Test printNumbers with a limit of 0 // done
    //Verify Exception //done

    //What else can we test?
    //What should we verify?
    private TacitKnowledgePrinter tkPrinter;
    private Printer printer;

    @Before
    public void setUp() {
        printer = mock(Printer.class);
        tkPrinter = new TacitKnowledgePrinter(printer);
        when(printer.print(anyString())).then(returnsFirstArg());

    }

    @Test
    public void testPrint10() { //test comprobador de 10 llamadas al printer
        tkPrinter.printNumbers(10);
        verify(printer, times(10)).print(anyString());

    }

    @Test
    public void testexpectedresult10() { //test para verificar el resultado del anterior
        tkPrinter.printNumbers(10);
        assertEquals(tkPrinter.calculate(10),"Knowledge");
    }
    @Test
    public void testexpectedprint15(){ // test para numero 15
        tkPrinter.printNumbers(15);
        assertEquals(tkPrinter.printNumbers(15),"12Tacit4KnowledgeTacit78TacitKnowledge11Tacit1314TacitKnowledge");
    }
    @Test
            (expected = RuntimeException.class)
    public void testPrint0() {
        when(tkPrinter.calculate(0)).thenThrow(new RuntimeException("limite debe ser mayor a 1 ")); //prueba de limite 0

    }
    @Test
    public void testprint15(){ //comprueba la divisibilidad de 15 el resultado
        tkPrinter.printNumbers(15);
        assertEquals(tkPrinter.calculate(15),"TacitKnowledge");
    }
    @Test
    public void testprintNUMEROTE(){ //comprueba la divisibilidad de 4755 el resultado
        tkPrinter.printNumbers(4755);
        assertEquals(tkPrinter.calculate(4755),"TacitKnowledge");
    }
    @Test
    public void testprintDiferente5y3(){ //comprueba la divisibilidad de 19 el resultado
        tkPrinter.printNumbers(12);
        assertEquals(tkPrinter.calculate(19),"19");
    }
}