package com.project.calculadoraposordem.service;

import com.project.calculadoraposordem.models.FilaDinamica;
import com.project.calculadoraposordem.models.PilhaDinamica;

public class TesteCalculadora {
    public static void main(String[] args) {

        FilaDinamica<String> fila = new FilaDinamica<>();
        PilhaDinamica<Double> pilha = new PilhaDinamica<>();

        CalculadoraPosOrdem calculadora = new CalculadoraPosOrdem();

        calculadora.inserirExpressao("2 3 1 * + 9 -");

        System.out.println(calculadora.calcularPosOrdem());

    }
}
