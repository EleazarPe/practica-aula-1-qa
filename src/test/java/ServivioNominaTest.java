import org.example.Empleado;
import org.example.ServicioNomina;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServivioNominaTest {

    @Test
    public void pagoBaseTest(){
        ServicioNomina servicioNomina = new ServicioNomina();

        Empleado empleado = new Empleado();

        assertEquals(new BigDecimal(40 * 10), servicioNomina.pagoBaseCalc(empleado));
    }

}
