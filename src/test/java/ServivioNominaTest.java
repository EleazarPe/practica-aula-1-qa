import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServivioNominaTest {

    private  Empleado crearEmpleadoTest() {
        Empleado empleado = new Empleado(1l, TipoEmpleado.PART_TIME, new BigDecimal("40"), new BigDecimal("10"), new BigDecimal("20.00"));
        return empleado;
    }

    @Test
    public void pagoBaseTest(){
        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado empleado = crearEmpleadoTest();

        assertEquals(new BigDecimal("800"), servicioNomina.pagoBaseCalc(empleado));
    }

    @Test
    public void calcularPagoHorasExtraTest(){
        Empleado empleado = crearEmpleadoTest();
        assertEquals(new BigDecimal("300.00"), ServicioNomina.calcularPagoHorasExtra(empleado).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    @Test
    public void aplicarBonoTest(){
        Empleado empleado = crearEmpleadoTest();

        assertEquals(new BigDecimal("500.00"), ServicioNomina.calcularAplicarBono(empleado).setScale(2, BigDecimal.ROUND_HALF_UP));

    }
}
