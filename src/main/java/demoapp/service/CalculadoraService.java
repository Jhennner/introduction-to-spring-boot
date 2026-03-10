package demoapp.service;

import demoapp.controller.NumeroData;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public boolean isPar(int numero){
        return numero % 2 == 0;
    }
}
