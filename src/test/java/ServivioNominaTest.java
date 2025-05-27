import org.example.Empleado;
import org.example.TipoEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ServivioNominaTest {

    Empleado empleado;


    private  Empleado crearEmpleadoTest(Long id, TipoEmpleado tipoEmpleado, BigDecimal horasTrabajadas, BigDecimal horasExtra, BigDecimal tarifaxHora) {
        empleado = new Empleado(id, TipoEmpleado.FULL_TIME, horasTrabajadas, horasExtra, tarifaxHora);
        return empleado;
    }

    @Test
    public void calcularPagoHorasExtraTest(){

    }
}
