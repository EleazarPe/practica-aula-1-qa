package org.example;

import java.math.BigDecimal;

public class ServicioNomina {


    public static Empleado crearEmpleado(Empleado empleado) {

        if (empleado.getHorasExtra().signum() == -1){
            throw new IllegalArgumentException("Horas Extra negativa");
        }

        if (empleado.getHorasTrabajadas().signum() == -1){
            throw new IllegalArgumentException("Horas Trabajadas negativa");
        }

        return empleado;
    }

    public static BigDecimal pagoBaseCalc(Empleado empleado) {

        return empleado.getTarifaxHora().multiply(empleado.getHorasTrabajadas());

    }

    public static BigDecimal calcularPagoHorasExtra(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado es null");
        }
        if(empleado.getTipoEmpleado() !=  TipoEmpleado.FULL_TIME){
            return BigDecimal.ZERO;
        }

        return empleado.getHorasExtra().multiply(BigDecimal.valueOf(1.5).multiply(empleado.getTarifaxHora()));
    }
    public static BigDecimal calcularAplicarBono(Empleado empleado) {

        if (empleado == null) {
            throw new IllegalArgumentException("El empleado es null");
        }
        if (empleado.getHorasTrabajadas().add(empleado.getHorasExtra()).compareTo(BigDecimal.valueOf(38)) > 0) {
            return new BigDecimal("500");
        }

        return empleado.getHorasTrabajadas().multiply(empleado.getTarifaxHora());
    }

    public static BigDecimal calcularSueldofinal(Empleado empleado) {
        BigDecimal sueldoFinal = new BigDecimal("0.00");
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado es null");
        }
        sueldoFinal = sueldoFinal.add(pagoBaseCalc(empleado));
        sueldoFinal = sueldoFinal.add(calcularPagoHorasExtra(empleado));
        sueldoFinal = sueldoFinal.add(calcularAplicarBono(empleado));
        if(!empleado.isAutorizacionSalario()) {
            throw new IllegalArgumentException("No se puede calcular el sueldo sin autorización de salario");
        }

        return sueldoFinal;
    }



}
