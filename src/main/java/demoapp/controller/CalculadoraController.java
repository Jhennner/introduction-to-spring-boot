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
}
