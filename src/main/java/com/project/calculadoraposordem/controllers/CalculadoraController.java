package com.project.calculadoraposordem.controllers;

import com.project.calculadoraposordem.exceptions.DivisaoPorZeroException;
import com.project.calculadoraposordem.exceptions.ExpressaoInvalidaException;
import com.project.calculadoraposordem.service.CalculadoraPosOrdem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

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

        try{
            double resultado = calculadoraPosOrdem.calcular(entrada);
           model.addAttribute("resultado", resultado);
           model.addAttribute("entradaAnterior", entrada);
        } catch (DivisaoPorZeroException | ExpressaoInvalidaException e) {
            model.addAttribute("mensagemErro", e.getMessage() );
            model.addAttribute("entradaAnterior", entrada);
        } catch (Exception e) {
            model.addAttribute("mensagemErro", "Ocorreu um erro inesperado. Por favor, verifique a expressão.");
            model.addAttribute("entradaAnterior", entrada);
        }
        return "index";
    }
}
