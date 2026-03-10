package demoapp.controller;

import demoapp.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    /*
         Numero Par Controller. A partir de aqui son Controles de numero par
    */
    @GetMapping("/numeropar")  //El plan es amliarlo a /calculadora/par
    public String parForm(NumeroData numero)
    {
        return "parForm";
    }

    @PostMapping("/numeropar")
    public String checkNumPar(@ModelAttribute @Valid NumeroData numero, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()){
            return "parForm";
        }
        String comprobar="";
        if(service.isPar(numero.getNumero())){
            comprobar="Numero par";
        }else {comprobar="Numero impar";}

        model.addAttribute("mensaje", comprobar);
        return "parForm";
    }

     /*
         Numero cuadrado Controller. A partir de aqui son Controles de numero cuadrado
    */
    @GetMapping("/numerocuadrado")
    public String cuadradoForm(Model model) {
        model.addAttribute("cuadradoData", new CuadradoData());
        return "cuadradoForm";
    }

    @PostMapping("/numerocuadrado")
    public String checkNumsCuadrado(@ModelAttribute("cuadradoData") @Valid CuadradoData data, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {return "cuadradoForm";}

        String estado = "";
        if(service.isCuadrado(data.getNum1(), data.getNum2())) estado = "El segundo número es el cuadrado del primero.";
        else estado="El segundo número NO es el cuadrado del primero.";
        model.addAttribute("mensaje", estado);
        return "cuadradoForm";
    }

    /*
        Operaciones: suma,resta, multiplicacion, divion.
     */
    @GetMapping("/calcular")
    public String calculadoraForm(Model model) {
        model.addAttribute("calcularData", new CalcularData());
        return "calcularForm";
    }

    @PostMapping("/calcular")
    public String calcular(@ModelAttribute("calcularData") @Valid CalcularData data, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "calcularForm";

        model.addAttribute("resultado",
                service.calcular(data.getNum1(), data.getNum2(), data.getOperacion()));
        return "calcularForm";
    }
}
