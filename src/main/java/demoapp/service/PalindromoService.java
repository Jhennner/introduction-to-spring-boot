package demoapp.service;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.stereotype.Service;

@Service
public class PalindromoService {

    public String isPalindromo(String palabra)
    {
        String plLimpio = palabra.replace("\\s+", "").toLowerCase();
        String plInversa = new StringBuilder(plLimpio).reverse().toString();
        String valor="";

        if(plLimpio.equals(plInversa)){valor="Verdadero";}
        else {valor="Falso";}

        return valor;
    }
}
