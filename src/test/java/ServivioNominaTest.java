import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServivioNominaTest {

    private  Empleado crearEmpleadoTest() {
        Empleado empleado = new Empleado(1l, TipoEmpleado.FULL_TIME, new BigDecimal("40"), new BigDecimal("10"), new BigDecimal("20.00"));
        return empleado;
    }

    @Test
    public void pagoBaseTest(){
        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado empleado = crearEmpleadoTest();

        assertEquals( empleado.getTarifaxHora().multiply(empleado.getHorasTrabajadas()), servicioNomina.pagoBaseCalc(empleado));
    }

    @Test
    public void calcularPagoHorasExtraTest(){
        Empleado empleado = crearEmpleadoTest();
        assertEquals(new BigDecimal("200.00"), empleado.getHorasExtra().multiply(empleado.getTarifaxHora()));
    }
}
