package org.example;


import java.math.BigDecimal;


public class Empleado {
    private Long id;
    private TipoEmpleado tipoEmpleado;
    private BigDecimal horasTrabajadas;
    private BigDecimal horasExtra;
    private BigDecimal tarifaxHora;

    public Empleado(Long id, TipoEmpleado tipoEmpleado, BigDecimal horasTrabajadas, BigDecimal horasExtra, BigDecimal tarifaxHora) {
        this.id = id;
        this.tipoEmpleado = tipoEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtra = horasExtra;
        this.tarifaxHora = tarifaxHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public BigDecimal getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public BigDecimal getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(BigDecimal horasExtra) {
        this.horasExtra = horasExtra;
    }

    public BigDecimal getTarifaxHora() {
        return tarifaxHora;
    }

    public void setTarifaxHora(BigDecimal tarifaxHora) {
        this.tarifaxHora = tarifaxHora;
    }
}
