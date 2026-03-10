package demoapp.controller;

import javax.validation.constraints.NotEmpty;

public class PalabraData {

    @NotEmpty
    private String palabra;

    public void setPalabra(String palabra){this.palabra = palabra;}

    public String getPalabra(){return palabra;}
}
