package org.example;

import java.math.BigDecimal;

public class ServicioNomina {


    public Empleado crearEmpleado(Empleado empleado) {

        if (empleado.getHorasExtra().signum() == -1){
            throw new IllegalArgumentException("Horas Extra negativa");
        }

        if (empleado.getHorasTrabajadas().signum() == -1){
            throw new IllegalArgumentException("Horas Trabajadas negativa");
        }

        return empleado;
    }

    public BigDecimal pagoBaseCalc(Empleado empleado) {

        return empleado.getTarifaxHora().multiply(empleado.getHorasTrabajadas());

    }

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
