// src/main/java/com/project/calculadoraposordem/service/TesteCalculadora.java
package com.project.calculadoraposordem.service;

// Não precisa mais importar FilaDinamica e PilhaDinamica aqui
// import com.project.calculadoraposordem.models.FilaDinamica;
// import com.project.calculadoraposordem.models.PilhaDinamica;

import com.project.calculadoraposordem.exceptions.DivisaoPorZeroException;
import com.project.calculadoraposordem.exceptions.ExpressaoInvalidaException;

public class TesteCalculadora {
    public static void main(String[] args) {

        CalculadoraPosOrdem calculadora = new CalculadoraPosOrdem();

        System.out.println("--- Testes com Expressões Válidas ---");
        try {
            System.out.println("2 3 1 * + 9 - = " + calculadora.calcular("2 3 1 * + 9 -")); // Expected: -4.0
            System.out.println("3 4 + = " + calculadora.calcular("3 4 +")); // Expected: 7.0
            System.out.println("5 1 2 + 4 * + 3 - = " + calculadora.calcular("5 1 2 + 4 * + 3 -")); // Expected: 14.0
            System.out.println("10 3 % 4 + = " + calculadora.calcular("10 3 % 4 +")); // Expected: 5.0
        } catch (Exception e) {
            System.out.println("Erro inesperado em expressão válida: " + e.getMessage());
        }


        System.out.println("\n--- Testes com Casos de Erro ---");
        // Divisão por zero
        try {
            System.out.println("10 0 / = " + calculadora.calcular("10 0 /"));
        } catch (DivisaoPorZeroException e) {
            System.out.println("Erro esperado (Divisão por Zero): " + e.getMessage());
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro inesperado (Expressão Inválida) para divisão por zero: " + e.getMessage());
        }

        // Operandos insuficientes
        try {
            System.out.println("5 + = " + calculadora.calcular("5 +"));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro esperado (Operandos Insuficientes): " + e.getMessage());
        }

        // Operandos excedentes
        try {
            System.out.println("5 2 + 3 = " + calculadora.calcular("5 2 + 3"));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro esperado (Operandos Excedentes): " + e.getMessage());
        }

        // Caractere/token desconhecido
        try {
            System.out.println("abc 2 + = " + calculadora.calcular("abc 2 +"));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro esperado (Caractere Desconhecido): " + e.getMessage());
        }

        // Operador inválido
        try {
            System.out.println("5 2 & = " + calculadora.calcular("5 2 &"));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro esperado (Operador Inválido): " + e.getMessage());
        }

        // Expressão vazia
        try {
            System.out.println("'' = " + calculadora.calcular(""));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro esperado (Expressão Vazia): " + e.getMessage());
        }

        // Expressão com apenas um operando (válido como resultado final)
        try {
            System.out.println("1 = " + calculadora.calcular("1"));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro inesperado (expressão com um operando): " + e.getMessage());
        }

        // Expressão com múltiplos operandos e nenhum operador
        try {
            System.out.println("1 2 = " + calculadora.calcular("1 2"));
        } catch (ExpressaoInvalidaException e) {
            System.out.println("Erro esperado (Expressão Malformada - faltando operador): " + e.getMessage());
        }
    }
}