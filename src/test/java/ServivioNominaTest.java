import org.example.Empleado;
import org.example.ServicioNomina;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServivioNominaTest {

    private  Empleado crearEmpleadoTest(Long id, TipoEmpleado tipoEmpleado, BigDecimal horasTrabajadas, BigDecimal horasExtra, BigDecimal tarifaxHora) {
        Empleado empleado = new Empleado(id, tipoEmpleado, horasTrabajadas, horasExtra, tarifaxHora);
        return empleado;
    }

    @Test
    public void pagoBaseTest(){
        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado empleado = new Empleado();

        assertEquals(new BigDecimal(40 * 10), servicioNomina.pagoBaseCalc(empleado));
    }

    @Test
    public void calcularPagoHorasExtraTest(){
        Empleado empleado = crearEmpleadoTest(1l, TipoEmpleado.FULL_TIME, new BigDecimal("40"), new BigDecimal("10"), new BigDecimal("20.00"));
        assertEquals(new BigDecimal("200.00"), empleado.getHorasExtra().multiply(empleado.getTarifaxHora()));
    }
}
