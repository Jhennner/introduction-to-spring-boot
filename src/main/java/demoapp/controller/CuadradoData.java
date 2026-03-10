package demoapp.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CuadradoData {
    @NotNull
    @Positive
    private int num1;

    @NotNull
    @Positive
    private int num2;

    public int getNum1() { return num1; }
    public void setNum1(Integer num1) { this.num1 = num1; }

    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }
}
