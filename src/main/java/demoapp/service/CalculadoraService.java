package demoapp.service;

import demoapp.controller.NumeroData;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    /*Número par: Lee un número y comprueba si es par*/
    public boolean isPar(int numero){
        return numero % 2 == 0;
    }

    /*Cuadrado: Lee dos números y comprueba si el segundo es el cuadrado del primero.*/
    public boolean isCuadrado(int num1, int num2){
        return num2 == (num1*num1);
    }
}
