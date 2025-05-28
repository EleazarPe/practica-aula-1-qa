import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServivioNominaTest {

    private Empleado crearEmpleadoParaTest() {
        return new Empleado(1l, TipoEmpleado.FULL_TIME, new BigDecimal("40"), new BigDecimal("10"), new BigDecimal("20.00"), true);
    }

    @Test
    public void crearEmpleadoTest() {

        ServicioNomina servicioNomina = new ServicioNomina();

        // Empleado no puede ser nulo.
        Empleado test0 = null;
        assertThrows(NullPointerException.class, () -> servicioNomina.crearEmpleado(test0));

        // Horas Trabajadas no puede ser negativo
        Empleado test1 = crearEmpleadoParaTest();
        test1.setHorasTrabajadas(new BigDecimal("-10"));
        assertThrows(IllegalArgumentException.class, () -> servicioNomina.crearEmpleado(test1));

        // Horas extras no puede ser negativo
        Empleado test2 = crearEmpleadoParaTest();
        test2.setHorasExtra(new BigDecimal("-10"));
        assertThrows(IllegalArgumentException.class, () -> servicioNomina.crearEmpleado(test2));
    }

    @Test
    public void pagoBaseTest() {
        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado empleado = crearEmpleadoParaTest();

        assertEquals(new BigDecimal("800.00"), servicioNomina.pagoBaseCalc(empleado));
    }

    @Test
    public void calcularPagoHorasExtraTest() {
        Empleado empleado = crearEmpleadoParaTest();
        assertEquals(new BigDecimal("300.00"), ServicioNomina.calcularPagoHorasExtra(empleado).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void aplicarBonoTest() {
        Empleado empleado = crearEmpleadoParaTest();

        assertEquals(new BigDecimal("500.00"), ServicioNomina.calcularAplicarBono(empleado).setScale(2, BigDecimal.ROUND_HALF_UP));

    }

    @Test
    public void calcularTotalTest() {
        BigDecimal totalPago = new BigDecimal("00.00");
        Empleado empleado = crearEmpleadoParaTest();
        totalPago = totalPago.add(ServicioNomina.calcularSueldofinal(empleado));
        assertEquals(new BigDecimal("1600.00"), totalPago.setScale(2, BigDecimal.ROUND_HALF_UP));


    }
}
