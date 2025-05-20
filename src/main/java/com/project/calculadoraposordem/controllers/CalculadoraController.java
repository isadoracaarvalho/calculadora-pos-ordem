package com.project.calculadoraposordem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

    @GetMapping("/projeto")
    public String index(){
        return "index";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("entrada") String entrada){

        return "index";
    }
}
