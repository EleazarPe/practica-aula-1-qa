package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    private Long id;
    private TipoEmpleado tipoEmpleado;
    private BigDecimal horasTrabajadas;
    private BigDecimal horasExtra;
    private BigDecimal tarifaxHora;
}
