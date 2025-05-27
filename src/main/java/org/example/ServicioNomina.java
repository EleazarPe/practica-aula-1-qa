package org.example;

import java.math.BigDecimal;

public class ServicioNomina {

    public static BigDecimal calcularPagoHorasExtra(Empleado empleado) {
        if(empleado == null){
           throw new IllegalArgumentException("empleado es null");
        }
        if(empleado.getTipoEmpleado() !=  TipoEmpleado.FULL_TIME){
            throw new IllegalArgumentException("El tipo de empleado es diferente a fullTime");
        }

        return BigDecimal.ZERO;
    }
}
