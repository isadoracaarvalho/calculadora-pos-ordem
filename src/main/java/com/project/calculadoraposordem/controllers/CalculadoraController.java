package com.project.calculadoraposordem.controllers;

import com.project.calculadoraposordem.service.CalculadoraPosOrdem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

    private final CalculadoraPosOrdem calculadoraPosOrdem;

    public CalculadoraController(final CalculadoraPosOrdem calculadoraPosOrdem) {
        this.calculadoraPosOrdem = calculadoraPosOrdem;
    }

    @GetMapping("/projeto")
    public String index(){
        return "index";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("entrada") String entrada, Model model){
        calculadoraPosOrdem.inserirExpressao(entrada);
        double resultado = calculadoraPosOrdem.calcularPosOrdem();

        model.addAttribute("resultado", resultado);

        return "index";
    }
}
