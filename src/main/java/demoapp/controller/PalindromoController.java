package demoapp.controller;

import demoapp.service.PalindromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PalindromoController {

    @Autowired
    private PalindromoService service;

    @GetMapping("/palindromo")
    public String palabraForm(PalabraData palabra)
    {
        return "formPalindromo";
    }

    @PostMapping("/palindromo")
    public String checkPalindromo(@ModelAttribute @Valid PalabraData palabra, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()){
            return "formPalindromo";
        }

        model.addAttribute("mensaje", service.isPalindromo(palabra.getPalabra()));
        return "formPalindromo";
    }
}
