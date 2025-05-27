package org.example;

import java.math.BigDecimal;

public class ServicioNomina {

    public BigDecimal pagoBaseCalc(Empleado empleado) {

        return empleado.getTarifaxHora().multiply(empleado.getHorasTrabajadas());

    }
}
