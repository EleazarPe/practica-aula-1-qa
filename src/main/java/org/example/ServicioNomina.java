package org.example;

import java.math.BigDecimal;

public class ServicioNomina {


    public Empleado crearEmpleado(Empleado empleado) {

        if (empleado == null){
            throw new NullPointerException("Empleado no puede ser nulo");
        }

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
           return BigDecimal.ZERO;
        }
        if(empleado.getTipoEmpleado() !=  TipoEmpleado.FULL_TIME){
            return BigDecimal.ZERO;
        }

        return empleado.getHorasExtra().multiply(BigDecimal.valueOf(1.5).multiply(empleado.getTarifaxHora()));
    }
    public static BigDecimal calcularAplicarBono(Empleado empleado) {
        if(empleado == null){
            return BigDecimal.ZERO;
        }
        if (empleado.getHorasTrabajadas().add(empleado.getHorasExtra()).compareTo(BigDecimal.valueOf(38)) > 0) {
            return new BigDecimal("500");
        }

        return empleado.getHorasTrabajadas().multiply(empleado.getTarifaxHora());
    }




}
