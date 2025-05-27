import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServivioNominaTest {

    private Empleado crearEmpleadoParaTest(){
        return new Empleado(1l, TipoEmpleado.FULL_TIME, new BigDecimal("40"), new BigDecimal("10"), new BigDecimal("20.00"), false);
    }

    @Test
    public  void crearEmpleadoTest() {

        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado test1 = crearEmpleadoParaTest();
        test1.setHorasTrabajadas(new BigDecimal("-10"));
        assertThrows(IllegalArgumentException.class, () -> servicioNomina.crearEmpleado(test1));

        Empleado test2 = crearEmpleadoParaTest();
        test2.setHorasExtra(new BigDecimal("-10"));
        assertThrows(IllegalArgumentException.class, () -> servicioNomina.crearEmpleado(test2));
    }

    @Test
    public void pagoBaseTest(){
        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado empleado = crearEmpleadoParaTest();

        assertEquals( new BigDecimal("800.00"), servicioNomina.pagoBaseCalc(empleado));
    }

    @Test
    public void calcularPagoHorasExtraTest(){

        Empleado empleado = crearEmpleadoParaTest();

        assertEquals(new BigDecimal("200.00"), empleado.getHorasExtra().multiply(empleado.getTarifaxHora()));
    }
}
