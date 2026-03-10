package demoapp.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CalcularData {
    @NotNull
    private Double num1;

    @NotNull
    private Double num2;

    @NotNull
    @Pattern(regexp = "[+\\-*/]", message = "Operación no válida. Usa +, -, *, /")
    private String operacion;

    public Double getNum1() { return num1; }
    public void setNum1(Double num1) { this.num1 = num1; }

    public Double getNum2() { return num2; }
    public void setNum2(Double num2) { this.num2 = num2; }

    public String getOperacion() { return operacion; }
    public void setOperacion(String operacion) { this.operacion = operacion; }
}
